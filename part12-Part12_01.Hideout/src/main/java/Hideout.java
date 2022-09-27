
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
public class Hideout<T> {
    
    private T inHideout;
    private T outHideout;
    
    public Hideout() {
        
    }
    
    public void putIntoHideout(T toHide) {
        if(inHideout == toHide) {
            inHideout = null;
        } else {
            inHideout = toHide;
        }
    }
    
    public T takeFromHideout() {
        outHideout = inHideout;
        inHideout = null;
        return outHideout;
    }
    
    public boolean isInHideout() {
        if(inHideout != null) {
            return true;
        }
        return false;
    }
}
