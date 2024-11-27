import java.util.LinkedList;
import java.util.Scanner;

public class Program3Demo {
	public static void main(String args[]) {

		UndirectedWeightedGraph graph = new UndirectedWeightedGraph("actors-small.txt");
		
		Scanner scn = new Scanner (System.in);
		char user_choice = '0';
		
		while (user_choice != '4') {
//			graph.printGraph();
			System.out.println("Enter your choice: \r\n"
					+ "1. Print out MST Information\r\n"
					+ "2. Find Shortest Path from one Actor to another\r\n"
					+ "3. Your Custom Method [You will describe your method here]\r\n"
					+ "4. Exit");
			
			user_choice = scn.next().charAt(0);
			
			//compute a valid, optimal minimum spanning tree, and the unique movies of the MST 
			if (user_choice == '1') {
				MinimumSpanningTree tree = new MinimumSpanningTree();
				System.out.println("Edges in MST:\r\n" + "---------------------");
				tree.kruskalsAlgorithm(graph);
				
				System.out.println();
				
				
			}
			
			//computes a valid, optimal (shortest) path from one actor to another
			//also identifies that there is not a path if the user provides an actor that does not exists
			//Only works in 1/2 the direction (top of input file down)
			//not entirely sure why its locked to this rule
			else if (user_choice == '2') {
				Scanner scn2 = new Scanner (System.in);
				System.out.println("Enter starting actor: ");
				String user_choice2 = scn2.nextLine();
				

				Scanner scn3 = new Scanner (System.in);
				System.out.println("Enter second actor: ");
				String user_choice3 = scn3.nextLine();

				System.out.println("Searching from " + user_choice2 + " to " + user_choice3 + ": ");
				
				if (!graph.getActors().contains(user_choice2) || !graph.getActors().contains(user_choice3)) {
					System.out.println("There is no path between " + user_choice2 + " and " + user_choice3);
				}
				
				else {
					ShortestPath sp = new ShortestPath();
					sp.computeShortestPath(graph, user_choice2);
				
					LinkedList<Edge> shortestPath = sp.getPathTo(user_choice3); 
					for(Edge e: shortestPath) {
						System.out.println(e.getVertices()[0] + " acted with " + e.getVertices()[1] + " in <" + e.getMovie() + ">");
					}
					System.out.println("Number of hops: " + sp.getHops());
				}	
				System.out.println();
			}
			
			//Personal function:
			//1. Average Degree//Connections for dataset
			//2. Least connected vert
			//3. Most connevted vert
			
			else if (user_choice == '3') {
				graph.computeDegree();
			}
			
			//end or reprompt user
			else {
				if (user_choice != '4') {
					System.out.println("Invalid choice entered, please enter number between 1 and 4!");
				}
			}
		}
		
		scn.close();
	}
}
