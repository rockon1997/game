package game.Armors;

public class Iron_Boots extends FootArmor
{
	private static final long serialVersionUID = 1L;

	public Iron_Boots()
	{
		this.setName("Iron Boots");
		this.setDesc("Basic forged iron boots.");
		this.isEquippable = true;
		this.quantity = 1;
		
		this.setDefense(2);
	}
}
