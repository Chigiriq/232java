
public class testing {
    public static void main(String[] args) {
    	String word1 = "caompeter";
    	String word2 = "compeer";
    	
    	int[][] graph = new int[word1.length() + 1][word2.length() + 1];
    	
    	// Initialize graph with -1
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                graph[i][j] = -1;
            }
        }
    	
    	int dist = editDistance(word2, word1, word2.length(), word1.length(), graph);

    	
    	System.out.println(dist);
    }
    
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