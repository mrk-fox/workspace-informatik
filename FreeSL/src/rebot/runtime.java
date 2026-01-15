package rebot;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TimeSystem: ruft jede Sekunde einen Callback auf.
 * Startet / stoppt explizit von außen (z.B. aus main in einer anderen Klasse).
 */
public class runtime {

    private final ScheduledExecutorService scheduler;
    private Runnable callback;
    private volatile boolean running = false;

    public runtime() {
        this.scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "TimeSystem-Tick");
            t.setDaemon(false);
            return t;
        });
        this.callback = () -> System.out.println("Tick @ " + Instant.now());
    }

 
    public void setCallback(Runnable callback) {
        if (callback == null) throw new IllegalArgumentException("callback darf nicht null sein");
        this.callback = callback;
    }

    public synchronized void start(boolean alignToWholeSecond) {
        if (running) return;
        long initialDelayMillis = 0;
        if (alignToWholeSecond) {
            initialDelayMillis = computeMillisUntilNextWholeSecond();
        }
        // scheduleAtFixedRate: versucht, Tasks in konstantem Rate-Intervall auszuführen.
        scheduler.scheduleAtFixedRate(() -> {
            try {
                callback.run();
            } catch (Throwable t) {
                // Fehler im Callback sollen Scheduler nicht killen
                t.printStackTrace();
            }
        }, initialDelayMillis, 1000L, TimeUnit.MILLISECONDS);
        running = true;
    }

    /**
     * Stoppt das System sauber (wartet kurz auf Terminierung).
     */
    public synchronized void stop() {
        if (!running) return;
        scheduler.shutdown(); // nimmt keine neuen Tasks mehr an
        try {
            if (!scheduler.awaitTermination(2, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        } finally {
            running = false;
        }
    }

    public boolean isRunning() {
        return running;
    }

    /**
     * Berechnet Millisekunden bis zur nächsten vollen Sekunde (z.B. wenn jetzt 12:00:00.350 -> 650 ms).
     */
    private static long computeMillisUntilNextWholeSecond() {
        Instant now = Instant.now();
        long millis = now.toEpochMilli();
        long next = ((millis / 1000L) + 1L) * 1000L;
        return next - millis;
    }
}
