package algoAnalysis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class bubbleSortTest {

	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }

    private int[] numbersForBubbleSmall;
    private int[] numbersForStandardSortSmall;
    private int[] numbersForBubbleMedium;
    private int[] numbersForStandardSortMedium;
    private int[] numbersForBubbleLarge;
    private int[] numbersForStandardSortLarge;
    private final static int SMALLSIZE = 100;
    private final static int MEDSIZE = 1000;
    private final static int LARGESIZE = 2000;
    private final static int MAX = 20;

    
    @Before
    public void setUpForBubble() throws Exception {
           	numbersForBubbleSmall = new int[SMALLSIZE];
            Random generator = new Random();
            for (int i = 0; i < numbersForBubbleSmall.length; i++) {
            	numbersForBubbleSmall[i] = generator.nextInt(MAX);
            }
            numbersForStandardSortSmall = numbersForBubbleSmall;
            //Arrays.sort(numbersForStandardSortSmall);
            
            numbersForBubbleMedium = new int[MEDSIZE];
            generator = new Random();
            for (int i = 0; i < numbersForBubbleMedium.length; i++) {
            	numbersForBubbleMedium[i] = generator.nextInt(MAX);
            }
            numbersForStandardSortMedium = numbersForBubbleMedium;
            //Arrays.sort(numbersForStandardSortMedium);
            
            numbersForBubbleLarge = new int[LARGESIZE];
            generator = new Random();
            for (int i = 0; i < numbersForBubbleLarge.length; i++) {
            	numbersForBubbleLarge[i] = generator.nextInt(MAX);
            }
            numbersForStandardSortLarge = numbersForBubbleLarge;
            //Arrays.sort(numbersForStandardSortLarge);
    }
    

    @Test
    public void testBubbleSortSmall() {
    	
    		System.out.println("Small set for bubble :");
    		for (int i = 0; i < numbersForBubbleSmall.length; i++) {
    			System.out.print(numbersForBubbleSmall[i] + ",");
    		}
    		
            long startTime = System.nanoTime();
            BubbleSort sorter = new BubbleSort();
            sorter.sort(numbersForBubbleSmall);

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("buuble small time(milliseconds): " + elapsedTime);
            
            printResultSmall(numbersForBubbleSmall);

            if (!validate(numbersForBubbleSmall)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            Arrays.sort(numbersForStandardSortSmall);
            assertEquals(numbersForStandardSortSmall,numbersForBubbleSmall);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Small Set Used memory is bytes: " + memory);
            System.out.println("Small Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            System.out.println();
            
            
     }
    @Test
    public void testBubbleSortMed() {
    	
	    	System.out.println("Medium set for bubble :");
	        for (int i = 0; i < numbersForBubbleMedium.length; i++) {
	            System.out.print(numbersForBubbleMedium[i] + ",");
	        }
	        Runtime runtime = Runtime.getRuntime();
            long startTime = System.nanoTime();
            BubbleSort sorter = new BubbleSort();
            sorter.sort(numbersForBubbleMedium);

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("Bubble medium Time(nanoseconds) : " + elapsedTime);
            
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Medium Set Used memory is bytes: " + memory);
            System.out.println("Medium Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            
            printResultMedium(numbersForBubbleMedium);

            if (!validate(numbersForBubbleMedium)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            assertEquals(numbersForStandardSortMedium,numbersForBubbleMedium);
            System.out.println();
    }
    @Test
    public void testBubbleSortLarge() {
    	
	    	System.out.println("Large set for bubble :");
	        for (int i = 0; i < numbersForBubbleLarge.length; i++) {
	            System.out.print(numbersForBubbleLarge[i]+ ",");
	        }
            
            long startTime = System.nanoTime();
            BubbleSort sorter = new BubbleSort();
            sorter.sort(numbersForBubbleLarge);

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("Bubble large Time(nanoseconds) : " + elapsedTime);
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Large Set Used memory is bytes: " + memory);
            System.out.println("Large Set Used memory is megabytes: "
                            + bytesToMegabytes(memory));
            
            printResultLarge(numbersForBubbleLarge);

            if (!validate(numbersForBubbleLarge)) {
                    fail("Should not happen");
            }
            assertTrue(true);
            assertEquals(numbersForStandardSortLarge,numbersForBubbleLarge);
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
    

