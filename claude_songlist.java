import java.util.*;

class Song {
    private String name;
    private double bangerRating;
    
    public Song(String name, double bangerRating) {
        this.name = name;
        this.bangerRating = bangerRating;
    }
    
    public double getBangerRating() {
        return bangerRating;
    }
    
    @Override
    public String toString() {
        return name + " (Rating: " + bangerRating + ")";
    }
}

public class SongSorter {
    
    /**
     * Takes all songs from a stack and returns them sorted by banger rating
     * from highest to lowest
     * 
     * @param stack Stack containing Song objects
     * @return List of songs sorted by banger rating (descending)
     */
    public static List<Song> sortSongsByBangerRating(Stack<Song> stack) {
        List<Song> songs = new ArrayList<>();
        
        // Remove all songs from stack
        while (!stack.isEmpty()) {
            songs.add(stack.pop());
        }
        
        // Sort by banger rating from highest to lowest
        songs.sort((s1, s2) -> Double.compare(s2.getBangerRating(), s1.getBangerRating()));
        
        return songs;
    }
    
    // Example usage
    public static void main(String[] args) {
        Stack<Song> songStack = new Stack<>();
        
        songStack.push(new Song("Bohemian Rhapsody", 5.0));
        songStack.push(new Song("Wonderwall", 3.5));
        songStack.push(new Song("Smells Like Teen Spirit", 4.8));
        songStack.push(new Song("Hey Jude", 4.2));
        songStack.push(new Song("Sweet Caroline", 3.9));
        
        List<Song> sortedSongs = sortSongsByBangerRating(songStack);
        
        System.out.println("Songs sorted by banger rating:");
        for (Song song : sortedSongs) {
            System.out.println(song);
        }
    }
}
