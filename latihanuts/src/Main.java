import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);
    ArrayList<Jeep> jeepList = new ArrayList<>();
    ArrayList<SUV> suvList = new ArrayList<>();
    ArrayList<Sedan> sedanList = new ArrayList<>();

    void showMenu() {
        System.out.println("SHOWROOM");
        System.out.println("============");
        System.out.println("1. Buy");
        System.out.println("2. Show");
        System.out.println("3. Exit");
    }

    void showBuy() {
        System.out.println("1. Jeep");
        System.out.println("2. SUV");
        System.out.println("3. Sedan");
    }

    void showCars() {
        System.out.println("===================");
        System.out.println("Jeep");
        System.out.println("===================");
        for (Jeep jeep : jeepList) {
            System.out.println(jeep.name);
        }

        System.out.println();
        System.out.println("===================");
        System.out.println("SUV");
        System.out.println("===================");
        for (SUV suv : suvList) {
            System.out.println(suv.name);
        }

        System.out.println();
        System.out.println("===================");
        System.out.println("Sedan");
        System.out.println("===================");
        for (Sedan sedan : sedanList) {
            System.out.println(sedan.name);
        }
    }

    void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public Main() {
        int choice;

        do {
            showMenu();
            System.out.print("Input : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    clear();
                    int buyChoice;

                    showBuy();
                    System.out.print("Input : ");
                    buyChoice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name : ");
                    String name;
                    name = sc.nextLine();

                    if (buyChoice == 1) {
                        Jeep newCar = new Jeep(name);
                        jeepList.add(newCar);
                    } else if (buyChoice == 2) {
                        SUV newCar = new SUV(name);
                        suvList.add(newCar);
                    } else if (buyChoice == 3) {
                        Sedan newCar = new Sedan(name);
                        sedanList.add(newCar);
                    }

                    break;
                case 2:
                    clear();
                    showCars();
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    break;
                default:
                    break;
            }

            clear();
        } while (choice != 3);
    }

    public static void main(String[] args) {
        new Main();
    }

}
