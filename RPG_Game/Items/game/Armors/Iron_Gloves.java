package game.Armors;

public class Iron_Gloves extends GlovesArmor
{
	private static final long serialVersionUID = 1L;

	public Iron_Gloves()
	{
		this.setName("Iron Gloves");
		this.setDesc("Basic forged iron gloves.");
		this.isEquippable = true;
		this.quantity = 1;
		
		this.setDefense(2);
	}
}
