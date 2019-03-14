package game;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import game.Armors.*;
import game.HealthPotions.Minor_Health_Potion;
import game.Weapons.Iron_Greatsword;

public class Orc extends Enemy
{
	Orc()
	{
		this.setName("Orc");
		this.setMinGold(5);
		this.setMaxGold(15);
		this.setLootTable(new ArrayList<Item>());
		
		this.setLevel(ThreadLocalRandom.current().nextInt(1, 4));
		
		if (this.getLevel() == 1)
		{
			this.setExpBasedOnLevel(10);
			this.setHealth(10);
			this.setDmg(4);
			this.setSpeed(4);
		}
		else if (this.getLevel() == 2)
		{
			this.setExpBasedOnLevel(15);
			this.setHealth(14);
			this.setDmg(6);
			this.setSpeed(5);
		}
		else if (this.getLevel() == 3)
		{
			this.setExpBasedOnLevel(20);
			this.setHealth(20);
			this.setDmg(8);
			this.setSpeed(6);
		}
		
		this.addToLootTable(new Minor_Health_Potion());
		this.addToLootTable(new Iron_Greatsword());
		this.addToLootTable(new Iron_Armor());
		this.addToLootTable(new Iron_Helmet());
		this.addToLootTable(new Iron_Shoulder_Plates());
		this.addToLootTable(new Iron_Gloves());
		this.addToLootTable(new Iron_Leggings());
		this.addToLootTable(new Iron_Boots());
	}
}
