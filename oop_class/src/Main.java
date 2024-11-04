import java.util.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Magang> MagangList= new ArrayList<>();
	static ArrayList<Tetap> TetapList = new ArrayList<>();
	
	static void showMenu() {
		System.out.println("1. View Employees");
		System.out.println("2. Add Employee");
		System.out.println("3. Delete Employee");
		System.out.println("4. Exit");
		System.out.println("Your Choice: ");
	}
	
	static void addTetap() {
		sc.nextLine();
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("ID: ");
		String id = sc.nextLine();
		System.out.println("Posisi: ");
		String posisi = sc.nextLine();
		System.out.println("Gaji BUlanaN: ");
		double gaji = sc.nextDouble();
		
		Tetap tetap_baru = new Tetap(name, id, posisi, gaji);
		TetapList.add(tetap_baru);
	}
	
	static void addMagang() {
		sc.nextLine();
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("ID: ");
		String id = sc.nextLine();
		System.out.println("Posisi: ");
		String posisi = sc.nextLine();
		System.out.println("Lama kerja (jam): ");
		int kerja = sc.nextInt();
		System.out.println("Gaji per jam: ");
		double gaji = sc.nextDouble();
		
		Magang magang_baru = new Magang(name, id, posisi, gaji, kerja);
		MagangList.add(magang_baru);
	}

	public static void main(String[] args) {
		int choice;
		
		do{
			showMenu();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				for(Tetap ttp : TetapList) {
					ttp.displayEmployee();
				}
				
				for(Magang mg : MagangList) {
					mg.displayEmployee();
				}
				break;
			case 2:
				System.out.println("Add mana");
				System.out.println("1. tetap");
				System.out.println("2. magang");
				int choice_add;
				do {
					choice_add = sc.nextInt();
				}while(choice_add != 1 && choice_add != 2);
						
				if(choice_add == 1) {
					addTetap();
				}
				else {
					addMagang();
				}
				break;
			case 3:
				break;
			case 4:
				System.out.println("tengs");
				break;
			default:
				System.out.println("yang bner");
			}
			
			
		}while(choice != 4);
	}

}
