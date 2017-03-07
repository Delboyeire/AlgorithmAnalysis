package algoAnalysis;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class sortTest {

	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }

    private int[] numbers;
    private int[] numbers2;
    private final static int SIZE = 100;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = generator.nextInt(MAX);
            }
            System.out.println("Set 1 :");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i]);
            }
            System.out.println();
    }
    @Before
    public void setUp2() throws Exception {
            numbers2 = new int[1000];
            Random generator = new Random();
            for (int i = 0; i < numbers2.length; i++) {
                    numbers2[i] = generator.nextInt(MAX);
            }
            System.out.println("Set 2 :");
            for (int i = 0; i < numbers2.length; i++) {
                System.out.print(numbers2[i]);
            }
            System.out.println();
    }

    @Test
    public void testQuickSort() {
            
            long startTime = System.nanoTime();
            quickSort sorter = new quickSort();
            sorter.sort(numbers);

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("Quicksort 1 time(nanoseconds): " + elapsedTime);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("First Set Used memory is bytes: " + memory);
            System.out.println("First Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            printResult(numbers);

            if (!validate(numbers)) {
                    fail("Should not happen");
            }
            assertTrue(true);
    }
    @Test
    public void testQuickSort2() {
            
            long startTime = System.nanoTime();
            quickSort sorter = new quickSort();
            sorter.sort(numbers2);

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("Quicksort 2 Time(nanoseconds) : " + elapsedTime);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Second Set Used memory is bytes: " + memory);
            System.out.println("Second Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            
            printResult2(numbers2);

            if (!validate(numbers2)) {
                    fail("Should not happen");
            }
            assertTrue(true);
    }

   
    private boolean validate(int[] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                            return false;
                    }
            }
            return true;
    }

    private void printResult(int[] numbers) {
    		System.out.println("First Set Sorted: ");
            for (int i = 0; i < numbers.length; i++) {
                    System.out.print(numbers[i]);
            }
            System.out.println();
    }
    private void printResult2(int[] numbers) {
		System.out.println("Second Set Sorted: ");
        for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i]);
        }
        System.out.println();
}
    
    
}
