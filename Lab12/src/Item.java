
public class Item implements Comparable<Item>{
	
	String item;
	double value;
	double weight;
	
	public Item(String s, double i, double j) {
		this.item = s;
		this.value = i;
		this.weight = j;
	}
	
	public String getItem() {
		return this.item;
	}
	
	public double getValue() {
		return this.value;
	}

	public double getWeight() {
		return this.weight;
	}
	
	public int compareTo(Item other) {
		double ratio1 = (double) this.value / this.weight;
	    double ratio2 = (double) other.value / other.weight;
	    return Double.compare(ratio2, ratio1);
	}
}
