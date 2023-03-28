package game;

public class Obstacle {
	
	private String name;
	private int damage;
	private int health;
	private int award;
	private int defaultHealth;
	
	public Obstacle(String name, int damage, int health, int award) {
		
		this.name = name; 
		this.damage = damage;
		this.defaultHealth = health;
		this.health = health;
		this.award = award;
	}
	
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the award
	 */
	public int getAward() {
		return award;
	}

	/**
	 * @return the defaultHealth
	 */
	public int getDefaultHealth() {
		return defaultHealth;
	}

	/**
	 * @param defaultHealth the defaultHealth to set
	 */
	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}

	/**
	 * @param award the award to set
	 */
	public void setAward(int award) {
		this.award = award;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		
		if(health < 0)
		{
			this.health = 0;
		}
		else
		{
			this.health = health;
		}
		
	}
	
}
