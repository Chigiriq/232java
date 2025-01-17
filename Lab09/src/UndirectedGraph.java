import java.util.HashSet;
import java.util.LinkedList;

public class UndirectedGraph {

	private LinkedList<Integer>[] adjacencyList;
	private boolean[] visited;
	private int numEdges;
	
	public UndirectedGraph(int size) {
		adjacencyList = new LinkedList[size];
		visited = new boolean[getVertices()];
		for(int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
		
		numEdges = 0;
		
	}
	
	public void addEdge(int vertex1, int vertex2) {
		adjacencyList[vertex1].add(vertex2);
		adjacencyList[vertex2].add(vertex1);
		numEdges++;
	}
	
	public void printGraph() {
		
		for(int i = 0; i < adjacencyList.length; i++) {
			System.out.println(i + ": " + adjacencyList[i]);
		}
		
	}
	
	public void removeEdge(int vertex1, int vertex2) {
		
		if(adjacencyList[vertex2].contains(vertex1) && adjacencyList[vertex1].contains(vertex2)) {
		
			adjacencyList[vertex1].remove( (Integer) vertex2);
			adjacencyList[vertex2].remove( (Integer) vertex1);
			numEdges--;
		}
	}
	
	public LinkedList<Integer> getNeighbors(int vertex){
		return adjacencyList[vertex];
	}
	
	public int getDegree(int vertex) {
		return adjacencyList[vertex].size();
	}
	
	public int getEdges() {
		return this.numEdges;
	}
	
	public int getVertices() {
		return this.adjacencyList.length;
	}
	
	//entire solution works off of print instead of println
	//https://stackoverflow.com/questions/64031674/system-out-print-vs-system-out-println-last-sentence
	public void depthFirst(int n) {
				
		System.out.print(n);
		visited[n] = true;
		for(int neighbor: getNeighbors(n)) {
			
			if(!visited[neighbor]) {
				
				System.out.print(", ");
				
				depthFirst(neighbor);
				
			}
		}
	}
	
	public boolean isTherePath(int vertex1, int vertex2) {
		depthFirst(vertex1);
		return visited[vertex2];
	}

	public void printConnectedComponents() {    //TO DO: Lab 9
		
		//HashSet to strore vertices of connected components HashSet<LinkedList<Integer>>
//		HashSet<LinkedList<Integer>> conVertices = new HashSet<LinkedList<Integer>>();
		//opted to just print the connected vertices in the dfs print since it can only visit neighbors so no need to store extra
		
		for (int i = 0; i < getVertices(); i++) {
			
			if (!this.visited[i]) {
				System.out.print("[");
				depthFirst(i);
				System.out.println("]");
			}
		}
	}
	
	
}