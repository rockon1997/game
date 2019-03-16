package game.Buildings;

import game.Player;

public class Tavern extends Building
{
	private int stayNightAmt;
	
	public Tavern()
	{
		this.stayNightAmt = 15;
		
		this.setName("Tavern");
		this.setDesc("Entering the tavern, you notice a variety of people. Including the likes of Humans, Elves, Dwarves, etc."
				 + "\nUpon approaching the tavern keeper, she asks, \"What do you need?\"");
	}
	
	public void spendNight(Player player)
	{
		System.out.println("\"It'll be 15 gold for a night.\", she says.");
		if (player.getGold() >= this.stayNightAmt)
		{
			player.setGold(player.getGold() - this.stayNightAmt);
			player.setHealth(player.getMaxHealth());
		}
		else
		{
			System.out.println("The tavern keeper looks at you annoyed, \"This isn't enough gold. Come back when you have more.\"");
		}
	}
}
