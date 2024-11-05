import java.util.*;

public class Main {
	
	static ArrayList<Mobil> MobilList = new ArrayList<>();
	static ArrayList<Motor> MotorList = new ArrayList<>();
	
	
    public static void main(String[] args) {
    	
    	Mobil mobil_baru = new Mobil("Wuling","BH151TT", "pink", 8, 5);
    	MobilList.add(mobil_baru);
    	
    	Motor motor_baru = new Motor("Bajaj", "B171GUA", "HITAM", "manual", 8);
    	MotorList.add(motor_baru);
    	
    	System.out.println("data mobil:");
    	for(Mobil m : MobilList) {
    		m.displayInfo();
    	}
    	
    	System.out.println("\ndata motor:");
    	for(Motor m : MotorList) {
    		m.displayInfo();
    	}
    	
    }
}