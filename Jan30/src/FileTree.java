import java.util.ArrayList;
import java.util.Arrays;

public class FileTree {

	private Node root;
	private Node current;
	
	public FileTree() {
		this.root = new Node("~");
		this.current = root;	
	}
	
	public boolean insert(String directory) {
		
		if(directory == null || directory.equals(" ") || directory.equals("~")) {
			return false;
		}
		else {
			Node newNode = new Node(directory);
			newNode.setParent(current);
			current.addChild(newNode);
			return true;
		}
	}
	
	//NOT DONE
	public boolean moveDown(String directory) {
		//TO DO: Allow for a directory path for an argument
		// cd School/CSCI232/Programs
		ArrayList<Node> children = current.getChildren();
		String[] path = directory.split("/"); //https://www.geeksforgeeks.org/split-string-java-examples/
		int correct = 0;
		
		//normal search
		if (path.length == 1) {
			for(Node child: children) {
				
				if(child.getName().equals(directory)) {
					//move down
					current = child;
					return true;
				}
			}
		}
		
		else if (path.length > 1) {
			for (int i = 0; i < path.length; i++) {
				if (moveDown(path[i]) == true) {     //this could be written much better but works
					correct += 1;
				}	
			}
			
			if (correct == path.length) {
				System.out.println("yes");
				return true;
			}
			
		}
		
		//old
		
//		else if (path.length > 1) {
//			//check each 
//			for (int i = 0; i < path.length; i++) {
//				for(Node child: children) {
//					if(child.getName().equals(path[i])) {
//						//move down
//						current = child;
//						correct += 1;
//					}
//				}
//			}
//			System.out.println(correct);
//			if (correct == path.length-1) {
//				return true;
//			}
//		}
				
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
	
	//DONE
	public boolean remove(String directory) { //assume that starting in above directory and removing child directories
		//TO DO: Lab 2
		
		//go through children
		ArrayList<Node> children = current.getChildren();
		for(Node child: children) {
			
			if(child.getName().equals(directory)) { //this one
//				System.out.println("found child" + child.getName());
				child.setParent(null);
				children.remove(child);
				return true;
			}
		
		}
		
		
		return false;
	}
	
	
	//DONE
	public String getPath() {
		//TO DO: Lab 2
		
		Node placeholder = current;
		String text = "";
		text = text + placeholder.getName();
		
		while (placeholder != root) {
			placeholder = placeholder.getParent();
			
			text = placeholder.getName() + "/" + text;
		}
		
		return text;
	}
	
	
	
	
}
