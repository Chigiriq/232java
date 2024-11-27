

public class Edge implements Comparable<Edge>{
	
	private String vertex1;
	private String vertex2;
	private String movieName;
	
	private int weight;
	
	public Edge(String vertex1, String vertex2, String m,  int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.movieName = m;
		this.weight = weight;
	}
	
//	public int[] getVertices(){
//		return new int[] {vertex1, vertex2};
//	}
//	
	public String[] getVertices() {
		return new String[] {vertex1, vertex2};
	}
 	
	public int getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return vertex1 + " - " + vertex2 + " (" + movieName + ")";
	}
	
	public String getMovie() {
		return this.movieName;
	}
	
	//override the == operator (to ensure to duplicate edges in Graph class)
	public boolean equals(Object obj) {
		Edge otherEdge = (Edge) obj;
		if(vertex1.equals(otherEdge.vertex1) && vertex2.equals(otherEdge.vertex2)) {
			//0,1 == 0,1 --> true
			return true;
		}
		else if(vertex1.equals(otherEdge.vertex2) && vertex2.equals(otherEdge.vertex1)) {
			//(0,1) == (1,0) -- > true
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	// make sure out priority queue sorts from least to greatest based on edge weights
	public int compareTo(Edge otherEdge) {
		
		if(weight < otherEdge.weight) {
			return  -1;
		}
		else if(weight > otherEdge.weight) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

	public String getTo() {
		return this.vertex2;
	}

	public String getFrom() {
		return this.vertex1;
	}
}
