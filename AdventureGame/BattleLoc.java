package game;

public abstract class BattleLoc extends Location {
	
	public int obsNumber;
	private Obstacle obstacle;
	private int maxObstacle;
	private String speacialItemName;
	public BattleLoc(Player player, String name, Obstacle obstacle, int maxObstacle, String speaicalItemName) {
		super(player, name);
		this.setObstacle(obstacle);
		this.setMaxObstacle(maxObstacle); 
		this.setSpeacialItemName(speaicalItemName);
	}
	@Override
	public boolean onLocation() {
		
		obsNumber = this.randomObstacleNumber();
		System.out.println("You are in " + this.getName()+ "\n" + obsNumber + " "+ this.getObstacle().getName() + "s are nearby");
		Inhibitory.sc.nextLine(); //needs for initial empty entering
		combatDecision(makeDecision());
		if(Game.player.getHealth() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String makeDecision() {
		System.out.print("\n<A>ttack or <R>un: ");
		String decision = Inhibitory.sc.nextLine();
		decision = Inhibitory.takeValidDecision(decision);
		return decision;
	}
	public void combatDecision(String decision) {
		if(decision.equals("A"))
		{
			combat();
		}
		else if(decision.equals("R"))
		{
			System.out.println("You return to your village");
		}
	}
	public void combat() {
		
		for(int i = 1; i <= obsNumber; ++i)
		{
			this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());			
			Game.player.playerInfo();
			obstacleInfo(i);
			while(Game.player.getHealth() > 0 && this.getObstacle().getHealth() > 0)
			{
				String decision = makeDecision();
				int firstHit = this.firstHit();
				if(decision.equals("A"))
				{
					if(firstHit == 0)
					{
						playerHitInfo();
						if(this.getObstacle().getHealth() > 0)
						{
							obstacleHitInfo();
						}
					}
					else if(firstHit == 1)
					{
						obstacleHitInfo();
						if(Game.player.getHealth() > 0)
						{
							playerHitInfo();
						}
					}
				}
				else if(decision.equals("R"))
				{
					System.out.println("You ran away from the war!");
					return;
				}
			}
			if(Game.player.getHealth() == 0)
			{
				break;
			}
			if(i == obsNumber)
			{
				System.out.printf("You defeat all the %ss!", this.getObstacle().getName());
				System.out.printf("\nYou earn %s", this.getSpeacialItemName());
				if(this instanceof Cave)
				{
					Game.player.inventory.setFood(true);
				}
				else if(this instanceof Forest)
				{
					Game.player.inventory.setWood(true);
				}
				else if(this instanceof River)
				{
					Game.player.inventory.setWater(true);
				}
				else if(this instanceof Mine)
				{
					Game.player.inventory.setSnakeSkin(true);
				}
			}
			else
			{
				System.out.printf("%d. %s is dead!", i, this.getObstacle().getName());
			}
			Game.player.setMoney(Game.player.getMoney() + this.getObstacle().getAward());
			System.out.printf("\nYou receive %d$.", this.getObstacle().getAward());
		}
	}
	public void playerHitInfo() {
		System.out.println("You hit " + Game.player.getDamage() + " damage to the " + this.getObstacle().getName());
		this.getObstacle().setHealth(this.getObstacle().getHealth() - Game.player.getDamage());
		System.out.println(this.getObstacle().getName() + "'s remaining health: " + this.getObstacle().getHealth());
	}
	public void obstacleHitInfo() {
		System.out.println(this.getObstacle().getName() + " hitted you " + this.getObstacle().getDamage() + " damage.");
		if(this.getObstacle().getDamage() > Game.player.getDefence())
		{
			Game.player.setHealth(Game.player.getHealth() - (this.getObstacle().getDamage() - Game.player.getDefence()));
			System.out.println("Your remaining health: " + Game.player.getHealth());
		}
		else 
		{
			System.out.println("Your armor is too strong you took no damage!");
		}
	}
	public int firstHit() {
		int probability = (int) (Math.random()*2);// generates random number 1 or 0
		return probability;
	}
	public void obstacleInfo(int i) {
		System.out.println("\n----- " + i + ". Obstacle Info -----");
		System.out.printf("Name: %s,\tHealth: %d,\tDamage: %d,\tMoney award: %d ", this.getObstacle().getName(), this.getObstacle().getHealth(),
				this.getObstacle().getDamage(), this.getObstacle().getAward());
	}
	public int randomObstacleNumber() {
		int randomNum = (int) (Math.random()*this.getMaxObstacle()+1);
		return randomNum;
	}
	/**
	 * @return the obstacle
	 */
	public Obstacle getObstacle() {
		return obstacle;
	}
	/**
	 * @return the maxObstacle
	 */
	public int getMaxObstacle() {
		return maxObstacle;
	}
	/**
	 * @return the speacialItemName
	 */
	public String getSpeacialItemName() {
		return speacialItemName;
	}
	/**
	 * @param maxObstacle the maxObstacle to set
	 */
	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}
	/**
	 * @param obstacle the obstacle to set
	 */
	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}
	/**
	 * @param speacialItemName the speacialItemName to set
	 */
	public void setSpeacialItemName(String speacialItemName) {
		this.speacialItemName = speacialItemName;
	}
}
