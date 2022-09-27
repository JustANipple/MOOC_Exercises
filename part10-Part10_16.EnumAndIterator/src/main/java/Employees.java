
import java.util.ArrayList;
import java.util.Iterator;
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
public class Employees {
    private List<Person> persons;
    
    public Employees() {
        this.persons = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        persons.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        for(Person p : peopleToAdd) {
            persons.add(p);
        }
    }
    
    public void print() {
        Iterator<Person> iterator = persons.iterator();
        while(iterator.hasNext()) {
            Person nextInLine = iterator.next();
            System.out.println(nextInLine);
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = persons.iterator();
        while(iterator.hasNext()) {
            Person nextInLine = iterator.next();
            if(nextInLine.getEducation() == education) {
                System.out.println(nextInLine);
            }            
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = persons.iterator();
        while(iterator.hasNext()) {
            Person nextInLine = iterator.next();
            if(nextInLine.getEducation() == education) {
                iterator.remove();
            }            
        }
    }
}
