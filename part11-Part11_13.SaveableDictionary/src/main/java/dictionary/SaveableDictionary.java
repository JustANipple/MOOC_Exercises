/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Pc
 */
public class SaveableDictionary {
    
    private final HashMap<String,String> dictionary;
    private String file;
    
    public SaveableDictionary() {
        
        this.dictionary = new HashMap<>();
        
    }
    
    public SaveableDictionary(String file) {
        
        this.file = file;
        this.dictionary = new HashMap<>();
        
    }
    
    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get("words.txt"))){
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                
                String word = parts[0];
                String translation = parts[1];
                add(word,translation);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    public boolean save() {
        try (PrintWriter writer = new PrintWriter(file)) {
            int x = 1;
            for (String key : dictionary.keySet()) {
                if(key != null && dictionary.get(key) != null) {
                    writer.append(key + ":" + dictionary.get(key));
                    if(x < dictionary.size()) {
                        writer.println();
                        x++;
                    }
                }
                
            }
            
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public void add(String words, String translation) {
        if(!dictionary.containsKey(words)) {
            dictionary.put(words, translation);
        }
        /*
        System.out.println("lista aggiornata:");
        for(String k : dictionary.keySet()) {
            System.out.println(k);
        }
        */
    }
    
    public String translate(String word) {
       if(this.dictionary.containsKey(word)) {
           return this.dictionary.get(word);
       }
       if(this.dictionary.containsValue(word)) {
           for(String s : this.dictionary.keySet()) {
               if(this.dictionary.get(s).equals(word)) {
                   return s;
               }
           }
       }
       return null;
    }
    
    public void delete(String word) {
        if(this.dictionary.containsKey(word)) {
            this.dictionary.remove(word);
        }
        if(this.dictionary.containsValue(word)) {
            for(String s : this.dictionary.keySet()) {
                this.dictionary.replace(s, word, null);
            }
        }
    }
}
