package oop2.module01;

import java.util.ArrayList;

/**
 * @author Dieter Holz
 */
public class Person {
    private int    age;
    private double weight;
    private double height;
    private ArrayList<Person> friends = new ArrayList<Person>();

    public Person(int age, double weight, double height) {
        this.age    = age;
        this.weight = weight;
        this.height = height;
    }

    public double getBMI() {
        return weight / (height * height);
    }

    //alle Getter und Setter

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // public methods

    public void addFriend(Person friend) {
        this.friends.add(friend);
        friend.friends.add(this);
    }

    public void removeFriend(Person friend) {
        this.friends.remove(friend);
        friend.friends.remove(this);
    }

    public int numberOfFriends() {
        return this.friends.size();
    }

    public boolean isFriend(Person friend) {
        if(this.friends.contains(friend)){
            return true;
        } else {
            return false;
        }
    }
}
