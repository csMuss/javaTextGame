package textGame.Entity;

public class ThePlayer extends Entity {
	
	private int damage = 15;

	public ThePlayer() {
		super(0, 100, "Player", "The Player", EntityClassification.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	public void setName(String userName) {
		this.setName(userName);
	}
	
	public void setDamage(int newDamage) {
		damage = newDamage;
	}
	
	public int getDamage() {
		return damage;
	}

}
