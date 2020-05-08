package movie.rental.interfaces;

/**
 * @author mrosa
 * 
 * Interface created to provide the method signatures to make messages
 * 
 * */
public interface Message {

	public void addMessage();
	
	public void errorMessage();
	
	public void freeRentAllowed();
	
	public void limitRental();
	
	public void titleAlreadyTaken();
}
