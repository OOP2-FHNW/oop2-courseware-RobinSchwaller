package oop2.module04.countries;

import oop2.module04.countries.Country;
import oop2.module04.countries.CountryByAreaComparator_Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest_Solution {

	private Country       ch;
	private Country       de;
	private Country       fr;
	private Country       it;
	private Country       au;
	private List<Country> countries;

	@BeforeEach
	void setUp() {
        ch = new Country("Schweiz", 41_285);
        de = new Country("Deutschland", 357_121.41);
        fr = new Country("Frankreich", 668_763.00);
        it = new Country("Italien", 301_338);
        au = new Country("\u00D6sterreich", 83_878.99);

		countries = new ArrayList<>();
		countries.add(fr);
		countries.add(de);
		countries.add(ch);
		countries.add(it);
		countries.add(au);
	}

	@Test
	void testSortByAreaViaSeparateComparatorClass(){
		//when
		Collections.sort(countries, new CountryByAreaComparator_Solution());


		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}

//	@Test
//	public void testSortCountriesWithAlmostSameArea() {
//		//given
//		Country c1 = new Country("a", 1.3);
//		Country c2 = new Country("b", 1.1);
//
//		List<Country> sut = new ArrayList<>();
//		sut.add(c1);
//		sut.add(c2);
//
//		//when
//		Collections.sort(sut, new CountryByAreaComparatorSolution());
//
//		//then
//		assertSame(c2, sut.get(0));
//		assertSame(c1, sut.get(1));
//	}

	private Country getFirst() {
		return countries.get(0);
	}

	private Country getLast() {
		return countries.get(countries.size() - 1);
	}


	@Test
	void testSortByNameViaInnerClass(){
		//when
		Collections.sort(countries, new InnerCountryByNameComparator());

		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}

	private class InnerCountryByAreaComparator implements Comparator<Country>{
		@Override
		public int compare(Country o1, Country o2){
			return Double.compare(o1.getArea(), o2.getArea());
		}
	}
    private class InnerCountryByNameComparator implements Comparator<Country> {

   		@Override
   		public int compare(Country o1, Country o2) {
   			return o1.getName().compareTo(o2.getName());
   		}
   	}

	@Test
	void testSortByAreaViaAnonymousInnerClass(){
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
	void testSortByNameViaLambda(){
		//when
		Collections.sort(countries, (o1, o2) -> o1.getName().compareTo(o2.getName()));

		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}

	@Test
	void testSortByAreaViaLambda(){
		//when
		Collections.sort(countries, (c1, c2) -> (int) (c1.getArea() - c2.getArea()));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}

	@Test
	void testSortByAreaViaSortMethod(){
		//when
		countries.sort((o1, o2) -> Double.compare(o1.getArea(), o2.getArea()));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}

	@Test
	void testSortByNameViaMethodReference(){
		//when
		countries.sort(Comparator.comparing(country -> country.getName()));
		countries.sort(Comparator.comparing(Country::getName));

		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}

	@Test
	void testSortByAreaViaMethodReference(){
		//when
		countries.sort(Comparator.comparingDouble(Country::getArea));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}

	@Test
	void testSortReversedByAreaViaMethodReference(){
		Collections.sort(countries, (c1, c2) -> Double.compare(c1.getArea(), c2.getArea()));

		//when
		countries.sort(Comparator.comparingDouble(Country::getArea).reversed());

		//then
		assertSame(fr, getFirst());
		assertSame(ch, getLast());
	}

	@Test
	void testSortReversedByNameViaMethodReference(){
		countries.forEach(c -> System.out.println(c));
		//when
		countries.sort(Comparator.comparing(Country::getName).reversed());

		//then
		assertSame(au, getFirst());
		assertSame(de, getLast());
	}

	@Test
	void testReplaceAllViaLambda(){
		//given
		List<String> countryNames = new ArrayList<>();
		for(Country c : countries){
			countryNames.add(c.getName());
		}

		//when
		countries.replaceAll(c -> new Country(c.getName() + " (" + c.getName().substring(0, 2) + ")", c.getArea()));

		//then
		assertFalse(countries.contains(ch));
		assertFalse(countries.contains(de));
		assertFalse(countries.contains(fr));
		assertFalse(countries.contains(it));
		assertFalse(countries.contains(au));

		for(int i = 0; i < countries.size(); i++){
			assert(countries.get(i).getName().startsWith(countryNames.get(i) + " ("));
		}
	}

	@Test
	void testRemoveSmallCountries(){
		//when
		countries.removeIf(c -> c.getArea() < 100_000);

		//then
		assertSame(3, countries.size());

		assertTrue(countries.contains(de));
		assertTrue(countries.contains(fr));
		assertTrue(countries.contains(it));
	}




}