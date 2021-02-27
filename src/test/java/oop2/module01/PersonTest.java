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

    @Test
    void testInitFriends(){
        // setup
        Person robin = new Person(20,70,1.80);
        Person luca = new Person (25, 70, 1.80);

        // when
        assertEquals(0, robin.numberOfFriends());
        assertEquals(0, luca.numberOfFriends());
    }

    @Test
    public void testAddFriend(){
        // setup
        Person robin = new Person(20,70,1.80);
        Person luca = new Person (25, 70, 1.80);

        // when
        robin.addFriend(luca);

        // then
        assertEquals(1, robin.numberOfFriends());
        assertEquals(1, luca.numberOfFriends());
        assertTrue(luca.isFriend(robin));
        assertTrue(robin.isFriend(luca));
    }

    @Test
    public void testAddFriendTwiche(){
        Person robin = new Person(20,70,1.80);
        Person luca = new Person (25, 70, 1.80);

        robin.addFriend(luca);
        robin.addFriend(luca);

        assertEquals(1, robin.numberOfFriends());
    }

    @Test
    public void testAddYourself(){
        Person robin = new Person(20,70,1.80);
        robin.addFriend(robin);
        assertEquals(0, robin.numberOfFriends());
    }

    @Test
    public void testRemoveFriend(){
        // setup
        Person robin = new Person(20,70,1.80);
        Person luca = new Person (25, 70, 1.80);
        robin.addFriend(luca);

        // when
        assertEquals(1, robin.numberOfFriends());
        assertEquals(1, luca.numberOfFriends());

        // then
        robin.removeFriend(luca);
        assertEquals(0, robin.numberOfFriends());
        assertEquals(0, luca.numberOfFriends());
        assertFalse(luca.isFriend(robin));
        assertFalse(robin.isFriend(luca));
    }
}