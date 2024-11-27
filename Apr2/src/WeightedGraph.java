import java.util.HashSet;
import java.util.LinkedList;

public class WeightedGraph {

	// vertices are integers
	private LinkedList<Edge>[] adjList;
	
	//for program3
	//private HashMap<String, LinkedList<Edge>> adjList;
	
	//store all edges of graph-- no duplicate edges
	private HashSet<Edge> edges;
	
	public WeightedGraph(int numVertices) {
		adjList = new LinkedList[numVertices];
		
		for(int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<>();
		}
		
		edges = new HashSet<Edge>();
	}
	
	public int getNumVertices() {
		return adjList.length;
	}
	
	public int getNumEdges() {
		return edges.size();
	}
	
	public HashSet<Edge> getEdges(){
		return edges;
	}
	
	public void addEdge(int v1, int v2, int weight) {
		Edge edge = new Edge(v1, v2, weight);
		
		if(edges.add(edge)) {
			adjList[v1].add(edge);
			adjList[v2].add(edge);
		}
		
		
	}
	
}
