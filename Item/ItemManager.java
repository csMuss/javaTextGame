package textGame.Item;

import java.util.ArrayList;

import textGame.Item.Items.BrokenSwordItem;

public class ItemManager {
	
	// holds all created items, can add to the player inventory, and remove from
	
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public ItemManager() {
		itemList.add(new BrokenSwordItem());
	}
	
	public static ArrayList<Item> getItems() {
		return itemList;
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
