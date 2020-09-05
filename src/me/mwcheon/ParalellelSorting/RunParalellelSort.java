package me.mwcheon.ParalellelSorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RunParalellelSort {
    public RunParalellelSort() {
    }

    public static void main(String[] args) {

        int arraySize = 1500;
        int [] randomArray = new int[arraySize];
        Random random = new Random();

        IntStream.range(0, arraySize).forEach(i -> randomArray[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(randomArray);
        System.out.println("arrays.sort : "+ (System.nanoTime() - start));

        IntStream.range(0, arraySize).forEach(i -> randomArray[i] = random.nextInt());
        long start2 = System.nanoTime();
        Arrays.parallelSort(randomArray);
        System.out.println("arrays.parallelSort : "+ (System.nanoTime() - start2));



    }
}
