package movie.rental.customers;

import movie.rental.main.Model;

public class Customer {

	private String name;
	private int phone;
	private String email;
	private String address;
	SubscriptionType subsc;
	public int points;
		
	public Customer(String name, int phone, String email, String address, SubscriptionType subsc) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.subsc = subsc;
		points = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public int getPhone() {
		return this.phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
