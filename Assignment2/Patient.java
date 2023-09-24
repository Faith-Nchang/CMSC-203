/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This class is blue print of a patient object
 * Due: 09/25/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Faith Nchang
*/

public class Patient
{
	// fields of the Patient class
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;	
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String emmergencyName;
	private String emmergencyContact;
	
	// no - argument constructor
	public Patient()
	{
		firstName  = " ";
		middleName = " ";
		lastName = " ";
	    streetAddress = "";
	    city = "";
		state ="";
		zipCode = "";
		phoneNumber = "";
 		emmergencyName ="";
	    emmergencyContact = ""; 
	}
	
	/**
	  constructor that receives 3 arguments
	  @param fName - first name of patient
	  @param mName - last name of patient
	  @param lName - last name of patient
	*/
	public Patient(String fName, String mName, String lName)
	{
		firstName = fName;
		middleName = mName;
		lastName = lName;
	}
	
	/*
	 constructor that receives parameters for all the field
	*/
	public Patient(String fName, String mName, String lName, String sAddress, String pCity, String pState, 
	String zip, String pNum, String emName, String emPhoneNum)
	{
		// assigns each parameter to the corresponding field
		firstName = fName;
		middleName = mName;
		lastName = lName;
		streetAddress = sAddress;
		city = pCity;
		state = pState;
		zipCode = zip;
		phoneNumber = pNum;
		emmergencyName = emName;
		emmergencyContact = emPhoneNum;
	}
	
	   //accessors
	/**
		accessor method for the firstName field
		@return first Name
	*/
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
		accessor method for the middle name field
		@return middle Name
	*/
	public String getMidlleName()
	{
		return middleName;
	}
	
	/**
		accessor method for the lastName field
		@return last Name
	*/
	public String getLastName()
	{
		return lastName;
	}
	
	/**
		accessor method for the streetAddress field
		@return street address
	*/
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	
	/**
		accessor method for the city field
		@return city
	*/
	public String getCity()
	{
		return city;
	}
	
	/**
		accessor method for the state field
		@return state Name
	*/
	public String getState()
	{
		return state;
	}
	
	/**
		accessor method for the zipCode field
		@return zip code
	*/
	public String getZipCode()
	{
		return zipCode;
	}
	
	/**
		accessor method for the phoneNumber field
		@return phone number
	*/
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
		accessor method for the emmergencyName field
		@return emmergency Name
	*/
	public String getEmmergencyName()
	{
		return emmergencyName;
	}
	
	/**
		accessor method for the emmergencyContact field
		@return emmergency contact
	*/
	public String getEmmergencyContact()
	{
		return emmergencyContact;
	}
	
		// MUTATORS
	
	//mutator for the firstName
	public void setFirstName(String fName)
	{
		firstName = fName;
	}
	
	//mutator for the middle name
	public void setMiddleName(String mName)
	{
		middleName = mName;
	}
	
	//mutator for the last name
	public void setLastName(String lName)
	{
		lastName = lName;
	}
	
	//mutator for the street address
	public void setStreetAddress(String strAddr)
	{
		streetAddress = strAddr;
	}
	
	//mutator for the city
	public void setCity(String scity)
	{
		city = scity;
	}
	
	//mutator for the state
	public void setState(String pstate)
	{
		state = pstate;
	}
	
	//mutator for the zip code
	public void setZipCode(String zip)
	{
		zipCode = zip;
	}
	
	//mutator for the phone number
	public void setPhoneNumber(String phoneNum)
	{
		phoneNumber = phoneNum;
	}
	
	//mutator for the emmergency name
	public void setEmmergencyName(String emmName)
	{
		emmergencyName = emmName;
	}
	
	//mutator for the emmergency contact
	public void setEmmergencyContact(String emmContact)
	{
		emmergencyContact = emmContact;
	}
	
	
	/**
		concatenates the first, middle, and last name
		@return full name 
	*/
	public String buildFullName()
	{
		String fullName;
		fullName = firstName + " " + middleName + " " + lastName;
		return fullName;
	}
	
	/**
	* concatenates the address, city, state, and zip code
	*	@return full Address
	*/
	public String buildAddress()
	{
	  String fullAddress;
	  fullAddress = streetAddress + " " + city + " " + state + " " + zipCode;
	  return fullAddress;
	}
	
	
	/**
		concatenates the emmergencyName and emmergencyContact
		@return full emergency contact
	*/
	public String buildEmergencyContact()
	{
		return emmergencyName + " " + emmergencyContact;
	}
	
	
	/**
	 * this method displays all the information of a patient
	*/
	public String toString()
	{
		String patientInformation = "\nPatient info: "
				+ "\n  Name: " +buildFullName()+ " "
				+ "\n  Phone number: "+ phoneNumber + "\n "
				+ " Address: " +buildAddress()+ " " 
				+ "\n  EmergencyContact: "+buildEmergencyContact() +"\n";
		return patientInformation;
	}
}