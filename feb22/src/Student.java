
public class Student {

	private String name;
	private int id;
	private String major;
	private double gpa;
	
	public Student(String n, int i, String m, double g) {
		this.name = n;
		this.id = i;
		this.major = m;
		this.gpa = g;
	}
	
	public void printInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("ID: " + this.id);
		System.out.println("Major: " + this.major);
		System.out.println("GPA: " + this.gpa);
	}
	
	
	
}
