package algoAnalysis;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;


public class HeapSortRunner {

	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }

    private int[] numbersForHeapSmall;
    private int[] numbersForHeapMedium;
    private int[] numbersForHeapLarge;
    private final static int SMALLSIZE = 100;
    private final static int MEDSIZE = 1000;
    private final static int LARGESIZE = 2000;
    private final static int MAX = 20;
    public long memory;
    public long elapsedTime;

    
    
    public int[] setUpForHeapSmall() throws Exception {
           	numbersForHeapSmall = new int[SMALLSIZE];
            Random generator = new Random();
            for (int i = 0; i < numbersForHeapSmall.length; i++) {
            	numbersForHeapSmall[i] = generator.nextInt(MAX);
            }
            for (int j = 0; j < numbersForHeapSmall.length; j++) {
            
            }
            return numbersForHeapSmall;
            
    }
    public int[] setUpForHeapMedium() throws Exception {
       	numbersForHeapMedium = new int[MEDSIZE];
        Random generator = new Random();
        for (int i = 0; i < numbersForHeapMedium.length; i++) {
        	numbersForHeapMedium[i] = generator.nextInt(MAX);
        }
        for (int j = 0; j < numbersForHeapMedium.length; j++) {
        
        }
        return numbersForHeapMedium;
        
    }
    public int[] setUpForHeapLarge() throws Exception {
       	numbersForHeapLarge = new int[LARGESIZE];
        Random generator = new Random();
        for (int i = 0; i < numbersForHeapLarge.length; i++) {
        	numbersForHeapLarge[i] = generator.nextInt(MAX);
        }
        for (int j = 0; j < numbersForHeapLarge.length; j++) {
        
        }
        return numbersForHeapLarge;
        
    }
    

    @Test
    public void testHeapSortSmall() {
    	
    		System.out.println("Small set for Heapsort :");
    		for (int i = 0; i < numbersForHeapSmall.length; i++) {
    			System.out.print(numbersForHeapSmall[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            HeapSort sorter = new HeapSort();
            sorter.sort(numbersForHeapSmall);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Heapsort small time(milliseconds): " + elapsedTime);
            
            printResultSmall(numbersForHeapSmall);

            if (!validate(numbersForHeapSmall)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Small Set Used memory is bytes: " + memory);
            System.out.println("Small Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            System.out.println();
            
    }
    @Test
    public void testHeapSortMedium() {
    	
    		System.out.println("Medium set for Heapsort :");
    		for (int i = 0; i < numbersForHeapMedium.length; i++) {
    			System.out.print(numbersForHeapMedium[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            HeapSort sorter = new HeapSort();
            sorter.sort(numbersForHeapMedium);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Heapsort Medium time(milliseconds): " + elapsedTime);
            
            printResultMedium(numbersForHeapMedium);

            if (!validate(numbersForHeapMedium)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Medium Set Used memory is bytes: " + memory);
            System.out.println("Medium Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            System.out.println();
            
    }
    @Test
    public void testHeapSortLarge() {
    	
    		System.out.println("Large set for Heapsort :");
    		for (int i = 0; i < numbersForHeapLarge.length; i++) {
    			System.out.print(numbersForHeapLarge[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            HeapSort sorter = new HeapSort();
            sorter.sort(numbersForHeapLarge);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Heapsort Large time(milliseconds): " + elapsedTime);
            
            printResultLarge(numbersForHeapLarge);

            if (!validate(numbersForHeapLarge)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Large Set Used memory is bytes: " + memory);
            System.out.println("Large Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
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
    

