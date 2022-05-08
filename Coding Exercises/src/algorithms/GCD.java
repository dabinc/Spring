package algorithms;

import java.util.Scanner;
public class GCD {

	public static int getGCD (int a, int b) {
		if (a > b) {
			System.out.println("b should be bigger");
			return -1;
		}
		if(a == 0) return b;
		return getGCD(b%a, a);
		// a = 100, b = 550 gcd = 50
		// b%a = 50 b = 100;
		// 100%50 = 0 b =  50 = a;
	}

    public static void main(String[] args){
         Scanner in = new Scanner(System.in);
         System.out.println("input a");
         int a = in.nextInt();
         System.out.println("input b");
         int b = in.nextInt();
         System.out.println(getGCD(a, b));
    }
}
