
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nums = new ArrayList<>();
        // Write your program here
        
        while(true) {
            String str = scanner.nextLine();
            if(str.equals("end")) {
                break;
            }
            nums.add(str);
        }
        
        double average = nums.stream()
                .mapToInt(n -> Integer.valueOf(n))
                .average()
                .getAsDouble();
        
        System.out.println("average of the numbers: " + average);

    }
}
