import java.util.Scanner;

public class GuessNumber {
	
	public static Scanner sc = new Scanner(System.in);
	
	final static int ANSWER = generateNumber();
	final static int GENERATE_MAX = 100;
	final static int GENERATE_MİN = 0;
	
	public static int min = GENERATE_MİN;  // initial maximum and minimum guess for PC
	public static int max = GENERATE_MAX;
	
	
	public static void main(String[] args) {
		System.out.printf("Guess the number between %d & %d\n", GENERATE_MİN, GENERATE_MAX);
		int userGuess = 0;
		int pcGuess = 0;
		while(userGuess != ANSWER && pcGuess != ANSWER)
		{
			// System.out.println("min: " + min + " max: " + max);
			System.out.println("Your turn");
			userGuess = userGuess();
			if(userGuess != ANSWER)
			{
				System.out.println("PC's turn");
				pcGuess = pcGuess();
			}
			
		}
		
	}
	
	public static int generateNumber() {
		int randomNumber = (int) (Math.random() * GENERATE_MAX + GENERATE_MİN);
		return randomNumber;
	}
	
	public static int userGuess() {
		
		int guess;
		
		// to validate the input
		while(true)
		{
			try 
			{
				guess = sc.nextInt();
				if(guess <= GENERATE_MAX && guess >= GENERATE_MİN)
				{
					break;
				}
				System.out.println("Invalid number. Please enter a number between " + GENERATE_MİN + "&" + GENERATE_MAX);
			}
			catch(Exception e)
			{
				System.out.println("Invalid syntax. Please enter a number between " + GENERATE_MİN + "&" + GENERATE_MAX);
				sc.nextLine();
			}
		}
		
		if(guess == ANSWER)
		{
			System.out.println(guess + " that's right you won the game!");
		}
		else if(guess < ANSWER)
		{
			if(min < guess)
			{
				min = guess;
			}
			System.out.println(guess + " is too SMALL");
		}
		else  // guess > ANSWER
		{
			if(max > guess)
			{
				max = guess;
			}
			System.out.println(guess + " is too BIG");
			
		}
		return guess;
	}
	
	public static int pcGuess() {
		int guess = (int) (Math.random() * (max - min - 1) + min + 1);  // generates a random number between min and max
		
		if(guess == ANSWER)
		{
			System.out.println("Answer was " + ANSWER + " PC won the game!");
		}
		else if(guess < ANSWER)
		{
			if(min < guess)
			{
				min = guess;
			}
			System.out.println(guess + " is too SMALL");
		}
		else  // guess > ANSWER
		{
			if(max > guess)
			{
				max = guess;
			}
			System.out.println(guess + " is too BIG");
		}
		return guess;
	}
}
