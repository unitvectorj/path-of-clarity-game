// Path of Clarity: Clarity - main gameloop

import java.util.Scanner;
import java.util.Random;

public class Clarity {
												
	public static Scanner input = new Scanner(System.in);
	public static Player miles = new Player();
	public static Random r = new Random();
	public static int wounds;
	public static int beasts;
	public static int songs;
	public static int trials;
	public static int wrong;
	
	public static void main(String[] args) {
		clearScreen();
		System.out.println("\n                          \033[4mThe Path of Clarity\033[0m\n\n\n\n                       a Star Trek text adventure\n\n                  based on the Deep Space Nine episode\n\n                      \"You Are Cordially Invited\"\n\n\n");
		pressEnter();
		System.out.println("Stardate 51247.5 - Federation Space Station \"Deep Space Nine\"\n\nYou are Miles O'Brien, Chief Engineer. Your old friend, Worf, has called\nyou suddenly to one of the meeting rooms. When you arrive you see that\nCaptain Ben Sisko, Doctor Julian Bashir, and the Klingon General Martok\nhave also been called here. Commander Worf stands as you enter.\n");
		System.out.println("\"Thank you for coming. As you probably know by now, Jadzia and I will be\nmarried here on the station in 6 days. By tradition a Klingon man spends\nthe four nights before his wedding on a mental and spiritual journey. It\nis called \033[3mKal'Hyah\033[0m, 'The Path of Clarity', and he is accompanied by his\nclosest male friends.\"\n");
		pressEnter();
		System.out.println("\n\nMartok adds, \"You cannot imagine the experience that awaits us. Four\nlong nights filled with song and fellowship.\"\n");
		System.out.println("You butt in, \"Are we talking about a bachelor party here?\"\n");
		System.out.println("\"It is a similar ritual. We will meet in the holosuite tomorrow night\nat 2100 hours. I advise you all to get plenty of rest.\"\n");
		pressEnter();
		dayOne();
		temptation(1);
		dayTwo();
		temptation(2);
		dayThree();
		temptation(3);
		dayFour();
		end();
	}
	
	public static void dayOne() { // This method just contains all the text and choices in day 1 of the game.
		System.out.println("                                DAY ONE\n");
		System.out.println("You arrive at the holosuite dressed in the traditional garb that you all\nreplicated for the occasion. When you walk through the doors, you find\nyourself in a cave where your friends are waiting along with Worf's son,\nAlexander. There are large metal pits about the room with fires blazing\nin them. You feel the sweat begin to form on your brow already. Martok\nhands you each a \033[3mma'staka\033[0m, a ritual club.\n");
		System.out.println("\"At the conclusion of the wedding ceremony, you will use these to attack\nWorf and Jadzia. It will only be a symbolic attack. The tradition dates\nback to the wedding of Kahless and Lukara, who were nearly killed by\nMolor's troops moments after they were married. Until the ceremony, you\nshould keep these with you at all times,\" explains Martok.\n");
		pressEnter();
		System.out.println("\n\nYour eyes wander over to a large table along one wall of the cave,\ncovered with a banquet of delicious looking foods. \"Excellent. I hadn't\nhad dinner before coming here,\" you say, walking toward the table.\n");
		System.out.println("\"That food is not to be eaten\", Worf states. \"It is only there to tempt\nus to break our fast. This is 'Deprivation' - the first of six trials we\nmust face on the Path of Clarity. We will now begin a fast that will\nlast until the wedding, 4 days from now.\n");
		pressEnter();
		System.out.println("\n\n\"What are the other five trials?\" you ask.\n\n\"They are - 'Blood', 'Pain', 'Sacrifice', 'Anguish', and 'Death'.\"\n");
		System.out.println("\"Sounds like marriage, alright,\" Julian says.\n\n\"How would you know?\", you retort, thinking of your wife, Keiko, and\nchildren, Molly and Kirayoshi, and how much you miss them.\n\n\"Now, let us begin the next trial,\" Worf says, solemnly.\n");
		pressEnter();
		topLine(2, "'Blood'");
		System.out.println("\nWorf stands over a large bowl, his back to you, a traditional knife in\nhand, while you and the rest of the groomsmen stand in a line facing\nhim.\n\n\"Now begins the Trial of Blood,\" he says.\n\n\"Let rivers flow from our veins,\" Martok intones.\n\n\"Who will be first?\"\n");
		System.out.println("You notice that rather than stepping forward, all the other groomsmen\nhave taken a step backwards, except for Julian, who is so dazed by the\nheat that he didn't notice. What do you do?\n");
		System.out.println("1 - You step in front of Julian.\n2 - You step backwards, leaving Julian to go first.");
		int choice = input.nextInt();
		clearScreen();
		topLine(2, "Blood");
		if (choice == 1) {
			System.out.println("\nWorf turns and sees you standing in front. \"I did not expect it to be\nyou, Miles. Do not worry. The pain will only last a moment, but your\nhonor will last forever.\"\n");
			miles.honor += 10;
		}
		else if (choice == 2) {
			System.out.println("\nYou step backwards. Worf turns just in time to see. He says nothing, but\nyou can tell he is disappointed by your actions.");
			miles.honor -= 10;
		}
		pressEnter();
		topLine(2, "Blood");
		System.out.println("\nIt is now your turn to step forward and add your blood to the bowl. You\ntake the ornate knife in your hand and press it against your other palm.\nHow do you cut?\n\n1 - Deeply and hard.\n2 - With a quick, firm pull.\n3 - Just a small cut.");
		choice = input.nextInt();
		clearScreen();
		topLine(2, "Blood");
		if (choice == 1) {
			System.out.println("\nYou cut deeply. Your blood flows from your hand into the bowl. Worf\nstares into your eyes and nods his approval at your show of dedication.\n");
			miles.health -= 10;
			miles.honor += 10;
		}
		else if (choice == 2) {
			System.out.println("\nYou cut into the flesh with a swift pull. Blood trickles from your hand\ninto the bowl. Worf acknowledges your contribution.\n");
			miles.health -= 5;
			miles.honor += 5;
		}
		else if (choice == 3) {
			System.out.println("\nYou lightly cut into your fingertip and squeeze out a droplet of blood.\nIt falls into the bowl with a tiny \"blip\". Worf glares at you with\ndisapproval.\n");
			miles.honor -= 10;
		}
		wounds++;
		trials++;
		pressEnter();
	}
	public static void dayTwo() { // This method contains a map with enemies. The map is defined by the Cave class, the mechanics of the rooms in the Room class, and the monsters are in the Monster class.
		System.out.println("                                DAY TWO\n\nYou wake up drenched in sweat in a large cavern you don't recognize,\nalone. There is a single opening which seems to lead into a deeper cave\nsystem. You think you hear the sounds of something moving in there.\n'I suppose this is another trial,' you think to yourself, and, gripping\nyour club, walk into the gaping mouth of the cave.\n");
		pressEnter();
		topLine(3, "Pain");
		Cave pain = new Cave();
		Room current = pain.getStartingRoom();
		boolean isOver = false;
		while (isOver == false) {
			System.out.print(current);
			System.out.println("[Q]uit.");
			String choice = input.next();
			Room next = null;
			switch( choice.toLowerCase() )
			{
				case "n": next = current.getNorth(); break;
				case "e": next = current.getEast();  break;
				case "w": next = current.getWest();  break;
				case "s": next = current.getSouth(); break;
				case "q": end();                     break;
				default: System.out.println("invalid command.");
			}
			if (next != null) {
				current = next;
				current.beenThere();
				if (current.equals(pain.exitroom)) {
					isOver = true;
					continue;
				}
				else if (!current.equals(pain.room2))
					current.enemy = chanceBoolean();
				if (current.enemy == true) {
					int m = r.nextInt(3);
					miles.attack(Monster.spawn(m));
					current.enemy = false;
				}
			}
			clearScreen();
			topLine(3, "Pain");
			if ( miles.health <= 0) {
				System.out.println("\nYour wounds have become so great that you fall to the ground,\nunconscious. You wake up in your quarters, your friend Worf standing\nover you.\n\n\"Rest now, my friend. You have pushed yourself a bit too far. I should\nhave known that these trials would be too much for humans. Do not feel\nashamed, however. The fact that you did not give up has proven your\ndedication, and your honor. I thank you. Now, please rest until the\nwedding.\"\n\nHe leaves you there and you drift off to sleep.\n");
				miles.honor += 20;
				pressEnter();
				wedding();
			}	
		}
		clearScreen();
		topLine(3, "Pain");
		trials++;
		System.out.println("\nAs you exit the cave, Worf is standing there, waiting for you.\n\n\"There you are, Miles. You have made it through the Trial of Pain with\nbravery... and a few battle wounds, I see. You bring honor to yourself\nand to me. Now, let us return to the fire to rest.\"\n");
		miles.honor += 10;
		pressEnter();
	}
	public static void dayThree() { // This method contains a map with puzzles/choices. It uses the Room class again, but the rooms are defined in the Maze class this time.
		System.out.println("                                DAY THREE\n\nYou wake up, your head spinning. The heat and the hunger are getting to\nyou badly, and you almost forget that you're in a holosuite. Worf lifts\nyou to your feet.\n\n\"The next trial is one of the mind and heart. This next cave is \033[3mChIm\nGhIt\033[0m, the 'Empty Hand', or a holographic reproduction of it. The\ncrystals within have a peculiar property of enhancing certain brain\npatterns. You may hallucinate many things. You must let your heart and\nmind guide you. This is the trial of 'Sacrifice'.\n\nAs he spoke, the words \"heart\", \"mind\", and \"empty\" echoed in your head,\ncausing your thoughts to be influenced by them.\n");
		pressEnter();
		topLine(4, "Sacrifice");
		Maze sacrifice = new Maze();
		Room current = sacrifice.getStartingRoom();
		boolean isOver = false;
		boolean[] friends = new boolean[2];
		boolean[] family = new boolean[3];

		while (isOver == false)
		{
			
			System.out.print(current);
			System.out.println("Sea[R]ch/Interact");
			System.out.println("[Q]uit.");
			String choice = null;
			choice = input.next();
			
			// This next series of ifs handle all the rooms with special items and events
			if (current.equals(sacrifice.room4) && choice.equals("r"))
				friends[0] = true;
			if (current.equals(sacrifice.room5) && choice.equals("r"))
				friends[1] = true;
			if (current.equals(sacrifice.room8) && choice.equals("r"))
				family[0] = true;
			if (current.equals(sacrifice.room9) && choice.equals("r"))
				family[1] = true;
			if (current.equals(sacrifice.room10) && choice.equals("r"))
				family[2] = true;
			
			if (current.equals(sacrifice.room2) && choice.equals("e")) {
				clearScreen();
				topLine(4, "Sacrifice");
				miles.honor += 10;
				System.out.println("\nYou dash towards Engineering, already trying to analyze what the problem\nmight be. The moment you pass through the door, though, you watch as the\nroom explodes, killing everyone within. Before you could even raise your\narms to shield your eyes, the scene is gone and you are in another room.\n");
				pressEnter();
			}
			if (current.equals(sacrifice.room6) && choice.equals("w")) {
				clearScreen();
				topLine(4, "Sacrifice");
				miles.honor += 10;
				System.out.println("\nYou grip your \033[3mma'staka\033[0m and run through the door yelling, \"Get the hell\naway from my friends, you bastards!\"\n\nYou are too late, however, and you watch as Borg implants burst out of\nyour friends' skin. Then the scene disappears and you are in a new room.\n");
				pressEnter();
			}
			if (current.equals(sacrifice.room12) && choice.equals("e")) {
				clearScreen();
				topLine(4, "Sacrifice");
				miles.honor += 10;
				System.out.println("\n\"I'm coming!\" you yell as you run in to save your family from whatever\nhorror lurks in the shadows of that room. Just as you cross the\nthreshold you watch as they are gripped by some \"thing\" and are pulled\ninto the shadows at the far end of the room. They scream, you hear a\nloud \"crunch\", and then the room is silent.\n");
				pressEnter();
			}
			if (current.equals(sacrifice.room2) && choice.equals("w")) {
				clearScreen();
				topLine(4, "Sacrifice");
				miles.honor -= 5;
				miles.health -= 5;
				wrong++;
				System.out.println("\nThe passageway you just came through shuts behind you, leaving you in a\nquiet, empty room. You feel something slice across the back of your\nright hand, leaving a thin line of blood.\n");
				pressEnter();
			}
			if (current.equals(sacrifice.room6) && choice.equals("n")) {
				clearScreen();
				topLine(4, "Sacrifice");
				miles.honor -= 5;
				miles.health -= 5;
				wrong++;
				System.out.println("\nThe passageway you just came through shuts behind you, leaving you in a\ndark, empty room. You feel something slice across the back of your right\nhand, leaving a thin line of blood.\n");
				pressEnter();
			}
			if (current.equals(sacrifice.room12) && choice.equals("n")) {
				clearScreen();
				topLine(4, "Sacrifice");
				miles.honor -= 5;
				miles.health -= 5;
				wrong++;
				System.out.println("\nThe passageway you just came through shuts behind you, leaving you in an\nempty room. You feel something slice across the back of your right hand,\nleaving a thin line of blood.\n");
				pressEnter();
			}
			if (current.equals(sacrifice.room15) && choice.equals("r") && friends[0] == true && friends[1] == true) {
				current.loot = "You put the two pieces together. The two protrusions link together like\nhands clasping and the object fuses into one shape with an image of two\nmen shaking hands. On the pedestal and the words change before your\neyes. They now read:\n\n" + Maze.glyph + "\n\n\"Hmm... sounds like friendship to me,\" you muse. And immediately the\nroom changes.\n";
				clearScreen();
				topLine(4, "Sacrifice");
				current.search();
				current = sacrifice.room6;
				current.beenThere();
				topLine(4, "Sacrifice");
				continue;
			
			}
			if (current.equals(sacrifice.room11) && choice.equals("r") && family[0] == true && family[1] == true && family[2] == true) {
				current.loot = "You place the three figures in the depressions and watch as they sink\ninto the pedestal. Suddenly, it is gone and you are in a new room.\n";
				clearScreen();
				topLine(4, "Sacrifice");
				current.search();
				current = sacrifice.room12;
				current.beenThere();
				topLine(4, "Sacrifice");
				continue;
			}
			
			Room next = null;
			switch( choice.toLowerCase() )
			{
				case "n": next = current.getNorth(); break;
				case "e": next = current.getEast();  break;
				case "w": next = current.getWest();  break;
				case "s": next = current.getSouth(); break;
				case "r": current.search();          break;
				case "q": end();                     break;
				default: System.out.println("invalid command.");
			}
			if (next != null) {
				current = next;
				current.beenThere();
				if (current.equals(sacrifice.exitroom)) {
					isOver = true;
					continue;
				}
			}
			if (current.equals(sacrifice.room14))
				sacrifice.exitroom.name = sacrifice.exitroom.actual;
			
			clearScreen();
			if ( miles.health <= 0) {
				topLine(4, "Sacrifice");
				System.out.println("\nYour wounds have become so great that you fall to the ground,\nunconscious. You wake up in your quarters, your friend Worf standing\nover you.\n\n\"Rest now, my friend. You have pushed yourself a bit too far. I should\nhave known that these trials would be too much for humans. Do not feel\nashamed, however. The fact that you did not give up has proven your\ndedication, and your honor. I thank you. Now, please rest until the\nwedding.\"\n\nHe leaves you there and you drift off to sleep.\n");
				miles.honor += 10;
				pressEnter();
				wedding();
			}
			topLine(4, "Sacrifice");	
		}
		clearScreen();
		topLine(4, "Sacrifice");
		trials += 2;
		System.out.println("\nYou come to the end of the cave system, feeling shaken by what you've\nseen inside. Worf approaches you and looks at your hand.\n");
		if (wrong > 0)
			System.out.println("\"Hmmm... The crystals in this cave enhance those thoughts you carry\nwhich belong to the ideas of duty, fellowship, and family; three of the\nmost important and revered concepts to Klingon society. I see from your\nhand that at some point you chose to deny the visions which represented\nthese ideas for the sake of continuing this ritual. While you may have\nthought that you should sacrifice them for my sake, this was... wrong.\nThis ritual, while important, is not as important as those, and you\nshould have chosen them. The shame you must feel at having walked away\nfrom the suffering of your loved ones will serve as the fifth trial,\n'Anguish'. Hopefully your shame will guide you to consider those things\nmore in the future. Come, let us return to the fire to rest.\"\n");
		else
			System.out.println("\"The crystals in this cave system somehow enhance the the thoughts you\ncarry which concern duty, fellowship, and family. I know that you chose\neach time to leave the cave to protect them. This was the honorable\nchoice. I also know that the crystals then made you see them torn away\nfrom you somehow. This is the fifth trial, 'Anguish'. It serves to make\nus feel what it would be like to lose these things, therefore increasing\nour desire to protect them. I am sorry you had to go through this, but\nyou have performed admirably. Come, let us return to the fire.\"\n");
		pressEnter();
	}
	public static void dayFour() { // This method is the final battle with just one final boss enemy.
		System.out.println("                                DAY FOUR\n\nYou are suddenly jarred out of sleep by the heavy collision of a\n\033[3mbat'leth\033[0m with the ground less than an inch from your head. \"Wake up, you\npathetic human and face me!\" a figure growls fiercely. You jump up and\nand clear your eyes a bit to get a better look at this man, but you\ndon't recognize him right away.\n\n\"Who the hell are you?\" you demand.\n\n\"Do you not recognize me, one who walks the Path of Clarity? I am\nKahless! Grab your weapon and prepare for battle!\"\n\n'Kahless?! The great Klingon warrior-hero? I don't stand a chance\nagainst him,' you worry to yourself. 'Should I fight him or should I try\nto run away?' You grab your \033[3mma'staka\033[0m and get ready...\n");
		pressEnter();
		topLine(6, "Death");
		miles.attackKahless(Monster.spawn(3));
	}
	public static void wedding() { // Worf gets married. Your honor score determines your ending.
		System.out.println("                         DAY FIVE:  THE WEDDING\n");
		if (miles.honor > 80) {
			if (miles.honor > 120) {
				System.out.println("Finally, the day of the wedding has come. You and the other groomsmen\nfeel as though you've been through a war, but the mutual suffering\nyou've all been through brings you closer together. Worf pulls you aside\nbefore the wedding.\n\n\"I am extremely impressed with the way you conducted yourself during the\ntrials. Miles Edward O'Brien, after this wedding would you do me the\nhonor of taking part in \033[3mR'uustai\033[0m with me? Performing this ritual with\nbond us as brothers in blood and my life will forever be tied to yours.\"\n\n\"Another ritual?\" you ask, hesitating for a moment. Then, looking at the\nserious face of your friend, you respond, \"It would be my honor.\"\n\nHe smiles, and returns to the preparations.\n");
				pressEnter();
				System.out.println("                         DAY FIVE:  THE WEDDING\n");
				
			}
			System.out.println("The excitement in the room is palpable as you wait with everyone else\nfor the wedding to begin. The ceremony is different than what you're\nused to, but beautiful in its own way, presided over by Worf's adopted\nmother, Sirella. You and Julian wait at the side for the time to come\nfor you to perform the ritual attack on the newlyweds. You can tell the\nceremony is coming to the end.\n\n\"...then let all who are present here today know that this man and this\nwoman are married.\" recites Sirella. Worf and Jadzia kiss.\n\n\"Now?\" you ask Martok. \"Not yet.\" he replies.\n\nWorf turns to kiss his adopted mother...\n\n\"Now?\" you ask again, anxious. \"Patience.\" says Martok.\n\nJadzia kisses her new mother-in-law...\n\n\"Now?\" you ask, impatiently. \"Now\", Martok nods.\n\nYou and Julian raise your \033[3mma'staka\033[0m in the air, and with a scream, charge\nat the newly married couple...\n\n                                THE END\n");
		}
		else if (miles.honor > 40)
			System.out.println("While everyone prepares for the wedding, Worf approaches you. \"Though\nyou did make it through the trials, you showed a lack of honor in many\nareas. In that light I have asked Captain Sisko to perform the ritual\nattack instead of you. You have a lot to learn about living honorably,\nmy friend.\"\n\nYou watch the wedding ceremony with interest, but you feel a wave of\nshame when it comes time for the ritual attack. You decide the best\ncourse of action now is to eat, and spend the rest of the party doing\njust that.\n\n                                THE END\n\n");
		else 
			System.out.println("You enter the room where everyone is preparing for the wedding. Worf\nsees you enter and stops you at the door. \"Chief, I have something to\nsay to you. Seeing the dishonorable way you behaved throughout the\ntrials has given me second thoughts about allowing you to participate in\nmy wedding. In fact, it's giving me second thoughts about our \nfriendship.\"\n\n\"But...\" you begin to say, but he stops you and asks you to leave. You\nreturn to your quarters and lay you head in your hands...\n\n                                THE END\n\n");
		pressEnter();
		end();
	}
	public static void clearScreen() { // This method is just one line, but makes it clearer to any other readers what is happening when this line is run.
    	System.out.print("\033[H\033[2J");
	}
	public static void pressEnter() { // This method prompts the user to press Enter before continuing to the next screen.
		System.out.print("Press Enter to continue:");
		try {
			System.in.read();
		}catch(Exception e) {
			
		}
		clearScreen();
	}
	public static void topLine(int trial, String name) { //This method just provides a top line which will display the Trial number and name, and the player character's health.
		System.out.printf("Trial %d: '%s'%nHealth: %d%n", trial, name, miles.health);
	}
	public static boolean chanceBoolean() { // 3 in 10 chance of returning true, meaning a monster appears
		Random i = new Random();
		int j = i.nextInt(10);
		if (j > 6)
			return true;
		else
			return false;
	}
	public static void temptation(int day) { // Every day ends with this method, which will test the character's resolve
		System.out.println("Day " + day + " End:\nHealth: " + miles.health + "\n\nYou return to the fire room where your friends are already settling down\nfor the night. Your belly rumbles and your eyes gravitate towards the\nbanquet against the wall. You feel that if you could just sneak a few\nbites, you may feel better in the morning.\n\n1 - Try to sneak some food.\n2 - Drink some water and sleep.\n3 - Sing a Klingon song of fellowship.");
		int choice = input.nextInt();
		if (choice == 1) {
			clearScreen();
			System.out.println("Day " + day + " End:\nHealth: " + miles.health + "\n\nBelieving everyone to be asleep, you sneak over to the table of food.\nCrawling across the ground like a snake, you reach up and grab the first\nmorsel you can reach and hungrily shove it into your mouth.\n\n\"Shame on you, Miles.\" you hear in Worf's deep bass voice. \"You shame\nyourself and me by doing this. You have failed the Trial of Deprivation\nand I must now ask you to leave us. You are no longer invited to share\nin this honor.\"\n\nYou beg him to let you stay but to no avail. You leave the holosuite and\nhead back to your quarters alone. The wedding comes and you stand in the\nback, watching your friends participate in the rituals. Maybe someday\nyou'll be able to repair your reputation with Worf and the others, but\nit's going to take time and effort.\n\n                                THE END\n\n");
			miles.honor = 0;
			pressEnter();
			end();
		}
		else if (choice == 2) {
			System.out.println("\nNo food for those on the path to \033[3mKal'Hyah\033[0m.\n");
			miles.honor += 5;
			hunger();
			pressEnter();
		}
		else if (choice == 3) {
			clearScreen();
			System.out.println("Day " + day + " End:\nHealth: " + miles.health + "\n\nYou rouse up your friends and start singing the Klingon song you learned\nfor the occasion.\n\n" + sing());
			miles.health += (5 - miles.health/20);
			miles.honor += 10;
			pressEnter();
		}
		else
			temptation(day);
	}
	public static void hunger() { //This method is run when you decide not to eat at the end of each day. It lowers health by 1/10 the player's current health, rounded down. 
		miles.health -= 10 - (miles.health / 10);
		if (miles.health < 0)
			miles.health = 0;
		System.out.println("Your hunger eats at your empty belly. HP: " + miles.health);
		if (miles.health == 0) {
			System.out.println("\nYou pass out from hunger and can no longer follow the Path to Clarity.");
			
		}
	}
	public static String sing() { // A Klingon song of fellowship.
		String song = "\033[3m                            Ka vek ko lee ko\n                            Eh to che mah lo\n                 Tah oo-wah kah esh to pah deh ah reee!\n                       Yah bosh-ah!  Yah bosh-ah!\n                            Yah bosh tomah!\033[0m\n\nSinging makes you feel a bit better somehow. Worf and Martok clap you on\nthe shoulders, saying \"Well sung, O'Brien. You would've made a fine\nKlingon!\"\n\nThe heat wraps you like a blanket, and you drift off to sleep, wondering\nwhat trials remain.\n";
		songs++;
		return song;
	}
	public static void end() { // This method quits the game at any time, and will display final stats.
		clearScreen();
		System.out.println("                          The Path of Clarity\n\n\nName: Miles O'Brien\n\nHonor: " + miles.honor + "\n\nWounds taken: " + wounds + "\n\nBeasts killed: " + beasts + "\n\nSongs sung: " + songs + "\n\nTrials passed: " + trials + "\n\n");
		System.exit(0);
	}
}