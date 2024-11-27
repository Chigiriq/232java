import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lab12Demo {

	public static void main(String[] args) {
		
		LinkedList<Item> items = new LinkedList<Item>();
		double weight_capacity = 35.0;  // capacity of the knapsack
		double current_capacity = 0;
		
		double totalWeight = 0;
		double totalValue = 0;
		// Add items. Format: Name, Value, Weight
		items.add(new Item("Gold Bar",100,20));
		items.add(new Item("Emerald Bar",40,5));
		items.add(new Item("Ruby Bar",13,10));
		items.add(new Item("Silver Bar",88,12));
		items.add(new Item("Sapphire Bar",52,8));
		items.add(new Item("Copper Bar",13,8));
		items.add(new Item("Quartz Bar",1,12));
		items.add(new Item("Pearl",20,1));
					
		// TO DO. Your code for the knapsack problem will go here.
		
		//sort the items from greatest to least based on value/weight ratio
		Collections.sort(items);
		
		//loop through the sorted array
		for (Item i: items) {
			double newValue = 0;
			
			//if knapsack is full exit
			if (current_capacity == weight_capacity) {
				break;
			}
			
			//if knapsack is not full add it
			if (current_capacity + i.getWeight() < weight_capacity) {
				newValue = i.getValue();
				current_capacity += i.getWeight();
				
				totalValue += newValue;
				totalWeight = current_capacity;
				
				System.out.println("-Name: " + i.getItem() + " | Value: " + i.getValue() + " |  Weight: " + i.getWeight());
			}
			
			//if take fraction of item
			else {
				double fraction_capacity = (weight_capacity - current_capacity) / i.getWeight();
				
				newValue = fraction_capacity * i.getValue();
				current_capacity = weight_capacity;
				
				totalValue += newValue;
				totalWeight += fraction_capacity * i.getWeight();
				
				System.out.println("-Name: " + i.getItem()  + " (F) | Value: " + i.getValue() * fraction_capacity + " |  Weight: " + i.getWeight() * fraction_capacity);
				
				System.out.println("Total weight: " + totalWeight);
				System.out.println("Total cost: " + totalValue);
				break;
			}
			
//			System.out.println(totalWeight);
		}
		
		
	}

}