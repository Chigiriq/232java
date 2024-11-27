import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class AnimalTree {
	
	private Node root;
	//private int count;
		
	public AnimalTree() {
		this.root = null;
	}
	
	public void fillTree(String filename) {
		
		try {
			Scanner input = new Scanner( new FileReader(filename) );
			
			while(input.hasNext() ) {
				String line = input.nextLine();
				
				String[] vals = line.split(",");
				String value = vals[0];
				String name = vals[1];
				
				//string to int
				int useValue = Integer.parseInt(value);
				
				insert(useValue, name);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("pain");
			e.printStackTrace();
		}
		
	}

	public void printTreeBFS(Node n) {
		if (root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
    	while ( !queue.isEmpty()) {
    			
    		Node current = queue.remove();
    		System.out.println(current.getValue() + ", " + current.getName());
    		
    		if (current.getLeft() != null) {
    			queue.add(current.getLeft());
    		}	
    		
    		if (current.getRight() != null) { //note don't use else if apparently
    			queue.add(current.getRight());
    		}	
    	}	
	}
	
	public void insert(int newValue, String name) {
		
		if(root == null) {
			root = new Node(newValue, name);
		}
		else {
			
			Node currentNode = root;
			boolean placed = false;
			
			while(!placed) {
				
				//insert the overlapping node
				if(currentNode.getValue() == newValue) {
					placed = true;
//					System.out.println("No duplicate values allowed");
					createInner(currentNode, newValue, name);
				}
				else if(newValue < currentNode.getValue()) {
					//move left
					if(currentNode.getLeft() == null) {
						// cant move left, so we found insertion spot
						//insert Node
						currentNode.setLeft(new Node(newValue, name));
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
						currentNode.setRight(new Node(newValue, name));
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
	
	public void guess() {
		Node current = root;
		Scanner scanner = new Scanner (System.in);
		char user_choice;
		String path = "";
		
		//Search through tree
		//no child node
		while (current.getLeft() != null && current.getRight() != null) { //maybe change later?
			
			System.out.println("Is this animal " + current.getName() + "? (Y/N)");
			user_choice = scanner.next().charAt(0);
			
			path += current.getName() + "  ";
			
			//go lower
			if (user_choice == 'Y') {
				current = current.getLeft();
			}
			
			else if (user_choice == 'N') {
				current = current.getRight();
			}
			
			else {
				System.out.println("Unable to read input... please try again");
			}
		}
		System.out.println("Hmmm... I think I know");		
		boolean answer = false;
		
		//Post program guess
		while (answer != true) {
			System.out.println("Is it a " + current.getName() + "?");
			
			
			user_choice = scanner.next().charAt(0);
			
			if (user_choice == 'Y') {
				System.out.println("Good! All done.");
				answer = true;
			}
			
			else if (user_choice == 'N') {
				System.out.println("I was wrong...");
				System.out.println("I don't know any animals that are not " + path);
				
//				scanner.close();
				place(current);		
				answer = true;
			}
			
			else {
				System.out.println("Unable to read input... please try again");
			}
		}		
	}
	
	public void place(Node current) { //maybe add id #
		Scanner scanner = new Scanner (System.in);
		System.out.println("What is the new animal?");
		String newAnimal = scanner.next();
		
		System.out.println("What characteristic does " + newAnimal + " have that " + current.getName() + " does not?");
		String newChar = scanner.next();
		
		//temporarily set to be inner node as child
		Node inner = new Node(current.getValue(), newChar);
		current.setRight(inner);
		
		//create new inner node
		insert(current.getValue(), newAnimal);
		
//		printTreeBFS(getRoot());

	}
	
	//start at a node and move child nodes down 
	private void createInner(Node currentNode, int newValue, String name) { //salamander
		Node parent = currentNode.getParent();   //legged
		Node inner = currentNode.getRight();     //shelled
		currentNode.setRight(null);
		Node newChild = new Node(newValue, name); //Turtle
		
		//set new values
		sort(currentNode.getValue());
		
		//manual adjust
		if (inner.getValue() > getRoot().getValue()) { //right side of tree
			inner.setValue(inner.getValue() + 1);
		}
		
		else {
			inner.setValue(inner.getValue() - 1);
		}
		
		//set node locations
		parent.setLeft(inner);
		inner.setParent(parent);		  //shelled parent now legged
		
		inner.setRight(currentNode);	   //Shelled r child now salamander
		inner.setLeft(newChild);          //setting turtle as l child
		
		currentNode.setParent(inner);      //salamander parent now shelled
		newChild.setParent(inner);		   //turtle parent now shelled
		
//		System.out.println();
//		printTreeBFS(getRoot());
		
	}
	
	private void sort(int start) {
		if (root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
    	while ( !queue.isEmpty()) {
    			
    		Node current = queue.remove();
//    		System.out.println(current.getValue() + ", " + current.getName());
    		
    		if (current.getLeft() != null) {
    			queue.add(current.getLeft());
    		}	
    		
    		if (current.getRight() != null) { //note don't use else if apparently
    			queue.add(current.getRight());
    		}	
    		
    		if (current.getValue() > (start-1)) {
				current.setValue(current.getValue() + 2);
			}
		}
	}
	
	public void inOrder(Node n, String filename) {
		if (n == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		try {
			
			FileWriter fWriter = new FileWriter(filename);
			
			while ( !queue.isEmpty()) {
    			
	    		Node current = queue.remove();
	//    		System.out.println(current.getValue() + ", " + current.getName());
	    		fWriter.write(current.getValue() + ", " + current.getName() + "\n");
	    		if (current.getLeft() != null) {
	    			queue.add(current.getLeft());
	    		}	
	    		
	    		if (current.getRight() != null) { //note don't use else if apparently
	    			queue.add(current.getRight());
	    		}	
			}
			
			fWriter.close();
    		
		} catch (IOException e) {
			 
            // Print the exception
            System.out.print("pain but worse");		
		}
	
	}
	
}
