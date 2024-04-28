package textGame.Movement.Encounters.EncOne;

import textGame.Kronk;
import textGame.Movement.Encounters.Encounter;
import textGame.Movement.Encounters.EncounterTypes;

public class SkeletonCastleEnc extends Encounter {

	private static boolean isSkeletonAlive = true;
	private static int skeletonHealth = 15;

	// Skeleton can only attack, it has 15 health, and it takes damage

	public SkeletonCastleEnc() {
		super(EncounterTypes.ATTACK, isSkeletonAlive);
	}

	public void setHealth(int newHealth) {
		skeletonHealth = newHealth; 
		if(skeletonHealth <= 0) {
			isSkeletonAlive = false;
		}
	}
	
	public int getHealth() {
		return skeletonHealth;
	}
	
	public boolean getIsAlive() {
		return isSkeletonAlive;
	}
	
	public void onDeath() {
		Kronk.print("YOU HAVE KILLED THE SKELETON... \n"
				+ "AS ITS JAW COLLAPSES TO THE GROUND, THE MAGIC THAT WAS HOLDING IT TOGETHER HAS\n"
				+ "LOST ITS GRASP ON THE SKELETON, AND THE SKELETON RETURNS TO A PILE OF BONES THE SKELETON IS DEAD AGAIN...\n");
	}

}
