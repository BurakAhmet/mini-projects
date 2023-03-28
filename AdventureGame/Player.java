package game;

public class Player {
	
	public Inventory inventory = new Inventory();
	private Champion champ;
	private Location location;
	private String name;
	private String champName;	
	private int health;
	private int damage;
	private int defence;
	private int money;
	
	public Player(String name) {
		this.setName(name);
	}
	public Player() {
		
	}
	public void selectChamp() {
		
		Champion[] champions = {new Warrior(), new Archer(), new Wizard()};
		Inhibitory.numberOfChamp = champions.length;
		int ID = 0;
		for(Champion c: champions)
		{
			++ID;
			System.out.println("\n----------------------------------------------------------------------------------");
			System.out.printf("%d -\tName: %s \tHealth: %d\tDamage: %d\tDefence: %d\tMoney: %d", ID, c.getName(), c.getHealth(), c.getDamage(), c.getDefence(), c.getMoney());
		}
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.print("\nEnter the champion ID you want to choose it: ");
		Inhibitory.takeInt(Inhibitory.sc);
		int selectedChamp = Inhibitory.sc.nextInt();
		selectedChamp = Inhibitory.takeValidID(selectedChamp);
		initPlayer(champions[selectedChamp-1]);
		Game.player.setChamp(champions[selectedChamp-1]);
		printChampInfo();
		
	}
	public void printChampInfo() {
		System.out.println("Chosen Champion: " + getChampName() 
		+ ", Health: " + getHealth()
		+ ", Damage: " + getDamage()
		+ ", Defence: " + getDefence()
		+ ", Money: " + getMoney());
	}
	public void selectLoc() {
		Location[] locations = {new SafeHouse(this), new ToolStore(this), new Cave(this), new Forest(this), new River(this), new Mine(this)};
		Inhibitory.numberOfLoc = locations.length;
		int NO = 0;
		for(Location loc: locations)
		{
			++NO;
			System.out.printf("\n%d - Place: %s", NO, loc.getName());
		}
		System.out.println("\n0 - Exit game");
		System.out.println("\nEnter the place NO you want to go there: ");
		Inhibitory.takeInt(Inhibitory.sc);
		int selectedLoc = Inhibitory.sc.nextInt();
		selectedLoc = Inhibitory.takeValidNO(selectedLoc);
		switch(selectedLoc) 
		{
			case 0: 
				this.location = null;
				break;
			default: 
				if(locations[selectedLoc-1] instanceof Cave && Game.player.inventory.hasFood() || locations[selectedLoc-1] instanceof Forest && Game.player.inventory.hasWood() || locations[selectedLoc-1] instanceof River && Game.player.inventory.hasWater() || locations[selectedLoc-1] instanceof Mine && Game.player.inventory.hasSnakeSkin())
				{
					System.out.println("This area seems clear.\nChoose another");
					selectLoc();
				}
				else 
				{
					this.setLocation((locations[selectedLoc-1]));
				}
		}
		
	}
	public void playerInfo() {
		System.out.println("\n\n----- Player Info -----");
		System.out.printf("Weapon: %s,\tHealth: %d,\tDamage: %d"
				+ "\nMoney: %d,\tArmor: %s,\tDefence: %d\n", inventory.getWeaponName(), this.getHealth(), this.getDamage(), 
				this.getMoney(), inventory.getArmorName(), this.getDefence());
	}
	public void initPlayer(Champion champ) {
		this.setHealth(champ.getHealth());
		this.setDamage(champ.getDamage());
		this.setMoney(champ.getMoney());
		this.setChampName(champ.getName());
		this.setDefence(champ.getDefence());
	}
	/**
	 * @return the champName
	 */
	public String getChampName() {
		return champName;
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
		return damage + inventory.getWeaponDamage();
	}
	/**
	 * @return the defence
	 */
	public int getDefence() {
		return defence + inventory.getArmorDefence();
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @return the champ
	 */
	public Champion getChamp() {
		return champ;
	}
	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	/**
	 * @param champ the champ to set
	 */
	public void setChamp(Champion champ) {
		this.champ = champ;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * @param champ the champName to set
	 */
	public void setChampName(String champName) {
		this.champName = champName;
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
		if(health < 0)
		{
			this.health = 0;
		}
		else
		{
			this.health = health;
		}
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
		if(0<=money)
		{
			this.money = money;
		}
	}
	/**
	 * @param defence the defence to set
	 */
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
}
