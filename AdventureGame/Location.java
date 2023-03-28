package game;

public abstract class Location {
	
	private String name;
	
	public Location(Player player, String name) {
		Game.player = player;
		this.name = name;
	}
	public abstract boolean onLocation();
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
