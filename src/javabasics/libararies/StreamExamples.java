package javabasics.libararies;


import jdk.jfr.DataAmount;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Product{
    int id;
    String name;
    float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class StreamExamples  {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        System.out.println("----------------- Basic Stream Operations -------------------------");
        List<Float> priceList =productsList.stream() //source data
                .filter(p -> p.price > 28000)// filtering data (intermediate operation)
                .map(p->p.price)        // fetching price (intermediate operation)
                .collect(Collectors.toList()); // collecting as list (terminal operation)
        System.out.println(priceList);

        System.out.println("----------------- forEach Terminal Operations ---------------------");
        productsList.stream() //source data
                .filter(p -> p.price > 28000)// filtering data (intermediate operation)
                .map(p->p.price)        // fetching price (intermediate operation)
                .forEach(price -> System.out.println(price)); // iterate (terminal operation)

        System.out.println("----------------- Collectors Operations ---------------------");
        /***
         * collect() performs mutable fold operations (repackaging elements to some data structures and applying some additional logic, concatenating them, etc.)
            Collectors.toList()
            Collectors.toSet()
            Collectors.toCollection()
            Collectors.partitioningBy
            Collectors.groupingBy
        toArray() If we need to get an array out of the stream*/

        Set<Float> priceSet =productsList.stream() //source data
                .filter(p -> p.price > 28000)// filtering data (intermediate operation)
                .map(p->p.price)        // fetching price (intermediate operation)
                .collect(Collectors.toSet()); // collecting as set (terminal operation)
        System.out.println(priceSet);

        Float[] array = (Float[]) productsList.stream() //source data
                .filter(p -> p.price > 28000)// filtering data (intermediate operation)
                .map(p->p.price)        // fetching price (intermediate operation)
                .toArray(Float[]::new); // collecting as array (terminal operation)
        System.out.println(Arrays.toString(array));


        Map<Float, List<Product>> mapList  = productsList.stream()
                .collect(Collectors.groupingBy(Product::getPrice)); //group by price

        mapList.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));



        Map<Boolean, List<Product>> mapBooleanList  = productsList.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() < 30000)); //partition into true/false based on criteria

        mapBooleanList.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));


        String csvProductName =productsList.stream() //source data
                .filter(p -> p.price > 28000)// filtering data (intermediate operation)
                .map(p->p.getName())        // get names only (intermediate operation)
                .collect(Collectors.joining(", ")) // join all elements (terminal operation)
                .toString(); //to a string
        System.out.println(csvProductName);

        System.out.println("----------------- flatMap ---------------------");
        String[][] strArr2d = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        List<String> flatStrArr = Stream.of(strArr2d)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .collect(Collectors.toList());      // return a List
        flatStrArr.forEach(System.out::println);

        int[][] intArr2d = new int[][] {{10,16},{2,8},{1,6},{7,12}};
        List<Integer> flatIntArr = Arrays.stream(intArr2d)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        flatIntArr.forEach(System.out::println);

        System.out.println("----------------- skip & limit ---------------------");

        productsList.stream()
                .skip(2) //skip 2 elements
                .limit(1) //limit result to 1
                .forEach(System.out::println);

        System.out.println("----------------- min & max ---------------------");

        Optional<Float> min = productsList.stream()
                .map(product -> product.getPrice())
                .min((e1,e2) -> Float.compare(e1, e2));
        min.ifPresent(value -> System.out.println("Min value : "+value));

        Optional<Float> max = productsList.stream()
                .map(product -> product.getPrice())
                .max((e1,e2) -> Float.compare(e1, e2));
        max.ifPresent(value -> System.out.println("Max value : "+value));


        System.out.println("----------------- distinct ---------------------");
        int[] intArr = new int[] {1,2,3,2,4,3,5};
        List<Integer> distinctIntArr = Arrays.stream(intArr)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        distinctIntArr.forEach(System.out::println);

        Set<Integer> setOfInteger = Arrays.stream(intArr)
                .boxed()
                .collect(Collectors.toSet());
        setOfInteger.forEach(System.out::println);


        System.out.println("------ allMatch, anyMatch, and noneMatch ---------");
        System.out.println(productsList.stream()
                .anyMatch(product -> product.getPrice()==28000)); //is any product priced at 28k?
        System.out.println(productsList.stream()
                .allMatch(product -> product.getPrice()==28000)); //are all product priced at 28k?
        System.out.println(productsList.stream()
                .noneMatch(product -> product.getPrice()==28000)); //no product priced at 28k?


        System.out.println("------ reduce ---------");
        List<String> words = Arrays.asList("Mihir", "Ranjan", "Chakraborty");

        System.out.println(words.stream().reduce((word1, word2) -> word1+","+word2));
    }
}
