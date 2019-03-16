package game.Sectors;

import game.Area;
import game.Sector;
import game.Cities.City;
import game.Towns.Town;

public class SectorOne extends Sector
{
	public SectorOne()
	{
		createSector();
	}
	
	public void createSector()
	{
		for (int i = 0; i < this.getSector().length; i++)
		{
			for (int j = 0; j < this.getSector().length; j++)
			{
				this.getSector()[i][j] = new Area();
			}
		}
		
		this.getSector()[4][6] = new Town();
		this.getSector()[5][21] = new Town();
		this.getSector()[7][13] = new Town();
		this.getSector()[12][7] = new Town();
		this.getSector()[13][15] = new Town();
		this.getSector()[20][3] = new Town();
		this.getSector()[15][20] = new Town();
		this.getSector()[23][16] = new Town();
		
		this.getSector()[16][11] = new City();
	}
}
