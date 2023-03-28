package game;

public class ToolStore extends NormalLoc {
	
	public ToolStore(Player player) {
		super(player, "ToolStore");
	}

	@Override
	public boolean onLocation() {
		System.out.println("-------------  Welcome to the ToolStore!  -------------");
		boolean showMenu = true;
		while(showMenu)
		{
			System.out.println("\nWhat do you want?");
			System.out.println("1 - Weapons\n2 - Armors\n0 - Exit");
			Inhibitory.takeInt(Inhibitory.sc);
			int choice = Inhibitory.sc.nextInt();
			choice = Inhibitory.takeValidChoice(choice);
			Item item = null;
			switch(choice) 
			{
				case 0:
					System.out.println("Take care.");
					showMenu = false;
					break;
				case 1: 
					item = new Weapon();
					break;
				case 2:
					item = new Armor();
					break;
			}
			if(showMenu)
			{
				printItems(item);	
				selectItem(item);
			}
		}
		return true;
	}
	public void printItems(Item item) {
		
		System.out.println("Your money: "+ Game.player.getMoney()+"$");
		int ID = 0;
		if(item instanceof Weapon)
		{
			for(Weapon wp: Weapon.weaponList())
			{
				++ID;
				System.out.printf("%d - %s:\tDamage: %d\tPrice: %d$\n", ID, wp.getName(), wp.getDamage(), wp.getPrice());
			}
		}
		else if(item instanceof Armor)
		{
			for(Armor ar: Armor.armorList())
			{
				++ID;
				System.out.printf("%d - %s:\tDefence: %d\tPrice: %d$\n", ID, ar.getName(), ar.getDefence(), ar.getPrice());
			}
		}
		System.out.println("0 - Exit");
		System.out.print("Enter the item ID you want to buy it: ");
	}
	public void selectItem(Item item) {
		
		int ID = -1;
		while(ID != 0)
		{
			if(item instanceof Weapon)
			{
				Inhibitory.takeInt(Inhibitory.sc);
				ID = Inhibitory.sc.nextInt();
				ID = Inhibitory.chooseValidWeapon(ID);
			}
			else if(item instanceof Armor)
			{
				Inhibitory.takeInt(Inhibitory.sc);
				ID = Inhibitory.sc.nextInt();
				ID = Inhibitory.chooseValidArmor(ID);
			}
			if(ID != 0)
			{
				buy(item, ID);
				printItems(item);
			}
		}
	}
	public void buy(Item item, int ID) {
		
		--ID; //index starts with 0
		if(item instanceof Weapon)
		{
			if(Game.player.getMoney() < Weapon.weaponList().get(ID).getPrice())
			{
				System.out.println("You don't have enough money!");
			}
			else
			{
				Game.player.inventory.setWeaponName(Weapon.weaponList().get(ID).getName());
				Game.player.inventory.setWeaponDamage(Weapon.weaponList().get(ID).getDamage());
				Game.player.setMoney(Game.player.getMoney() - Weapon.weaponList().get(ID).getPrice());
				System.out.println("You bought: " + Weapon.weaponList().get(ID).getName());
			}
			
		}
		else if(item instanceof Armor)
		{
			if(Game.player.getMoney() < Armor.armorList().get(ID).getPrice())
			{
				System.out.println("You don't have enough money!");
			}
			else
			{
				Game.player.inventory.setArmorName(Armor.armorList().get(ID).getName());
				Game.player.inventory.setArmorDefence(Armor.armorList().get(ID).getDefence());
				Game.player.setMoney(Game.player.getMoney() - Armor.armorList().get(ID).getPrice());
				System.out.println("You bougth: " + Armor.armorList().get(ID).getName());
			}
		}
		
	}
	
}
