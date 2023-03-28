package game;

import java.util.ArrayList;

public class Armor extends Item {
	
	private int defence;
	
	public Armor(String name, int damage, int price) {
		this.name = name;
		this.defence = damage;
		this.price = price;
	}
	public Armor() {
		
	}
	public static ArrayList<Armor> armorList() {
		ArrayList<Armor> armors = new ArrayList<Armor>();
		armors.add(new Armor("Gladiator Armor", 1, 15));
		armors.add(new Armor("Necro Armor", 3, 25));
		armors.add(new Armor("Molten Armor", 5, 40));
		return armors;
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
}
