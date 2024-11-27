
public class WeightedGraphDemo {

	public static void main(String args[]) {
		
		WeightedGraph graph = new WeightedGraph(6);
		
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 3, 7);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 5);
		graph.addEdge(2, 3, 2);
		graph.addEdge(2, 5, 2);
		graph.addEdge(3, 4, 3);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 5, 4);
		
		MinimumSpanningTree mst = new MinimumSpanningTree();
		mst.kruskalsAlgorithm(graph);
		
		
	}
	
}
