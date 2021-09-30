// Path of Clarity: Player

import java.util.Scanner;
import java.util.Random;

public class Player 
{
	public int health;
	public int strength;
	public int honor;
	public Random r = new Random();
	private boolean isFighting;

	public Player() { // Player constructor
		this.health = 100;
		this.honor = 0;
		this.isFighting = false;
	}

	public boolean isFighting() { // Getter. Makes sure the attack method keeps looping until the monster dies or the player flees
		return this.isFighting; 
	}
	public void isFighting(boolean isFighting) { // Setter for isFighting boolean.
		this.isFighting = isFighting;
	}

	public void attack(Monster monster) { // This method manages monster encounters
		Demo.clearScreen();
		this.isFighting = true;
		Demo.topLine(3, "Pain");
		System.out.printf("%nA wild %s appears!%n", monster.getName());
		while (this.isFighting) {
			Scanner input = new Scanner(System.in);
			System.out.println("\n[a]ttack;");
			System.out.println("[f]lee");
			String choice = input.next();
			switch( choice.toLowerCase() )
			{
				case "a": this.melee(monster); break;
				case "f": this.flee(); 		  break;
				default: this.attack(monster); break;
			}
		}
	}
	
	public void melee(Monster monster) { // This method handles the effects of choosing "attack" during a monster encounter.
		int damage = r.nextInt(7) + 7;
		monster.takeDamage(damage);
		Demo.clearScreen();
		Demo.topLine(3, "Pain");
		
		System.out.printf("%nYou attack the %s for %d damage%n",monster.getName(), damage);
		if (monster.getHealth() <= 0) {
			this.honor += monster.getHonor();
			System.out.printf("%n\033[3mQapla'\033[0m! You have defeated the %s.%n%n", monster.getName() );
			this.isFighting = false;
			Demo.pressEnter();
		}
		else {
			takeDamage( monster.getStrength() );
			System.out.printf("The %s %s for %d damage.%n", monster.getName(), monster.getAttack(monster.getName()), monster.getStrength());
		}	
	}
	
	public void flee() { // This method determines whether you successfully flee or not. 4/10 chance. Honor- loss.
		Demo.clearScreen();
		Demo.topLine(3, "Pain");
		int success = r.nextInt(10);
		if (success > 5) {
			this.isFighting = false;
			System.out.println("\nYou run away from the creature, hoping it won't follow. It doesn't, but\nyou feel like a bit of a coward.\n");
			Demo.pressEnter();
		}
		else 
			System.out.println("\nYou try to run away but the creature skirts around you blocking your\nexit.\n");
		this.honor -= 5;
	}
	public void takeDamage(int damage) { // This method handles applying enemy damage to the player, and what happens if you lose all health to a monster fight.
		if (damage < this.health)
		{
			this.health -= damage;
		}
		else
		{
			this.health = 0;
		}
	}
}