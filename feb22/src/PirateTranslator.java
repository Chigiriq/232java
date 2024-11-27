import java.util.HashMap;
import java.util.Scanner;

public class PirateTranslator {

	public static void main(String[] args) {
		
		
		HashMap<String, String> translator = new HashMap<String, String>();
		
		translator.put("hello", "ahoy");
		translator.put("friend", "matey");
		translator.put("yes", "aye");
		translator.put("stop", "heave");
		translator.put("treasure", "booty");
		translator.put("csci232", "Davey Jones's Locker");
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter phrase in english: ");
		
		String sentence = input.nextLine().toLowerCase();
		
		String newSentence = "";
		String[] splitted_sentence = sentence.split(" ");
		for(String s: splitted_sentence) {
			
			String result = translator.get(s);
			if(result != null) {
				newSentence += result + " ";
			}
			else {
				newSentence += s + " ";
			}
		}
		System.out.println(newSentence);

	}

}
