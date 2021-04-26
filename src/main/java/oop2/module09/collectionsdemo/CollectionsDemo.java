package oop2.module09.collectionsdemo;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class CollectionsDemo {
    ObservableList<String> myList = FXCollections.observableArrayList();


    public CollectionsDemo(){
        myList.addListener((ListChangeListener<? super String>) c->{
            while (c.next()) {
                if (c.wasPermutated()) {
                    for (int i = c.getFrom(); i < c.getTo(); ++i) {
                        //permutate
                    }
                } else if (c.wasUpdated()) {
                    //update item
                } else {

                    for (String additem : c.getAddedSubList()) {
                        System.out.println("Added: " + additem);
                    }
                }
            }
        });
    }

    public void addEntry(String value){
        myList.add(value);
    }

    public static void main(String[] args) {
        CollectionsDemo demo = new CollectionsDemo();
        demo.addEntry("First Entry");
    }
}
