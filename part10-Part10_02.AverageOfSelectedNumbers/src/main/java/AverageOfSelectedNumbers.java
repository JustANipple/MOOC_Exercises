
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nums = new ArrayList<>();
        // toteuta ohjelmasi tänne
        
        while(true) {
           String str = scanner.nextLine();
           if(str.equals("end")) {
               break;
           }
           nums.add(str);           
        }
        
        System.out.println("Print the average of the negative numbers"
                + "or the positive numbers? (n/p)");
        String cmd = scanner.nextLine();
        
        if(cmd.equals("n")) {
            
            double negAvg = nums.stream()
                    .mapToInt(n -> Integer.valueOf(n))
                    .filter(f -> f < 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + negAvg);
            
        } else if (cmd.equals("p")) {
            
            double posAvg = nums.stream()
                    .mapToInt(n -> Integer.valueOf(n))
                    .filter(f -> f >= 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the positive numbers: " + posAvg);
            
        }

    }
}
