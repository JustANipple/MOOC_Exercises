
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pc
 */
public class Warehouse {
    
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;
    
    public Warehouse() {
        
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
        
    }
    
    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }
    
    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.stocks.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if(this.stocks.getOrDefault(product, 0) == 0) {
            return false;
        }
        this.stocks.put(product, this.stocks.get(product) -1);
        return true;        
    }
    
    public Set<String> products() {
        Set<String> names = new HashSet<>();
        for(String s : prices.keySet()) {
            names.add(s);
        }
        return names;
    }
}
