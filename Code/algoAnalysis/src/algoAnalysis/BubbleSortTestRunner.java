package algoAnalysis;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;


public class BubbleSortTestRunner {

	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }

    private int[] numbersForBubbleSmall;
    private int[] numbersForBubbleMedium;
    private int[] numbersForBubbleLarge;
    private final static int SMALLSIZE = 100;
    private final static int MEDSIZE = 1000;
    private final static int LARGESIZE = 2000;
    private final static int MAX = 20;
    public long memory;
    public long elapsedTime;

    
 
    public int[] setUpForBubbleSmall() throws Exception {
       	numbersForBubbleSmall = new int[SMALLSIZE];
        Random generator = new Random();
        for (int i = 0; i < numbersForBubbleSmall.length; i++) {
        	numbersForBubbleSmall[i] = generator.nextInt(MAX);
        }
        for (int j = 0; j < numbersForBubbleSmall.length; j++) {
        
        }
        return numbersForBubbleSmall;
        
}
    public int[] setUpForBubbleMedium() throws Exception {
       	numbersForBubbleMedium = new int[MEDSIZE];
        Random generator = new Random();
        for (int i = 0; i < numbersForBubbleMedium.length; i++) {
        	numbersForBubbleMedium[i] = generator.nextInt(MAX);
        }
        for (int j = 0; j < numbersForBubbleMedium.length; j++) {
        
        }
        return numbersForBubbleMedium;
        
}
    public int[] setUpForBubbleLarge() throws Exception {
       	numbersForBubbleLarge = new int[LARGESIZE];
        Random generator = new Random();
        for (int i = 0; i < numbersForBubbleLarge.length; i++) {
        	numbersForBubbleLarge[i] = generator.nextInt(MAX);
        }
        for (int j = 0; j < numbersForBubbleLarge.length; j++) {
        
        }
        return numbersForBubbleLarge;
        
}
    

    @Test
    public void testBubbleSortSmall() {
    	
    		System.out.println("Small set for bubble :");
    		for (int i = 0; i < numbersForBubbleSmall.length; i++) {
    			System.out.print(numbersForBubbleSmall[i] + ",");
    		}
    		
    		System.out.println();
            long startTime = System.nanoTime();
            BubbleSort sorter = new BubbleSort();
            sorter.sort(numbersForBubbleSmall);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Quicksort 1 time(milliseconds): " + elapsedTime);
            
            printResultSmall(numbersForBubbleSmall);

            if (!validate(numbersForBubbleSmall)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            System.out.println();
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("First Set Used memory is bytes: " + memory);
            System.out.println("First Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            
    }
    @Test
    public void testBubbleSortMedium() {
    	
	    	System.out.println("Medium set for bubble :");
	        for (int i = 0; i < numbersForBubbleMedium.length; i++) {
	            System.out.print(numbersForBubbleMedium[i] + ",");
	        }
	        System.out.println();
	        Runtime runtime = Runtime.getRuntime();
            long startTime = System.nanoTime();
            BubbleSort sorter = new BubbleSort();
            sorter.sort(numbersForBubbleMedium);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Quicksort 2 Time(nanoseconds) : " + elapsedTime);
            
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Second Set Used memory is bytes: " + memory);
            System.out.println("Second Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            
            printResultMedium(numbersForBubbleMedium);

            if (!validate(numbersForBubbleMedium)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            System.out.println();
    }
    @Test
    public void testBubbleSortLarge() {
    	
	    	System.out.println("Large set for bubble :");
	        for (int i = 0; i < numbersForBubbleLarge.length; i++) {
	            System.out.print(numbersForBubbleLarge[i]+ ",");
	        }
	        System.out.println();
            
            long startTime = System.nanoTime();
            BubbleSort sorter = new BubbleSort();
            sorter.sort(numbersForBubbleLarge);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Quicksort 2 Time(nanoseconds) : " + elapsedTime);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Second Set Used memory is bytes: " + memory);
            System.out.println("Second Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            
            printResultLarge(numbersForBubbleLarge);

            if (!validate(numbersForBubbleLarge)) {
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
    

