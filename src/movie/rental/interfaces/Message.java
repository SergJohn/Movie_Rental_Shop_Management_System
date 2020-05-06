package movie.rental.interfaces;

public interface Message {

	public void addMessage();
	
	public void errorMessage();
	
	public void freeRentAllowed();
	
	public void limitRental();
	
	public void titleAlreadyTaken();
}
