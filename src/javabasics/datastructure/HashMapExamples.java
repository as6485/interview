package javabasics.datastructure;

import java.util.*;
import java.util.concurrent.*;  

public class HashMapExamples {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();// Creating HashMap
		map.put(1, "Mango"); // Put elements in Map
		map.put(2, "Apple");
		map.put(3, "Banana");
		map.put(4, "Grapes");

		System.out.println("---------------- get all keys -----------------------");

		map.keySet().stream().forEach(System.out::println);

		System.out.println("---------------- get all values -----------------------");

		map.values().stream().forEach(System.out::println);

		System.out.println("---------------- EntrySet -----------------------");
		for (Map.Entry m : map.entrySet()) {
			System.out.println("Key :: " + m.getKey() + " Value :: " + m.getValue());
		}

		System.out.println("---------------- Remove -----------------------");

		map.remove(1);

		for (Map.Entry m : map.entrySet()) {
			System.out.println("Key :: " + m.getKey() + " Value :: " + m.getValue());
		}

		System.out.println("--------------- putIfAbsent-------------------");

		map.putIfAbsent(5, "Mango");

		for (Map.Entry m : map.entrySet()) {
			System.out.println("Key :: " + m.getKey() + " Value :: " + m.getValue());
		}

		System.out.println("-------------------computeIfPresent--------------------");

		for (Map.Entry m : map.entrySet()) {
			map.computeIfPresent((Integer) m.getKey(), (key, val) -> val.toLowerCase());
			System.out.println("Key :: " + m.getKey() + " Value :: " + m.getValue());
		}

		System.out.println("-------------------computeIfAbsent--------------------");

		System.out.println(map.computeIfAbsent(6, (key) -> {
			return "cucumber";
		}));

		for (Map.Entry m : map.entrySet()) {
			System.out.println("Key :: " + m.getKey() + " Value :: " + m.getValue());
		}

		System.out.println("-------------------forEach--------------------");
		map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
	}

}
