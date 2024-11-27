import java.util.Scanner;

public class AnimalTreeDemo {
	public static void main(String args[]) {
		
		AnimalTree at = new AnimalTree();
		
		at.fillTree("tree.txt");
		
		at.printTreeBFS(at.getRoot());
		
		System.out.println();
		
		Scanner scn = new Scanner (System.in);
		boolean contin = true;
		char user_choice = 'Y';
		
		while (contin == true) {
			System.out.println("Would you like to add another animal? (Y/N)");
			
			user_choice = scn.next().charAt(0);
			
			if (user_choice == 'N') {
				at.inOrder(at.getRoot(), "tree.txt");
				break;
			}
			
			else if (user_choice == 'Y'){
				at.guess();
			}
		}
		
		
		scn.close();
		
	}
}
