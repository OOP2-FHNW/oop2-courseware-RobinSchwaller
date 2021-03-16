package oop2.module04.countries;

import java.util.Comparator;

/**
 * @author Dieter Holz
 */
public class CountryByAreaComparator_Solution implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return (int) (o1.getArea() - o2.getArea());
        //return Double.compare(o1.getArea(), o2.getArea());
    }
}
