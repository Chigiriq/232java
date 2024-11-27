
public class StudentDatabaseDemo {
	
	public static void main(String[] args) {
		
		StudentDatabase database = new StudentDatabase(100);
		
		database.insert("Joe", "Computer Science", 245006, 3.0);
		database.insert("Sally", "Math", 123456, 4.0);
		database.insert("Sam", "Political Science", 121212, 2.5);

//		database.insert("Mark", "Chemistry", 132206, 1.0);
		
		database.print();
		
//		System.out.println();
//		Student s = database.get(123456);
//		s.printInfo();
	}
}
