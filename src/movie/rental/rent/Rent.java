package movie.rental.rent;

import movie.rental.customers.Customer;
import movie.rental.titles.Title;

public class Rent {
	
	private String rentDate;
	private String returnDate;
	private Customer customerName;
	private Title titleName;
	
	public Rent(String rentDate, String returnDate, Customer customerName, Title titleName) {
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.customerName = customerName;
		this.titleName = titleName;
	}
	
	public Rent(Customer customerName, Title titleName, String rentDate) {
		this.customerName = customerName;
		this.titleName = titleName;
		this.rentDate = rentDate;
		returnDate = rentDate + 3;
		
	}

}
