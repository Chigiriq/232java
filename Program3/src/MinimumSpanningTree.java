import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class MinimumSpanningTree {

	
	public void kruskalsAlgorithm(UndirectedWeightedGraph graph) {
		
		HashSet<Edge> mst = new HashSet<Edge>();
		
		//ccm = connected component marker (used to detect cycles)
		HashMap<String, Integer> ccm = new HashMap<String, Integer>();

		int i = 0;
		for (String vert: graph.getVertices()) {
			ccm.put(vert, 1);
			i++;
		}
		
//		System.out.println(ccm);
		
		PriorityQueue<Edge> edgeQueue = new PriorityQueue<Edge>();
		for(Edge edge: graph.getEdges()) {
			edgeQueue.add(edge);
		}
		
//		System.out.println(edgeQueue);
		
		while(!edgeQueue.isEmpty()) {
			
			Edge check = edgeQueue.poll();

			 if (ccm.containsKey(check.getVertices()[0]) && ccm.containsKey(check.getVertices()[1])) {
			        // Check if adding this edge creates a cycle
			        if (ccm.get(check.getVertices()[0]).intValue() == ccm.get(check.getVertices()[1]).intValue()) {	
						mst.add(check);

						int newMarker = ccm.get(check.getVertices()[0]);
				        int oldMarker = ccm.get(check.getVertices()[1]);
						
				        for (String vertex : ccm.keySet()) {
				            if (ccm.get(vertex).equals(newMarker)) {
				                ccm.put(vertex, oldMarker);
				            }
				        }
			        }
				
			}
			
		}
		
		//printing out first half of menu option 1
		int j = 1;
		for(Edge edge: mst) {
			System.out.println(j + ". " + edge);
			j++;
		}
		
		
		System.out.println();
		
		System.out.println("List of movies to watch that covers all 30 Actors:\r\n" + "---------------------");

		//printing out second half of menu option 1
		j = 1;
		LinkedList<String> movies = new LinkedList<String>();
		for(Edge edge: mst) {
			//if movie has been printed
			if (movies.contains(edge.getMovie())) {
				continue;
			}
			//movie has not been printed
			else {
				System.out.println(j + ": " + edge.getMovie());
				movies.add(edge.getMovie());
				j++;
			}
		}
		
	}
	
	
}
