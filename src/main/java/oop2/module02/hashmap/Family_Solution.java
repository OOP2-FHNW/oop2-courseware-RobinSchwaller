package oop2.module02.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import oop2.module02.Person;

/**
 * @author Dieter Holz
 */
public class Family_Solution {

    private final Set<Person> members = new HashSet<>();

    private final Map<Integer, Integer> ageToCountMap = new HashMap<>();


    public int size() {
        return members.size();
    }

    public void add(Person person) {
        members.add(person);

        Integer count = ageToCountMap.get(person.getAge());
		if(count == null){
			ageToCountMap.put(person.getAge(), 1);
		}
		else {
			ageToCountMap.put(person.getAge(), count + 1);
		}
    }

    public Person getOldest() {
        Person oldest = null;
        for (Person p : members) {
            if (oldest == null || p.getAge() > oldest.getAge()) {
                oldest = p;
            }
        }
        return oldest;
    }

    public boolean isMember(Person person) {
        return members.contains(person);
    }

    public int numberOfMembers(int age) {
		Integer count = ageToCountMap.get(age);
		if(count == null){
            return 0;
        }
        else {
            return count;
        }
		//return count == null ? 0 : count;
    }

    public Set<Integer> allAges() {
		return ageToCountMap.keySet();
    }

}
