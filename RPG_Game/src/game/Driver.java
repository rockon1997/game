package game;

import java.util.*;

import game.Sectors.SectorOne;

public class Driver
{
	static Scanner scnr = new Scanner(System.in);
	static Sector sector = new Sector();
	static Sector sectorOne = new SectorOne();
	static Area area = new Area();
	static Player player = new Player();
	static Combat combat = new Combat();
	
	public static void main(String[] arg)
	{
		sectorOne.showSector(1, 1);
		//mainMenu();
	}
	
	public static void mainMenu()
	{
		IO.CLS();
		
		int choice = 0;
		
		IO.mainMenuOutput();
		
		IO.inputString();
		choice = scnr.nextInt();
		
		System.out.println();
		
		IO.CLS();
		
		switch (choice)
		{
			case 1:
				gameMenu();
				break;
			case 2:
				player.loadGame();
				gameMenu();
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
	
	public static void gameMenu()
	{
		int choice = 0;
		
		do
		{
			IO.gameMenuOutput();
			
			IO.inputString();
			choice = scnr.nextInt();
			
			System.out.println();
			
			IO.CLS();
			
			IO.gameMenuChoice(player, area, choice);
		} while (choice != 0);
	}
}
