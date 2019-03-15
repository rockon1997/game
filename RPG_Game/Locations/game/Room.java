package game;

import java.util.ArrayList;

public class Room
{
	private ArrayList<Enemy> enemies;
	private int x, y;
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

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
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
