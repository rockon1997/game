package game;

import java.util.concurrent.ThreadLocalRandom;

public class Area
{
	Room[][] area;
	
	public Area()
	{
		area = new Room[10][10];
	}
	
	public Room[][] getArea()
	{
		return area;
	}

	private Room createRoom(int y, int x)
	{
		Room room = new Room();
		
		room.addEnemy(new Goblin());
		room.setY(y);
		room.setX(x);
		
		return room;
	}
	
	public void createArea()
	{
		int maxEnemies = ThreadLocalRandom.current().nextInt(10, 20);
		
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
		
		area[exitY][exitX].setExit(true);
		
		boolean status = true;
		
		for (int i = 0; i < maxEnemies; i++)
		{
			do
			{
				int x = ThreadLocalRandom.current().nextInt(10);
				int y = ThreadLocalRandom.current().nextInt(10);
				
				if (!area[y][x].isExit())
				{
					area[y][x] = createRoom(x, y);
					status = true;
				}
				else
				{
					status = false;
				}
			} while (!status);
		}
	}
	
	public void showArea(int y, int x)
	{
		System.out.println("-----------------------------------------");
		for (int i = 0; i < area.length; i++)
		{
			for (int j = 0; j < area.length; j++)
			{
				if (j == x && i == y)
				{
					System.out.print(String.format("%-2s%-2s", "|", "P"));
				}
				else if (area[i][j].isExit())
				{
					System.out.print(String.format("%-2s%-2s", "|", "E"));
				}
				else if (!area[i][j].getEnemies().isEmpty())
				{
					System.out.print(String.format("%-2s%-2s", "|", "X"));
				}
				else
				{
					System.out.print(String.format("%-2s%-2s", "|", " "));
				}
			}
			System.out.println("|\n-----------------------------------------");
		}
	}
}
