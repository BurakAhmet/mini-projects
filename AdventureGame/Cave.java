package game;

public class Cave extends BattleLoc {
	
	public Cave(Player player) {
		super(player, "Cave", new Zombie(), 3, "Food");
	}
}
