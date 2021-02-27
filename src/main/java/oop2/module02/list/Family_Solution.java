package oop2.module02.list;

import java.util.ArrayList;
import java.util.List;

import oop2.module02.Person;

/**
 * @author Dieter Holz
 */
public class Family_Solution {

    private final List<Person> members = new ArrayList<>();

    public int size() {
        return members.size();
    }

    public void add(Person person) {
        if (isMember(person)) {
            return;
        }
        members.add(person);

    }

    public boolean isMember(Person person) {
        return members.contains(person);
    }

    public Person getOldest() {
        Person oldest = members.get(0);
        for (Person p : members) {
            if (p.getAge() > oldest.getAge()) {
                oldest = p;
            }
        }
        return oldest;
    }
}
