
import java.util.HashMap;
import java.util.HashSet;

public class HashMapDemo {

	public static void main(String[] args) {
		
		HashMap<String, String> capitalCities = new HashMap<String, String>();
		
		capitalCities.put("Montana", "Helena");
		capitalCities.put("Washington", "Olympia");
		capitalCities.put("Colorado", "Denver");
		
		System.out.println(capitalCities);
		
		System.out.println(capitalCities.get("Washington"));
		
		//capitalCities.remove("Colorado");
		//System.out.println(capitalCities);
		
		System.out.println(capitalCities.keySet());
		
		HashSet<String> candy = new HashSet<String>();
		
		candy.add("Skittles");
		candy.add("Twix");
		candy.add("Snickers");
		
		System.out.println(candy);
		int hash = System.identityHashCode("Reeses");
		System.out.println(hash);
		
	}

}
