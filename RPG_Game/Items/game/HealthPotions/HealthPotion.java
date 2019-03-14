package game.HealthPotions;

import game.Item;
import game.Player;

public class HealthPotion extends Item
{
	private static final long serialVersionUID = 1L;

	private int healAmt;

	public int getHealAmt()
	{
		return healAmt;
	}

	public void setHealAmt(int healAmt)
	{
		this.healAmt = healAmt;
	}
	
	public void useItem(Player player)
	{
		player.setHealth(player.getHealth() + this.healAmt);
	}

	public boolean isPotion()
	{
		return isPotion;
	}
}