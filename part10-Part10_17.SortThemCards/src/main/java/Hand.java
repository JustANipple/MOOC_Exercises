
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pc
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        Iterator<Card> iter = cards.iterator();
        while(iter.hasNext()) {
            Card line = iter.next();
            System.out.println(line);
        }
    }
    
    public void sort() {
        ArrayList<Card> sorted = new ArrayList<>();
        cards.stream().sorted().forEach(c -> sorted.add(c));
        this.cards = sorted;
    }
    
    @Override
    public int compareTo(Hand hand) {
        int sum1 = 0;
        for(Card c : this.cards) {
            sum1 += c.getValue();
        }
        int sum2 = 0;
        for(Card d : hand.cards) {
            sum2 += d.getValue();
        }
        return sum1 - sum2;
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}
