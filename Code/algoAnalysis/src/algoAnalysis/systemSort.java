package algoAnalysis;
import java.util.Arrays;

public class systemSort {
	

    private int[] numbers;
    
    public void sort(int[] values) {
            // check for empty or null array
            if (values ==null || values.length==0){
                    return;
            }
            this.numbers = values;
            systemsort(numbers);
    }

    private void systemsort(int[] arr) {
    	Arrays.sort(arr);

}}