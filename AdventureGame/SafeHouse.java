package game;

public class SafeHouse extends NormalLoc{
	
	public SafeHouse(Player player) {
		super(player, "Tavern");
	}

	@Override
	public boolean onLocation() {
		Game.player.setHealth(Game.player.getChamp().getHealth());
		System.out.println("Welcome to the tavern!\n-- Your health is regenereted --");
		boolean showMenu = true;
		int drinkCounter = 0;
		while(showMenu)
		{
			if(Game.player.getHealth() > 0)
			{
				System.out.println("Do you want to drink something?\n1 - Yes\n0 - Exit");
				Inhibitory.takeInt(Inhibitory.sc);
				int decision = Inhibitory.sc.nextInt();
				decision = Inhibitory.takeValidDecision(decision);
				switch(decision)
				{
					case 0:
						System.out.println("See you...");
						showMenu = false;
						break;
					case 1: 
						if(Game.player.getMoney()!=0)
						{
							System.out.println("Here your beer!");
							++drinkCounter;
							if(drinkCounter>2)
							{
								System.out.println("-1$\n-1 HP");
								Game.player.setHealth(Game.player.getHealth() - 1);
								Game.player.setMoney(Game.player.getMoney() - 1);
								switch(drinkCounter)
								{
									case 5: 
										System.out.println("don't vomit here.");
										break;
									case 10: 
										System.out.println("Easy man what is the matter with you?");
										break;
									case 20: 
										System.out.println("You don't look well");
										break;
								}
							}
						}
						else
						{
							System.out.println("You don't have enough money!");
						}
						break;
				}
			}
			else
			{
				return false;
			}
		}
		return true;
	}
}
