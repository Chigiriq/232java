import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UndirectedWeightedGraph {

	//HashMap<key, value> ----> HashMap<vertices, edge>
	private HashMap<String, LinkedList<Edge>> adjList;
	
	//HashMap<key, value> ----> HashMap<actor, edge>
	private HashMap<String, LinkedList<Edge>> adjListMST;
	
	//store all edges of graph-- no duplicate edges
	private HashSet<Edge> graphEdges;

	private String filename;
	private HashSet<String> actorsList;

	//constructor
	public UndirectedWeightedGraph(String s) {
		this.filename = s;
		this.graphEdges = new HashSet<Edge>();
		this.actorsList = new HashSet<String>();
		this.adjList = readGraph();	
		this.adjListMST = printGraph();
	}

	//read in from input file and create hash map of type <Movie, Edges>
	//Also called in init
	//loops through
	//		1. reading file
	//		2. HashMap <Movie, Actors> into HashMap <Movie, Edges>
	public HashMap<String,LinkedList<Edge>> readGraph() {
		
		//create hash map
		HashMap<String, LinkedList<Edge>> graph = new HashMap<String, LinkedList<Edge>>();
		
		//create a temp HashMap of Strings (Movies) to LL of Strings (Actors in that movie)
		HashMap<String, LinkedList<String>> temp = new HashMap<String, LinkedList<String>>();
		
		//open and read file
		try { 
			Scanner input = new Scanner( new FileReader(filename));

			while (input.hasNext()) {
				String line = input.nextLine();
				String[] words = line.split("\\|");
				
				//make list of actors
				LinkedList<String> actors = temp.getOrDefault(words[1], new LinkedList<String>());
				actors.add(words[0]);
				
				this.actorsList.add(words[0]);
				//link movie to actor lists
				temp.put(words[1], actors);
				
				
			}
			input.close();

			
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
			e.printStackTrace();
		}



		for (Map.Entry<String, LinkedList<String>> entry: temp.entrySet()) {  //https://sentry.io/answers/iterate-hashmap-java/
		
			String movie = entry.getKey();
			LinkedList<String> actorList = entry.getValue();
		
			//get vertice1 = actor1
			for (String actor1: actorList) {
				
			    //get vertice2 = actor2
				for (String actor2: actorList) {
					Edge edge = new Edge(actor1, actor2, movie, 1); //setting weight as 1 for now
					
					//handle self loop case
					if (actor1.equals(actor2)) {
						continue;  	//https://www.w3schools.com/java/java_break.asp
					}
					
					//symmetric edges: allow for edge(a,b) but not edge(b,a)
					else if (graph.containsKey(movie)) {
						LinkedList<Edge> edges = graph.get(movie);
						Edge sym = new Edge(actor2,actor1, movie, 1);
						
						if (edges.contains(sym)) {
							continue;  	//https://www.w3schools.com/java/java_break.asp
						}
					}
					
					//add edge						
					graph.computeIfAbsent(movie, k -> new LinkedList<Edge>()).add(edge);	
					
					graphEdges.add(edge);
				}
				
			}
			
		}
		System.out.println();

		return graph;
	}
	
	//Create a new hashmap of type <Actor, Edges> from type <Movie, Edges>
	//Loops called:
	//		1. go from HashMap<Movie, Edges> to HashMap<Actor name, Edges>
	//		2. print out Actor name and its edges 
	public HashMap<String, LinkedList<Edge>> printGraph() {
		Map<String, LinkedList<Edge>> printMap = new HashMap<String, LinkedList<Edge>>();

	    //create new hashmap
	    for (Map.Entry<String, LinkedList<Edge>> entry : this.adjList.entrySet()) {
	        LinkedList<Edge> edges = entry.getValue();

	        for (Edge edge: edges) {
	            String actor1 = edge.getVertices()[0];
	            String actor2 = edge.getVertices()[1];
	            
	            // Add actor2 to the list of edges for actor1
	            printMap.computeIfAbsent(actor1, k -> new LinkedList<Edge>()).add(edge);
	            
	            // Add actor1 to the list of edges for actor2
	            printMap.computeIfAbsent(actor2, k -> new LinkedList<Edge>()).add(edge);
	        }
	    }

	    //print new hashmap
//	    for (Entry<String, LinkedList<Edge>> entry : printMap.entrySet()) {
//	        String actor = entry.getKey();
//	        LinkedList<Edge> edges = entry.getValue();
//	        
//	        System.out.println(actor + ": " + edges);
//	    }
	    
		return (HashMap<String, LinkedList<Edge>>) printMap;
	}

	//returns all edges in graph
	public HashSet<Edge> getEdges() {
		return graphEdges;
	}
	
	//returns a set of vertices from adj list
	public Set<String> getVertices() {     // https://stackoverflow.com/questions/5139724/whats-the-difference-between-hashset-and-set
		return this.adjListMST.keySet();
	}

	//returns the amount of vertices in the adj list
	public int getNumVertices() {
		return this.adjList.size();
	}

	//adj list return for Dijkstra's alg
	public LinkedList<Edge> getAdjacencyEdges(String vertex) {
		return this.adjListMST.getOrDefault(vertex, new LinkedList<Edge>());
	}
	
	//Returns a list of all actors in the dataset
	public HashSet<String> getActors() {
		return this.actorsList;
	}

	//computes the degree statistics of the graph... see more description in demo
	public void computeDegree() {
	    int totalDegree = 0;
	    
	    int leastDegree = Integer.MAX_VALUE;
	    int mostDegree = 0;
	    String leastActor = null;
	    String mostActor = null;
	    
	    int numVertices = getNumVertices();


	    for (String actor : getVertices()) {
	        LinkedList<Edge> adjacencyEdges = getAdjacencyEdges(actor);
	        int degree = adjacencyEdges.size();
	        totalDegree += degree;
	        
	        //update to find least used actor
	        if (degree < leastDegree) {
	        	leastDegree = degree;
	        	leastActor = actor;
	        }
	        
	        //update to find most used actor
	        else if (degree > mostDegree) {
	        	mostDegree = degree;
	        	mostActor = actor;
	        }
	        
	    }

	    double averageDegree = (double) totalDegree / numVertices;
	    String rounded = String.format("%.2f", averageDegree); //https://www.baeldung.com/java-double-round-two-decimal-places
	    System.out.println("Average degree of the graph: " + rounded);
	        
	    System.out.println("Actor with lowest degree: " + leastActor);
	    System.out.println("Actor with highest degree: " + mostActor);
	
	    System.out.println();
	}

}
