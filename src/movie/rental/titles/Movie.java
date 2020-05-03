package movie.rental.titles;

public class Movie extends Title {
	
	private String director;

	// Constructors
	public Movie(String name) {
		super(name);
	}
	
	public Movie(String name, String genre, int year, int duration, String director) {
		super(name, genre, year, duration);
		this.director = director;
	}
	
	// Director's getter and setter
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getDirector() {
		return this.director;
	}

}
