package test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		
//		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
//		
//		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
//		myList.stream().findFirst().ifPresent(System.out::println);
//		Stream.of("a1","a2","a3").findFirst().ifPresent(System.out::println);
//		
//		IntStream.range(1, 4).forEach(System.out::println);
//		
//		Arrays.stream(new int[] {1,2,3}).map(n -> 2*n+1).average().ifPresent(System.out::println);
//		
//		Stream.of("a1","a2","a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
//		
//		IntStream.range(1, 4).mapToObj(i -> "a"+i).forEach(System.out::println);
//		
//		Stream.of("d2","a2","b1","b3","c").filter(s -> {System.out.println("filter: "+ s);
//		return true;
//		}).forEach(s -> System.out.println("forEach: "+s));
//		
//		Stream.of("d2","a2","b1","b3","c").map(s -> {
//			System.out.println("map: "+s);
//			return s.toUpperCase();
//		}).anyMatch(s -> {
//			System.out.println("anyMatch: "+s);
//			return s.startsWith("A");
//		});
		
		Arrays.asList("a1","a2","b1","c2","c1")
		.parallelStream()
		.filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		})
		.map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		})
		.sorted((s1,s2) -> {
			System.out.format("sort: %s <> %s [%s]\n", s1,s2, Thread.currentThread().getName());
			return s1.compareTo(s2);
		})
		.forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}
}
