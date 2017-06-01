
public class Client extends Person {

	public Client(String id, String firstName, String lastName, String street, String city, String state,
			String zipCode, String country, String[] emailAddress) {
		super(id, firstName, lastName, street, city, state, zipCode, country, emailAddress);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("*****************Client***************** \n");
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
		return sb.toString();
	}
	
	public boolean isBroker() {
		return false;
	}
	
}
