import java.util.Scanner;

public class Program4Demo {
	public static void main(String args[]) {
		Scanner scn = new Scanner (System.in);
		String entered_word = " ";
		
		//create hash table
		SpellCheck check = new SpellCheck("words.txt");
		check.loadQueue("words.txt");
		
		while (entered_word.charAt(0) != '0') {
			System.out.println("Enter a word (enter 0 to end): ");
			entered_word = scn.nextLine();
				
			//if entered_word in queue then
			if (check.check_doc(entered_word)) {
				System.out.println("You spelt the word correctly. Good Job!");
			}
			
			//not a word
			else {
				if (entered_word.charAt(0) != '0') {
					check.computeSimilar(entered_word);
				}
			}
		}		
		scn.close();
	}
}
