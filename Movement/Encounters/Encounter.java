package textGame.Movement.Encounters;

import textGame.Entity.Entity;

public class Encounter {
	
	private EncounterTypes encounterType;
	private boolean isEncounterOnGoing = false;
	
	public Encounter(EncounterTypes encounterType, boolean isEncounterOnGoing) {
		this.encounterType = encounterType;
		this.isEncounterOnGoing = isEncounterOnGoing;
	}

	public EncounterTypes getEncounterType() {
		return encounterType;
	}
	
	public boolean getIsEncounterOnGoing() {
		return isEncounterOnGoing;
	}
	
	public void handleEncounter(EncounterTypes ent, Entity target) {
		
	}
}
