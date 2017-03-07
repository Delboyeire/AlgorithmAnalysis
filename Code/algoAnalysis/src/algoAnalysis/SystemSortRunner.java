package algoAnalysis;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class SystemSortRunner {

	private static final long MEGABYTE = 1024L * 1024L;
    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }
    public long memory;
    public long elapsedTime;
    

    @Test
    public void testSystemSortSmall(int[] numbersForSystemSmall) {
    	
    		System.out.println("Small set for Systemsort :");
    		for (int i = 0; i < numbersForSystemSmall.length; i++) {
    			System.out.print(numbersForSystemSmall[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            systemSort sorter = new systemSort();
            sorter.sort(numbersForSystemSmall);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Systemsort small time(milliseconds): " + elapsedTime);
            
            printResultSmall(numbersForSystemSmall);

            if (!validate(numbersForSystemSmall)) {
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
    public void testSystemSortMedium(int[] numbersForSystemMedium) {
    	
    		System.out.println("Medium set for Systemsort :");
    		for (int i = 0; i < numbersForSystemMedium.length; i++) {
    			System.out.print(numbersForSystemMedium[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            systemSort sorter = new systemSort();
            sorter.sort(numbersForSystemMedium);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Systemsort small time(milliseconds): " + elapsedTime);
            
            printResultMedium(numbersForSystemMedium);

            if (!validate(numbersForSystemMedium)) {
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
    public void testSystemSortLarge(int[] numbersForSystemLarge) {
    	
    		System.out.println("Large set for Systemsort :");
    		for (int i = 0; i < numbersForSystemLarge.length; i++) {
    			System.out.print(numbersForSystemLarge[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            systemSort sorter = new systemSort();
            sorter.sort(numbersForSystemLarge);

            long stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("Systemsort small time(milliseconds): " + elapsedTime);
            
            printResultLarge(numbersForSystemLarge);

            if (!validate(numbersForSystemLarge)) {
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
    

