
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> raws = new ArrayList<>();
        
        while(true) {
            String str = scanner.nextLine();
            if (str.isEmpty()) {
                break;
            }
            raws.add(str);
        }
        raws.stream()
                .forEach(row -> System.out.println(row));

    }
}
