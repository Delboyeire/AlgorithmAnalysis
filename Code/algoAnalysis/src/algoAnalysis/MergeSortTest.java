package algoAnalysis;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class MergeSortTest {

	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }

    private int[] numbersForMergeSmall;
    private int[] numbersForMergeMedium;
    private int[] numbersForMergeLarge;
    private final static int SMALLSIZE = 100;
    private final static int MEDSIZE = 1000;
    private final static int LARGESIZE = 2000;
    private final static int MAX = 20;

    
    @Before
    public void setUpForMerge() throws Exception {
           	numbersForMergeSmall = new int[SMALLSIZE];
            Random generator = new Random();
            for (int i = 0; i < numbersForMergeSmall.length; i++) {
            	numbersForMergeSmall[i] = generator.nextInt(MAX);
            }
            
            numbersForMergeMedium = new int[MEDSIZE];
            generator = new Random();
            for (int i = 0; i < numbersForMergeMedium.length; i++) {
            	numbersForMergeMedium[i] = generator.nextInt(MAX);
            }
            numbersForMergeLarge = new int[LARGESIZE];
            generator = new Random();
            for (int i = 0; i < numbersForMergeLarge.length; i++) {
            	numbersForMergeLarge[i] = generator.nextInt(MAX);
            }
    }
    

    @Test
    public void testMergeSortSmall() {
    	
    		System.out.println("Small set for bubble :");
    		for (int i = 0; i < numbersForMergeSmall.length; i++) {
    			System.out.print(numbersForMergeSmall[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            MergeSort sorter = new MergeSort();
            sorter.sort(numbersForMergeSmall);

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("Quicksort 1 time(milliseconds): " + elapsedTime);
            
            printResultSmall(numbersForMergeSmall);

            if (!validate(numbersForMergeSmall)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("First Set Used memory is bytes: " + memory);
            System.out.println("First Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            System.out.println();
            
    }
    @Test
    public void testMergeSortMed() {
    	
	    	System.out.println("Medium set for bubble :");
	        for (int i = 0; i < numbersForMergeMedium.length; i++) {
	            System.out.print(numbersForMergeMedium[i] + ",");
	        }
	        System.out.println();
	        Runtime runtime = Runtime.getRuntime();
            long startTime = System.nanoTime();
            MergeSort sorter = new MergeSort();
            sorter.sort(numbersForMergeMedium);

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("Quicksort 2 Time(nanoseconds) : " + elapsedTime);
            
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Second Set Used memory is bytes: " + memory);
            System.out.println("Second Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            
            printResultMedium(numbersForMergeMedium);

            if (!validate(numbersForMergeMedium)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            System.out.println();
    }
    @Test
    public void testMergeSortLarge() {
    	
	    	System.out.println("Large set for bubble :");
	        for (int i = 0; i < numbersForMergeLarge.length; i++) {
	            System.out.print(numbersForMergeLarge[i]+ ",");
	        }
	        System.out.println();
            
            long startTime = System.nanoTime();
            MergeSort sorter = new MergeSort();
            sorter.sort(numbersForMergeLarge);

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
            
            printResultLarge(numbersForMergeLarge);

            if (!validate(numbersForMergeLarge)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            System.out.println();
    }

   
    private boolean validate(int[] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                            return false;
                    }
            }
            return true;
    }

    private void printResultSmall(int[] numbers) {
    		System.out.println("Small Set Sorted: ");
            for (int i = 0; i < numbers.length; i++) {
                    System.out.print(numbers[i] + ",");
            }
            System.out.println();
    }
    private void printResultMedium(int[] numbers) {
		System.out.println("Medium Set Sorted: ");
        for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + ",");
        }
        System.out.println();
}
    private void printResultLarge(int[] numbers) {
		System.out.println("Large Set Sorted: ");
        for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + ",");
        }
        System.out.println();
}
}
    

