package algoAnalysis;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;




public class TestRunner {

	public static void main(String[] args) {
	      Result bubbleResultSmall = JUnitCore.runClasses(bubbleSortTest.class);
			
	      for (Failure failure : bubbleResultSmall.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      if(bubbleResultSmall.wasSuccessful()){
	    	  System.out.println("");
	      }
	      
	   }
}
    

