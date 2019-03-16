package game.Towns;

import java.util.ArrayList;

import game.Area;
import game.Buildings.Building;
import game.Buildings.GeneralStore;
import game.Buildings.Tavern;

public class Town extends Area
{
	ArrayList<Building> town;
	
	public Town()
	{
		town = new ArrayList<Building>();
		town.add(new GeneralStore());
		town.add(new Tavern());
	}
}
