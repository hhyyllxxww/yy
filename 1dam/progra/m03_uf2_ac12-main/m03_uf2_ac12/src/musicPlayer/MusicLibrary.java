package musicPlayer;


import java.util.List;


public class MusicLibrary {

	String name;
	List<CD> cds;

	public MusicLibrary(String name, List<CD> cds) {
		this.name = name;
		this.cds = cds;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<CD> getCds() {
		return cds;
	}



	public void setCds(List<CD> cds) {
		this.cds = cds;
	}



	@Override
	public String toString() {
		return "MusicLibrary{" +
				"name='" + name + '\'' +
				", cds=" + cds +
				'}';
	}
}
