package movie.rental.titles;

public abstract class Title {
	
	protected String name;
	protected int year;
	protected String genre;
	protected int duration;
	protected boolean available;
	
	// Constructor
	public Title(String name) {
		this.name = name;
	}
	
	public Title(String name, String genre, int year, int duration) {
		this.name = name;
		this.genre = genre;
		this.year = year;
		this.duration = duration;
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
