
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> s = new ArrayList<>();
        
        while(true) {
            String str = scanner.nextLine();
            if(Integer.valueOf(str) < 0) {
                break;
            }
            s.add(Integer.valueOf(str));
        }
        
        s.stream()
                .filter(f -> f > 0 && f < 6)
                .forEach(n -> System.out.println(n));

    }
}
