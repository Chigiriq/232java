import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FileTree {

	private Node root;
	private Node current;	
	
	public FileTree() {
		this.root = new Node("~", 0);
		this.current = root;	
	}
	
	public boolean insert(String directory) {
		
		if(directory == null || directory.equals(" ") || directory.equals("~")) {
			return false;
		}
		else {
			Node newNode = new Node(directory, current.getDepth() + 1); //add depth from current
			newNode.setParent(current);
			current.addChild(newNode);
			return true;
		}
	}
	
	public boolean moveDown(String directory) {
		//TO DO: Allow for a directory path for an argument
		// cd School/CSCI232/Programs
		ArrayList<Node> children = current.getChildren();
		for(Node child: children) {
			
			if(child.getName().equals(directory)) {
				//move down
				current = child;
				return true;
			}
			
		}
		return false;
		
		
	}
	
	public void moveUp() {
		if (current != root) {
			current = current.getParent();
		}
	}
	
	public void goHome() {
		current = root;
	}
	
	public String getCurrentLocation() {
		return current.getName();
	}
	
	public String getChildren() {
		String files = "";
		ArrayList<Node> children = current.getChildren();
		for(Node c: children) {
			files += c.getName() + " ";
		}
		return files;
	}
	
	public boolean remove(String directory) {
		//TO DO: Lab 2
		
		return false;
	}
	
	
	public String getPath() {
		//TO DO: Lab 2
		
		return null;
	}
	
	
	//make a queue that goes fifo
	public void breadthFirst() {
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	if (root != null) {
    		queue.add(root);
    		
    		
    		while ( !queue.isEmpty()) {
    			
    			Node node = queue.remove();
    			System.out.println(node.getName() + " " + node.getDepth()); //"Action"
    			
    			for (Node n: node.getChildren()) {
    				queue.add(n);
    			}
    		}
    	}
    }
	
	//make a stack lifo
	public void depthFirst() {	
		Stack<Node> stack = new Stack<Node>();
		
		if (root != null) {
			
			stack.add(root);
			
			while (!stack.isEmpty()) {
			
				Node remove = stack.pop();
				System.out.println(remove.getName() + " " + remove.getDepth());
				
				for (Node c: remove.getChildren()) {
					stack.push(c);
				}
			
			}
		}
	}
	
	public int getHeight() {
		//depth first or breadth first and find largest depth number		
		return 0;
	}
		
	public void serachFor(String directory) {
		//take bf or df and instead of printing do an if statement that checks if directory.equals(node.getname)
		
	}
	
}
