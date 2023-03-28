package game;

public class Snake extends Obstacle {
	
	private static int damage = (int) (Math.random()*10 + 5);
	
	public Snake() {
		super("Snake", damage, 15, 0);
	}

}
