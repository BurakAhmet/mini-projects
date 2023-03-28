import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean letter = true;
		int remaining = 5;
		System.out.print("Enter the mystery word: ");
		String word;
		do {
			word = in.nextLine();
			word = word.toUpperCase();
			for (int i = 0; i < word.length(); i++) {
				if (!Character.isLetter(word.charAt(i)) || word.charAt(i) == ' ' || word.charAt(i) == '	') {
					letter = false;
					System.out.println("Please use only letters!");
					break;
				} else {
					letter = true;
				}
			}
		} while (!letter);
		{
			for (int i = 0; i < 5; i++) {
				System.out.println(); // girilen kelimenin gözükmemesi için 5 satır boşluk
			}
			System.out.print("The word is: ");
			for (int i = 0; i < word.length(); i++) {
				System.out.print("_ ");
			}
			String displayWord = "";
			for (int i = 0; i < word.length(); i++) {
				displayWord += "_";
			}
			while (remaining > 0) {
				System.out.print("\nPlease guess a character: ");
				char guess = in.next().charAt(0);
				guess = Character.toUpperCase(guess);
				int position = word.indexOf(guess);
				if (position == -1) {
					--remaining;
				} else {
					for (; position >= 0; position = word.indexOf(guess, position + 1)) {
						displayWord = displayWord.substring(0, position) + guess + displayWord.substring(position + 1);
					}
					if (displayWord.equals(word)) {
						System.out.println(word + "\nYou won the game!");
						break;
					}
				}
				System.out.println(displayWord + "\nNumber of guess left: " + remaining);
			}
			if (!displayWord.equals(word)) {
				System.out.println("\nYou lost the game! \nThe word was: " + word);
			}
			in.close();
		}
	}
}
