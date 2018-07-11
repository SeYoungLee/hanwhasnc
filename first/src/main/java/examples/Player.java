package examples;

public class Player {
	private String name;
	private Dice dice;
	
	public Player() {
		System.out.println("Player !!");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public void play() {
		System.out.println(name + " play : " + dice.get());
	}
	

}
