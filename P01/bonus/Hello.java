import java.util.Scanner;

public class Hello{
	public static void main(String[] args){
		String name;
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		name = input.nextLine();
		System.out.println("Hello " + (name) + "!");
	}
}
