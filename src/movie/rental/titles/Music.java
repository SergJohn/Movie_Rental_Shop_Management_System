package movie.rental.titles;

public class Music extends Title {
	
	private String band;

	// Constructors
	public Music(String name) {
		super(name);
	}
	
	public Music(String name, String genre, int year, int duration, String band) {
		super(name, genre, year, duration);
		this.band = band;
	}
	
	public Music(String name, String band) {
		super(name);
		this.band = band;
	}

}
