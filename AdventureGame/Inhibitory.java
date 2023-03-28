package game;

import java.util.Scanner;

public abstract class Inhibitory {
	
	public static Scanner sc = new Scanner(System.in);
	public static int numberOfChamp;
	public static int numberOfLoc;
	private static final String noPermittedChar="[ \"*-/<>|!,?.\\'@	.%]+";
	private static final int maxNameLength=15, minNameLength=3;
	
	public static String takeValidName(String name) {
		
		while(!isValidName(name))
		{
			if(name.length() < minNameLength || name.length() > maxNameLength)
			{
				System.out.printf("Your nickname must be %d-%d characters!\nPlease enter your nickname: ", minNameLength, maxNameLength);
				name = sc.nextLine();
			}
			else
			{
				System.out.printf("Your nickname can not include these characters: %s\nPlease enter your nickname: ", noPermittedChar);
				name = sc.nextLine();
			}
		}
		return name;
	}
	private static boolean isValidName(String name) { //checks the name valid or not
		
		if(minNameLength <= name.length() && name.length() <= maxNameLength && name.equals(optimalName(name)))
			return true;
		else
			return false;
	}
	private static String optimalName(String name) {
		
		String words[]=name.trim().split(noPermittedChar);
		String checker="";
		for (String s:words)
		{
			checker+=s;
		}
		return checker;
	}
	public static void takeInt(Scanner sc) {
		
		while(!sc.hasNextInt())
		{
			System.out.print("\nPlease use just integers!\nEnter again: ");
			sc.next();
		}
	}
	public static String takeValidDecision(String decision) {
		decision = decision.toUpperCase();
		while(!decision.equals("A") && !decision.equals("R"))
		{
			System.out.println("Enter a valid letter! (<A> - <R>)");
			decision = sc.nextLine().toUpperCase();
		}
		return decision;
	}
	public static int takeValidDecision(int decision) {
		while(decision < 0 || decision > 1)
		{
			System.out.println("Enter a valid number! (0-1)\nDo you want to drink something?\n1 - Yes\n0 - Exit");
			takeInt(sc);
			decision = sc.nextInt();
		}
		return decision;
	}
	public static int takeValidID(int champID) {
		
		while(champID < 1 || champID > numberOfChamp)
		{
			System.out.printf("\nPlease enter a valid number! (1-%d)\nEnter the champion ID you want to choose it: ", numberOfChamp);
			takeInt(sc);
			champID = sc.nextInt();
		}
		return champID;
	}
	public static int takeValidNO(int locNO) {
		while(locNO < 0 || locNO > numberOfLoc)
		{
			System.out.printf("\nPlease enter a valid number! (1-%d)\nEnter the location NO you want to go there: ", numberOfLoc);
			takeInt(sc);
			locNO = sc.nextInt();
		}
		
		return locNO;
	}
	public static int takeValidChoice(int choice) {
		while(choice < 0 || choice > 3)
		{
			System.out.println("\nPlease enter a valid number! (0-3)\nWhat do you want?");
			takeInt(sc);
			choice = sc.nextInt();
		}
		return choice;
	}
	public static int chooseValidWeapon(int weaponID) {
		while(weaponID < 0 || weaponID > Weapon.weaponList().size())
		{
			System.out.printf("\nPlease enter a valid ID! (0-%d)\nEnter the weapon ID you want to buy it: ", Weapon.weaponList().size());
			takeInt(sc);
			weaponID = sc.nextInt();
		}
		return weaponID;
	}
	public static int chooseValidArmor(int armorID) {
		while(armorID < 0 || armorID > Armor.armorList().size())
		{
			System.out.printf("\nPlease enter a valid ID! (0-%d)\nEnter the armor ID you want to buy it: ", Armor.armorList().size());
			takeInt(sc);
			armorID = sc.nextInt();
		}
		return armorID;
	}
	
}
