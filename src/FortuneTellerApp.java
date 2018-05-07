/*
 * Fortune Teller App.
 * WeCodeIT Columbus FlexCode Summer 2018 
 * Anthony J. DeMeglio
 * ademeglio@bartha.com | ademeglio@gmail.com
 * May 7, 2018
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class FortuneTellerApp {

	public static void main(String[] args) {
		// Part 1 asks user questions needed for telling their fortune
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
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
		
		// Part 1 questions
		nameFirst = asker.verifyString("Hello, what is your first name?");
		nameLast = asker.verifyString("Nice to meet you " + nameFirst + ". What is your last name?");
		userAge = asker.returnInt(nameFirst + " how old are you?", false);
		userBirthMonth = asker.returnInt(nameFirst + " using numbers, what month were you born in?", false);
		
		//verify userBirthMonth is between January (1) and December (12)
		/* This code is commented out to be able to meet the project requirements.
		 *	while (userBirthMonth > 12) {
		 *		userBirthMonth = asker.returnInt(nameFirst + " you do know there are only 12 months in a year, right?"
		 *				+ "\nSo, what month were you born in, using numbers?", false);
		 *	}
		 */
		
		/* when asking for color, we need to make sure choices fall within ROYBGIV or suggest 'help' if
		 * the user doesn't know what ROYGBIV stands for.
		 */
		
		boolean colorPicked = false;
		
		do {
			favColor = asker.verifyString(nameFirst + " what is your favorite color in the rainbow (ROYBGIV)?"
					+ " **Type 'Help' if you're not sure what ROYGBIV stands for.**");
			
			favColor = favColor.toLowerCase(); // make sure response is lowerCase to work with if statement and switch.
			
			if (favColor.equals("red") 
					|| favColor.equals("orange")
					|| favColor.equals("yellow") 
					|| favColor.equals("green")
					|| favColor.equals("blue")   
					|| favColor.equals("indigo") 
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
		
		noSiblings = asker.returnInt("Finally " + nameFirst + ", how many siblings do you have?", true);
		
		// Part 2 acts on the questions asked of the user.
		
		// Part 2: retirement years 
		int retireInYears;
		
		if (userAge % 2 == 0) {
			retireInYears = 7;
		} else {
		retireInYears = 13;
		}
	
		// Part 2: vacation home location
		String[] vacationHomeChoices = {  // Location | No. of siblings
				"Ambergris Caye, Belize", // | 0
				"Paris, France",          // | 1
				"Anaheim, CA",            // | 2
				"Orlando, FL",            // | 3
				"Estes Park, CO",         // | 4+
				"North Pole"};            // | <0
		
		String vacationHome = "";
		
		if (noSiblings < 0) {
			vacationHome = vacationHomeChoices[5];
		}
		else if (noSiblings >= 0 ) {
			if (noSiblings < 4) {
				vacationHome = vacationHomeChoices[noSiblings];
			}
			else vacationHome = vacationHomeChoices[4];
		}
		
		// Part 2: mode of transportation
		
		String modeOfTransport = ""; 
		
		switch (favColor) {
			case "red":    modeOfTransport = "motorcycle";
				 		   break;
			case "orange": modeOfTransport = "donkey";
						   break;
			case "yellow": modeOfTransport = "race car";
						   break;
			case "green":  modeOfTransport = "frisbee";
			               break;
			case "blue":   modeOfTransport = "fighter jet";
			   			   break;
			case "indigo": modeOfTransport = "rocket ship";
			   			   break;
			case "violet": modeOfTransport = "unicorn";
			   			   break;				
		}
		
		// Part 2: what's in the bank?
		
		double bankBalance = 0.00;
		
		if (userBirthMonth >= 1 && userBirthMonth <=4) {
			bankBalance = 1555000.86;
		}
		else if (userBirthMonth > 4 && userBirthMonth < 9) {
			bankBalance = 2500.00;
		}
		else if (userBirthMonth > 8 && userBirthMonth < 13) {
			bankBalance = 3.86;
		}
		
		// Part 3 Program output: user's fortune is...
		
		System.out.println(nameFirst + " " + nameLast + " will retire in " + retireInYears + " years"
				+ " with " + defaultFormat.format(bankBalance) + " in the bank, a vacation home in " + vacationHome
				+ ", and travel by " + modeOfTransport + ".");
	}
}

