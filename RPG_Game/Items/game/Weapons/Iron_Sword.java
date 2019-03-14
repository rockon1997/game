package game.Weapons;

public class Iron_Sword extends Weapon
{
	private static final long serialVersionUID = 1L;

	public Iron_Sword()
	{
		this.setName("Iron Sword");
		this.setDesc("Basic forged iron sword.");
		this.isEquippable = true;
		this.quantity = 1;
		
		this.setDmg(3);
	}
}
