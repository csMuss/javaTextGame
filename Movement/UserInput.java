package textGame.Movement;

import java.util.Scanner;

import textGame.Kronk;

public class UserInput {
	
	public static UserInput input = new UserInput();
	
	public String scannerInstance() {
		Scanner scan = new Scanner(System.in);
		String instance = scan.nextLine();
		
		if(Kronk.getGameState() == false) {
			scan.close();
		}
		
		return instance;
	}
	
}
