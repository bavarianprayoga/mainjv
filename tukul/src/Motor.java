
public class Motor extends Kendaraan {
	private String transmisi;
	private int lama_sewa;
	
	public Motor(String merk, String plat, String warna, String transmisi, int lama_sewa) {
		super(merk, plat, warna);
		this.transmisi = transmisi;
		this.lama_sewa = lama_sewa;
	}

	@Override
	public double rentalCost(int lama_sewa) {
		return lama_sewa * 250000;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("transmisi: " + transmisi);
		System.out.println("biaya sewa " + lama_sewa + " hari: " + rentalCost(lama_sewa));
	}
}
