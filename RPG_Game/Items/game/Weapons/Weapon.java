package game.Weapons;

import game.Item;

public class Weapon extends Item
{
	private static final long serialVersionUID = 1L;
	
	private int dmg;
	private boolean isWeapon = true;

	public int getDmg()
	{
		return dmg;
	}

	public void setDmg(int dmg)
	{
		this.dmg = dmg;
	}

	public boolean isWeapon()
	{
		return isWeapon;
	}
}
