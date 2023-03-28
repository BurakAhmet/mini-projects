package game;

import java.util.ArrayList;

public class Weapon extends Item {
	
	private int damage;
	
	public Weapon(String name, int damage, int price) {
		this.name = name;
		this.damage = damage;
		this.price = price;
	}
	public Weapon() {
		
	}
	public static ArrayList<Weapon> weaponList() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		weapons.add( new Weapon("Blood Butcherer", 2, 15));
		weapons.add(new Weapon("Molten Fury", 3, 35));
		weapons.add(new Weapon("Star Cannon", 7, 45));
		return weapons;
	}
	
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
}
