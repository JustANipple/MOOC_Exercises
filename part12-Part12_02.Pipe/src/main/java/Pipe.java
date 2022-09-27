
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pc
 */
public class Pipe<T> {
    
    private ArrayList<T> values;
    
    public Pipe() {
        
        values = new ArrayList<>();
        
    }
    
    public void putIntoPipe(T value) {
        this.values.add(value);
    }
    
    public T takeFromPipe() {
        if(this.values.isEmpty()) {
            return null;
        }
        T toReturn = this.values.get(0);
        this.values.remove(toReturn);
        return toReturn;
        
    }
    
    public boolean isInPipe() {
        return !this.values.isEmpty();
    }
    
}
