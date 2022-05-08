package arrayEx;

import java.util.Arrays;

public class Array1 {
	//simple array rotation example
	//rotate [n] shifts to the left on a size [x] array
	
	public int[] rotate(int[] arr, int shift, int size) {
	    int[] output = new int[size];
	    for(int i = 0; i < output.length;i++) {
	        int newIndex =  (arr.length-shift+i) % arr.length;
	        output[newIndex] = arr[i];
	        }
	    System.out.println(Arrays.toString(output));
	    return output;
	}
}