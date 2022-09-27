
import java.util.ArrayList;


public class Box implements Packable{
    private double maxCap;
    private ArrayList<Packable> items;
    
    public Box(double maxCap) {
        this.maxCap = maxCap;
        this.items = new ArrayList<>();
        
    }
    
    public void add(Packable item) {
        if(item.weight() + weight() <= this.maxCap) {
           this.items.add(item); 
        }        
    }    
    
    @Override
    public double weight() {
        double tot = 0;
        for(Packable item : items) {
            tot += item.weight();
        }
        return tot;
    }
    
    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}
