package oop2.module03.cage;

import oop2.module03.cage.animal.Animal;

import java.util.ArrayList;

public class Cage <T extends Animal> {
    ArrayList<T> animals = new ArrayList<>();

    public int numberOfAnimals() {
        return animals.size();
    }

    public boolean shelters(T animal) {
        return animals.contains(animal);
    }

    public void jail(T animal) {
        if(!animals.contains(animal)){
            animals.add(animal);
        }
    }

    public void setFree(T animal) {
        animals.remove(animal);
    }

    public static <A extends Animal> void jailAll(Cage<A> cage, A[] animalArray) {
        for(A animal: animalArray){
            cage.jail(animal);
        }
    }
}
