package fileio;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ReadFileFromURL {
	public static void main(String[] args) {
		System.out.print("Enter a URL: ");
		String URLString = "http://cs1.calstatela.edu:8280/~cs120s100/ch4.html";
		try{
		java.net.URL url = new java.net.URL(URLString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

		 OutputStreamWriter out = new OutputStreamWriter(
                 connection.getOutputStream());
		 out.write("I'm a Fool, I'm a Fool, I'm a Fool");
		 out.close();

		 Scanner input = new Scanner(url.openStream());
	      while (input.hasNext()) {
	        String line = input.nextLine();
	        System.out.println(line);
	        
	      } 
		}catch(IOException e){
			System.out.println(e);
		}
	}
}