package algoAnalysis;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;


public class QuickSortRunner {

	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }

    private int[] numbersForQuickSmall;
    private int[] numbersForQuickMedium;
    private int[] numbersForQuickLarge;
    private final static int SMALLSIZE = 100;
    private final static int MEDSIZE = 1000;
    private final static int LARGESIZE = 2000;
    private final static int MAX = 20;
    public long memory;
    public long elapsedTime;

    
    
    public int[] setUpForQuickSmall() throws Exception {
           	numbersForQuickSmall = new int[SMALLSIZE];
            Random generator = new Random();
            for (int i = 0; i < numbersForQuickSmall.length; i++) {
            	numbersForQuickSmall[i] = generator.nextInt(MAX);
            }
            for (int j = 0; j < numbersForQuickSmall.length; j++) {
            
            }
            return numbersForQuickSmall;
            
    }
    public int[] setUpForQuickMed() throws Exception {
       	numbersForQuickMedium = new int[MEDSIZE];
        Random generator = new Random();
        for (int i = 0; i < numbersForQuickMedium.length; i++) {
        	numbersForQuickMedium[i] = generator.nextInt(MAX);
        }
        for (int j = 0; j < numbersForQuickMedium.length; j++) {
        
        }
        return numbersForQuickMedium;
        
}
    public int[] setUpForQuickLarge() throws Exception {
       	numbersForQuickLarge = new int[LARGESIZE];
        Random generator = new Random();
        for (int i = 0; i < numbersForQuickLarge.length; i++) {
        	numbersForQuickLarge[i] = generator.nextInt(MAX);
        }
        for (int j = 0; j < numbersForQuickLarge.length; j++) {
        
        }
        return numbersForQuickLarge;
        
}


    @Test
    public void testQuickSortSmall() {
    	
    		System.out.println("Small set for Quicksort :");
    		for (int i = 0; i < numbersForQuickSmall.length; i++) {
    			System.out.print(numbersForQuickSmall[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            quickSort sorter = new quickSort();
            sorter.sort(numbersForQuickSmall);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Quicksort small time(milliseconds): " + elapsedTime);
            
            printResultSmall(numbersForQuickSmall);

            if (!validate(numbersForQuickSmall)) {
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
    public void testQuickSortMedium() {
    	
    		System.out.println("Medium set for Quicksort :");
    		for (int i = 0; i < numbersForQuickMedium.length; i++) {
    			System.out.print(numbersForQuickMedium[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            quickSort sorter = new quickSort();
            sorter.sort(numbersForQuickMedium);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Quicksort small time(milliseconds): " + elapsedTime);
            
            printResultMedium(numbersForQuickMedium);

            if (!validate(numbersForQuickMedium)) {
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
    public void testQuickSortLarge() {
    	
    		System.out.println("Large set for Quicksort :");
    		for (int i = 0; i < numbersForQuickLarge.length; i++) {
    			System.out.print(numbersForQuickLarge[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            quickSort sorter = new quickSort();
            sorter.sort(numbersForQuickLarge);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Quicksort small time(milliseconds): " + elapsedTime);
            
            printResultLarge(numbersForQuickLarge);

            if (!validate(numbersForQuickLarge)) {
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
    

