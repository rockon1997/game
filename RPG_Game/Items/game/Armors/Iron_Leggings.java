package game.Armors;

public class Iron_Leggings extends LegArmor
{
	private static final long serialVersionUID = 1L;

	public Iron_Leggings()
	{
		this.setName("Iron Leggings");
		this.setDesc("Basic forged iron leggings.");
		this.isEquippable = true;
		this.quantity = 1;
		
		this.setDefense(2);
	}
}
