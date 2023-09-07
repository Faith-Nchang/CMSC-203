/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: a program that tests your ESP (extrasensory perception)
 * Due: 09/05/2023
 * Platform/compiler: Windows - Eclipse
 * Assignmnet #: 1
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Faith Nchang
*/
import java.util.Scanner; // imports the scanner class to ask the user for input
import java.util.Random; // imports the random class


public class ESPGame
{
	public static void main(String[] args)
	{
		// constant variables of all the 7 colors
		final String COLOR_RED = "Red";
		final String COLOR_GREEN = "Green";
		final String COLOR_BLUE = "Blue";
		final String COLOR_ORANGE = "Orange";
		final String COLOR_YELLOW = "Yellow";
		final String COLOR_INDIGO = "Indigo";
		final String COLOR_VIOLET = "Violet";
		 
		final int ASSIGNMENT_NUM = 1; // stores the assignment number
		final int TOTAL_ROUNDS = 11; // stores the maximum number of times the user will make a guess
		final int TOTAL_COLORS = 7; // stores all the total colors
	
		
		// creates a scanner object(keyboard) to prompt the user for input
		Scanner keyboard = new Scanner(System.in);
		
		String userName; //store the user's name
		//prompts the user for their name
		System.out.print("Enter your name: ");
		userName = keyboard.nextLine(); // stores the user input in the userName variable
		
		int mNumber; // stores the user's M number
		System.out.print("Enter your MC M number: ");
		mNumber = keyboard.nextInt();
		
		keyboard.nextLine(); // stores the extra new line character in the keyboard buffer
		
		String userDescription; //  store a brief description of the user
		System.out.print("Describe yourself: ");
		userDescription = keyboard.nextLine();
		
		String dueDate; // stores the due date the user will input
		System.out.print("Due Date (MM/DD/YY): ");
		dueDate = keyboard.nextLine();
		
		System.out.println("CMSC203 Assignment " + ASSIGNMENT_NUM + ": Test your ESP skills");
		
		int roundNumber; // stores the current round the user is guessing
		String userGuessColor, // stores the color the user will guess
			   randomColor; // stores the generated random color
		int randomColorNumber; // stores the random number which will be used to determine the random color
		int userCorrectGuesses = 0; // stores the running total number of guesses the user got right
		
		// creates a random number object between 0 and 6
		Random randomNumbers = new Random();
		
		// loops 11 times prompting the user for a guess within each iteration
		for (roundNumber = 1; roundNumber <= TOTAL_ROUNDS; roundNumber++)
		{
			System.out.println("Round " + roundNumber);
			// creates a random integer number and assign it to randomColorNumber
			randomColorNumber = randomNumbers.nextInt(TOTAL_COLORS);
			
			// determines the random color depending on the randomColorNumber generated from the Random class
			switch(randomColorNumber)
			{
				case 0:
					randomColor = COLOR_RED;
					break;
				case 1:
					randomColor = COLOR_GREEN;
					break;
				case 2:
					randomColor = COLOR_BLUE;
					break;
				case 3: 
					randomColor = COLOR_ORANGE;
					break;
				case 4:
					randomColor = COLOR_YELLOW;
					break;
				case 5:
					randomColor = COLOR_INDIGO;
					break;
				case 6:
					randomColor = COLOR_VIOLET;
					break;
				default:
					randomColor = "none"; // might never happen, but just in case the random color number is out range
					break;
			
			}
			
			System.out.println("\nI am thinking of a color.");
			System.out.println("Is it " +COLOR_RED+", " +COLOR_GREEN+ ", " +COLOR_BLUE+ ", " +COLOR_ORANGE+ ", " +COLOR_YELLOW+ ", " +COLOR_INDIGO+ ", or " +COLOR_VIOLET+ "?");
			
			//prompts the user for a guess
			System.out.println("Enter your guess: ");
			userGuessColor = keyboard.nextLine(); // stores user guess in the userGuessColor variable		

			//validates whether what the user inputs is in the list of color names
		
			while(!userGuessColor.equalsIgnoreCase(COLOR_RED) && !userGuessColor.equalsIgnoreCase(COLOR_GREEN) && !userGuessColor.equalsIgnoreCase(COLOR_BLUE) && !userGuessColor.equalsIgnoreCase(COLOR_ORANGE) 
					&& !userGuessColor.equalsIgnoreCase(COLOR_YELLOW) && !userGuessColor.equalsIgnoreCase(COLOR_INDIGO) && !userGuessColor.equalsIgnoreCase(COLOR_VIOLET))
			{
				System.out.print("You entered an incorrect color. ");
				System.out.println("Is it " +COLOR_RED+", " +COLOR_GREEN+ ", " +COLOR_BLUE+ ", " +COLOR_ORANGE+ ", " +COLOR_YELLOW+ ", " +COLOR_INDIGO+ ", or " +COLOR_VIOLET+ "?");
				System.out.println("Enter your guess again: "); // re-prompts the user for their guess
				userGuessColor = keyboard.nextLine();
			}
			
			
			// if the user's guess is equal to the random color
			if(randomColor.equalsIgnoreCase(userGuessColor))
				userCorrectGuesses++; // increments user correct guesses
			//displays the random color
			System.out.println("\nI was thinking of " + randomColor);
			
		}
		
		System.out.println("Game over.");
		// displays the number guesses the user got right
		System.out.println("\nYou guessed " +userCorrectGuesses+ " out of "+TOTAL_ROUNDS+" correctly.");
		System.out.println("User Name: " + userName);
		System.out.println("MC M number: " + mNumber);
		System.out.println("User Description: " + userDescription);
		System.out.println("Due Date: " +dueDate);

	}
}