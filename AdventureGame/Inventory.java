package game;

public class Inventory {
	
	private String weaponName = "Punch";
	private String armorName = "Body";
	private int weaponDamage = 0;
	private int armorDefence = 0;
	private boolean food;
	private boolean wood;
	private boolean water;
	private boolean snakeSkin;
	/**
	 * @return the weaponName
	 */
	public String getWeaponName() {
		return weaponName;
	}
	/**
	 * @return the armorName
	 */
	public String getArmorName() {
		return armorName;
	}
	/**
	 * @return the weaponDamage
	 */
	public int getWeaponDamage() {
		return weaponDamage;
	}
	/**
	 * @return the armorDefence
	 */
	public int getArmorDefence() {
		return armorDefence;
	}
	/**
	 * @return the snakeSkin
	 */
	public boolean hasSnakeSkin() {
		return snakeSkin;
	}
	/**
	 * @return the food
	 */
	public boolean hasFood() {
		return food;
	}
	/**
	 * @return the wood
	 */
	public boolean hasWood() {
		return wood;
	}
	/**
	 * @return the water
	 */
	public boolean hasWater() {
		return water;
	}
	/**
	 * @param food the food to set
	 */
	public void setFood(boolean food) {
		this.food = food;
	}
	/**
	 * @param wood the wood to set
	 */
	public void setWood(boolean wood) {
		this.wood = wood;
	}
	/**
	 * @param water the water to set
	 */
	public void setWater(boolean water) {
		this.water = water;
	}
	/**
	 * @param snakeSkin the snakeSkin to set
	 */
	public void setSnakeSkin(boolean snakeSkin) {
		this.snakeSkin = snakeSkin;
	}
	/**
	 * @param weaponName the weaponName to set
	 */
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	/**
	 * @param armorName the armorName to set
	 */
	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}
	/**
	 * @param weaponDamage the weaponDamage to set
	 */
	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}
	/**
	 * @param armorDefence the armorDefence to set
	 */
	public void setArmorDefence(int armorDefence) {
		this.armorDefence = armorDefence;
	}
	
}
