package company;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/***************************************************************************
File name:Temp.java
Author:Wang Peng
Course :CST8284_303
Assignment:3
Date:12/04/2019
Professor:Dave Houtman
Purpose:company management tool prototype 
Class list:Temp

****************************************************************************/


/**
 * The class {@code Temp} represents temporary employees,
 * @author  Peng Wang
 * @since   1.8
 */
public class Temp extends Employee {
	
	// private fields for endContractDate
	private OurDate endContractDate;
	
	
	// default constructor; uses values that clearly indicate default conditions;
    // chained to (String, int, OurDate, double,OurDate) Temp constructor as below
	public Temp() {
		this("unknown", -9, new OurDate(), -1.1 , new OurDate()); 
	}
	

	  // load constructor using Temp's full name, work number, start date, salary and end of contract date 
	
	
	  /**
	  
    *
    * @param  name  the name
    * @param  employeeNumber  the employee number
    * @param  startDate  the date
    * @param  salary  the salary
    * @param  endContractDate  the end of contract date
    */
	
	public Temp(String name,int employeeNumber,OurDate startDate,double salary,OurDate endContractDate) {
		super(name, employeeNumber, startDate, salary);
		setEndContractDate(endContractDate);
	}
	
	public Temp(String name,int employeeNumber,OurDate startDate,double salary,String endContractDate) {
		super(name, employeeNumber, startDate, salary);
		setExtraInfo(endContractDate);
	}
	
	
	// return's the Temp's end of contract date as an OurDate object
	/**
     * @return  a date representation of end of contract date
     */
	public OurDate getEndContractDate() {
		return endContractDate;
	}
	
	
	// public setter for Temp's end of contract date
	/**
    *  @param  endContractDate  the end of contract date
    */
	public void setEndContractDate(OurDate endContractDate) {
		this.endContractDate = endContractDate;
	}
	
	
	// public setter for Temp's end of contract date as pass day,month and year
	 /**
     * @param   day    the day of the month between 1-31.
     * @param   month   the month between 0-11.
     * @param   year    the year 
     */
	public void setEndContractDate(int day,int month,int year) {
		new OurDate(day,month,year);
	}
	

	// get temporary employees' end contract day,users need to input their date
	//information include day,month and year
	@Override
	public void loadExtraInfo() {
		int year, month,day;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the year of your work contract expiration (year) : ");
		year=input.nextInt();
		System.out.println("Please enter the month of your work contract expiration (month) : ");
		month=input.nextInt();
		System.out.println("Please enter the day of your work contract expiration day (day): ");
		day=input.nextInt();
		endContractDate = new OurDate(year,month,day);
	}
	
	
	// Display temporary employees information to the console
	/**
     * @return  a string representation of the temp
     */
	 @Override
	public String toString() {
		return  getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary() +"\t\t"+getEndContractDate();
	 }
	 
	 
	 
	 // Compare two temp for equality by comparing their relevant properties
	 /**
	  
     *
     * @param   obj the reference object with which to compare.
     *
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
	   @Override
	  public boolean equals(Object obj) {
	    if ((obj == null) || (this.getClass() != obj.getClass())) return false;
	    Temp other =(Temp ) obj;
	    return super.equals(other)&&(obj instanceof Temp )&&getEndContractDate().equals(other.getEndContractDate());
	 }//END EQUALS METHOD 


	@Override
	public String getExtraInfo() {
		// TODO Auto-generated method stub
		
		//getEndContractDate();
		return getEndContractDate().toString() ;
	}


	@Override
	public void setExtraInfo(String s) {
		
		//setOurDate(s);
		new OurDate(s);
		
		
	//	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//dateFormat.setLenient(false);
		
		//	String[] dmy = s.split("/");
			
		//	setEndContractDate(Integer.parseInt(dmy[0]),Integer.parseInt(dmy[1]),Integer.parseInt(dmy[2]));
			
			//setYear(Integer.parseInt(dmy[2]));
			//setMonth(Integer.parseInt(dmy[1]));
			//setDay(Integer.parseInt(dmy[0]));
			//CALENDAR.setTime(dateFormat.parse(s)); 
		// TODO Auto-generated method stub
		
	}
	    
}//END CLASS TEMP
