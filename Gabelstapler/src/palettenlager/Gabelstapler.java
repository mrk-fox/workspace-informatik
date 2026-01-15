package palettenlager;

public class Gabelstapler {
	public static Stack<Paletten> stapel = new Stack<Paletten>();
	public static Stack<Paletten> stapel_big = new Stack<Paletten>();
	public static Stack<Paletten> stapel_small = new Stack<Paletten>();
	public Paletten current;
	
	public void sort() {
		if(!stapel.isEmpty()) {
			current = stapel.top();
			if(current.gibGroesse() == 1) {
				stapel_small.push(current);
				stapel.pop();
			}
			
			else if (current.gibGroesse() == 2) {
				stapel_big.push(current);
				stapel.pop();
			}
			
			else {
				stapel.pop();
			}
		}
		
	}
	
    public static void main(String[] args) {
        stapel.push(new Paletten("p1", false, 1));
        stapel.push(new Paletten("p2", false, 2));
        stapel.push(new Paletten("p3", false, 1));
        stapel.push(new Paletten("p4", false, 2));
    }
}