
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random roll = new Random();
        System.out.println("How many random numbers should be printed?");
        int qty = Integer.valueOf(scanner.nextLine());
        
        for(int i = 0; i < qty; i++) {
            int num = roll.nextInt(11);
            System.out.println(num);
        }
    }

}
