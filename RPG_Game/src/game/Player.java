package game;

import java.util.Scanner;

import game.Armors.*;
import game.HealthPotions.*;
import game.Weapons.*;

import java.util.ArrayList;
import java.io.*;

public class Player implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Scanner scnr;
	
	private ArrayList<Item> inventory;
	Weapon weapon;
	HelmetArmor helmet;
	ShoulderArmor shoulders;
	ChestArmor chest;
	GlovesArmor gloves;
	LegArmor legs;
	FootArmor boots;
	
	private Area currentArea;
	private int x, y, direction;
	
	private int level;
	private int exp;
	private int expThreshold;
	private int dmg; // Overall damage for player character.
	private double maxHealth;
	private double health; // Overall health for player character.
	private int speed; // Determines who attacks first in combat.
	private int armor; // Overall defense for player character.
	private int gold; // Overall amount of gold the player character has.
	
	Player()
	{
		this.scnr = new Scanner(System.in);
		
		this.inventory = new ArrayList<Item>(20);
		
		for (int i = 0; i < inventory.size(); i++)
		{
			this.inventory.add(null);
		}
		
		addToInventory(new Minor_Health_Potion());
		this.inventory.get(0).quantity = 3;
		
		addToInventory(new Iron_Sword());
		
		this.weapon = new Weapon();
		this.helmet = new HelmetArmor();
		this.shoulders = new ShoulderArmor();
		this.chest = new ChestArmor();
		this.gloves = new GlovesArmor();
		this.legs = new LegArmor();
		this.boots = new FootArmor();
		
		this.currentArea = new Area();
		this.x = this.y = 0;
		
		this.level = 1;
		this.exp = 0;
		this.expThreshold = 0;
		this.dmg = 3;
		this.maxHealth = 10;
		this.health = 10;
		this.speed = 5;
		this.armor = 1;
	}
	
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

	public Area getCurrentArea()
	{
		return this.currentArea;
	}

	public int getX()
	{
		return this.x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getDirection()
	{
		return this.direction;
	}

	public int getLevel()
	{
		return this.level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getExp()
	{
		return this.exp;
	}

	public void setExp(int exp)
	{
		this.exp = exp;
	}

	public int getDmg()
	{
		return this.dmg + this.weapon.getDmg();
	}
	
	public void setDmg(int dmg)
	{
		this.dmg = dmg;
	}
	
	public double getMaxHealth()
	{
		return this.maxHealth;
	}

	public void setMaxHealth(double maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
	public double getHealth()
	{
		return Math.ceil(this.health);
	}
	
	public void setHealth(double health)
	{
		this.health = health;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int getArmor()
	{
		return armor;
	}

	public void setArmor(int armor)
	{
		this.armor = armor;
	}
	
	public int getGold()
	{
		return gold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}
	
	// LEVEL FORMULA: (currentLevel * 100) + previousEXPThreshold
	public int getNextExpThreshold()
	{
		return this.expThreshold = (this.level * 100) + this.expThreshold;
	}
	
	public void levelUp()
	{
		if (this.exp >= getNextExpThreshold())
		{
			this.level += 1;
			
			IO.levelUpNotification(this);
			
			this.dmg += 3;
			this.maxHealth += 5;
			this.health = this.maxHealth;
			this.speed += 1;
		}
	}
	
	public void move(Area area)
	{
		int choice = 0;
		
		this.currentArea = area;
		
		while (this.health > 0)
		{
			if (!this.currentArea.getArea()[this.x][this.y].getEnemies().isEmpty())
			{
				new Combat().combat(this.currentArea.getArea()[this.x][this.y].getEnemies().get(0), this);
				
				this.currentArea.getArea()[this.x][this.y].getEnemies().remove(0);
			}
			
			this.currentArea.showArea(this.x, this.y);
			
			IO.inGameMenuOutput();
			IO.inputString();
			choice = scnr.nextInt();
			
			if (choice == 1)
			{
				direction = 0;
				while (direction != 5)
				{
					System.out.println("1. Move up\n2. Move left\n3. Move right\n4. Move down\n5. Stop moving\n");
					IO.inputString();
					this.direction = scnr.nextInt();
					
					if (this.direction == 5)
					{
						move(this.currentArea);
					}
					
					IO.moveDirection(this, this.direction);
					
					if (!this.currentArea.getArea()[this.x][this.y].getEnemies().isEmpty())
					{
						new Combat().combat(this.currentArea.getArea()[this.x][this.y].getEnemies().get(0), this);
						
						this.currentArea.getArea()[this.x][this.y].getEnemies().remove(0);
					}
					else if (this.currentArea.getArea()[this.x][this.y].isExit())
					{
						return;
					}
					
					this.currentArea.showArea(this.x, this.y);
				}
			}
			else
			{
				IO.inGameMenu(this, choice);
			}
		}
	}
	
	/* Determines if the inventory ArrayList contains the item passed through.
	 * If it is and it isn't equippable, then it adds one to the quantity of that item.
	 * If not, then it adds a new instance of that item to the inventory ArrayList.
	 */
	public void addToInventory(Item item)
	{
		boolean found = false;
		
		Item addingItem = item;
		
		for (Item currentItem : this.inventory)
		{
			if (addingItem.getClass().equals(currentItem.getClass()) && !addingItem.isEquippable)
			{
				currentItem.quantity++;
				found = true;
			}
		}
		
		if (!found)
		{
			inventory.add(item);
		}
	}
	
	public void removeFromInventory()
	{
		int choice = 0;
		
		displayInventory();
		System.out.println();
		
		System.out.println("Choose which item to drop:\n");
		IO.inputString();
		choice = scnr.nextInt();
		
		if (inventory.get(choice-1) != null)
		{
			inventory.remove(choice-1);
		}
		else
		{
			System.out.println("No item in that slot.\n");
		}
	}
	
	public void useItem()
	{
		int choice = 0;
		boolean hasPotion = false;
		
		for (int i = 0; i < this.inventory.size(); i++)
		{
			if (this.inventory.get(i) != null && this.inventory.get(i).isPotion)
			{
				hasPotion = true;
				
				System.out.println((i + 1) + ": " + this.inventory.get(i).getName()
										  + " (x" + this.inventory.get(i).quantity + ") - "
										          + this.inventory.get(i).getDesc());
			}
		}
		
		if (!hasPotion)
		{
			System.out.println("You do not have any potions to use currently.");
			return;
		}
		
		do 
		{
			System.out.println("\nChoose which item to use: (Type -1 to exit)");
			IO.inputString();
			choice = scnr.nextInt();
			
			if (choice == -1)
			{
				return;
			}
			
			Item potion = this.inventory.get(choice-1);
			
			if (potion instanceof HealthPotion)
			{
				if (potion.quantity > 0)
				{
					potion.useItem(this);
					
					if (this.health >= this.maxHealth)
					{
						this.health = this.maxHealth;
					}
					
					this.inventory.get(choice-1).quantity -= 1;
					
					if (this.inventory.get(choice-1).quantity <= 0)
					{
						this.inventory.set(choice-1, null);
						return;
					}
				}
			}
		} while (this.inventory.get(choice-1) == null);
	}
	
	/* Displays currently equipped gear.
	 * Asks which item to equip.
	 * Once decided, game logic determines which category of armor it is.
	 * Then equips current item to specific armor slot.
	 * After it has determined the armor slot to choose, it calculates new armor number.
	 */
	public void equipItem()
	{
		int choice = 0;
		
		do
		{
			System.out.println("\n--GEAR--");
			System.out.println("1: Weapon - " + weapon.getName());
			System.out.println("2: Head - " + helmet.getName());
			System.out.println("3: Shoulders - " + shoulders.getName());
			System.out.println("4: Chest - " + chest.getName());
			System.out.println("5: Gloves - " + gloves.getName());
			System.out.println("6: Legs - " + legs.getName());
			System.out.println("7: Boots - " + boots.getName());
			System.out.println("8: Exit");
			
			System.out.println("Choose which item to equip:\n");
			System.out.print(">> ");
			choice = scnr.nextInt();
			
			if (choice == 8)
			{
				return;
			}
			
			while (choice < 0 || choice > inventory.size())
			{
				System.out.println("\nChoose a different index:\n");
				IO.inputString();
				choice = scnr.nextInt();
				
				if (choice == 8)
				{
					return;
				}
			}
			
			if (this.inventory.get(choice-1) != null && this.inventory.get(choice-1).isEquippable)
			{
				Item item = inventory.get(choice-1);
				if (item instanceof Weapon)
				{
					weapon = (Weapon) item;
				}
				else if (item instanceof HelmetArmor)
				{
					helmet = (HelmetArmor) item;
					armor = helmet.getDefense() + chest.getDefense() + shoulders.getDefense() + gloves.getDefense() + legs.getDefense() + boots.getDefense();
				}
				else if (item instanceof ChestArmor)
				{
					chest = (ChestArmor) item;
					armor = helmet.getDefense() + chest.getDefense() + shoulders.getDefense() + gloves.getDefense() + legs.getDefense() + boots.getDefense();
				}
				else if (item instanceof ShoulderArmor)
				{
					shoulders = (ShoulderArmor) item;
					armor = helmet.getDefense() + chest.getDefense() + shoulders.getDefense() + gloves.getDefense() + legs.getDefense() + boots.getDefense();
				}
				else if (item instanceof GlovesArmor)
				{
					gloves = (GlovesArmor) item;
					armor = helmet.getDefense() + chest.getDefense() + shoulders.getDefense() + gloves.getDefense() + legs.getDefense() + boots.getDefense();
				}
				else if (item instanceof LegArmor)
				{
					legs = (LegArmor) item;
					armor = helmet.getDefense() + chest.getDefense() + shoulders.getDefense() + gloves.getDefense() + legs.getDefense() + boots.getDefense();
				}
				else if (item instanceof FootArmor)
				{
					boots = (FootArmor) item;
					armor = helmet.getDefense() + chest.getDefense() + shoulders.getDefense() + gloves.getDefense() + legs.getDefense() + boots.getDefense();
				}
			}
			else
			{
				System.out.println("Item is not able to be equipped.\n");
			}
			
		} while (choice >= 1 && choice <= 7);
	}
	
	/* Displays currently equipped gear.
	 * Asks which item to unequip.
	 * Once decided, determines if current armor slot is occupied.
	 * If it is, then unequips current item.
	 * If not, then tells the user that there is no armor in that slot.
	 * After it has determined the armor slot to choose, it calculates new armor number.
	 */
	public void unequipItem()
	{
		int choice = 0;
		
		do
		{
			System.out.println("\n--GEAR--");
			System.out.println("1: Weapon - " + weapon.getName());
			System.out.println("2: Head - " + helmet.getName());
			System.out.println("3: Shoulders - " + shoulders.getName());
			System.out.println("4: Chest - " + chest.getName());
			System.out.println("5: Gloves - " + gloves.getName());
			System.out.println("6: Legs - " + legs.getName());
			System.out.println("7: Boots - " + boots.getName());
			System.out.println("8: Exit");
			
			System.out.println("Choose which item to unequip:\n");
			IO.inputString();
			choice = scnr.nextInt();
			
			switch (choice)
			{
				case 1:
					if (!weapon.getName().equals("Empty"))
					{
						weapon = new Weapon();
					}
					else
					{
						System.out.println("No armor equipped.\n");
					}
					break;
				case 2:
					if (!helmet.getName().equals("Empty"))
					{
						helmet = new HelmetArmor();
					}
					else
					{
						System.out.println("No armor equipped.\n");
					}
					break;
				case 3:
					if (!shoulders.getName().equals("Empty"))
					{
						shoulders = new ShoulderArmor();
					}
					else
					{
						System.out.println("No armor equipped.\n");
					}
					break;
				case 4:
					if (!chest.getName().equals("Empty"))
					{
						chest = new ChestArmor();
					}
					else
					{
						System.out.println("No armor equipped.\n");
					}
					break;
				case 5:
					if (!gloves.getName().equals("Empty"))
					{
						gloves = new GlovesArmor();
					}
					else
					{
						System.out.println("No armor equipped.\n");
					}
					break;
				case 6:
					if (!legs.getName().equals("Empty"))
					{
						legs = new LegArmor();
					}
					else
					{
						System.out.println("No armor equipped.\n");
					}
					break;
				case 7:
					if (!boots.getName().equals("Empty"))
					{
						boots = new FootArmor();
					}
					else
					{
						System.out.println("No armor equipped.\n");
					}
					break;
				default:
					return;
			}
		} while (choice >= 1 && choice <= 7);
	}
	
	// Displays currently equipped weapons and armor.
	public void displayEquipped()
	{
		System.out.println("--STATS--");
		System.out.println("Level: " + this.level
					   + "\nExperience: " + this.exp
					   + "\nHealth: " + Math.round(this.health) 
					   + "\nBase Damage: " + this.dmg
					   + "\nDamage per hit: " + getDmg()
					   + "\nArmor: " + this.armor);
		
		System.out.println("\n--GEAR--");
		System.out.println("1: Weapon - " + weapon.getName());
		System.out.println("2: Head - " + helmet.getName());
		System.out.println("3: Shoulders - " + shoulders.getName());
		System.out.println("4: Chest - " + chest.getName());
		System.out.println("5: Gloves - " + gloves.getName());
		System.out.println("6: Legs - " + legs.getName());
		System.out.println("7: Boots - " + boots.getName());
	}
	
	// Displays current inventory.
	public void displayInventory()
	{
		int i = 0;
		
		System.out.println("--INVENTORY--");
		
		if (inventory.isEmpty())
		{
			System.out.println("Empty");
		}
		else
		{
			for (Item item : this.inventory)
			{
				System.out.println(++i + ": " + item.getName() + " (x" + item.quantity + ") - " + item.getDesc());
			}
		}
		
		System.out.println("Gold: " + this.gold);
	}
	
	/* Serializes current inventory, currently equipped gear and current stats.
	 * Then writes all this to a .ser file named savefile.
	 */
	public void saveGame()
	{
		try
		{
			FileOutputStream file = new FileOutputStream("savefile.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(this.inventory);
			out.writeObject(this.weapon);
			out.writeObject(this.helmet);
			out.writeObject(this.shoulders);
			out.writeObject(this.chest);
			out.writeObject(this.gloves);
			out.writeObject(this.legs);
			out.writeObject(this.boots);
			
			out.writeInt(this.level);
			out.writeInt(this.exp);
			out.writeDouble(this.maxHealth);
			out.writeDouble(this.health);
			out.writeInt(this.dmg);
			out.writeInt(this.speed);
			out.writeInt(this.armor);
			out.writeInt(this.gold);
			
			out.close();
			file.close();
			
			System.out.println("Game successfully saved.\n");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/* De-Serializes inventory, equipped gear, and stats objects/data types.
	 * Then reads them into respective objects/variables.
	 */
	@SuppressWarnings("unchecked")
	public void loadGame()
	{
		try
		{
			FileInputStream file = new FileInputStream("savefile.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			
			this.inventory = (ArrayList<Item>) in.readObject();
			this.weapon = (Weapon) in.readObject();
			this.helmet = (HelmetArmor) in.readObject();
			this.shoulders = (ShoulderArmor) in.readObject();
			this.chest = (ChestArmor) in.readObject();
			this.gloves = (GlovesArmor) in.readObject();
			this.legs = (LegArmor) in.readObject();
			this.boots = (FootArmor) in.readObject();
			
			this.level = in.readInt();
			this.exp = in.readInt();
			this.maxHealth = in.readDouble();
			this.health = in.readDouble();
			this.dmg = in.readInt();
			this.speed = in.readInt();
			this.armor = in.readInt();
			this.gold = in.readInt();
			
			in.close();
			file.close();
		}
		catch (IOException e)
		{
			System.out.println("IOException caught");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}