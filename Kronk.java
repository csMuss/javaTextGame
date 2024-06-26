package textGame;

import textGame.Entity.ThePlayer;
import textGame.Item.ItemManager;
import textGame.Movement.CommandLogic;
import textGame.Movement.UserInput;
import textGame.Prompts.Prompts;

public class Kronk {
	
	private static double version = 0.2;
	private static String gameName = "Kronk ";
	
	private static int currentPosition = 0;
	private static boolean isRunning = true;
	
	public static ItemManager itmMan = new ItemManager();
	public static ThePlayer player = new ThePlayer();
	
	// java -jar kronk.jar
	
	public static void main(String[] args) {
		print("Welcome to " + getGameName() + getVersion() + " ...");
		print(Prompts.pmts.getCurrentPosPrompt(currentPosition));
		while(currentPosition < 10000) {
			// Get input and pass currentPos
			CommandLogic.cmd.checkCMD(UserInput.input.scannerInstance(), currentPosition);
			// Update position
			currentPosition = CommandLogic.cmd.getNewPosition();
			// Print movement message
			print(CommandLogic.cmd.getMessage());
			// Get new prompt
			print(Prompts.pmts.getCurrentPosPrompt(currentPosition));
		}
		
		isRunning = false;
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(int d) {
		System.out.println("" + d);
	}
	
	public static void print(double d) {
		System.out.println("" + d);
	}
	
	public static void errPrint(String s) {
		System.err.println(s);
	}
	
	public static void errPrint(int d) {
		System.err.println("" + d);
	}
	
	public static void errpPrint(double d) {
		System.err.println("" + d);
	}
	
	public static boolean getGameState() {
		return isRunning;
	}
	
	public static double getVersion() {
		return version;
	}
	
	public static String getGameName() {
		return gameName;
	}
}