
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
        
        ArrayList<Person> persons = readFile();
        persons.stream()
                .sorted()
                .forEach(p -> System.out.println(p));

    }
    
    public static ArrayList<Person> readFile() {
        ArrayList<Person> persons = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(Paths.get("literacy.csv"))) {
            
            while(scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] parts = row.split(",");
                
                String theme = parts[0];
                String ageGroup = parts[1];
                String gender = "";
                if(parts[2].contains("male")) {
                    gender = "male";
                }
                if(parts[2].contains("female")) {
                    gender = "female";
                }
                String country = parts[3];
                int year = Integer.valueOf(parts[4]);
                double litPerc = Double.valueOf(parts[5]);
                
                persons.add(new Person(theme,ageGroup,gender,country,year,litPerc));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return persons;
    }
}
