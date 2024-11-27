
public class BST {

	private Node root;
	
	public BST() {
		this.root = null;
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
	
	public void printTree(Node n){
		//depth-first (recursion)
		if(n == null) {
			return;
		}
		else {
			System.out.println(n.getValue());
			printTree(n.getLeft());
			printTree(n.getRight());
		}
		
	}
	
	public void remove(int removeNum) {
		

		if(root == null) {
			System.out.println("Empty tree...");
		}
		else {
			
			Node currentNode = root;
			boolean found = false;
			int left_or_right = -1; //0 = left, 1 = right
			while(!found) {
				
				if(currentNode.getValue() == removeNum) {
					//found the node to delete
					found = true;
					// case 1- no children
					if(currentNode.getLeft() == null && currentNode.getRight() == null) {
							
						if(left_or_right == 0) {
							currentNode.getParent().setLeft(null);
						}
						else if(left_or_right == 1) {
							currentNode.getParent().setRight(null);
						}
						
					}
					
					//case 2 - 1 child
					else if(currentNode.getLeft() != null && currentNode.getRight() == null) {
						//we know we have 1 child
						if(left_or_right == 0) {
							currentNode.getParent().setLeft(currentNode.getLeft());
							currentNode.getLeft().setParent(currentNode.getParent());
						}
						else if(left_or_right == 1) {
							currentNode.getParent().setRight(currentNode.getLeft());
							currentNode.getLeft().setParent(currentNode.getParent());
						}
					}
					else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
						//we know we have 1 child
						if(left_or_right == 0) {
							currentNode.getParent().setLeft(currentNode.getRight());
							currentNode.getRight().setParent(currentNode.getParent());
						}
						else if(left_or_right == 1) {
							currentNode.getParent().setRight(currentNode.getRight());
							currentNode.getRight().setParent(currentNode.getParent());
						}
					}
					else {
						//case 3 -- two children
						boolean explored = false;
						Node replaceMe = currentNode;
						currentNode = currentNode.getRight(); //move to right subtree
						
						if(currentNode.getLeft() == null && currentNode.getRight() == null) {
							//there is nothing in the right subtree
							replaceMe.setValue(currentNode.getValue());
							replaceMe.setRight(null);
							return;
						}
						
						if(currentNode.getLeft() == null && currentNode.getRight() != null) {
							replaceMe.setValue(currentNode.getValue());
							replaceMe.setRight(currentNode.getRight());
							currentNode.getRight().setParent(currentNode.getParent());
							return;
						}
						
						while(!explored) {
							//find min value 
							if(currentNode.getLeft() != null) {
								currentNode = currentNode.getLeft();
							}
							else {
								explored = true;
							}
						}
						//---------------------------------------------------
						//This code is fixed (i think)
						//If you are able to break it, let me know
						//-----------------------------------------------
						replaceMe.setValue(currentNode.getValue());
						currentNode.getParent().setLeft(currentNode.getRight());
						if(currentNode.getRight() != null) {
							currentNode.getRight().setParent(currentNode.getParent());
						}
					}
					
					
					
					
					
					
				}
				else if(removeNum < currentNode.getValue()) {
					//move left
					if(currentNode.getLeft() == null) {
						// cant move left, remove node could not be found
						System.out.println("Node not found");
						found = true;
					}
					else {
						// otherwise move left
						currentNode = currentNode.getLeft();
						left_or_right = 0;
					}
				}
				else {
					//move right
					if(currentNode.getRight() == null) {
						//cant move right, insert new node
						System.out.println("Node not found");
						found = true;
					}
					else {
						//move right
						currentNode = currentNode.getRight();
						left_or_right = 1;
					}
				}
				
				
			}
			
			
			
		}
		
		
		
		
	}
	
	public void inOrder(Node n) {
		if(n == null) {
			return;
		}
		else {
			printTree(n.getLeft());
			System.out.println(n.getValue());
			printTree(n.getRight());
		}
	}
	
	public void postOrder(Node n) {
		if(n == null) {
			return;
		}
		else {
			printTree(n.getLeft());
			printTree(n.getRight());
			System.out.println(n.getValue());
		}
	}
	
}
