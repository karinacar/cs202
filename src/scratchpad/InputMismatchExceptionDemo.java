package scratchpad;

import java.util.*;

public class InputMismatchExceptionDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;

		do {

			System.out.print("Enter an integer: ");
			if (input.hasNextInt(2)) {
				int number = input.nextInt();

				// Display the result
				System.out.println("The number entered is " + number);

				continueInput = false;

			} else {
				System.out.println("Try again. ("
						+ "Incorrect input: an integer is required)");
				input.nextLine(); // discard input
			}
		} while (continueInput);
	}
}
