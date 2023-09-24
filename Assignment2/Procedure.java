/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This class is a blue print of the procedure a patient can perform
 * Due: 09/25/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Faith Nchang
*/

public class Procedure
{
	private String procedureName; // stores the name of the procedure
	private String dateOfProcedure; // stores the date of the procedure
	private String practitionerName; // stores the name of the practitioner who performed the procedure
	private double costOfProcedure; // stores the charge of the procedure
	
	// no - arg constructor
	public Procedure()
	{
		procedureName = "";
		dateOfProcedure = "";
		practitionerName = "";
		costOfProcedure = 0.0;
	}
	
	/**
		constructor with 2 parameters
		@param pName - procedure name
		@param date - procedure date
	*/
	public Procedure(String pName, String date)
	{
		procedureName = pName;
		dateOfProcedure = date;
	}
	
	/**
		constructor that receives all the attributes as parameters
	*/
	public Procedure(String pName, String date, String practName, double cost)
	{
		procedureName = pName;
		dateOfProcedure = date;
		practitionerName = practName;
		costOfProcedure = cost;
	}
	
	// ACCESSORS
	// accessors for procedureName
	public String getProcedureName()
	{
		return procedureName;
	}
	
	//accessors for date of procedure
	public String getDateOfProcedure()
	{
		return dateOfProcedure;
	}
	
	// accessors for practitioner name
	public String getPractitionerName()
	{
		return practitionerName;
	}
	
	//accessors for cost of procedure
	public double getCostOfProcedure()
	{
		return costOfProcedure;
	}
	
	//   MUTATORS
	//mutators for the procedureName
	public void setProcedureName(String name)
	{
		procedureName = name;
	}
	
	//mutator for the dateOfProcedure
	public void setDateOfProcedure(String date)
	{
		dateOfProcedure = date;
	}
	
	
	
	
	//mutator for the practitionerName
	public void setPractionerName(String practName)
	{
		practitionerName = practName;
	}
	
	// mutator for the costOfProcedure
	public void setCostOfProcedure(double cost)
	{	
		costOfProcedure = cost;
	}
	
	/**
	 * displays all the fields of the Procedure(name, date, practioner, and charge)
	 */
	public String toString()
	{
		String procedureInfo = "\n\tProcedure: "+procedureName+"\n"
				+ "\tProcedure Date = "+dateOfProcedure+"\n"
				+ "\tPractitioner = " +practitionerName+ "\n"
				+ "\tCharges: "+costOfProcedure+"\n";
		return procedureInfo;
	}
}