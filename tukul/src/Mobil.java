
public class Mobil extends Kendaraan{
	private int kursi;
	private int lama_sewa;
	
	public Mobil(String merk, String plat, String warna, int kursi, int lama_sewa) {
		super(merk, plat, warna);
		this.kursi = kursi;
		this.lama_sewa = lama_sewa;
	}
	
	@Override
	public double rentalCost(int lama_sewa) {
		return lama_sewa * 250000;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("seat: "+ kursi);
		System.out.println("biaya sewa " +lama_sewa + " hari: " + rentalCost(lama_sewa));
	}

}
