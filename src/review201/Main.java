package review201;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input a string");
		String s = input.next();
		System.out.println(reverse(s));
		whizzBam();
	}

	public static String reverse(String s) {

		char[] charArray = s.toCharArray();

		int beg = 0;
		int end = charArray.length - 1;

		while (end > beg) {
			char temp = charArray[beg];
			charArray[beg] = charArray[end];
			charArray[end] = temp;
			end--;
			beg++;		
		}
		return new String(charArray);
	}
	
	public static void whizzBam(){
		
		for(int i = 0; i<=100; i++){
			if (i % 4 == 0 && i % 6 == 0){
				System.out.println(i + " Whizz Bam");
			}else if(i % 4 == 0){
				System.out.println(i + " Whizz");
			}else if (i % 6 == 0){
				System.out.println(i + " Bam");
			}else{
				System.out.println(i);
			}
		}
	}

}
