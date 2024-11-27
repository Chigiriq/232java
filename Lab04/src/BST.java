import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

	private Node root;
	private int count;
	
	public BST() {
		this.root = null;
		this.count = 1;
	}
	
	public void insert(int newValue) {
		
		if(root == null) {
			root = new Node(newValue);
		}
		else {
			
			Node currentNode = root;
			boolean placed = false;
			
			while(!placed) {
				
				if(currentNode.getValue() == newValue) {
					placed = true;
					System.out.println("No duplicate values allowed");
				}
				else if(newValue < currentNode.getValue()) {
					//move left
					if(currentNode.getLeft() == null) {
						// cant move left, so we found insertion spot
						//insert Node
						currentNode.setLeft(new Node(newValue));
						currentNode.getLeft().setParent(currentNode);
						placed = true;
					}
					else {
						// otherwise move left
						currentNode = currentNode.getLeft();
					}
				}
				else {
					//move right
					if(currentNode.getRight() == null) {
						//cant move right, insert new node
						currentNode.setRight(new Node(newValue));
						currentNode.getRight().setParent(currentNode);
						placed = true;
					}
					else {
						//move right
						currentNode = currentNode.getRight();
					}
				}	
			}		
		}	
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	
	//These are the four methods you need to write for lab 4. You are welcome to make additional changes to the BST class.
	
	//DONE
	public void inOrder(Node n) {
		//TO DO: Lab 4		
		if (n == null) {
			return;
		}
		
		else {
			inOrder(n.getLeft());
			System.out.println(count + ": " + n.getValue());
			count++;
			inOrder(n.getRight());
			
		}
	}
	
	public void depthFirst(Node n) {
		if (n != null) {
		System.out.println(n.getValue());
		depthFirst(n.getLeft());
		depthFirst(n.getRight());
		}
	}
	
	public int getMin() {
		//TO DO: Lab 4		
		
		if (root == null) {
			return -1;
		}
		
		else {
			Node current = root;
			
			while (current.getLeft() != null) {
				current = current.getLeft();
			}
			return current.getValue();
			
		}
		
	}
	
	public int getMax() {
		//TO DO: Lab 4
		if (root == null) {
			return -1;
		}
		
		else {
			Node current = root;
			
			while (current.getRight() != null) {
				current = current.getRight();
			}
			return current.getValue();
			
		}
		
	}
	
	public Node find(int value) {
		//TO DO: Lab 4
		if (root == null) {
			return null;
		}
		
		else {
			Node current = root;
			
			
			while (current.getValue() != value) {
				//current is lower
				if (value > current.getValue()) {	
					//check right node
					if (current.getRight() != null) {
						current = current.getRight();
					}
					
					else {
						System.out.println("Not found");
						return null;
					}
				}
				//current is higher
				else if (value < current.getValue()) {	
					//check left node
					if (current.getLeft() != null) {
						current = current.getLeft();		
					}
					
					else {
						System.out.println("Not found");
						return null;
					}
				}
			}
//			System.out.println("Match Found: " + current.getValue());
			System.out.println("Found!");
			return current;		
		}
		
		
	}
	
}
