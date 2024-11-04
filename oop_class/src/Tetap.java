public class Tetap extends Employee{
	private double salary_monthly;
	
	
	public Tetap(String name, String id, String posisi, double salary_monthly) {
		super(name, id, posisi);
		this.salary_monthly = salary_monthly;
	}
	
	@Override
	public double calculateSalary() {
		return salary_monthly;
	}

}
