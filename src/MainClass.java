import java.util.Random;
import java.util.Scanner;

public class MainClass {
    static Random rand = new Random();
    public static void main(String[] args) {
        
    }
    public static void homeWork1(String[] args) {
        FirstArrayList <Integer> arr = new FirstArrayList<>(100000);

        //заполняем массив

        for(int i=0; i<arr.getCapacity(); i++) {
            arr.add(rand.nextInt());
        }

        //selectionSort
        System.out.println("selectionSort start: " + System.currentTimeMillis());
        long start = System.currentTimeMillis();
        arr.selectionSort();
        System.out.println("time selectionSort: " + (System.currentTimeMillis()-start));

        //insertionSort
        System.out.println("insertionSort start: " + System.currentTimeMillis());
        start = System.currentTimeMillis();
        arr.insertionSort();
        System.out.println("time insertionSort: " + (System.currentTimeMillis()-start));

        //bubbleSort
        System.out.println("bubbleSort start: " + System.currentTimeMillis());
        start = System.currentTimeMillis();
        arr.bubbleSort();
        System.out.println("time bubbleSort: " + (System.currentTimeMillis()-start));
    }
}