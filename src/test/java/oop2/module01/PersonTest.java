package oop2.module01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testBMI(){
        //given
        Person p = new Person(42, 90, 1.85);

        //when
        double bmi = p.getBMI();

        //then
        assertEquals(26.3, bmi, 0.01);
    }

    @Test
    public void testInitialization() {
        //given
        Person p = new Person(42, 90, 1.85);

        //then
        assertEquals(42, p.getAge());
        assertEquals(90, p.getWeight(), 0.01);
        assertEquals(1.85, p.getHeight(), 0.01);
    }

}