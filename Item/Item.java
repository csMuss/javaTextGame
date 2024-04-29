package textGame.Item;

public class Item {
	
	private int damage;
	private int healing;
	private String name;
	private boolean doesDamage;
	private ItemClassification itemType;
	
	public Item(int damage, int healing, boolean doesDamage, ItemClassification itemType) {
		this.damage = damage;
		this.healing = healing;
		this.doesDamage = doesDamage;
		this.itemType = itemType;
	}
	
	public int getDamage() {
		return damage;
	}

	public int getHealing() {
		return healing;
	}

	public String getName() {
		return name;
	}

	public boolean isDoesDamage() {
		return doesDamage;
	}

	public ItemClassification getItemType() {
		return itemType;
	}
	
}
