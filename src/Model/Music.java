package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author - Aaron Barker
 * CIS175 - Fall 2021
 * Sep 13, 2021
 */


@Entity
@Table(name = "songlist")
public class Music {

// DECLARATIONS
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private String id;
	@Column(name = "ARTIST")
	private String artist;
	@Column(name = "TITLE")
	private String title;

// GETTERS AND SETTERS
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
// CONSTRUCTORS
	public Music() {
		super();
	}
	
	public Music(String title, String artist) {
		super();
		this.artist = artist;
		this.title = title;
	}
	
// METHODS
	public String songDetails() {
		return("Song: {}  Artist: {}").format(this.title, this.artist);
	}
	
}
