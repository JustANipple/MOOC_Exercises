
public class Person implements Comparable<Person> {
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double litPerc;
    
    public Person(String theme, String ageGroup, String gender, String country, int year, double litPerc) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.litPerc = litPerc;
        
    }

    public double getLitPerc() {
        return litPerc;
    }
    
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.litPerc;
    }
    
    @Override
    public int compareTo(Person person) {
        if(this.litPerc == person.getLitPerc()) {
            return 0;
        } else if (this.litPerc > person.getLitPerc()) {
            return 1;
        } else {
            return -1;
        }
    }    
}
