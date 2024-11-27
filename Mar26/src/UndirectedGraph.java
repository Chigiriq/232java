import java.util.LinkedList;

public class UndirectedGraph {

	
	private LinkedList<Integer>[] adjacencyList;
	private boolean[] visited; //used to make sure to only visit unvisited neighbors
	private int[] previousVertex; //used for determining path in graph
	private int num_of_edges;
	
	private int startVertex;
	
	public UndirectedGraph(int vertices) {
		this.adjacencyList = new LinkedList[vertices];
		for(int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new LinkedList<Integer>(); 
		}
		this.num_of_edges = 0;
		visited = new boolean[vertices];
		startVertex = 0;
		previousVertex = new int[vertices];
	}
	
	//create an edge between v1 and v2
	public void addEdge(int vertex1, int vertex2) {
		adjacencyList[vertex1].add(vertex2);
		adjacencyList[vertex2].add(vertex1);
		num_of_edges++;
	}
	
	// print out my adjencecny list 
	public void printGraph() {
		for(int i = 0; i < adjacencyList.length; i++) {
			System.out.println(i + "--> " + adjacencyList[i]);
		}
	}
	
	// remove a edge betweeen v1 and v2
	public void removeEdge(int vertex1, int vertex2) {
		
		//check if see if edge actually exists
		if(adjacencyList[vertex2].contains(vertex1) && adjacencyList[vertex1].contains(vertex2)) {
			
			//Integer = make sure that we are calling the correct remove method
			adjacencyList[vertex1].remove((Integer)vertex2);
			adjacencyList[vertex2].remove((Integer)vertex1);
			num_of_edges--;
			
		}
		
		
	}

	//returns the degree of some node
	public int getDegree(int vertex) {
		return adjacencyList[vertex].size();
	}

	//returns the neighbors of some node
	public LinkedList<Integer> getNeighbors(int n){
		return adjacencyList[n];
	}
	
	public void depthFirst(int n) {
		
		System.out.println(n); //do action
		visited[n] = true;
		for(int neighbor: getNeighbors(n)) {
			//only want to travel to the neighbor if it has not been visited
			if(!visited[neighbor]) {
				previousVertex[neighbor] = n;
				depthFirst(neighbor);
			}
		}
		
	}
	
	//Checks to see if we can reach the endVertex, after depthFirst has been completed
	public boolean isReachable(int endVertex) {
		depthFirst(startVertex);
		return visited[endVertex];
	}
	
	public LinkedList<Integer> getPath(int endVertex){
		//this won't be the optimal path
		
		if(!isReachable(endVertex)) {
			//if depth first did not find a path, there cannot be a path to endVertex
			return null;
		} 
		else {
			LinkedList<Integer> path = new LinkedList<>(); // holds our actual path
			
			//work backwards and build path back to starting vertex
			for(int v = endVertex; v != startVertex; v = previousVertex[v]) {
				path.addFirst(v);
			}
			path.addFirst(startVertex);
			return path;
		}
	}
	
	
}
