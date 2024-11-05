public class Kendaraan {
    private String plat;
    private String merk;
    private String warna;

    public Kendaraan(String merk, String plat, String warna) {
    	this.merk = merk;
    	this.plat = plat;
    	this.warna = warna;
    }
    
	public double rentalCost(int lama_sewa) {
		return lama_sewa * 500000;
	}
	
	public void displayInfo() {
		System.out.println("merk: " + merk);
		System.out.println("plat: " + plat);
		System.out.println("warna: " + warna);
	}
}
