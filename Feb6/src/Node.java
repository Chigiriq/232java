
import java.util.ArrayList;

public class Node {

	private String name; //name of directory 
	private Node parent;
	private ArrayList<Node> children;
	private int depth;
	
	public Node(String n, int d) {
		this.name = n;
		this.depth = d;
		this.children = new ArrayList<Node>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public ArrayList<Node> getChildren(){
		return this.children;
	}
	
	public void addChild(Node newChild) {
		this.children.add(newChild);
	}
	
	public void setParent(Node newParent) {
		this.parent = newParent;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	
}
