package movie.rental.titles;

public class LiveConcert extends Title {

	public LiveConcert(String name) {
		super(name);
	}
	
	public LiveConcert(String name, String genre, int year, int duration) {
		super(duration, name, genre, genre, year, genre, duration, duration);
	}

}
