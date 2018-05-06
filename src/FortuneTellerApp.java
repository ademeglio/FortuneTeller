import java.util.Scanner;

public class FortuneTellerApp {

	public static void main(String[] args) {
		// Part 1 variables
		String nameFirst;
		String nameLast;
		int userAge;
		int userBirthMonth;
		String favColor;
		String help = "The ROYGBIV Colors are "
				+ "red, orange, yellow, green, blue, indigo, violet.";
		int noSiblings;
		
		Scanner input = new Scanner(System.in);
		QuestionAsker asker = new QuestionAsker(input);
		
		// Part 1 questions
		nameFirst = asker.verifyString("Hello, what is your first name?");
		nameLast = asker.verifyString("Nice to meet you " + nameFirst + ". What is your last name?");
		userAge = asker.returnInt(nameFirst + " how old are you?");
		userBirthMonth = asker.returnInt(nameFirst + " using numbers, what month were you born in?");
		
		//verify userBirthMonth is between January (1) and December (12)
		while (userBirthMonth > 12) {
			userBirthMonth = asker.returnInt(nameFirst + " you do know there are only 12 months in a year, right?"
					+ "\nSo, what month were you born in, using numbers?");
		}
		
		/* when asking for color, we need to make sure choices fall within ROYBGIV or suggest 'help' if
		 * the user doesn't know what ROYGBIV stands for.
		 */
		
		boolean colorPicked = false;
		
		do  {
			
			favColor = asker.verifyString(nameFirst + " what is your favorite color in the rainbow (ROYBGIV)?"
					+ " **Type 'Help' if you're not sure what ROYGBIV stands for.**");
			
			favColor = favColor.toLowerCase(); // make sure response is lowerCase to work with if statement.
			
			if (favColor.equals("red") || favColor.equals("orange")
					|| favColor.equals("yellow") || favColor.equals("green")
					|| favColor.equals("blue")   || favColor.equals("indigo") 
					|| favColor.equals("violet") ) {
				System.out.println(favColor + " is a great color!");
				colorPicked = true;
			}
			else if (favColor.equals("help")) {
				System.out.println(help);
			}
			else {
				System.out.println("I recommend you type 'Help' inorder to pick a valid color.");
			}
		}
		while (colorPicked == false);
		
		System.out.println("Finally " + nameFirst + ", how many siblings do you have?");
		noSiblings = input.nextInt();
		input.nextLine();
		
		System.out.println("TEMP END");
	}
}
