package midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NumberCopier extends FileCopier {
	
	public NumberCopier(){
		super();
	}

	@Override
	public void copy(String fromtextfilepath, String totextfilepath)
			throws FileNotFoundException {
		
		
		File fromFile = new File(fromtextfilepath);
		File toFile = new File(totextfilepath);
		
		Scanner input = new Scanner(fromFile);
		PrintWriter output = new PrintWriter(toFile);
		
		while(input.hasNextLine()){
			String next = input.nextLine();
			next = next.replaceAll("[^0-9]", "");
			output.println(next);			
		}
		output.close();
		
	}

	
}
