package fileio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WriteData {
	static java.io.PrintWriter output;
	public static void main(String[] args) {
		java.io.File file = new java.io.File("scores.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			try {
				System.out.println(file.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.exit(0);
		} else {

			// Create a file
			
			try {
				output = new java.io.PrintWriter(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Write formatted output to the file
			output.print("John T Smith ");
			output.println(90);
			output.print("Eric K Jones ");
			output.println(85);

			// Close the file
			output.close();
		}
	}
}