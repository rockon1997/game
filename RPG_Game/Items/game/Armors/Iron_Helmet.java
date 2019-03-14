package game.Armors;

public class Iron_Helmet extends HelmetArmor
{
	private static final long serialVersionUID = 1L;

	public Iron_Helmet()
	{
		this.setName("Iron Helmet");
		this.setDesc("Basic forged iron helmet.");
		this.isEquippable = true;
		this.quantity = 1;
		
		this.setDefense(2);
	}
}
