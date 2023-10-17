package javabasics;

import java.util.*;
import java.util.concurrent.*;  

public class HashMapExample1 {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> ht = new ConcurrentHashMap<Integer, String>();
		HashMap<Integer, String> map = new HashMap<Integer, String>();// Creating HashMap
		map.put(1, "Mango"); // Put elements in Map
		map.put(2, "Apple");
		map.put(3, "Banana");
		map.put(4, "Grapes");

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

		map.computeIfAbsent(6, (key) -> {
			return "cucumber";
		});

		for (Map.Entry m : map.entrySet()) {
			System.out.println("Key :: " + m.getKey() + " Value :: " + m.getValue());
		}

		System.out.println("-------------------forEach--------------------");
		map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
	}

}
