
import java.util.ArrayList;
import java.util.Collections;


public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
    
    public double maxValue() {
        if(this.history.isEmpty()) {
            return 0;
        }
        ArrayList<Double> copy = new ArrayList<>();
        for(Double h : history) {
            copy.add(h);
        }
        Collections.sort(copy);
        return copy.get(copy.size() -1);
    }
    
    public double minValue() {
        if(this.history.isEmpty()) {
            return 0;
        }
        ArrayList<Double> copy = new ArrayList<>();
        for(Double h : history) {
            copy.add(h);
        }
        Collections.sort(copy);
        return copy.get(0);
    }
    
    public double average() {
        if(this.history.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for(Double d : this.history) {
            sum += d;
        }
        return (double)sum / this.history.size();
    }
}
