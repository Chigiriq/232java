import java.util.HashMap;

public class Lab11Demo {

	private static HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
		
	public static void main(String[] args) {
	
		//TO DO: Write the fib() method and use top-down dynamic programming (recursion, memoization table) to calculate fibonacci digits.
		//   You are welcome to change anything in this class, but your program should calculate the 10th, 60th, and 80th fibonnaci digit.
		//   You can use an array or a HashMap for your memoization table (HashMap might be easier)
		
		
		System.out.println("The 10th Fibonacci digit is: " + fib(10));
		System.out.println("The 60th Fibonacci digit is: " + fib(60));
		System.out.println("The 80th Fibonacci digit is: " + fib(80));
		
	}

	
	// You will likely need to change the arguments to this method
	// Fibonacci digits are really big, so this method needs to return a long 

	public static long fib(int n) {
		long value;
			
		//base case
		if (n <= 1) {
			return n;
		}
		
		//memo case
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		
		//recursive case
		else {
//			return fib(n-1) + fib(n-2); 
			value = fib(n-1) + fib(n-2);
			memo.put(n, value);
			return value;
		}
		
	}

}
