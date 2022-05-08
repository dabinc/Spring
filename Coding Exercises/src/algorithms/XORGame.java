package algorithms;

public class XORGame {

//	Given a positive number k, we need to find a minimum value of positive integer n, 
//	such that XOR of n and n+1 is equal to k. If no such n exist then print -1.
//
//
//	Example 1:
//
//	Input: k = 3
//	Output: 1
//	Explaination: 1 xor 2 = 3.
	 
	// 01 xor 10 	= 11  (1 xor 2 = 3)
	// 10 xor 11 	= 01  (2 xor 3 = 1)
	// 11 xor 100 	= 111 (3 xor 4 = 7)
	// 100 xor 101  = 001 (4 xor 5 = 1)
	//--------------------------------
	// 101 xor 110  = 011 (5 xor 6 = 3)
	// 110 xor 111  = 001 (6 xor 7 = 1)
	// 111 xor 1000 = 1111(7 xor 8 = 15)
	//1000 xor 1001 = 0001(8 xor 9 = 1)
	//--------------------------------
	//1001 xor 1010 = 11  (9  xor 10 = 3)
	//1010 xor 1011 =  1  (10 xor 11 = 1)
	//1011 xor 1100 = 111 (11 xor 12 = 7)
	//1100 xor 1101 = 0001(12 xor 13 = 1)
	//--------------------------------
	//1111 xor 10000= 11111(15 xor 16 = 31)
	// 31, 32 = 63
	
	
	// like this., pattern keeps coming up
	public int xorCalculator(int k) {
		switch (k) {
			case 2 : return -1;
			case 4 : return -1;
			case 3 : return 1;
			case 1 : return 2;
			case 7 : return 3;
			default: return checker(k);
		}
	}

	private int checker(int k) {
		if (((k+1) & -(k+1)) == k) {
			return (int) (Math.ceil(k/2) -1);
		}
		return -1;
		
	}
	
}
