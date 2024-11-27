import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestPath {

	
//	private double[] distance; //best estimates to each vertex
//	private Edge[] previous; //keeps track of the Edge that got us to that vertex
	//For program these, these two data structures will be HashMaps
	
	private HashMap<String, Double> distance;
	private HashMap<String, Edge> previous;
	
	private int hops = 0;

	//finds the shortest path from one actor to another using dijktra's algorithm
	public void computeShortestPath(UndirectedWeightedGraph graph, String start) {
		//Dijkstra's Algorithm
		distance = new HashMap<String, Double>();
		
		for (String vert: graph.getVertices()) {
			distance.put(vert, Double.POSITIVE_INFINITY);
		}

		distance.put(start, 0.0);

		previous = new HashMap<String, Edge>();
		
		PriorityQueue<PriorityVertex> visitQueue = new PriorityQueue<PriorityVertex>();
		visitQueue.add( new PriorityVertex(start, 0.0) );		
		
		while(!visitQueue.isEmpty()) {
			
			PriorityVertex vertex = visitQueue.poll();
			//Check all the paths we can travel on with our new vertex
			for(Edge edge: graph.getAdjacencyEdges(vertex.getVertex())) {
				
				String neighbor = edge.getTo();
				double newDist = distance.get(vertex.getVertex()) + edge.getWeight();

				if (newDist < distance.get(neighbor)) {
				
					//we found a new best estimate, so update our data structures
					distance.put(neighbor, newDist);
					previous.put(neighbor, edge);
					
					//We need to remove the old vertex from the PQ and insert the new one
					visitQueue.remove( new PriorityVertex(neighbor, 0)  ); // 0 can be any number
					visitQueue.add(new PriorityVertex(neighbor, newDist));

				}
				
			}

		}
	}

	//Determines if we have a path after Dijkstra's.
	//    The best estimate for destination will still be infinity if we never touched it
	public boolean hasPath(String destination) {
		return distance.get(destination) < Double.POSITIVE_INFINITY;
	}
	
	
	//Backtracks through the "previous" array and assembles our shortest path
	public LinkedList<Edge> getPathTo(String destination) {
		
		if( !hasPath(destination)) {
			return null;
		}
		else {
			LinkedList<Edge> solution = new LinkedList<Edge>();
			Edge edge = previous.get(destination);
			while(edge != null) {
				solution.addFirst(edge);
				edge = previous.get(edge.getFrom());
			}
			
			hops = solution.size();
			
			return solution;
			
		}
		
	}
	
	public int getHops() {
		return hops;
	}
	
	

}
