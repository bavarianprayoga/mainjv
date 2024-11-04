public class Employee {
	private String name;
	private String id;
	private String posisi;
	
	// constructor
	public Employee(String name, String id, String posisi) {
		this.name = name;
		this.id = id;
		this.posisi = posisi;
	}
	
	public double calculateSalary() {
		return 0.0;
	}
	
	public void displayEmployee() {
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
		System.out.println("Position: " + posisi);
		System.out.println("Salary: " + calculateSalary());
	}
	
}
