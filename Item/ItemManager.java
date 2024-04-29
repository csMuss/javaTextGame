package textGame.Item;

import java.util.ArrayList;

import textGame.Item.Items.BrokenSwordItem;

public class ItemManager {
	
	// holds all created items, can add to the player inventory, and remove from
	
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public ItemManager() {
		itemList.add(new BrokenSwordItem());
	}
}
