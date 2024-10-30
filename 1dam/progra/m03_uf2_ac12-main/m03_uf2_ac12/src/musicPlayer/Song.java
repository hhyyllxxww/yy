package musicPlayer;


public class Song {

	private int id;
	private String title;
	private float duration;
	private short year;
	private Artist artist;
	private String producer;
	private Sound sound;
	private String image;
	private String lyrics;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public String producer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public Sound getSound() {
		return sound;
	}
	public void setSound(Sound sound) {
		this.sound = sound;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public Song(int id, String title, float duration, short year, Artist artist, String producer, Sound sound, String image, String lyrics) {
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.year = year;
		this.artist = artist;
		this.producer = producer;
		this.sound = sound;
		this.image = image;
		this.lyrics = lyrics;
	}
	@Override
	public String toString() {
		return String.format("%-5d%-45s%-10.2f%-10d%-31s", this.id, this.title, this.duration, this.year,
				this.producer);
		//Please Please Please Let Me Get What I Want
	}
}
