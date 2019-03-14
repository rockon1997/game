package game;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import game.Armors.*;
import game.HealthPotions.Minor_Health_Potion;
import game.Weapons.Iron_Sword;

public class Goblin extends Enemy
{
	Goblin()
	{
		this.setName("Goblin");
		this.setLootTable(new ArrayList<Item>());
		this.setMinGold(2);
		this.setMaxGold(10);
		
		this.setLevel(ThreadLocalRandom.current().nextInt(1, 4));
		
		if (this.getLevel() == 1)
		{
			this.setExpBasedOnLevel(5);
			this.setHealth(5);
			this.setDmg(2);
			this.setSpeed(3);
		}
		else if (this.getLevel() == 2)
		{
			this.setExpBasedOnLevel(9);
			this.setHealth(8);
			this.setDmg(3);
			this.setSpeed(4);
		}
		else if (this.getLevel() == 3)
		{
			this.setExpBasedOnLevel(15);
			this.setHealth(10);
			this.setDmg(4);
			this.setSpeed(5);
		}
		
		this.addToLootTable(new Minor_Health_Potion());
		this.addToLootTable(new Iron_Sword());
		this.addToLootTable(new Iron_Armor());
		this.addToLootTable(new Iron_Gloves());
		this.addToLootTable(new Iron_Leggings());
		this.addToLootTable(new Iron_Boots());
	}
}
