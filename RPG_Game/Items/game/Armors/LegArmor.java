package game.Armors;

import game.Item;

public class LegArmor extends Item
{
	private static final long serialVersionUID = 1L;
	
	private int defense;
	private boolean isLeg = true;

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public boolean isLeg()
	{
		return isLeg;
	}
}
