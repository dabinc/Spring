package arrayEx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Array2 {
	
	public int[] rearrange(int[] arr) {
		int[] output = new int[arr.length];
		HashSet<Integer> hash = new HashSet<>();
		System.out.println("sorted input array: " + Arrays.toString(arr));
	
		for (int key : arr) {
			hash.add(key);
		}
		
		int notFound = -1;
		for (int i = 0; i < arr.length; i++) {
			
			if (hash.contains(i)) {
				output[i] = i;
			} else {
				output[i] = notFound;
			}
		}
		return output;
	}
}
