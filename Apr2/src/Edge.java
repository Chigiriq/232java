
public class Edge implements Comparable<Edge>{

	private int vertex1;
	private int vertex2;
	
	private int weight;
	
	public Edge(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	public int[] getVertices(){
		return new int[] {vertex1, vertex2};
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return "(" + vertex1 + ", " + vertex2 + "): " + weight;
	}
	//override the == operator (to ensure to duplicate edges in Graph class)
	public boolean equals(Object obj) {
		Edge otherEdge = (Edge) obj;
		if(vertex1 == otherEdge.vertex1 && vertex2 == otherEdge.vertex2) {
			//0,1 == 0,1 --> true
			return true;
		}
		else if(vertex1 == otherEdge.vertex2 && vertex2 == otherEdge.vertex1) {
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
	
}
