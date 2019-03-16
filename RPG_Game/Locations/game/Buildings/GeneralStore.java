package game.Buildings;

import java.util.ArrayList;

import game.Item;

public class GeneralStore extends Building
{
	ArrayList<Item> store;
	
	public GeneralStore()
	{
		store = new ArrayList<Item>(10);
		
		this.setName("General Store");
		this.setDesc("As you walk in, you see shelves of potions, materials and miscellaneous items."
				 + "\nThe clerk faces you after storing an item in the back. \"How can I help?\"");
	}
	
	public void buyItem()
	{
		
	}
}