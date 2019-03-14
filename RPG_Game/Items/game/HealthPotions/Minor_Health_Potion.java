package game.HealthPotions;

import game.Player;

public class Minor_Health_Potion extends HealthPotion
{
	private static final long serialVersionUID = 1L;
	
	public Minor_Health_Potion()
	{
		this.setName("Minor Health Potion");
		this.setDesc("Alchemically produced potion to restore health by a small amount.");
		this.isEquippable = false;
		this.isPotion = true;
		this.quantity = 1;
		
		this.setHealAmt(5);
	}
	
	public void useItem(Player player)
	{
		player.setHealth(player.getHealth() + this.getHealAmt());
	}
}