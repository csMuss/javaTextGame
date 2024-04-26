package textGame.Entity;

public class Entity {
	
	private int ID;
	private int health;
	private int damage;
	private String name;
	private String description;
	private EntityClassification classifcation;

	public Entity(int ID, int health, String name, String description, EntityClassification classifcation) {
		this.ID = ID;
		this.setHealth(health);
		this.name = name;
		this.description = description;
		this.classifcation = classifcation;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public EntityClassification getClassifcation() {
		return classifcation;
	}
	
	public void onAttack() {}
	
	public void onDefend() {}
	
	public void onGetAttacked() {}
	
	public void onHeal() {}
	
	public int getDamage() {
		return damage;
	}
}
