// Path of Clarity: Room

public class Room {
	
	public String name;
	public String actual;
	public String description;
	public boolean enemy;
	private Room north;
	private Room east;
	private Room west;
	private Room south;
	
   
	public Room(String name, String description, boolean enemy) { //Room constructor for the Cave class.
		this.actual = name;
		this.description = description;
		this.enemy = enemy;
		if ( name.equals("Low Shelf") || name.equals("Exit") )
			this.name = name;
		else {
			this.name = "[unknown]";
		}
	}
	public void setExits(Room n, Room e, Room w, Room s) { // Exit setter
		this.north = n;
		this.east = e;
		this.west = w;
		this.south = s;
	}
	public String getExits() { // Exit getter
		String exits = "";
		if (this.north != null)
			exits += "[N]orth: " + this.north.name + "\n";
		if (this.east != null)
			exits += "[E]ast: " + this.east.name + "\n";
		if (this.west != null)
			exits += "[W]est: " + this.west.name + "\n";
		if (this.south != null)
			exits += "[S]outh: " + this.south.name + "\n";
		return exits;
	}
	public void beenThere() { // Changes name from "Unknown" or some other predefined String to its actual value once you enter the Room
		this.name = this.actual;
	}
	public Room getNorth() {
		return this.north;
	}
	public Room getEast() {
		return this.east;
	}
	public Room getWest() {
		return this.west;
	}
	public Room getSouth() {
		return this.south;
	}
	public String toString() { // Prints Room name, description, and available exits.
		return "\n[" + this.name + "]\n" + this.description + "\n\n" + getExits();
	}
}