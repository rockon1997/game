package game;

import java.util.concurrent.ThreadLocalRandom;

public class Area
{
	Room[][] area;
	
	Area()
	{
		area = new Room[10][10];
	}
	
	public Room[][] getArea()
	{
		return area;
	}

	private Room createRoom()
	{
		Room room = new Room();
		
		room.addEnemy(new Goblin());
		
		return room;
	}
	
	public void createArea()
	{
		int maxEnemies = ThreadLocalRandom.current().nextInt(5, 9);
		
		for (int i = 0; i < area.length; i++)
		{
			for (int j = 0; j < area.length; j++)
			{
				area[i][j] = new Room();
			}
		}
		
		int exitX, exitY;
		exitX = ThreadLocalRandom.current().nextInt(10);
		exitY = ThreadLocalRandom.current().nextInt(10);
		
		area[exitX][exitY].setExit(true);
		
		boolean status = true;
		
		for (int i = 0; i < maxEnemies; i++)
		{
			do
			{
				int x = ThreadLocalRandom.current().nextInt(10);
				int y = ThreadLocalRandom.current().nextInt(10);
				
				if (!area[x][y].isExit())
				{
					area[x][y] = createRoom();
				}
				else
				{
					status = false;
				}
			} while (!status);
		}
	}
	
	public void showArea(int x, int y)
	{
		System.out.println("-----------------------------------------");
		for (int i = 0; i < area.length; i++)
		{
			for (int j = 0; j < area.length; j++)
			{
				if (i == x && j == y)
				{
					System.out.print(String.format("%-2s%-2s", "|", "P"));
				}
				else if (area[i][j].isExit())
				{
					System.out.print(String.format("%-2s%-2s", "|", "E"));
				}
				else if (area[i][j].getEnemies().isEmpty())
				{
					System.out.print(String.format("%-2s%-2s", "|", "O"));
				}
				else
				{
					System.out.print(String.format("%-2s%-2s", "|", "X"));
				}
			}
			System.out.println("|\n-----------------------------------------");
		}
	}
}
