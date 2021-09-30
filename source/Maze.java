// Path of Clarity: Maze

public class Maze
{
	public Room room0;
	public Room room1;
	public Room room2;
	public Room room3;
	public Room room4;
	public Room room5;
	public Room room6;
	public Room room7;
	public Room room8;
	public Room room9;
	public Room room10;
	public Room room11;
	public Room room12;
	public Room room13;
	public Room room14;
	public Room room15;
	public Room exitroom;
	public static String glyph = "               What costs nothing but is worth everything,\n                 weighs nothing but can last a lifetime,\n          that one person can't own but two or more can share?";
	public static String glyph1 = "What costs nothing but is worth everything,";
	public static String glyph2 = "weighs nothing but can last a lifetime,";
	public static String glyph3 = "that one person can't own but two or more can share?";
	Crypt crypt = new Crypt("19", "79"); //The seed for the encryption applied to the glyph in the Riddle Room

	public Maze() // Assigns all values to the second Room type in the Room class
	{
		this.room0 = new Room("Entrance", "You can't tell if it's just the heat and hunger, but you feel something\ncoming from the cave. Some kind of power.", "There's nothing here.\n");
		this.room1 = new Room("Crystal Corridor", "The walls and ceiling are crystals. They seem to be  pulsing with a\ncertain, hypnotizing rhythm. You can swear you hear the sounds of\ntrouble happening on the station.", "It's strange, but some of these crystals look a bit like power\ncouplers...\n");
		this.room2 = new Room("1st Choice", "The entrance to this room disappears behind you as you enter and now\nthere are only two exits. Through one exit is the Engineering room of\nDeep Space Nine. There are sparks flying from the consoles and your\nsubordinates are running around in panic. You feel a strong urge to run\nin there and get to work. Through the other exit is a silent room with\nnothing inside.\n\n'I'm not sure what to do,' you think. 'What did Worf mean by\n\"sacrifice\"?' You look back and forth between the exits...", "There is nothing here but the exits.\n");
		this.room3 = new Room("Silent Room", "This room is so silent you can hear your own breathing.", "There is nothing special in this room.\n");
		this.room4 = new Room("Rubble Room", "A pile of rubble crowds one corner of this room.", "You search the rubble pile and quickly find a small object. One side is\nrounded and the other has a protrusion sticking out.\n");
		this.room5 = new Room("Sandy Corridor", "The floor of this room is covered with sand. You can't tell how deep it\nis.", "You dig in the sand and your hand finds a small object. It is round on\none side and jagged on the other.\n");
		this.room6 = new Room("2nd Choice", "You see two exits again. Through one exit you see your friends being\nattacked by Borg. \"Help us!\" they scream desperately. Through the other\nexit is an inky, black room.", "There is nothing in this room but the exits.\n");
		this.room7 = new Room("Dark Room", "This room is empty of all features. The walls reflect no light.", "There is nothing here.\n");
		this.room8 = new Room("\033[3mBe'nal\033[0m", "A stone the size of a person stands in this room.", "You touch the stone and a small figure of a woman appears in a small\ndepression that wasn't there before. You think for a moment you hear\nKeiko's voice, calling for you. You pick up the figure.\n");
		this.room9 = new Room("\033[3mPuqbe'\033[0m", "A stone half your height stands in the center of the room.", "You touch the stone and a small figure of a girl appears on top of it.\nYou grab the figure and Molly's voice drifts into your mind.\n");
		this.room10 = new Room("\033[3mPuqloD\033[0m", "A small stone sits on the ground in this room.", "You crouch down near the stone and a small figure of a baby boy rolls\nout from behind the stone. You pick it up, and hear your infant son\ncrying.\n");
		this.room11 = new Room("\033[3mQorDu'\033[0m", "A pedestal sits in the middle of this room.", "The pedestal has three depressions on top.\n");
		this.room12 = new Room("3rd Choice", "The room has only two exits. Through one of them are you wife and\nchildren. They are in a dark room with bones strewn about them. You hear\nsomething large growling in the room with them and their faces are\nwracked with fear. Through the other exit is a completely empty room.", "There is nothing here but the exits.\n");
		this.room13 = new Room("Hall of Echoes", "Your footsteps reverberate in this room. The sound reminds you of how\nalone you are in this cave.", "There is nothing here.\n");
		this.room14 = new Room("Hall of Solitude", "You are alone.", "There is nothing here.\n");
		this.room15 = new Room("Riddle Room", "There is a small pedestal in this room, which something like a plaque\ncarved into the stone of the wall.", "The pedestal has a circular depression. The plaque on the wall is\n covered in glyphs you cannot understand. It reads:\n\n               " + crypt.encrypt(glyph1) + "\n                 " + crypt.encrypt(glyph2) + "\n          " + crypt.encrypt(glyph3) + "\n");
		this.exitroom = new Room("Emptiness", "", "");
		this.setupRooms();
	}

	private void setupRooms() // Assign each Room's relative position
	{
		room0.setExits(room1, null, null, null);
		room1.setExits(room2, null, null, room0);
		room2.setExits(null, room6, room3, null);
		room3.setExits(room4, null, room5, null);
		room4.setExits(null, null, null, room3);
		room5.setExits(room15, room3, null, null);
		room6.setExits(room7, null, room12, null);
		room7.setExits(null, room8, null, null);
		room8.setExits(room10, room9, room7, null);
		room9.setExits(room11, null, room8, null);
		room10.setExits(null, room11, null, room8);
		room11.setExits(null, null, room10, room9);
		room12.setExits(room13, exitroom, null, null);
		room13.setExits(room14, null, null, null);
		room14.setExits(exitroom, null, null, null);
		room15.setExits(null, null, null, room5);
		
	}

	public Room getStartingRoom() { // Sets the starting room to "Entrance"
		this.room0.name = this.room0.actual;
		return this.room0;
	}
}