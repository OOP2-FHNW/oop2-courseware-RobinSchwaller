package oop2.module04.countries;

import oop2.module04.countries.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryTest {

	private Country       ch;
	private Country       de;
	private Country       fr;
	private Country       it;
	private Country       au;
	private List<Country> countries;

	@BeforeEach
	public void setUp()  {
		ch = new Country("Schweiz",          41_285.00);
		de = new Country("Deutschland",     357_121.41);
		fr = new Country("Frankreich",      668_763.00);
		it = new Country("Italien",         301_338.00);
		au = new Country("\u00D6sterreich",  83_878.99);

		countries = new ArrayList<>();
		countries.add(fr);
		countries.add(de);
		countries.add(ch);
		countries.add(it);
		countries.add(au);
	}

    private Country getFirst() {
        return countries.get(0);
  	}

  	private Country getLast() {
  		return countries.get(countries.size() - 1);
  	}

//	@Test
//	public void testSortByAreaViaSeparateComparatorClass(){
//		//when
//		Collections.sort(countries, ...);
//
//
//		//then
//		assertSame(ch, getFirst());
//		assertSame(fr, getLast());
//	}


//	@Test
//	public void testSortByAreaViaInnerClass(){
//		//when
//		Collections.sort(countries, ...);
//
//		//then
//		assertSame(ch, getFirst());
//		assertSame(fr, getLast());
//	}


	@Test
	public void testSortByAreaViaAnonymousInnerClass(){
		//when
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return Double.compare(o1.getArea(), o2.getArea());
			}
		});

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}

	@Test
	public void testSortByNameViaInnerClass(){
		//when
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}


	@Test
	public void testSortByNameViaLambda(){
		//when
		Collections.sort(countries, (c1, c2) -> c1.getName().compareTo(c2.getName()));

		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}


	@Test
	public void testSortByAreaViaLambda(){
		//when
		Collections.sort(countries, (c1, c2) -> Double.compare(c1.getArea(), c2.getArea()));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}

    @Test
    public void testSortByNameViaSortMethod() {
        //when
        countries.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));

        //then
        assertSame(de, getFirst());
        assertSame(au, getLast());
    }

	@Test
	public void testSortByAreaViaSortMethod(){
		//when
		countries.sort((c1,c2) -> Double.compare(c1.getArea(), c2.getArea()));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}


	@Test
	public void testSortByNameViaMethodReference(){
		//when
		countries.sort(Comparator.comparing(Country::getName));

		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}



	@Test
	public void testSortByAreaViaMethodReference(){
		//when
		countries.sort(Comparator.comparing(Country::getArea));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}



	@Test
	public void testSortReversedByAreaViaMethodReference(){
		//when
		countries.sort(Comparator.comparing(Country::getArea).reversed());

		//then
		assertSame(fr, getFirst());
		assertSame(ch, getLast());
	}


	@Test
	public void testSortReversedByNameViaMethodReference(){
		//when
		countries.sort(Comparator.comparing(Country::getName).reversed());

		//then
		assertSame(au, getFirst());
		assertSame(de, getLast());
	}


	@Test
	public void testRemoveCountriesSmallerThan100_000(){
		//when
		countries.removeIf(c -> c.getArea() < 100000);

		//then
		assertSame(3, countries.size());

		assertTrue(countries.contains(de));
		assertTrue(countries.contains(fr));
		assertTrue(countries.contains(it));
	}



}
