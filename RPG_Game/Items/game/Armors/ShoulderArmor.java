package game.Armors;

import game.Item;

public class ShoulderArmor extends Item
{
	private static final long serialVersionUID = 1L;
	
	private int defense;
	private boolean isShoulder = true;

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public boolean isShoulder()
	{
		return isShoulder;
	}
}
