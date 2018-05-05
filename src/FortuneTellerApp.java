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
				+ "red, orange, yellow, blue, indigo, violet.";
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
		boolean colorPicked = false;
		while (!colorPicked) {
			
			favColor = asker.verifyString(nameFirst + " what is your favorite color in the rainbow (ROYBGIV)?"
					+ "\n**Type 'Help' if you're not sure what ROYBGIV stands for.**)");
			favColor.toLowerCase();
			if (favColor == "help") {
				System.out.println(help);
			}
			else if (favColor != "red" || favColor != "Orange" || favColor != "yellow" 
					|| favColor != "blue" || favColor != "indigo" || favColor != "violet") {
				System.out.println("I recommend you type 'Help' inorder to pick a valid color");
			}
			else {
			colorPicked = true;
			}
		}
		System.out.println("Finally " + nameFirst + ", how many siblings do you have?");
		noSiblings = input.nextInt();
		input.nextLine();
		
		System.out.println("END");
	}
}
