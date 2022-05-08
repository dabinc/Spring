package arrayEx;

import java.util.Arrays;
import java.util.Collections;

public class Array4 {

	
	public static void main(String[] args) {
		System.out.println(findPair(new int[] {11, 15, 26, 38, 9, 10}, 45));
	}
	
	
	public static Boolean findPair(int[] array, int target) {
		
		Arrays.sort(array);
		
		if (array[array.length-1] + array[array.length-2] < target) {
			return false;
		}
		System.out.println("start");
		for (int i = 0; i < array.length; i++) {
			System.out.println("i:" + "	" + array[i]);
			for (int j = 1 + i; j < array.length - 1 - i; j++) {
				System.out.println("j:" + "	" + array[j]);
				if (array[i] + array[j] == target) {
					System.out.println(array[i] + array[j]);
					return true;
				}
			}
		}
		return false;
	}
	
	
}
