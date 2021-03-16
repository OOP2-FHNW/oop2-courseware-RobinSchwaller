package oop2.module04;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Dieter Holz
 */
public class MethodReferences {
    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);

        Function<Integer, String> func = (Integer i) -> {
            return "James" + i;
        };

        Supplier<String> func2 = () -> "Raoul";

        Supplier<String> func3 = () -> {
            return "Richard";
        };

//		Consumer<String> func4 = (String s) -> {
//			return "Raoul";
//		};
    }
}
