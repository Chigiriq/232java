import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SpellCheck {
	String words;
	String input;
	HashMap<String, Integer> hashTable;
//	HashSet hashSet;
	
	
	public SpellCheck(String w, String in) {
		this.words = w;
		this.input = in;
		this.hashTable = loadHashTable(this.input); //is this legal idk
//		this.hashSet = loadHashSet(this.words);

	}
	//HashMap<key, value>
	public HashMap<String, Integer> loadHashTable(String filename) {
		
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		int[] punc_nums = {0, 0, 0, 0};
		
		//input.txt -> hash map
		try {
			Scanner input = new Scanner( new FileReader(filename));
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] words = line.split(" ");  //thank you stack overflow https://stackoverflow.com/questions/15625629/regex-expressions-in-java-s-vs-s
				String punctuation_list = ".,?!";
				
				//handle punctuation
				for (int i = 0; i < words.length; i++) {
					String punctuation_add = "";
										
					//identify punctuation XXX CHECK LATER 
					for (char c: words[i].toCharArray()) {
						if (punctuation_list.contains(Character.toString(c))) {
							punctuation_add = Character.toString(c);
							
							if (punctuation_add.equals(".")) {
								punc_nums[0] = punc_nums[0] + 1;
							}
							
							else if (punctuation_add.equals(",")) {
								punc_nums[1] = punc_nums[1] + 1;
							}
							
							else if (punctuation_add.equals("?")) {
								punc_nums[2] = punc_nums[2] + 1;
							}
							
							else if (punctuation_add.equals("!")) {
								punc_nums[3] = punc_nums[3] + 1;
							}
							
							
							words[i] = words[i].replace(Character.toString(c), "");
						}
					}
					
					
					//String in hashmap is same as words fixed
					if (table.containsKey(words[i].toLowerCase())) {
						table.put(words[i].toLowerCase(), table.get(words[i].toLowerCase()) + 1);
					}
				
					
					else {
						table.put(words[i].toLowerCase(), 1);
					}
				
				}
				//place puncs
				table.put("periods", punc_nums[0]);
				table.put("commas", punc_nums[1]);
				table.put("question", punc_nums[2]);
				table.put("exclamation", punc_nums[3]);			
			}
		} catch (FileNotFoundException e) {
			System.out.println("pain");
			e.printStackTrace();
		}	
		
		
		return table;
	}
	
	//part 3 -- DONE
	public void check_doc() {
		HashSet<String> set = new HashSet<String>();
		
		//words.txt -> hash set
		try {
			Scanner input = new Scanner( new FileReader(this.words));
			while (input.hasNext()) {
				String line = input.nextLine();
				
				set.add(line); //load the second line later	
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("pain");
			e.printStackTrace();
		}
		
		
		//read through input.txt
		try {
			Scanner input2 = new Scanner( new FileReader(this.input));
			while (input2.hasNext()) {
				String line2 = input2.nextLine();
				String[] inputWords = line2.split(" ");  //thank you stack overflow https://stackoverflow.com/questions/15625629/regex-expressions-in-java-s-vs-s
				
				//handle punctuation and locate words that are incorrect
				String punctuation_list = ".,?!";				
				for (int i = 0; i < inputWords.length; i++) {
					String punctuation_add = "";
					
					for (char c: inputWords[i].toCharArray()) {
						if (punctuation_list.contains(Character.toString(c))) {
							punctuation_add = Character.toString(c);
							
							
							inputWords[i] = inputWords[i].replace(Character.toString(c), "");
						}
					}
					
					if (!set.contains(inputWords[i].toLowerCase())) {
						line2 = line2.replaceAll(inputWords[i], "<" + inputWords[i] + ">");

					}
				}
				
				System.out.println(line2);
			}
		} catch (FileNotFoundException e) {
				System.out.println("pain");
				e.printStackTrace();
			}
			
			
	}

	//part 4 -- mostly done (weird stuff going on w puncs)
	public void print_word_freq() {
		
		Set<String> keySet = this.hashTable.keySet(); //https://www.geeksforgeeks.org/how-to-convert-hashmap-to-arraylist-in-java/
		ArrayList<String> listKeys = new ArrayList<String>(keySet); 
//		Collection<Integer> values = this.hashTable.values();
//		ArrayList<Integer> listOfValues = new ArrayList<Integer>(values);

//		System.out.println("The Keys of the Map are " + listOfKeys); 
//		System.out.println("The Values of the Map are " + listOfValues); 
		
		Collections.sort(listKeys);
//		System.out.println(listKeys);
		
		for (String s: listKeys) {
			System.out.println(s + ": " + this.hashTable.get(s));
		}
		
	}
	

	//part 5
	public void print_word_freqGTL() {
		
		//create invMap
		HashMap<Integer, HashSet<String>> invMap = new HashMap<Integer, HashSet<String>>();
		for (Map.Entry<String, Integer> entry: this.hashTable.entrySet()) { //https://sentry.io/answers/iterate-hashmap-java/
			
			//create a new hash set every iteration
			HashSet<String> newSet = invMap.get(entry.getValue());			
			
			//handle first run
			if (newSet == null) {
				newSet = new HashSet<String>();
				invMap.put(entry.getValue(), newSet);
			}
			
			newSet.add(entry.getKey());			
		}
//		System.out.println(invMap);

		//loop for printing
		for (int i = Collections.max(invMap.keySet()); i > 0; i--) {
			
			String currentValue = "";
			for (Map.Entry<Integer, HashSet<String>> entry: invMap.entrySet()) {
				
				if (entry.getKey() == i) {
					
					if (currentValue.equals("")) {
						currentValue = currentValue + entry.getValue().toString();
					}
					
					else {
						currentValue = currentValue + ", " + entry.getValue().toString();
					}
				}
			}
			
			//remove brackets
			if (!currentValue.equals("")) {
//				currentValue = currentValue.replace("[", "");
//				currentValue = currentValue.replace("]", "");
				
				currentValue = currentValue.substring(1, currentValue.length() - 1);
			}
			
			System.out.println(i + ": " + currentValue);
		}
		System.out.println();
	}


}
