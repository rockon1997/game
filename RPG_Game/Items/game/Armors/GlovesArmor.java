package game.Armors;

import game.Item;

@SuppressWarnings("serial")
public class GlovesArmor extends Item
{
	private int defense;
	private boolean isGloves = true;

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public boolean isGloves()
	{
		return isGloves;
	}
}
