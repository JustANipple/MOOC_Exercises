
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
public class Herd implements Movable {
    
    private ArrayList<Movable> organisms;
    
    public Herd() {
        this.organisms = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Movable o : this.organisms) {
            str.append(o.toString() + "\n");
        }
        return str.toString();
    }
    
    public void addToHerd(Movable movable) {
        this.organisms.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable m : organisms) {
            m.move(dx, dy);
        }
    }
}
