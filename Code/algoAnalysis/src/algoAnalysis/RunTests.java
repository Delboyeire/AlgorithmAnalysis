package algoAnalysis;

public class RunTests {

	public static void main(String[] args) {

		//Bubble
		bubbleSortTest bubbleTest = new bubbleSortTest();
		try {
			bubbleTest.setUpForBubble();
		} catch (Exception e) {
			e.printStackTrace();
		}
		bubbleTest.testBubbleSortSmall();
		bubbleTest.testBubbleSortMed();
		bubbleTest.testBubbleSortLarge();
		
		//merge
		MergeSortTest mergeTest = new MergeSortTest();
		try{
			mergeTest.setUpForMerge();
		}catch (Exception e) {
			e.printStackTrace();
		}
		mergeTest.testMergeSortSmall();
		mergeTest.testMergeSortMed();
		mergeTest.testMergeSortLarge();
		
		
		//Heap 
		HeapSortTest heapTest = new HeapSortTest();
		try{
			heapTest.setUpForHeap();
		}catch (Exception e) {
			e.printStackTrace();
		}
		heapTest.testHeapSortSmall();
		heapTest.testHeapSortMed();
		heapTest.testHeapSortLarge();
		
		
	}

}
