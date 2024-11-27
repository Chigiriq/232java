import java.util.Scanner;

public class SpellCheckDemo {
	public static void main(String args[]) {

		SpellCheck check = new SpellCheck("words.txt", "input.txt");
		
		//load hashmap and hashset
		
		
		Scanner scn = new Scanner (System.in);
		char user_choice = '0';
		
		while (user_choice != '4') {
			System.out.println("1: Spell Check your document "); //+ document
			System.out.println("2: Print word frequency alphabetically");
			System.out.println("3: Print word frequency from greatest to least");
			System.out.println("4: Exit program");
			
			user_choice = scn.next().charAt(0);
			
			if (user_choice == '1') {
				check.check_doc();
			}
			
			else if (user_choice == '2') {
				check.print_word_freq();
			}
			
			else if (user_choice == '3') {
				check.print_word_freqGTL();
			}
			
			else {
				if (user_choice != '4') {
					System.out.println("Invalid choice entered, please enter number between 1 and 4!");
				}
			}
			
		}
		
		
		scn.close();
		
//		check.check_doc();
	}
}
