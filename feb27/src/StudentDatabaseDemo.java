
public class StudentDatabaseDemo {

	public static void main(String[] args) {
		
		StudentDatabase database = new StudentDatabase(97);
		
		database.insert("Joe","Computer Science",245097, 3.0);
		database.insert("Sally","Math",123456, 4.0);
		database.insert("Sam","Politcal Science",121212, 2.5);
		
		database.insert("Collision","Politcal Science",245000, 2.5);
		
		//database.insert("Mark","Chemistry",132206, 1.0);
		
		//database.remove(123456);
		
		database.print();
		
		//Student s = database.get(111111);
		//s.printInfo();
		
		
	}

}
