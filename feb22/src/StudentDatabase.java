import java.util.HashMap;
import java.util.HashSet;


public class StudentDatabase {
	
	private HashMap<Integer, Student> data;
	
	private HashSet<Integer> keySpace;
	
	public StudentDatabase(int size) {
		this.data = new HashMap<Integer, Student>();
		this.keySpace = new HashSet<Integer>();
	}
	
	public void insert(String name, String major, int id, double gpa) {
		Student newStudent = new Student(name, id, major, gpa);
		
		data.put(id, newStudent);
	
		keySpace.add(id);
		
	}
	
	
	public void print() {
		System.out.println(keySpace);
		for(Integer i: keySpace) { // O(K) k = # keys
			data.get(i).printInfo();
		}
		
	}
	
	public Student get(int id) {	
		return data.get(id);
	}

	public void remove(int id) {
		
		data.remove(id);
		
		//Integer i = Integer.valueOf(id);
		
		keySpace.remove(id);
		
	}
	
}
