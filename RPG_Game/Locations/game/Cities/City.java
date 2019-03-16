package game.Cities;

import java.util.ArrayList;

import game.Area;
import game.Buildings.*;

public class City extends Area
{
	ArrayList<Building> city;
	
	public City()
	{
		city = new ArrayList<Building>();
		
		city.add(new Blacksmith());
		city.add(new GeneralStore());
		city.add(new Tavern());
	}
}