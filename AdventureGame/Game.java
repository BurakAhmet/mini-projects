package game;

public class Game {
	
	public static Player player = new Player();
	
	public void start() {
		
		System.out.print("Welcome to the adventure!\nBefore you start please enter your nickname: ");
		String playerName = Inhibitory.sc.nextLine();
		playerName = Inhibitory.takeValidName(playerName);
		player = new Player(playerName);
		System.out.printf("Welcome %s!\n\nSelect your champion to survive in this horrible island!\n", player.getName());
		player.selectChamp();
		while(true)
		{
			player.playerInfo();
			player.selectLoc();
			if(player.getLocation() == null)
			{
				System.out.println("Game terminated.");
				break;
			}
			else if(!player.getLocation().onLocation())
			{
				System.out.println("\nYou died!\nGame Over!");
				break;
			}
			else if(Game.player.inventory.hasFood() && Game.player.inventory.hasWood() && Game.player.inventory.hasWater())
			{
				System.out.println("\nYou won the game\nDo you want to finish it?\nIf you want to contiune to play enter a key\nPress 0 to finish it");
				String finish = Inhibitory.sc.next();
				if(finish.equals("0"))
				{
					System.out.println("Stay strong...");
					break;
				}
			}
		}
		
	}

}
