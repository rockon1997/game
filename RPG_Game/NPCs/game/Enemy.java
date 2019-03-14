package game;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy
{
	private ArrayList<Item> lootTable;
	private String name;
	private double health;
	private int dmg;
	private int speed;
	private int minGold;
	private int maxGold;
	private int level;
	private int expBasedOnLevel;
	
	public double getHealth()
	{
		return this.health;
	}
	
	public void setHealth(double health)
	{
		this.health = health;
	}
	
	public int getDmg()
	{
		return this.dmg;
	}
	
	public void setDmg(int dmg)
	{
		this.dmg = dmg;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public ArrayList<Item> getLootTable()
	{
		return this.lootTable;
	}
	
	public void setLootTable(ArrayList<Item> lootTable)
	{
		this.lootTable = lootTable;
	}
	
	public void addToLootTable(Item item)
	{
		lootTable.add(item);
	}
	
	public int getMinGold()
	{
		return this.minGold;
	}

	public void setMinGold(int minGold)
	{
		this.minGold = minGold;
	}

	public int getMaxGold()
	{
		return this.maxGold;
	}

	public void setMaxGold(int maxGold)
	{
		this.maxGold = maxGold;
	}

	public int getLevel()
	{
		return this.level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getExpBasedOnLevel()
	{
		return this.expBasedOnLevel;
	}

	public void setExpBasedOnLevel(int expBasedOnLevel)
	{
		this.expBasedOnLevel = expBasedOnLevel;
	}

	public Item drop(Player player)
	{
		int random = ThreadLocalRandom.current().nextInt((99 + 1));
		
		if (random < 80)
		{
			int gold = ThreadLocalRandom.current().nextInt(this.minGold, this.maxGold);
			
			System.out.println("\n" + this.name + " dropped " + gold + " gold.");
			player.setGold(player.getGold() + gold);
		}
		if (random <= 40)
		{
			System.out.println(this.name + " has dropped a " + lootTable.get(0).getName());
			player.addToInventory(lootTable.get(0));
		}
		if (random <= 15)
		{
			int randomLoot = ThreadLocalRandom.current().nextInt(0, lootTable.size());
			
			return lootTable.get(randomLoot);
		}
		
		return null;
	}
}
