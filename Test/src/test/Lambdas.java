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
		
		List<String> wörter = Arrays.asList("aa","a","aaaa","aaa");
		
		System.out.println(wörter);
		
		Collections.sort(wörter, comparatorAnonymeInnereKlasse);
		
		System.out.println(wörter);
		
		wörter = Arrays.asList("aa","a","aaaa","aaa");
		
		System.out.println(wörter);
		
		Collections.sort(wörter, comparatorLambda);
		
		System.out.println(wörter);
		
		Predicate<String> wortLängerAlsFünfBuchstaben = (String s) -> s.length() > 5;
		
		wortLängerAlsFünfBuchstaben = (s) -> s.length() > 5;
		
		wortLängerAlsFünfBuchstaben = s -> s.length() > 5;
		
		System.out.println(wortLängerAlsFünfBuchstaben.test("Hallo"));
		
		System.out.println(wortLängerAlsFünfBuchstaben.test("Hallo Welt!"));
		
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
