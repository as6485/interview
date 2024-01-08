package javabasics.datastructure;

import java.util.*;
/*
https://www.benchresources.net/java-how-to-add-remove-modify-an-element-to-list-while-iterating/
https://stackoverflow.com/questions/993025/adding-elements-to-a-collection-during-iteration
 */

public class ConcurrentModificationInCollection {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<String>();
        fruits.add("Melons");
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Cherry");
        fruits.add("Grapes");

        /*iterate using forEach and trying to add/remove items lead to ConcurrentModificationException*/
        /*for(String fruit : fruits) {
            fruits.add("ABC");
            fruits.remove(fruit);
        }

        fruits.forEach(v -> {fruits.remove(v);});

        */

        //using Iterator we can remove from a list while iterating
        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equalsIgnoreCase("Cherry"))
                iterator.remove();
        }


        /** Using ListIterator we can add to a list while iterating
        this doesn't work on other Collections, we can create a separate collection and add it to the original in such cases
         **/
        ListIterator<String> listIterator = fruits.listIterator();
        while(listIterator.hasNext()) {
            if(listIterator.next().equalsIgnoreCase("Melons")) {
                listIterator.remove();
                listIterator.add("Banana");
            }
        }
    }
}
