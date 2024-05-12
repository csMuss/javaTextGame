package textGame.Entity;

import java.util.ArrayList;

import textGame.Item.Item;

public class ThePlayer extends Entity {
	
	private int damage = 15;
	// The players inventory
	private static ArrayList<Item> inventory = new ArrayList<Item>();

	public ThePlayer() {
		super(0, 100, "Player", "The Player", EntityClassification.PLAYER);
		
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
	
	public static ArrayList<Item> getItems() {
		return inventory;
	}
	
	public static Item getItemByName(String name) {
		for(Item item : getItems()) {
			if(item.getName() == name) {
				return item;
			}
		}
		return null;
	}

}
