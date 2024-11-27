import java.util.LinkedList;

public class StudentDatabase {
	
	private LinkedList<Student>[] data;
	
	//private LinkedList<Integer> keySpace;
	
	public StudentDatabase(int size) {
		this.data = new LinkedList[size];
		//this.keySpace = new LinkedList<Integer>();
	}
	
	public void insert(String name, String major, int id, double gpa) {
		Student newStudent = new Student(name, id, major, gpa);
		
		int insertIndex = hash(id);
		if(data[insertIndex] == null) {
			data[insertIndex] = new LinkedList<Student>();
		}
	
		data[insertIndex].add(newStudent);
		//keySpace.add(id);
		
	}
	
	public int hash(int id) {
		// id % 100
		return id % this.data.length;
	}
	
	public void print() {
		
		for(int i = 0; i < data.length; i++) {
			
			if(data[i] != null) {
				
				String info = "";
				for(Student s: data[i]) {
					
					info += s.getName();
					
				}
				System.out.println(i + ": " + info);
				
				
			}
			
			
			
		}
		
		
		/*
		for(Student s: data) {
			if(s != null) {
				s.printInfo();
			}
		}
		*/
	}
	
	public Student get(int id) {
		
		//int arrayIndex = hash(id);
		
		//return data[arrayIndex];
		return null;
	}

	public void remove(int id) {
		
		int arrayIndex = hash(id);
		
		data[arrayIndex] = null;
		
		//Integer i = Integer.valueOf(id);
		
		//keySpace.remove( (Integer) id);
		
	}
	
}
