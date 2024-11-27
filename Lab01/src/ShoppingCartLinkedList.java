
import java.util.LinkedList;

public class ShoppingCartLinkedList {

	private LinkedList<Item> shoppingCart;
	private int num_of_items;
	
	public ShoppingCartLinkedList() {
		this.shoppingCart = new LinkedList<Item>();
		this.num_of_items = 0;
	}
	
	public void addItem(String name, double price, int quantity) {
		Item item = new Item(name, price, quantity);
		shoppingCart.add(item);
		num_of_items++;
	}
	
	public void printCart() {
		System.out.println("Shopping Cart");
		System.out.println("--------------------");
		for(Item i: shoppingCart) {
			System.out.println(i.getName() + " " + i.getPrice() + " " + i.getQuantity());
		}
	}
	
	public void searchForItem(String name) {
		//TO DO: Search for item in LinkedList
		Item current = this.shoppingCart.getFirst();
		
		for (int i = 0; i < num_of_items; i++) {
			current = this.shoppingCart.get(i);   //doing it this way is weird but it works
			
			if (current.getName().equals(name)) {
				System.out.println(name + " " + current.getPrice() + " " + current.getQuantity());
				return;
			}

		}
		System.out.println(name + " is not in shopping cart.");
	}
	
	public void removeItem(String name) {
		// TO DO: Remove item from LinkedList
		Item current = this.shoppingCart.getFirst();
				
		for (int i = 0; i < num_of_items; i++) {
			current = this.shoppingCart.get(i);
			
			if (current.getName().equals(name)) {
				this.shoppingCart.remove(i);
				return;
			}
		}
	}
	
	
}
