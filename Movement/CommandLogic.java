package textGame.Movement;

import textGame.Kronk;
import textGame.Entity.ThePlayer;
import textGame.Item.Item;
import textGame.Item.ItemManager;
import textGame.Item.Items.BrokenSwordItem;
import textGame.Movement.Encounters.EncounterTypes;
import textGame.Movement.Encounters.EncOne.SkeletonCastleEnc;

public class CommandLogic {

	private static String message;
	private static int newPosition;
	public static CommandLogic cmd = new CommandLogic(message, newPosition);
	
	public CommandLogic(String message, int newPosition) {
		CommandLogic.message = 
				"==========================\n" + message + "\n==========================\n";
		CommandLogic.newPosition = newPosition;
	}

	public String getMessage() {
		return message;
	}

	public int getNewPosition() {
		return newPosition;
	}
	
	/*
	 * Checks a cmd command and if it is in the list, executes the command
	 * else it will return an error.
	 * 
	 * Return a new command logic, and return new helper commands
	 */

	public CommandLogic checkCMD(String userInput, int currentPos) {
		switch (userInput.toLowerCase().trim()) {
		case "north":
			// If current pos allows it...
			// If currentPos = 6 we are at a break and we need to let the player know
			return new CommandLogic("MOVING FORWARD", currentPos + 1);
		case "west":
			// If current pos allows it...
			return new CommandLogic("MOVING WEST", currentPos + 10);
		case "east":
			// If current pos allows it...
			return new CommandLogic("MOVING EAST", currentPos - 10);
		case "south":
			// If current pos allows it...
			return new CommandLogic("MOVING BACK", currentPos - 1);
		case "exit":
			return new CommandLogic("ending game", currentPos + 10100);
		case "look around":
			return new CommandLogic("" + currentPos, currentPos);
		case "help":
			return new CommandLogic("Try looking at the read me...", currentPos);
		case "reset":
			return new CommandLogic("RESETING POSITION TO START...", (currentPos / currentPos) - 1);
			// Attack defend etc
		case "attack":
			if(currentPos == 4) {
				return handleAttack(currentPos);
			} 
			return new CommandLogic("YOU HAVE ATTACKED...", currentPos);
		case "defend":
			return new CommandLogic("YOU HAVE DEFENDED...", currentPos);
		case "tp":
			return handleTp(currentPos);
		case "pick up":
			// Add to inventory of player
			return handleItemPickup(currentPos);
		case "inv":
			// Print inventory
			return handleInventoryPrint(currentPos);
		default:
			return new CommandLogic("UNKNOWN COMMAND", currentPos);
		}
	}
	
	private CommandLogic handleAttack(int currentPos) {
		switch(currentPos) {
		case 4:
			SkeletonCastleEnc skeleton = new SkeletonCastleEnc();
			skeleton.handleEncounter(EncounterTypes.ATTACK, Kronk.player);
			skeleton.setHealth(skeleton.getHealth() - Kronk.player.getDamage());
			Kronk.print("YOU HAVE ATTACKED THE SKELETON AND DELT: ");
			
			if(skeleton.getIsAlive()) {
				return new CommandLogic("YOU HAVE DAMAGED THE SKELETON FOR: " + Kronk.player.getDamage(), currentPos);
			} else {
				return new CommandLogic("ATTACK", currentPos + 1);
			}
		default:
			return new CommandLogic("UNKNOWN ATTACK", currentPos);	
		}
	}
	
	private CommandLogic handleTp(int currentPos) {
		Kronk.print("DEBUG: TP POS: ");
		String tpPos = UserInput.input.scannerInstance();
		// gets the second input as an integer breaks if a char is sent as it will
		// place the character outside the bounds
		// Gets the first charater from the array as a number
		int newPos = Character.getNumericValue(tpPos.toCharArray()[0]);
		return new CommandLogic("DEBUG: TELEPORT TO: " + newPos, newPos);
	}
	
	/*	After an encounter you can pick up the item, if the encounter is successful
	 * the currentPos = encounterPos + 1
	 * */
	private CommandLogic handleItemPickup(int currentPos) {
		switch(currentPos) {
		case 5: // broken sword pos
			ThePlayer.getItems().add(new BrokenSwordItem());
			return new CommandLogic("YOU HAVE PICKED UP A(N): " + ThePlayer.getItems().get(0).getName(), currentPos + 1);
		default: 
			return new CommandLogic("THERE IS NOTHING TO PICK UP...", currentPos);
		}
	}
	
	/* Prints the inventory of the player else returns an inventory empty
	 * */
	private CommandLogic handleInventoryPrint(int currentPos) {
		if(!ThePlayer.getItems().isEmpty()) {
			// Int for getting the number of items in the inventory
			int invSize = ThePlayer.getItems().size();
			String inv = "";
			for(int i = 0; i < invSize; i++) {
				
				inv += ThePlayer.getItems().get(i).getName();
				
				// If i is not the last item, add the \n
				if(invSize - i != 1) {
					inv += "\n";
				}
				
			}
			
//			// After we parse the string and count the number of occurrences
//			String splitUp[] = inv.split("\n");
//			// Make count occurrences an array for the different items, 0 being the first item
//			// 1 being the second n being the last...
//			int countOccurrences = 0;
//			// Do the same here as with count occurrences
//			String item = "Broken Sword";
//			for(int i = 0; i < splitUp.length; i++) {
//				if(item.equals(splitUp[i])) {
//					countOccurrences++;
//				}
//			}
//			
//			// This will need to be re-worked, this is a simple solution, or we can just repeat it for all items
//			// "Broken Sword" + "x (" + countOccurrences + ")\n"
//			inv = inv.replaceAll("Broken Sword", "");
			
			return new CommandLogic("YOU INSPECT YOUR ITMES...\n" + inv, currentPos);
		} else {
			return new CommandLogic("YOUR INVENTORY IS EMPTY...", currentPos);
		}
	}
	
}
