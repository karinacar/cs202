package midterm;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// C:\Users\Mark\workspace\CS202\input.txt
	
		copyText(new FileCopier());
		copyText(new NumberCopier());
		copyText(new LetterCopier());
			
	}

	public static void copyText(FileCopier copier) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the from file path");
		String fromfilepath = input.next();
		System.out.println("Enter the to file path");
		String tofilepath = input.next();
		copier.copy(fromfilepath, tofilepath);
	}

}
