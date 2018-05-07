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
		if (response.toLowerCase().equals("quit"))  {
			System.exit(0);
		}
		
		// future code to verify string is valid.
		
		return response;
	}
	
	int returnInt(String question, Boolean negativesOK) {
		System.out.println(question);
		
		if (!negativesOK) {
			while (true) {
				String response = input.nextLine();
				if (response.toLowerCase().equals("quit"))  {
					System.exit(0);//input.nextLine();
				}
				int responseInt = Integer.parseInt(response);

				if (responseInt > 0) {
					return responseInt;
				}
				System.out.println("Please enter a realistic (positive) number!");
			}
		}
		String response = input.nextLine();
		if (response.toLowerCase().equals("quit")) {
			System.exit(0);
		}
		int responseInt = Integer.parseInt(response);
		return responseInt;
	}
}
