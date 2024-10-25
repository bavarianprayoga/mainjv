package tugaskelompok6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<User> userList = new ArrayList<>();
		
		while(true) {
			System.out.println("1. Input Data");
			System.out.println("2. Show Data");
			System.out.println("3. Delete Data");
			System.out.println("4. Exit");
			System.out.print("Your choice: ");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					String nama;
					String nim;
					String phone;
					System.out.print("Nama: ");
					nama = scan.nextLine();
					System.out.print("Nim: ");
					nim = scan.nextLine();
					System.out.print("Phone: ");
					phone = scan.nextLine();
					
					userList.add(new User(nama, nim, phone));
					System.out.println("New data is added");
					System.out.println();
					break;
					
				case 2:
					int i = 0;
					int size = userList.size();
					System.out.println("===================================================================");
					System.out.printf("|%-2s|%30s|%15s|%15s|\n", "No", "Nama", "Nim", "Phone");
					System.out.println("===================================================================");
					if(size < 1) {
						System.out.printf("%40s\n", "|No data exist!|");
					}
					else {
						for(User user : userList) {
							System.out.printf("|%-2s|%30s|%15s|%15s|\n", ++i, user.getNama(), user.getNim(), user.getPhone());
						}
						System.out.println("===================================================================");
					}

					System.out.println();
					break;
					
				case 3:
					int j = 0;
					System.out.println("===================================================================");
					System.out.printf("|%-2s|%30s|%15s|%15s|\n", "No", "Nama", "Nim", "Phone");
					System.out.println("===================================================================");
					for(User user : userList) {
						System.out.printf("|%-2s|%30s|%15s|%15s|\n", ++j, user.getNama(), user.getNim(), user.getPhone());
					}
					System.out.println("===================================================================");
					System.out.print("Input data number to be deleted: ");

					int dataToDelete = scan.nextInt(); 
					userList.remove(dataToDelete - 1);

					System.out.println("Data is removed");
					System.out.println();
					break;
				case 4:
					System.out.println("Stopping the program...");
					scan.close();
					return;
				default:
					System.out.println("Wrong Input!");
					break;
			}
			
		}

	}

}
