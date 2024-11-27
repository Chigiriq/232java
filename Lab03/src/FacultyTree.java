import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FacultyTree {

	
	private Node root;
	private Node current;
	
	
	public FacultyTree() {
		root = new Node("MSU Faculty",0);
		current = root;
		fillTree();
	}
	
	private void insert(String name) {
		Node newNode = new Node(name, current.getDepth()+1);
		newNode.setParent(current);
		current.addChild(newNode);
	}
	
	private void insert(String name, String title, String office) {
		Node newNode = new Node(name, title, office, current.getDepth()+1);
		newNode.setParent(current);
		current.addChild(newNode);
		
	}
	
	private void goHome() {
		current = root;
	}
	
	private void moveDown(String name) {
		ArrayList<Node> children = current.getChildren();
		for(Node child : children) {
			if(child.getName().equals(name)) {
				current = child;
			}
		}
	}
	
	private void moveUp() {
		if( current != root ) {
			current = current.getParent();
		}
	}
	
	
	private void fillTree() {
        	insert("Administration");
	        insert("Sociology");
	        insert("Engineering");

        	moveDown("Administration");
	        insert("Waded Cruzado", "President", "Montana Hall 216");
        	insert("Bob Markwa", "Provost", "Montana Hall 212");
	        goHome();
		
        	moveDown("Sociology");
	        insert("Cody Warner", "Department Head", "Wilson Hall 2-128");
        	insert("Suzy McElrath", "Assistant Professor", "Wilson Hall 2-114");
	        insert("Sara Rasch", "Instructor", "Wilson Hall 2-109");
        	goHome();
        
	        moveDown("Engineering");
	        insert("Computer Science");
        	insert("Electrical Engineering");
        
	        moveDown("Computer Science");
        	insert("Reese Pearsall", "Instructor", "Barnard Hall 361");
	        insert("John Paxton", "Director", "Bardnard Hall 353");
        	insert("Shane Blanchard", "Academic Advisor", "Barnard Hall 357");
	        insert("Hunter Lloyd", "Teaching Professor", "Barnard Hall 354");
        
        	moveUp();
	        moveDown("Electrical Engineering");
	        insert("Brock LaMeres", "Professor", "Norm Asbjornson Hall 316");
        	insert("Bradley Whitaker", "Assistant Professor", "Cobbleigh Hall 630");
        
        

	}
	
	//
	// YOUR CODE SHOULD GO BELOW THIS COMMENT
	// DO NOT MODIFY ANYTHING ABOVE

	//dfs 
	public void printTree() { //XXX DONE
		//TO DO: Lab 3
		Stack<Node> stack = new Stack<Node>();
		
		if (root != null) {
			
			stack.add(root);
			
			while (!stack.isEmpty()) {
				Node remove = stack.pop();
				
				if (remove.getChildren().size() == 0) {
					System.out.println("-".repeat(remove.getDepth()) + ">" + remove.getName()); 
					//https://stackoverflow.com/questions/2255500/can-i-multiply-strings-in-java-to-repeat-sequences
				}
				
				else {
					System.out.println("-".repeat(remove.getDepth()) + remove.getName());
				}
				for (Node c: remove.getChildren()) {
					stack.push(c);
				}
			}
		}
	}

	public int getHeight() {
		//TO DO: Lab 3
		Stack<Node> stack = new Stack<Node>();
		int max = 0;
		
		if (root != null) {
			
			stack.add(root);
			max = root.getDepth();
			
			while (!stack.isEmpty()) {
				Node remove = stack.pop();
				
				
				for (Node c: remove.getChildren()) {
					stack.push(c);
					
					if (max < c.getDepth()) {
						max = c.getDepth();
					}
					
				}
			}
		}

		return max;
	}

	public void searchFor(String name) {
		//TO DO: Lab 3		
		Queue<Node> queue = new LinkedList<Node>();
		
		if (root != null) {
			
			queue.add(root);
			
			while (!queue.isEmpty()) {
				
				Node node = queue.remove();
				
				for (Node n: node.getChildren()) {
					queue.add(n);
					
					if (name.equals(n.getName())) {
						System.out.println("Match found!");
						System.out.println("Name: " + n.getName());
						System.out.println("Title: " + n.getTitle());
						System.out.println("Office: " + n.getOffice());
						return;
					}
				}
			}
			
			System.out.println(name + " was not found in the tree.");
		}
	}
	
	
	
}
