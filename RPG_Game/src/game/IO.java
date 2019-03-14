package game;

public class IO
{
	public static void CLS()
	{
		System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
				         + "\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
				         + "\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
				         + "\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
				         + "\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
				         + "\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
				         + "\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
				         + "\r\n");
	}
	
	public static void inputString()
	{
		System.out.print("\n>> ");
	}
	
	// ---DRIVER---
	public static void mainMenuOutput()
	{
		System.out.println("1. New Game"
			           + "\n2. Load Game"
			           + "\n3. Exit");
	}
	
	public static void gameMenuOutput()
	{
		System.out.println("\n1. Enter area"
	    		         + "\n2. Status"
			             + "\n3. Inventory"
	    		         + "\n4. Use Item"
			             + "\n5. Equip Item"
			             + "\n6. Unequip Item"
			             + "\n7. Drop Item"
			             + "\n8. Save Game"
			             + "\n9. Exit");
	}
	
	public static void gameMenuChoice(Player player, Area area, int choice)
	{
		switch(choice)
		{
			case 1:
				area.createArea();
				player.move(area);
				break;
			case 2:
				player.displayEquipped();
				System.out.println();
				break;
			case 3:
				player.displayInventory();
				System.out.println();
				break;
			case 4:
				player.useItem();
				System.out.println();
				break;
			case 5:
				player.displayInventory();
				System.out.println();
				player.equipItem();
				System.out.println();
				break;
			case 6:
				player.unequipItem();
				System.out.println();
				break;
			case 7:
				player.removeFromInventory();
				break;
			case 8:
				player.saveGame();
				break;
			case 9:
				System.exit(0);
				break;
		}
	}
	
	// ---PLAYER---
	public static void levelUpNotification(Player player)
	{
		System.out.println("You have leveled up to " + player.getLevel());
	}
	
	public static void inGameMenuOutput()
	{
		System.out.println("1. Move"
				   + "\n2. Status"
				   + "\n3. Inventory"
				   + "\n4. Use Item"
				   + "\n5. Equip Item"
				   + "\n6. Unequip Item"
				   + "\n7. Drop Item"
				   + "\n8. Exit\n");
	}
	
	public static void inGameMenu(Player player, int choice)
	{
		inGameMenuOutput();
		
		switch(choice)
		{
			case 2:
				player.displayEquipped();
				System.out.println();
				break;
			case 3:
				player.displayInventory();
				System.out.println();
				break;
			case 4:
				player.useItem();
				System.out.println();
				break;
			case 5:
				player.displayInventory();
				System.out.println();
				player.equipItem();
				System.out.println();
				break;
			case 6:
				player.unequipItem();
				System.out.println();
				break;
			case 7:
				player.removeFromInventory();
				break;
			case 8:
				System.exit(0);
				break;
		}
	}
	public static void moveDirection(Player player, int direction)
	{
		switch (direction)
		{
			case 1:
				if (player.getX() - 1 >= 0)
				{
					player.setX(player.getX() - 1);
				}
				else
				{
					wall();
				}
				break;
			case 2:
				if (player.getY() - 1 >= 0)
				{
					player.setY(player.getY() - 1);
				}else
				{
					wall();
				}
				break;
			case 3:
				if (player.getY() + 1 < player.getCurrentArea().getArea().length)
				{
					player.setY(player.getY() + 1);
				}else
				{
					wall();
				}
				break;
			case 4:
				if (player.getX() + 1 < player.getCurrentArea().getArea().length)
				{
					player.setX(player.getX() + 1);
				}else
				{
					wall();
				}
				break;
		}
	}
	
	public static void wall()
	{
		System.out.println("That is a wall.\n");
	}
	
	// ---COMBAT---
	public static void encounter(Enemy enemy)
	{
		System.out.println("You've encountered a level "
						 + enemy.getLevel() + " " + enemy.getName());
	}
	
	public static void encounterWon(Enemy enemy)
	{
		System.out.println("\nYou have won against the " + enemy.getName());
	}
	
	public static void encounterLost(Enemy enemy)
	{
		System.out.println("\nYou have lost against the " + enemy.getName());
	}
	
	public static void itemDropped(Enemy enemy, Item item)
	{
		System.out.println("The " + enemy.getName() + " dropped a " + item.getName());
	}
}
