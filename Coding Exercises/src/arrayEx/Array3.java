package arrayEx;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Array3 {
	//simple array rotation example
	//rotate [n] shifts to the left on a size [x] array
	
	public int[] rotate(int[] arr, int shift) {
	    int[] output = new int[arr.length];
	    for(int i = 0; i < output.length;i++) {
	        int newIndex =  (arr.length-shift+i) % arr.length;
	        output[newIndex] = arr[i];
	        }
	    return output;
	}
	
	public int calculate(int[] arr) {
		rotate(arr, 2);
		System.out.println("rotation : " + Arrays.toString(rotate(arr, 1)));
		rotate(arr, 2);
		System.out.println("rotation : " + Arrays.toString(rotate(arr, 1)));
		rotate(arr, 2);
		System.out.println("rotation : " + Arrays.toString(rotate(arr, 1)));
		
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int rotationSum = 0;
			for (int j = 0; j < arr.length; j++) {
				rotationSum += arr[j] * j;
				System.out.println(arr[j] * j + "arr[j] * j");
			}
			System.out.println(rotationSum);
			hs.add(rotationSum);	
		}
		return Collections.max(hs);
		
	}
	
	
}