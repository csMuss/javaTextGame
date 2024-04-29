package textGame.Movement;

import textGame.Kronk;
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

	public CommandLogic checkCMD(String userInput, int currentPos) {
		switch (userInput.toLowerCase()) {
		case "north":
			// If current pos allows it...
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
			handleItemPickup(currentPos);
		case "inv":
			// Print inventory
			handleInventoryPrint(currentPos);
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
		case 5:
			Kronk.player.inventory.add(Kronk.itmMan.itemList.get(0));
			return new CommandLogic("YOU HAVE PICKED UP A(N): " + Kronk.player.inventory.get(0), currentPos);
		default: 
			return new CommandLogic("THERE IS NOTHING TO PICK UP...", currentPos);
		}
	}
	
	private CommandLogic handleInventoryPrint(int currentPos) {
		if(!Kronk.player.inventory.isEmpty()) {
			return new CommandLogic("YOU INSPECT YOUR ITMES...\n " + Kronk.player.inventory.get(0), currentPos);
		} else {
			return new CommandLogic("YOUR INVENTORY IS EMPTY...", currentPos);
		}
	}
	
}
