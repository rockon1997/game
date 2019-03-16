package game.Buildings;

import java.util.ArrayList;

import game.Item;

public class Blacksmith extends Building
{
	ArrayList<Item> store;
	
	public Blacksmith()
	{
		this.setName("Blacksmith");
		this.setDesc("The blacksmith looks at you sternly. In a gruff voice, he asks, \"What can I do for you?\"");
	}
	
	public void buyItem()
	{
		
	}
}