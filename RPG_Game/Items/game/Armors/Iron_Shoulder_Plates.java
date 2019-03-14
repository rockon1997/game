package game.Armors;

public class Iron_Shoulder_Plates extends ShoulderArmor
{
	private static final long serialVersionUID = 1L;

	public Iron_Shoulder_Plates()
	{
		this.setName("Iron Armor");
		this.setDesc("Basic forged iron armor.");
		this.isEquippable = true;
		this.quantity = 1;
		
		this.setDefense(2);
	}
}