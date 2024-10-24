import java.util.Scanner;

public class userinput {
    public static void main(String[] args)  {

        Scanner beha = new Scanner(System.in);

        System.out.println("What's your name?");
        String nama = beha.nextLine();
        System.out.println("How old are u?");
        int age = beha.nextInt();
        beha.nextLine();
        // ini biar pertanyaan berikutnya ga ke skip
        System.out.println("tag jomok lu "+nama);
        String jomok = beha.nextLine();

        System.out.println("Hello, "+nama+".");
        System.out.println("You're "+age+"");
        System.out.println("mantap "+jomok+"");

        beha.close();
    }   
}