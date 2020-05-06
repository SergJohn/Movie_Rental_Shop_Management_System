package movie.rental.titles;

public class TVBox extends Title {

	public TVBox(String name) {
		super(name);
	}
	
	public TVBox(String name, String genre, int year, int duration) {
		super(duration, name, genre, genre, year, genre, duration, duration);
	}

}
