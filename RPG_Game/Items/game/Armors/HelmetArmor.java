package game.Armors;

import game.Item;

@SuppressWarnings("serial")
public class HelmetArmor extends Item
{
	private int defense;
	private boolean isHelmet = true;

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public boolean isHelmet()
	{
		return isHelmet;
	}
}
