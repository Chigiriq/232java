
public class ShoppingCartArray {

	private Item[] shoppingCart;
	private int num_of_items;
	
	public ShoppingCartArray() {
		this.shoppingCart = new Item[0];
		this.num_of_items = 0;
	}
	
	public void addItem(String name, double price, int quantity) {
		Item item = new Item(name, price, quantity);

		Item[] tempArray = new Item[shoppingCart.length+1];
		
		for(int i = 0; i < shoppingCart.length; i++) {
			tempArray[i] = shoppingCart[i];
		}
		
		tempArray[shoppingCart.length] = item;
		shoppingCart = tempArray;
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
		//TO DO: Search for item in Array
		for (int i = 0; i < num_of_items; i++) {
			
			if (this.shoppingCart[i].getName().equals(name)) {
				
				System.out.println(name + " " + shoppingCart[i].getPrice() + " " + shoppingCart[i].getQuantity());
				return;
			}
		}
		
		System.out.println(name + " is not in shopping cart.");
	}
	
	public void removeItem(String name) {
		// TO DO: Remove item from Array
		Item[] tempArray = new Item[shoppingCart.length-1];
		int newIndex = 0;
		
		//find item and remove it
		for (int i = 0; i < num_of_items; i++) {
			if (this.shoppingCart[i].getName().equals(name)) {
				
			}
			
			else {
				tempArray[newIndex] = shoppingCart[i];
				newIndex++;
			}
		}
		
		shoppingCart = tempArray;
		
	}
	
}
