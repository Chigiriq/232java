import java.util.Random;

public class HashTable {

	// You are welcome to make changes to this class, but you should not remove any of the existing code.

	private Integer[] data; //empty spots will be null
	private String[] collisions;
	
	public HashTable(int size) {
		this.data = new Integer[size];
		this.collisions = new String[size];
		for(int i = 0; i < collisions.length; i++) {
			collisions[i] = "";
		}
	}
	
	public int hash(int i) {
		return i % data.length;
	}
	
	public void insert(int newEntry) {
		//TO DO: Lab 6
		//Must use linear probing to handle collisions
		//insertable
		if (this.data[hash(newEntry)] == null) {
			this.data[hash(newEntry)] = newEntry;
		}
		
		//collision
		else {
			boolean searching = true;
			int index = hash(newEntry);
			
			while (searching) {
				
				
				//spot is full
				if (this.data[index] != null) {
					
					if (index == 49) {
						this.collisions[index] = this.collisions[index] + "*";
						index = 0;
					}
					
					else {
						this.collisions[index] = this.collisions[index] + "*";
						index++;
					}
					
					
				}
				
				//spot is empty
				else {
					this.data[index] = newEntry;
					searching = false;
				}
			}
		}		
	}

	public void printHashTable() {
		//TO DO: Lab 6
		for (int i = 0; i < data.length; i++) {
			
			if (this.data[i] != null) {
				System.out.println(i + ": " + this.data[i]);
			}
			
			else {
				System.out.println(i + ": ");
			}
		}
	}

	public void insertRandomValues(int n) {
		//TO DO: Lab 6
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			
			int r = rand.nextInt(1000);
			insert(r);
		}
	}


	public void printCollisionTable() {
		//TO DO: Lab 6
		for (int i = 0; i < this.collisions.length; i++) {
			
			if (this.collisions.equals("")) {
				System.out.println(i + ": ");
			}
			
			else {
				System.out.println(i + ": " + this.collisions[i]);
			}
		}
	}


	public int get(int search) {
		//TO DO: Lab 6
		for (int i = 0; i < this.data.length; i++) {
			
			if (this.data[i] != null && this.data[i] == search) {
				return i;
			}
		}
		
		return -1;
	}

}
