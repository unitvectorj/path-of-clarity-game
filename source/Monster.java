// Path of Clarity: Monster

import java.util.Random;

public class Monster {
	private String name;
	private static String species;
	private int health;
	private int strength;
	private int honor;
	private Random r = new Random();
	
	public Monster(String name, int health, int strength, int honor) {// Monster constructor
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.honor = honor;
	}
	public static Monster spawn(int type) {// Randomly generates 1 of 3 enemies to fight.
		
		int[] stats = new int[3];
		if (type == 0) {
			species = "Targ";
			stats = new int[]{15, 2, 3};
		}
		else if (type == 1) {
			species = "Krencha";
			stats = new int[]{30, 3, 6};
		}
		else if (type == 2) {
			species = "Brush Devil";
			stats = new int[]{40, 4, 8};
		}
		else if (type == 3) {
			species = "Kahless";
			stats = new int[]{300, 15, 300};
		}
		Monster monster = new Monster(species, stats[0], stats[1], stats[2]);
		return monster;
	}
	public String getSpecies() {
		return this.species;
	}
	public String getName() { // Name getter
		return this.name;
	}
	public int getHealth() { // Health getter
		return this.health;
	}
	public int getStrength() { // Strength getter
		return this.strength;
	}
	public int getHonor() { // Honor getter
		return this.honor;
	}
	public String getAttack(String species) { // randomly chooses one of three attacks for each monster type. It only affects the words displayed, not the amount of damage.
		int type = r.nextInt(3);
		String attack = "";
		if (species.equals("Targ")) {
			switch (type) {
				case 0: attack = "bites you"; break;
				case 1: attack = "charges you"; break;
				case 2: attack = "kicks at you"; break;
			}
		}
		else if (species.equals("Krencha")) {
			switch (type) {
				case 0: attack = "claws at you"; break;
				case 1: attack = "bites you with its fangs"; break;
				case 2: attack = "whips you with its tail"; break;
			}
		}
		else if (species.equals("Brush Devil")) {
			switch (type) {
				case 0: attack = "screams loudly, hurting your ears"; break;
				case 1: attack = "bites at you"; break;
				case 2: attack = "jumps up and scratches your face"; break;
			}
		}
		return attack;
	}
	public void takeDamage(int damage) {// Lowers the monsters health by the player character's attack, which is a randomly generated number 7-13.
		this.health -= damage;
		if (this.health < 0)
			this.health = 0;
	}
	public void attack(Player hero) {// Displays the monster and type of attack, then lowers player health.
		hero.takeDamage(this.strength);
		System.out.printf("%s attacks player for %d damage%n", this.name, this.strength);
	}
}