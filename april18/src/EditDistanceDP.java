import java.util.Arrays;

public class EditDistanceDP {

	public static void main(String[] args) {
		
		String str1 = "SNOWY";
		String str2 = "SUNNY";
		
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[n+1][m+1];
		for(int i = 0 ; i < n +1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int solution = editDistance(str1, str2, m, n, dp);
		System.out.println(solution);

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
