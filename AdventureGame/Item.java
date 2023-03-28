package game;

public abstract class Item {
	
	public String name;
	public int price;
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
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
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
}
