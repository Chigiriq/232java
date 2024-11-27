import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class EmojiTranslator {
	
	
	public EmojiTranslator() {
		
	}
	
	//take in file and create hash map and hash set
	public HashMap<String, String> loadHashTable(String filename) { //eclipse wants me to do this idk how much it helps though
		 
		HashMap<String, String> emojiMap = new HashMap<String, String>();
		
		try {
			Scanner input = new Scanner( new FileReader(filename) );
			
			while(input.hasNext() ) {
				String line = input.nextLine();
				
				String[] vals = line.split(",");
				String emoji = vals[0];
				String code = vals[1];
				
				emojiMap.put(code, emoji); //https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
										   //THE AMOUNT OF TIME IT TOOK FOR ME TO SWITCH THESE TWO AROUND WAS TOO LONG			
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("pain");
			e.printStackTrace();
		}
		
		
		return emojiMap;
		
	}
	
	//take a sentence and convert emoji codes
	public String convert(String string) { 
		
		HashMap<String, String> emojiMap = loadHashTable("emojis.txt");
		String newSentence = "";
		String[] split_sentence = string.split(" ");
		
		for (String s: split_sentence) {
			
			String result = emojiMap.get(s);
			
			if (result != null) {
				newSentence += result + " ";
			}
			
			else {
				newSentence += s + " ";
			}
			
		}
		
		
		return newSentence;
	}

	//take in string and match code then return the emoji
	public String getEmoji(String string) {	
		HashMap<String, String> emojiMap = loadHashTable("emojis.txt");

		String fixed_string = ":" + string + ":";
		
		if (emojiMap.get(fixed_string) != null) {
			return emojiMap.get(fixed_string);
		}
		
		else {
			return "Emoji not found: " + string;
		}
		
	}

}
