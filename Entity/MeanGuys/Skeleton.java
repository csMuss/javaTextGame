package textGame.Entity.MeanGuys;

import textGame.Entity.Entity;
import textGame.Entity.EntityClassification;
import textGame.Prompts.Prompts;

public class Skeleton extends Entity {

	public Skeleton() {
		super(1, 25, "Skeletion", Prompts.pmts.getSkeletonDescription(), EntityClassification.HOSTILE);
	}
	
	

}
