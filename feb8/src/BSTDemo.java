
public class BSTDemo {

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.insert(44);
		bst.insert(17);
		bst.insert(88);
		bst.insert(21);
		bst.insert(6);
		bst.insert(61);
		bst.insert(73);
		bst.insert(54);
		
		bst.insert(2);
		bst.insert(1);
		bst.insert(10);
		bst.insert(8);
		bst.insert(9);
		
		bst.insert(18);
		bst.insert(95);
		
		bst.printTree(bst.getRoot());
		
		bst.remove(61);
		
		
		System.out.println();
		bst.printTree(bst.getRoot());

	}

}
