import java.util.Scanner;
import java.text.*;

public class QuestionAsker {
	
	Scanner input;
	
	public QuestionAsker(Scanner input) {
		this.input = input;
	}
	
	boolean yesOrNo(String question) {
		System.out.println(question);
		while (true) {
			String response = input.nextLine();
			switch (response.toLowerCase()) {
				case "y":	
				case "yes":
					return true;
				case "n":
				case "no": 
					return false;
				default:
					System.out.println("Sorry, I didn't catch that?");
			}
			
		}
	}
	
	String verifyString(String question) {
		System.out.println(question);
		String response = input.nextLine();
		if (response.equals("quit"))  {
			System.exit(0);
		}
		
		// future code to verify string is valid.
		
		return response;
	}
	
	int returnInt(String question, Boolean negativesOK) {
		System.out.println(question);
		
		if (!negativesOK) {
			while (true) {
				int response = input.nextInt();
				input.nextLine();
				if (response > 0) {
					return response;
				}
				System.out.println("Please enter a realistic (positive) number!");
			}
		}
		int response = input.nextInt();
		input.nextLine();
		return response;
	}
}
