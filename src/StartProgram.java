import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

import Controller.MusicHelper;
import Model.Music;


/**
 * @author - Aaron Barker
 * CIS175 - Fall 2021
 * Sep 14, 2021
 */


public class StartProgram {
	
// OBJECT CREATION
	static Scanner userInput = new Scanner(System.in);
	static MusicHelper mh = new MusicHelper();

	
// GLOBAL DECLARATIONS
	static String title = "";
	static String artist = "";
	static String selection = "X";
	
	public static void main(String[] args) {
		

	// INTRO
		System.out.println("\r\n***  Thank you for using Song List Creator  ***");
		
	// USER SELECTION LOOP
		do{
			System.out.println("\r\nEnter 'A' (to add song), 'D' (to delete song), 'E' (to edit song), 'V' (to view song list), 'X' (to exit)");
			System.out.print("Selection: ");
			selection = userInput.nextLine();
			
			
		// METHOD/PERSISTENCE DIRECTORY BASED ON 'selection'
			if(selection.equalsIgnoreCase("A")) {
				addSong();
				String msg = MessageFormat.format("\r\nThe song ''{0}'' was added to your song list.", title);
				System.out.println(msg);
			}else if(selection.equalsIgnoreCase("D")) {
				deleteSong();
				String msg = MessageFormat.format("\r\nThe song ''{0}'' was removed from your song list.", title);
				System.out.println(msg);
			}else if(selection.equalsIgnoreCase("V")) {
				viewSongs();
				//String msg = MessageFormat.format("\r\nThe song ''{0}'' was removed from your song list.", title);
				//System.out.println(msg);
			}else if(selection.equalsIgnoreCase("X")) {
				System.out.println("\r\n***  Thank you for using Song List Creator  ***");
			}else {
				System.out.println("\r\n***  Invalid entry. Thank you for using Song List Creator  ***");
				System.exit(0);
			}
		}while(!selection.equalsIgnoreCase("X") & !selection.equalsIgnoreCase(""));
	}
	
	
// PERSISTENCE METHOD CALLS TO 'MusicHelper'
	private static void addSong() {  // add song and artist to 'songlist' table
		
		System.out.print("Enter a artist: ");
		artist = userInput.nextLine();
		System.out.print("Enter a title: ");
		title = userInput.nextLine();
		
		Music toAdd = new Music(artist, title);
		mh.insertSong(toAdd);
	}
	
	private static void deleteSong() {  // remove song from 'songlist' table
		

		System.out.print("Enter the song to be removed from the playlist: ");
		title = userInput.nextLine();
		System.out.print("Enter that song's artist: ");
		artist = userInput.nextLine();
		
		Music toDelete = new Music(title, artist);
		mh.deleteSong(toDelete);
	}
	
	private static void viewSongs() {  // view current song list
		
		System.out.println("\r\nCurrent song list:");
		
		List<Music> allItems = mh.showSongs();
		for(Music singleItem: allItems){
		System.out.println(singleItem.songDetails());
		}

	}
}











