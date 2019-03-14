package game;

import java.util.ArrayList;

public class Room
{
	private ArrayList<Enemy> enemies;
	private boolean isExit;
	
	Room()
	{
		enemies = new ArrayList<Enemy>();
		isExit = false;
	}

	public ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}
	
	public void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	}

	public boolean isExit()
	{
		return isExit;
	}

	public void setExit(boolean isExit)
	{
		this.isExit = isExit;
	}
}
