package test;

import java.util.*;
import java.util.function.Predicate;

public class Lambdas {
	public static void main(String[] args) {
		Comparator<String> comparatorAnonymeInnereKlasse = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};
		
		Comparator<String> comparatorLambda = (String s1, String s2) -> { return s1.length() - s2.length();};
		
		comparatorLambda = (s1,s2) -> { return s1.length() - s2.length();};
		
		comparatorLambda = (s1,s2) -> s1.length() - s2.length();
		
		List<String> w�rter = Arrays.asList("aa","a","aaaa","aaa");
		
		System.out.println(w�rter);
		
		Collections.sort(w�rter, comparatorAnonymeInnereKlasse);
		
		System.out.println(w�rter);
		
		w�rter = Arrays.asList("aa","a","aaaa","aaa");
		
		System.out.println(w�rter);
		
		Collections.sort(w�rter, comparatorLambda);
		
		System.out.println(w�rter);
		
		Predicate<String> wortL�ngerAlsF�nfBuchstaben = (String s) -> s.length() > 5;
		
		wortL�ngerAlsF�nfBuchstaben = (s) -> s.length() > 5;
		
		wortL�ngerAlsF�nfBuchstaben = s -> s.length() > 5;
		
		System.out.println(wortL�ngerAlsF�nfBuchstaben.test("Hallo"));
		
		System.out.println(wortL�ngerAlsF�nfBuchstaben.test("Hallo Welt!"));
		
		Runnable runnable = () -> System.out.println("Hallo Welt!");
		
		runnable.run();
		
		new LambdaCalculateTest();
	}
}

class LambdaCalculateTest {
    interface Rectangle {
        public double getArea(double length, double width);
    }

    public LambdaCalculateTest() {
        Rectangle rect = (l, w) -> { l*=2; w*=3; return l * w; };
        System.out.println("Flaeche: " + rect.getArea(4, 3));
    }
}
