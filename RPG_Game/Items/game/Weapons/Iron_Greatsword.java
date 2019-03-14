package game.Weapons;

public class Iron_Greatsword extends Weapon
{
	private static final long serialVersionUID = 1L;

	public Iron_Greatsword()
	{
		this.setName("Iron Greatsword");
		this.setDesc("Basic forged iron two-handed sword.");
		this.isEquippable = true;
		this.quantity = 1;
		
		this.setDmg(3);
	}
}
