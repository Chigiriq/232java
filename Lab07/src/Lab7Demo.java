import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Lab7Demo {
	
	public static void main(String[] args) {
		makeAL(10000);
		makeLL(10000);
		makeTS(10000);
		makeHS(10000);
	}

	
	private static void makeAL(int n) {
		ArrayList<Integer> AL = new ArrayList<Integer>();
		long start_time = System.nanoTime();
		
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			
			int rand_int = rand.nextInt(1000);
			
			AL.add(rand_int);
		}
		
		long end_time = System.nanoTime();
		long elapsed_time = (end_time - start_time); 
		System.out.println("Time taken to add 10,000 things to an Array List: " + elapsed_time+ " ns");
	}
	
	private static void makeLL(int n) {
		LinkedList<Integer> LL = new LinkedList<Integer>();
		long start_time = System.nanoTime();
		
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			
			int rand_int = rand.nextInt(1000);
			
			LL.add(rand_int);
		}
		
		long end_time = System.nanoTime();
		long elapsed_time = (end_time - start_time); 
		System.out.println("Time taken to add 10,000 things to a Linked List: " + elapsed_time+ " ns");
	}


	private static void makeTS(int n) {
		TreeSet<Integer> TS = new TreeSet<Integer>();
		long start_time = System.nanoTime();
		
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			
			int rand_int = rand.nextInt(1000);
			
			TS.add(rand_int);
		}
		
		long end_time = System.nanoTime();
		long elapsed_time = (end_time - start_time); 
		System.out.println("Time taken to add 10,000 things to a Tree Set: " +elapsed_time+ " ns");
	}


	private static void makeHS(int n) {
		HashSet<Integer> HS = new HashSet<Integer>();
		long start_time = System.nanoTime();
		
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			
			int rand_int = rand.nextInt(1000);
			
			HS.add(rand_int);
		}
		
		long end_time = System.nanoTime();
		long elapsed_time = (end_time - start_time); 
		System.out.println("Time taken to add 10,000 things to a Hash Set: " +elapsed_time + " ns");
	}
}
