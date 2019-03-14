package game.Armors;

import game.Item;

@SuppressWarnings("serial")
public class FootArmor extends Item
{
	private int defense;
	private boolean isFoot = true;

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public boolean isFoot()
	{
		return isFoot;
	}
}
