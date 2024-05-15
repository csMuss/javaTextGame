package textGame.Prompts;

import textGame.Movement.Encounters.EncOne.SkeletonCastleEnc;

public class Prompts {

	public static Prompts pmts = new Prompts();

	private String introPrompt = 
			"YOU ARE IN A GOLDEN FIELD YOU SEE A GREAT OAK TREE PROVIDING\n"
			+ "SHADE FROM THE WARM SUN, YOU LOOK AROUND AND YOU SEE SEVERAL\n"
			+ "WELL TRAVLED PATHS, WITH NO TRAVLERS, YOU MAY GO NORTH, SOUTH, OR EAST,\n"
			+ "YOU CURRENTLY FACE NORTH\n";
	// North, south, and east
	private String northernFieldPrompt = 
			"AFTER TRAVELING NORTH FOR A BIT, YOU REACH A FORESTED AREA THAT YOU CANNOT \n"
			+ "PASS THROUGHT, IT IS BLOCK ON THE EAST AND THE WEST, YOU MAY ONLY GO NORTH OR SOUTH\n";
	
	private String southFieldPrompt = 
			"AFTER TRAVELING SOUTH FOR A BIT, YOU HAVE REACHED A GREAT CANYON WITH A HUGE WATERFALL AT THE TOP \n"
			+ "YOU FIND A POSSIBLE WAY DOWN IF YOU TRAVEL FURTHER SOUTH, THAT SEEMS TO BE THE ONLY WAY\n"
			+ "AS THE PATH IS BLOCKED BY THE STEEP CLIFS AND THE TREES\n";
	
	private String castlePrompt = 
			"AFTER TRAVELING YOU REACH A SMALL OLD CASTLE, WITH BROKEN WINDOWS, MOSS, AND SEVERAL\n"
			+ "SKELETONS AROUND, THEY EACH HAVE BROKEN SWORDS AROUND THEM AS IF A GREAT\n"
			+ "BATTLE TOOK PLACE HERE, ATOP THE CASTLE, THERE IS SHIMMERING OBJECT IN THE UPPER MOST WINDOW\n";
	// Inside areas
	private String insideCastle = 
			"YOU FIND YOURSELF IN THE CASTLE AND LOOK AROUND TO FIND A STAIR CASE TO THE NORTH, "
			+ "A GREAT HALL TO THE EAST AND A COURT YARD TO THE WEST...\n";
	
	private String skeletonDescription = "A TALL LANKY SKELETON POSSESED BY SOME SORT OF MAGIC, \n"
			+ "WITH A BROKEN IRON SWORD, SOME EVEN HAVE SWORDS, ARROWS, AND OTHER BATTLE DEBRIS STUCK\n"
			+ "INSIDE OF THEM\n";
	// Encounters
	private String firstSkeletonEnc = 
			"AFTER GOING UP THE STAIRS YOU SPOT AN UNDEAD SKELETON, IT NOTICES YOU AND LUNGES\n"
			+ "AT YOU WITH ITS BROKEN SWORD...";
	
	private String afterSkeletonEncOneDeath = 
			"AFTER YOU HAVE KILLED THE SKELETON YOU NOTICE THAT ITS BROKEN SWORD IS ON THE GROUND\n"
			+ "THE ONLY WAY FORWARD IS NORTH BACK DOWN THE STAIRS...";
	
	public String getIntroPrompt() {
		return introPrompt;
	}
	
	public String getSkeletonDescription() {
		return skeletonDescription;
	}
	
	public String getCurrentPosPrompt(int currentPos) {
		switch(currentPos) {
		case -1: // south
			return southFieldPrompt;
		case 0:
			return introPrompt;
		case 1: // Forward off of first move
			return northernFieldPrompt;
		case 2: // Forward twice
			return castlePrompt;
		case 3: // forward into the castle
			return insideCastle;
		case 4: // north inside castle
			return firstSkeletonEnc;
		case 5: // Killing the skeleton 
			SkeletonCastleEnc skeleton = new SkeletonCastleEnc();
			if(skeleton.getIsAlive() == false){
				skeleton.onDeath();
				return afterSkeletonEncOneDeath;
			} else {
				// Do damage to the player
				return firstSkeletonEnc;
			}
		case 6: //  back at the enterance after pick up
				// Or player does not pick up and just goes north
			return insideCastle;
		default:
			return "UNKNOW POSITION, THE GAME IS BROKEN... YOU CAN EXIT OR RESET.\nDEBUG: " + currentPos;
		}
	}
}
