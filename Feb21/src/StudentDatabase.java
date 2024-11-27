import java.util.LinkedList;

public class StudentDatabase {

		private Student[] data;
		
		private LinkedList<Integer> keySpace;
		
		
		public StudentDatabase(int size) {
			this.data = new Student[size];
			this.keySpace = new LinkedList<Integer>();
		}
		
		
		public void insert(String name, String major, int id, double gpa) {	
			Student newStudent = new Student(name, id, major, gpa);
			
			int insertIndex = hash(id);
			System.out.println(name + " is getting inserted into " + insertIndex);
			
			data[insertIndex] = newStudent;
			keySpace.add(id);
			
		}
	
		
		public int hash(int id) {
			//id % 100
			return id % this.data.length;
		}
		
		
		public void print() {
			System.out.println();
			System.out.println(keySpace);
			//NEW
			for (Integer i: keySpace) {  //O(K)  K = # keys
				
				Student s = get(i);  // O(1) 
				s.printInfo();
				System.out.println();
			}
			
			
			
			
			//OLD
//			for (Student s: data) {
//				
//				if (s != null) {
//					s.printInfo();	
//					System.out.println();
//				}
//			}
		}


		public Student get(int id) {
			
			int arrayIndex = hash(id);
			
			return data[arrayIndex];
			
		}
}
