
public class Broker extends Person {
	private String secID;
	
	public Broker(String id, String firstName, String lastName, String street, String city, String state, String zipCode, String country, String[] emailAddress, String secID) {
		super(id, firstName, lastName, street, city, state, zipCode, country, emailAddress);
		this.secID = secID;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("*****************Broker***************** \n");
		sb.append("ID: " + getId() + " \n");
		sb.append("First name: " + getFirstName() + " \n");
		sb.append("Last name: " + getLastName() + " \n");
		sb.append("Street: " + getStreet() + " \n");
		sb.append("City: " + getCity() + " \n");
		sb.append("State: " + getState() + " \n");
		sb.append("Zipcode: " + getZipCode() + " \n");
		sb.append("Country: " + getCountry() + " \n");
		String[] email = getEmailAddress();
		for (int i = 0; i < email.length; i++) {
			sb.append("Email Address " + (i+1) + ": " + email[i] + " \n");
		}
		sb.append("Sec ID: " + getSecID() + " \n");
		
		return sb.toString();
	}
	
	public boolean isBroker() {
		return true;
	}
	
	// this will be either E or J
	private String position;
	
	public String getSecID() {
		return secID;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	
	
	

}
