package game;

public abstract class Champion {
	
	private String name;
	private int health;
	private int damage;
	private int money;
	private int defence;
	
	public Champion(String name, int health, int damage, int defence, int money) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.money = money;
		this.defence = defence;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @return the defence
	 */
	public int getDefence() {
		return defence;
	}
	/**
	 * @param defence the defence to set
	 */
	public void setDefence(int defence) {
		this.defence = defence;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
}
