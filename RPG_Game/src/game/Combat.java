package game;

import java.util.Scanner;

public class Combat
{
	private Scanner scnr = new Scanner(System.in);
	
	public void combat(Enemy enemy, Player player)
	{
		boolean isPlayersTurn = true;
		
		IO.encounter(enemy);
		
		System.out.println("\nCurrent health: " + player.getHealth());
		System.out.println(enemy.getName() + " health: " + enemy.getHealth());
		
		if (enemy.getSpeed() <= player.getSpeed())
		{
			combatMenu(player, enemy, isPlayersTurn);
			isPlayersTurn = false;
			
			if (enemy.getHealth() <= 0)
			{
				IO.encounterWon(enemy);
				
				player.setExp(player.getExp() + enemy.getExpBasedOnLevel());
				player.levelUp();
				
				Item droppedItem = enemy.drop(player);
				
				if (droppedItem != null)
				{
					IO.itemDropped(enemy, droppedItem);
					
					player.addToInventory(droppedItem);
				}
				
				return;
			}
		}
		else
		{
			attack(player, enemy, isPlayersTurn);
			isPlayersTurn = true;
			
			if (player.getHealth() <= 0)
			{
				IO.encounterLost(enemy);
				System.exit(0);
			}
		}
		
		while(player.getHealth() > 0 && enemy.getHealth() > 0)
		{
			if (isPlayersTurn)
			{
				combatMenu(player, enemy, isPlayersTurn);
				isPlayersTurn = false;
				
				if (enemy.getHealth() <= 0)
				{
					IO.encounterWon(enemy);
					
					player.setExp(player.getExp() + enemy.getExpBasedOnLevel());
					player.levelUp();
					
					Item droppedItem = enemy.drop(player);
					
					if (droppedItem != null)
					{
						IO.itemDropped(enemy, droppedItem);
						
						player.addToInventory(droppedItem);
					}
					
					return;
				}
			}
			else
			{
				attack(player, enemy, isPlayersTurn);
				isPlayersTurn = true;
				if (player.getHealth() <= 0)
				{
					System.out.println("\nYou lost.");
					System.exit(0);
				}
			}
			
			System.out.println("\nCurrent health: " + player.getHealth());
			System.out.println(enemy.getName() + " health: " + enemy.getHealth());
		}
	}
	
	public void combatMenu(Player player, Enemy enemy, boolean isPlayersTurn)
	{
		int choice = 0;
		
		System.out.println("\n1. Attack"
					   + "\n2. Use Item"
					   + "\n3. Retreat");
		
		IO.inputString();
		choice = scnr.nextInt();
		
		System.out.println();
		
		switch (choice)
		{
			case 1:
				attack(player, enemy, isPlayersTurn);
				break;
			case 2:
				useItem(player);
				break;
			case 3:
				retreat(player, player.getDirection());
				return;
		}
	}
	
	public void attack(Player player, Enemy enemy, boolean isPlayersTurn)
	{
		if (isPlayersTurn)
		{
			System.out.println("You attacked " + enemy.getName() + " for " + player.getDmg());
			
			enemy.setHealth((enemy.getHealth() - player.getDmg()));
		}
		else
		{
			System.out.println(enemy.getName() + " attacked you for " + enemy.getDmg());
			
			player.setHealth((player.getHealth() - (enemy.getDmg() / Math.ceil(player.getArmor() * .5))));
		}
	}
	
	public void useItem(Player player)
	{
		player.useItem();
	}
	
	public void retreat(Player player, int direction)
	{
		switch (direction)
		{
			case 1:
				player.setX(player.getX() + 1);
				player.move(player.getCurrentArea());
			case 2:
				player.setY(player.getY() + 1);
				player.move(player.getCurrentArea());
			case 3:
				player.setY(player.getY() - 1);
				player.move(player.getCurrentArea());
			case 4:
				player.setX(player.getX() - 1);
				player.move(player.getCurrentArea());
		}
	}
}
