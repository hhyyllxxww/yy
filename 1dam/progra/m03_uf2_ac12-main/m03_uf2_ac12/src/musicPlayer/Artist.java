package musicPlayer;


public class Artist {

	private int id;
	private String name;
	private String image;
	private String info;

	private static int countId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public static int getCountId() {
		return countId;
	}

	public static void setCountId(int countId) {
		Artist.countId = countId;
	}

	public int getId() {
		return id;
	}

	public Artist(String name, String image, String info) {
		this.id = initId();
		this.name = name;
		this.image = image;
		this.info = info;
	}

	public int initId() {
		return countId++;
	}
	@Override
	public String toString() {
		return "Artist{" +
				"id=" + id +
				", name='" + name + '\'' +
				", image='" + image + '\'' +
				", info='" + info + '\'' +
				'}';
	}
}
