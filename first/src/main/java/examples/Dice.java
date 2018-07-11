package examples;

public class Dice {
	private int face = 6;
	
	public Dice() {
		System.out.println("Dice 생성자.");
	}
	
	public void setFace(int face) {
		this.face = face;
	}

	// Math.random() ; 0.0 <= x < 1.0
	//        * 6      0.0 <= x < 6.0
	//   (int)         0   <= x  < 6  (정수)
	//    +1           1   <= x  <= 6
	public int get() {
		return (int)(Math.random() * face) + 1;
	}
}
