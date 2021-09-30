// Path of Clarity: Cave

public class Cave {
	
	private Room room0;
	private Room room1;
	public Room room2; 
	private Room room3;
	private Room room4;
	private Room room5;
	private Room room6;
	private Room room7;
	private Room room8;
	private Room room9;
	private Room room10;
	private Room room11;
	private Room room12;
	private Room room13;
	private Room room14;
	public Room exitroom;

	public Cave() { // Assigns all the values to the first Room type in the Room class
		this.room0 = new Room("Mouth", "Entrance to the cave.", false);
		this.room1 = new Room("Outer Tunnel", "A narrow passage leading deeper into the cave.", false);
		this.room2 = new Room("Dead End", "A small room that goes nowhere.", true);
		this.room3 = new Room("Cavern of Tears", "Water drips from hundreds of stalactites, echoing against the walls.", false);
		this.room4 = new Room("Cave Pond", "A pool of black water reflects the cave ceiling on its mirror-smooth\nsurface.", false);
		this.room5 = new Room("Inner Tunnel", "This tunnel angles downward, and water runs down the slope, almost\nmaking you slip.", false);
		this.room6 = new Room("Waterfall Room", "You hear water falling off some unseen edge into a hidden cavern below.", false);
		this.room7 = new Room("Curved Crawlway", "A tight crawlspace leads through the far wall into the next area.", false);
		this.room8 = new Room("Crystal Room", "Countless facets of red and purple crystals reflect your light back\nat you from every angle.", false);
		this.room9 = new Room("High Shelf","This half of this large cavern sits high above the lower half. You may\nbe able to slide down, but you won't be able to get back up.", false);
		this.room10 = new Room("Low Shelf","The upper shelf looks much higher from down here. It's impossible to get\nback up that way.", false);
		this.room11 = new Room("Upstairs","The west exit resembles a spiral staircase leading downwards.", false);
		this.room12 = new Room("Downstairs","The west exit resembles a spiral staircase leading upwards.", false);
		this.room13 = new Room("Shadow Room","Fallen boulders block the east exit, through which you can see a fire,\nwhich leaves dancing shadows on the opposite wall.", false);
		this.room14 = new Room("Blood Room","The stones and walls of this room are of a deep red color.", false);
		this.exitroom = new Room("Exit","", false);
		this.setupRooms();
	}
	private void setupRooms() { // Assigns each Room's relative positions
		room0.setExits(room1, null, null, null);
		room1.setExits(room2, room3, null, room0);
		room2.setExits(null, null, null, room1);
		room3.setExits(room5, room4, room1, null);
		room4.setExits(null, null, room3, null);
		room5.setExits(null, room6, null, room3);
		room6.setExits(null, room7, room5, null);
		room7.setExits(room8, null, room6, null);
		room8.setExits(room9, null, null, room7);
		room9.setExits(room10, null, room11, room8);
		room10.setExits(room13, room14, room12, null);
		room11.setExits(null, room9, room12, null);
		room12.setExits(null, room10, room11, null);
		room13.setExits(null, null, null, room10);
		room14.setExits(exitroom, null, room10, null);
		
	}
	public Room getStartingRoom() { // Sets the starting room to "Mouth"
		this.room0.name = this.room0.actual;
		return this.room0;
	}	
}