/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This class creates an instance of the Patient class with sample data, and creates 3 
				instances of the Procedure class
 * Due: 09/25/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Faith Nchang
*/
import java.util.Scanner;

public class PatientDriverApp 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String firstName, // patient's first name
				middleName, //patient's middle Name
				lastName, // patient's last name
				address, // patient's address
				city, 
				state,
				zipCode,
				phoneNum,
				emergencyName,
				emergencyNum;
		//prompts the user for their first name
		System.out.print("Enter your First Name: ");
		firstName = sc.nextLine();
		
		// prompts the user for their middle name
		System.out.print("Enter your middle Name: ");
		middleName = sc.nextLine();
		
		// prompts the user for their last name
		System.out.print("Enter your last name: ");
		lastName = sc.nextLine();
		
		// prompts the user for their address
		System.out.print("Enter your address: ");
		address = sc.nextLine();
		
		// prompts the user for the city
		System.out.print("Enter the city: ");
		city = sc.nextLine();
		
		// prompts the user for the state
		System.out.print("Enter your state: ");
		state = sc.nextLine();
		
		// prompts the user for their zip code
		System.out.print("Enter your zip code: ");
		zipCode = sc.nextLine();
		
		//prompts the user for their phone number
		System.out.print("Enter your phone number(e.g 234-345-4567): ");
		phoneNum = sc.nextLine();
		
		//prompts the user for their emmergency name
		System.out.print("Enter your emergency name: ");
		emergencyName= sc.nextLine();
		
		//prompts the user for their emergency phone number
		System.out.print("Enter your emergency phone number: ");
		emergencyNum = sc.nextLine();
		
		// creates a patient class instance from the Patient class
		Patient patient1 = new Patient(firstName, middleName, lastName, address, city, state,
										zipCode, phoneNum, emergencyName, emergencyNum);
		
		// variables for the first procedure object
		String procedure1Name = "",
			   procedure1Date="",
			   procedure1Practitioner="";
		double procedure1Charge=0.0;
		
		// variables for the second procedure object
		String procedure2Name="",
		   procedure2Date="",
		   procedure2Practitioner="";
		double procedure2Charge=0.0;
		
		// variables for the third procedure
		String procedure3Name="",
		   procedure3Date="",
		   procedure3Practitioner="";
		double procedure3Charge=0.0;
		
		for(int procedureNum =1; procedureNum<=3; procedureNum++)
		{
			// prompts the user for name of the procedure
			System.out.printf("\nEnter the name for procedure %d: ", procedureNum);
			// determines which procedure
			if(procedureNum==1)
				procedure1Name = sc.nextLine();
			else if(procedureNum==2)
				procedure2Name = sc.nextLine();
			else
				procedure3Name = sc.nextLine();
			
			// prompts the user for the procedure date
			System.out.printf("Enter the date of procedure %d: ", procedureNum);
			if(procedureNum==1)
				procedure1Date = sc.nextLine();
			else if(procedureNum==2)
				procedure2Date = sc.nextLine();
			else
				procedure3Date = sc.nextLine();
			
			// prompts the user for the procedure practitioner name
			System.out.printf("Enter the practioner name for procedure %d: ", procedureNum);
			if(procedureNum==1)
				procedure1Practitioner = sc.nextLine();
			else if(procedureNum==2)
				procedure2Practitioner = sc.nextLine();
			else
				procedure3Practitioner = sc.nextLine();
			
			// prompts the user for the charge of each procedure
			System.out.printf("Enter the charge for procedure %d: ", procedureNum);
			if(procedureNum==1)
				procedure1Charge = sc.nextDouble();
			else if(procedureNum==2)
				procedure2Charge = sc.nextDouble();
			else
				procedure3Charge = sc.nextDouble();
			
			sc.nextLine();
			
		}
	
		// creates an instance of the Procedure class using the no-arg constructor
		Procedure procedure1 = new Procedure();
		// assigns a value to the procedureName field 
		procedure1.setProcedureName(procedure1Name);
		// assigns a value to the dateOfProcedure field 
		procedure1.setDateOfProcedure(procedure1Date);
		// assigns a value to the practitionerName field 
		procedure1.setPractionerName(procedure1Practitioner);
		// assigns a value to the costOfProcedure field 
		procedure1.setCostOfProcedure(procedure1Charge);
		
		//creates the second instance of the Procedure class
		Procedure procedure2 = new Procedure(procedure2Name, procedure2Date);
		// assigns a value to the practitionerName field 
		procedure2.setPractionerName(procedure2Practitioner);
		// assigns a value to the costOfProcedure field 
		procedure2.setCostOfProcedure(procedure2Charge);
		
		//creates the last instance of the Procedure class passing all the field arguments
		Procedure procedure3 = new Procedure(procedure3Name, procedure3Date, procedure3Practitioner, procedure3Charge);
		
		// calls the displayPatient method which displays all the information of a patient
		displayPatient(patient1);
		
		//calls the displayProcedure method which displays all the information of each Procedure object
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);
		
		// stores the total charges of all the procedures
		double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
		System.out.printf("\nTotal Charges: $%,.2f", totalCharges);
		
		// displays the programmer's information
		System.out.println("\n\nThis program was programmed by: ");
		System.out.println("Student Name: Faith Nchang");
		System.out.println("MC#: M21163668");
		System.out.println("Due Date: 09/25/2023");
		
	}
	
	
	/**
	 * calls the toString method in order to display name, number, address, and emergency contact
	 * @param patientObject - an instance of the Patient class
	 */
	public static void displayPatient(Patient patientObject)
	{
		System.out.println(patientObject.toString());
	}
	
	/**
	 * calls the toString method of the Procedure class to display the Procedure name, date,
	 * 		practitioner name, and the charge of the procedure
	 * @param procedureObject - an instance of the Procedure class
	 */
	public static void displayProcedure(Procedure procedureObject)
	{
		System.out.println(procedureObject.toString());
	}
	
	
	/**
	 *  computes the total charge of all the three procedures
	 * @param p1 - first instance of the Procedure class
	 * @param p2 - second instance of the Procedure class
	 * @param p3 - third instance of the procedure class
	 * @return totalCharges
	 */
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3)
	{
		double totalCharges; // stores the total charges of all the 3 procedures
		// calls the accessor method of the cost of procedure for each instance of the Procedure class
		totalCharges = p1.getCostOfProcedure() + p2.getCostOfProcedure() + p3.getCostOfProcedure();
		return totalCharges;
	}
}