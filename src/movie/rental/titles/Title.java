package movie.rental.titles;

public abstract class Title {
	
	protected int id;
	protected String name;
	protected String director;
	protected String genre;
	protected int duration;
	protected String media;
	protected int year;
	protected int membership;	
	protected boolean available;
	
	// Constructor
	public Title(String name) {
		this.name = name;
	}
	
	public Title(int id, String name, String director, String genre, int duration, String media, int year, int membership) {
		this.id = id;
		this.name = name;
		this.director = director;
		this.genre = genre;
		this.duration = duration;
		this.media = media;
		this.year = year;
		this.membership = membership;
		available = false;
		
	}
	
	// getters and setters
	
	// Name getter and setter
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	// Year getter and setter
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return this.year;
	}
	
	// Genre getter and setter
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	// Duration getter and setter
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	// Methods
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean isAvailable() {
		return this.available;
	}

}
