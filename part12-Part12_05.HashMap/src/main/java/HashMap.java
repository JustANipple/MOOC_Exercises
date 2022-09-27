
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pc
 */
public class HashMap<K, V>{
    
    private List<Pair<K, V>>[] values;
    private int firstFreeIndex;
    
    public HashMap() {
        this.values = new List[32];
        this.firstFreeIndex = 0;
    }
    
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }

        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }

        return null;
    }
    
    public void add(K key, V value) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if(values[hashValue] == null) {
            
        }
        
        List<Pair<K,V>> valuesAtIndex = values[hashValue];
        
        int index = -1;
        for(int i = 0; i < valuesAtIndex.size(); i++) {
            if(valuesAtIndex.get(i).getKey().equals(key)) {
                index = i;
                break;
            }
        }
        
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key,value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
    }
}
