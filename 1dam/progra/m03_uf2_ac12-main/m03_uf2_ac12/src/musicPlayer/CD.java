package musicPlayer;
import java.util.List;

public class CD {
	
	private int id;
	private String name;
	private List<Song> songs;
	private String image;

	private static int countId = 1;

	public CD(String name, List<Song> songs, String image) {
		this.id = initId();
		this.name = name;
		this.songs = songs;
		this.image = image;
	}

	public int initId() {
		return countId++;
	}

	public String toString() {
		return id + ": " + name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static int getCountId() {
		return countId;
	}

	public static void setCountId(int countId) {
		CD.countId = countId;
	}

}
