/**
 * 
 */
import java.util.Scanner;

public class MovieDriverTask2 {

	public static void main(String[] args) {
		// creates a Scanner object
		Scanner keyboard = new Scanner(System.in);
		char shouldContinue;
		
   	do {
			// creates a movie object
			Movie movie = new Movie();
			// stores the title of the movie
			String movieTitle;
			System.out.println("Enter the movie title: ");
			movieTitle = keyboard.nextLine();
			movie.setTitle(movieTitle);
			
			String rating;
			System.out.println("Enter the rating: ");
			rating = keyboard.nextLine();
			movie.setRating(rating);
			
			int ticketsSold; // stores the tickets sold at the theater
			System.out.println("Enter the number of tickets sold at a theater: ");
			ticketsSold = keyboard.nextInt();
			//sets the movie object's sold tickets to ticketsSold
			movie.setSoldTickets(ticketsSold);
			
			System.out.println(movie.toString());
			
			keyboard.nextLine();
			System.out.println("Do you want to enter another? (y/n):");
			shouldContinue = keyboard.next().charAt(0);
			
			keyboard.nextLine();
		} while (shouldContinue == 'y' || shouldContinue == 'Y');
		System.out.println("Goodbye!!!");
	}

}
