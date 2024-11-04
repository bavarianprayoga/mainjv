public class Magang extends Employee{
	private double hourly_rate;
	private int hours_worked;
	
	public Magang(String name, String id, String posisi, double hourly_rate, int hours_worked) {
		super(name, id, posisi);
		this.hourly_rate = hourly_rate;
		this.hours_worked = hours_worked;
	}

	@Override
	public double calculateSalary() {
		return hourly_rate * hours_worked;
	}
	
}
