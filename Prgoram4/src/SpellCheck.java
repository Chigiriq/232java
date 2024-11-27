import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SpellCheck {
	String words;

	PriorityQueue<Word> wordQueue = new PriorityQueue<Word>();
	PriorityQueue<String> stringQueue = new PriorityQueue<String>();
	
	
	public SpellCheck(String w) {
		this.words = w;
		this.wordQueue = loadQueue(this.words);
	}

	//create a queue of
	//	1. Words (for computing spell corrections)
	//	2. Strings (for checking if word exists)
	public PriorityQueue<Word> loadQueue(String input2) {
		PriorityQueue<Word> temp = new PriorityQueue<Word>();
		
		try {
			Scanner input = new Scanner( new FileReader(this.words));
			while (input.hasNext()) {
				String line = input.nextLine();
				
				Word newWord = new Word(line, -1);
				
				temp.add(newWord);
				stringQueue.add(line);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("pain");
			e.printStackTrace();
		}
		
		return temp;
	}

	//Uses queue of strings to see if word exists
	public boolean check_doc(String enteredWord) {
		return this.stringQueue.contains(enteredWord.toLowerCase());
	}

	//sets a words edit distance and places it in a sorted queue
	public void computeSimilar(String enteredWord) {		
		PriorityQueue<Word> similarQueue = new PriorityQueue<Word>();
		for (Word w: wordQueue) {

			String word1 = enteredWord.toLowerCase();
			String word2 = w.getText();

			//make table of size of enteredWord by loop word	
			int[][] graph = new int[word1.length() + 1][word2.length() + 1];

	    	// Initialize graph with -1
	        for (int i = 0; i <= word1.length(); i++) {
	            for (int j = 0; j <= word2.length(); j++) {
	                graph[i][j] = -1;
	            }
	        }
	        
	        int dist = editDistance(word2, word1, word2.length(), word1.length(), graph);
			w.setDist(dist);

			similarQueue.add(w);
		}
		//sort		
		similarQueue.comparator();

		//print
		for (int j = 0; j < 10; j++) {
			Word currentWord = similarQueue.poll();
			System.out.println("Did you mean " + currentWord.getText() + "(" + currentWord.getDist() + ")");
		}
	}
	
	//Computes the edit distance between str1 and str2 in polynomial time
	public static int editDistance(String str1, String str2, int m, int n, int[][] dp) {
		//base case
		if(m == 0) {
			return n;
		}
		else if(n == 0) {
			return m;
		}
		//Check memoization table if we already have the answer
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			int x = editDistance(str1, str2, m-1, n-1, dp);
			dp[n][m] = x;
			return dp[n][m];
		}
		
		//Try our three possible options for a misalignment
		int insert = 1 + editDistance(str1, str2, m, n-1, dp);
		int remove = 1 + editDistance(str1, str2, m-1, n, dp);
		int replace = 1 + editDistance(str1, str2, m-1, n-1, dp);
		
		//Select the minimum branch
		int solution = Math.min(Math.min(insert, remove), replace);
		dp[n][m] = solution;
		return dp[n][m];	
	}

}
