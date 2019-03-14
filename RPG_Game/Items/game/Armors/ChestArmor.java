package game.Armors;

import game.Item;

@SuppressWarnings("serial")
public class ChestArmor extends Item
{
	private int defense;
	private boolean isChest = true;

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public boolean isChest()
	{
		return isChest;
	}
}
