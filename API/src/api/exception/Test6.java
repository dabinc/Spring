package api.exception;

import java.util.Scanner;

public class Test6 {
	
	public static void main(String[] args) throws Exception {
	
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			try {
			System.out.println("Enter your desired nickname");
			String name = in.nextLine();
			if (name.length() == 0) {
				throw new Exception("Nickname cannot be empty");
			} else if (name.contains("¿î¿µÀÚ")) {
				throw new Exception("Cannot contain admin in nickname");
			} else if (name.length() > 10 || name.length() < 3) {
				throw new Exception("Name should be between 3 to 10 letters");
			} else {
				System.out.println("Your nickname is set to: " + name);
				break;
			}
			} catch (Exception e) {
				System.err.println("Error: " + e.toString());
			}
		}
		
		
		
	}
	
}


