
public class UndirectedGraphDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		UndirectedGraph graph = new UndirectedGraph(6);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		
		System.out.println(graph.getPath(5));
		
		//graph.depthFirst(0);
		
		//graph.depthFirst(5);
		
		//graph.removeEdge(2, 1);
		
		graph.printGraph();
		
		//System.out.println(graph.getDegree(3));
		
		/*
		UndirectedGraphHashMap graph = new UndirectedGraphHashMap();
		
		graph.addVertex("Montana");
		graph.addVertex("Idaho");
		graph.addVertex("Wyoming");
		graph.addVertex("South Dakota");
		
		graph.addEdge("Montana", "Idaho");
		graph.addEdge("Montana", "Wyoming");
		graph.addEdge("Wyoming", "Idaho");
		graph.addEdge("Montana", "South Dakota");
		graph.addEdge("Wyoming", "South Dakota");
		
		graph.printGraph();
		*/
	}

}
