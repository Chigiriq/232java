
public class Node {

	private int value;
	
	private Node left;
	private Node right;
	
	private Node parent;
	
	public Node(int newValue) {
		this.value = newValue;
	}
	
	//getter methods
	public int getValue() {
		return this.value;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	//setter
	public void setParent(Node newParent) {
		this.parent = newParent;
	}
	
	public void setLeft(Node newLeft) {
		this.left = newLeft;
	}
	
	public void setRight(Node newRight) {
		this.right = newRight;
	}

	public void setValue(int newValue) {
		// TODO Auto-generated method stub
		this.value = newValue;
		
	}
	
}
