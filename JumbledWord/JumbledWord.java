import java.io.*;
import java.util.*;

public class Assignment4 {

	public static void main(String[] args) {

		System.out.print("Shuffled letters: ");
		File file = new File("input.txt");  // YOUR PATH GOES HERE
		String data = "";
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				data = sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		char[] shuffledLetters = new char[numOfLetters(data)];  // to making array for the shuffled letters
		for (int i = 0; i < shuffledLetters.length; i++) {
			shuffledLetters[i] = data.charAt(i);
			System.out.print(shuffledLetters[i] + " ");
		}
		char[] alphabet = { 'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'Ğ', 'H', 'I', 'İ', 'J', 'K', 'L', 'M', 'N', 'O',
				'Ö', 'P', 'R', 'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z' };// alphabet to calculating the points of letters
		String[] possibleHelper = data.split(":");  // first step to making array of the possible words
		String[] possibleWords = possibleHelper[1].split(",");  // second step to making array of the possible words
		System.out.println("\nPlease try to enter a 3 word with using this letters");
		Scanner in = new Scanner(System.in);
		int score = 0;
		int counter = 0;
		String empty = "";  // to removing the entered words from array
		for (int i = 0; i < 3; i++) {
			counter++;
			System.out.printf("%d. word: ", counter);
			String userWord = in.nextLine();
			userWord = userWord.toUpperCase();
			int letterPoints = 0;
			boolean notFound = true;  // to determining if a word doesn't exist in array
			for (int j = 0; j < possibleWords.length; j++) {
				if (userWord.equals(possibleWords[j])) {
					for (int x = 0; x < userWord.length(); x++) {
						for (int y = 0; y < alphabet.length; y++) {
							if (userWord.charAt(x) == alphabet[y]) {
								letterPoints += (y + 1);  // +1: at the first index of array is 0
							}
						}
					}
					int point = userWord.length() * (letterPoints);
					System.out.printf("You earned %d points for this word!\n", point);
					notFound = false;
					score += point;
					possibleWords[j] = empty;  // to removing the entered words from array
					break;  // doesn't need to looking for every word
				}
			}
			if (notFound) {
				System.out.println("You earned 0 points for this word!");
			}
		}
		in.close();
		System.out.printf("\nThe game is over! your total score is: %d", score);

	}

	public static int numOfLetters(String s) {  // to make array for shuffled letters
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ' || s.charAt(i) == '	') {
				;
			} else if (s.charAt(i) == ':') {
				break;
			} else if (s != "") {
				counter++;
			}
		}
		return counter;
	}

}
