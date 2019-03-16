package game;

import game.Cities.*;
import game.Towns.*;

public class Sector
{
	private Area[][] sector;
	
	protected Sector()
	{
		sector = new Area[25][25];
	}
	
	public Area[][] getSector()
	{
		return sector;
	}
	
	public void showSector(int y, int x)
	{
		System.out.println("-----------------------------------------"
				+ "-----------------------------------------"
				+ "-------------------");
		for (int i = 0; i < sector.length; i++)
		{
			for (int j = 0; j < sector.length; j++)
			{
				if (j == x && y == i)
				{
					System.out.print(String.format("%-2s%-2s", "|", "P"));
				}
				else if (sector[i][j] instanceof City)
				{
					System.out.print(String.format("%-2s%-2s", "|", "C"));
				}
				else if (sector[i][j] instanceof Town)
				{
					System.out.print(String.format("%-2s%-2s", "|", "T"));
				}
				else
				{
					System.out.print(String.format("%-2s%-2s", "|", " "));
				}
			}
			System.out.println("|\n-----------------------------------------"
					+ "-----------------------------------------"
					+ "-------------------");
		}
	}
}
