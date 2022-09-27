
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pc
 */
public class ShoppingCart {
    
    private Map<String, Item> items;
    
    public ShoppingCart() {
        
        this.items = new HashMap<>();
        
    }
    
    public void add(String product, int price) {
        if(items.containsKey(product)) {
            items.get(product).increaseQuantity();
        } else {
           this.items.put(product, new Item(product, 1, price)); 
        }        
    }
    
    public int price() {
        int tot = 0;
        for(Item i : items.values()) {
            tot += i.price();
        }
        return tot;
    }
    
    public void print() {
        for(Item i : items.values()) {
            System.out.println(i.toString());
        }
    }
}
