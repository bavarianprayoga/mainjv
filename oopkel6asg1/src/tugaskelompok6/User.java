package tugaskelompok6;

public class User {
	String nama;
	String nim;
	String phone;

	public User(String nama, String nim, String phone) {
		this.nama = nama;
		this.nim = nim;
		this.phone = phone;
	}
	
	public String getNama() {
		return nama;
	}
	
	public String getNim() {
		return nim;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public void setNim(String nim) {
		this.nim = nim;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
