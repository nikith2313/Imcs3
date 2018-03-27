package passenger.Bean;

public class Passenger {
	
	private int profileId;
	
	private String firstName;
	
	private String lastName;
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTelePhoneno(long telePhoneno) {
		this.telePhoneno = telePhoneno;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	private String address;
	private String password;
	private long telePhoneno;
	private String emailId;
	public Passenger() {

	}
	public int getProfileId() {
		return profileId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	public long getTelePhoneno() {
		return telePhoneno;
	}
	public String getEmailId() {
		return emailId;
	}
	
}
