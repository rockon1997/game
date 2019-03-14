package game;

import java.util.*;

public class Driver
{
	static Scanner scnr = new Scanner(System.in);
	static Area area = new Area();
	static Player player = new Player();
	static Combat combat = new Combat();
	
	public static void main(String[] arg)
	{
		mainMenu();
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
