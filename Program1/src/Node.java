
public class Node {
	
	private int value;
	private String name;
	private Node rightChild;
	private Node leftChild;
	private Node parent;
	
	public Node(int v, String n) {
		this.value = v;
		this.name = n;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Node getLeft() {
		return this.leftChild;
	}
	
	public Node getRight() {
		return this.rightChild;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setParent(Node newParent) {
		this.parent = newParent;
	}
	
	public void setLeft(Node newNode) {
		this.leftChild = newNode;
	}
	
	public void setRight(Node newNode) {
		this.rightChild = newNode;
	}
	
	public void setValue(int newValue) {
		this.value = newValue;
	}
	
}
