package game;

import java.io.Serializable;

public class Item implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String desc;
	protected boolean isEquippable;
	protected boolean isPotion;
	protected int quantity;
	
	protected Item()
	{
		name = "Empty";
		desc = "Empty";
		isEquippable = false;
		isPotion = false;
		quantity = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	
	public void useItem(Player player)
	{
		System.out.println("Used item.");
	}
}
