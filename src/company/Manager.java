package company;
import java.util.Scanner;
/***************************************************************************
File name:Manager.java
Author:Wang Peng
Course :CST8284_303
Assignment:3
Date:12/04/2019
Professor:Dave Houtman
Purpose:company management tool prototype 
Class list:Manager

****************************************************************************/


/**
 * The class {@code Manager} represents senior employees,
 * @author  Peng Wang
 * @since   1.8
 */
public class Manager extends Employee  {
	
	// private fields for title
	private String title;
	
	
	// default constructor; uses values that clearly indicate default conditions;
    // chained to (String, int, OurDate, double,OurDate) Temp constructor as below
	public Manager() {
		this("unknown", -9, new OurDate(), -1.1 , ""); 
	}
	
	
	 // load constructor using Manager's full name, work number, start date, salary and job title  
	
	 /**
    * @param  name  the name
    * @param  employeeNumber  the employee number
    * @param  startDate  the date
    * @param  salary  the salary
    * @param   title  the job title
    */
	public Manager (String name,int employeeNumber,OurDate startDate,double salary,String title) {
		super(name, employeeNumber, startDate, salary);
		setTitle(title);
	}
	
	
	// return's the Manager's job title as a String
	
	 /**
     * @return  a string representation of the {@code int} argument.
     */
	public String getTitle() {
		return title;
	}
	
	
	// public setter for Manager's title
	/**
    *  @param  title  the job title
    */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	// get Manager' title,users need to input their title
		//information 
	public void loadExtraInfo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your title,e.g President,VP,supervisor");
		title = input.nextLine();
	}
	
	
	// Display Manager information to the console
	/**
     * @return  a string representation of the manager
     */
    @Override
	public String toString() {
		return  getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary() +"\t\t"+getTitle();
	}

    
 // Compare two Manager for equality by comparing their relevant properties
    /**
    * @param   obj the reference object with which to compare.
    * @return  {@code true} if this object is the same as the obj
    *          argument; {@code false} otherwise.
    */
    @Override
    public boolean equals(Object obj) {
    	if ((obj == null) || (this.getClass() != obj.getClass())) return false;
    	Manager other =(Manager) obj;
    	return super.equals(other)&&(obj instanceof Manager)&&getTitle().equals(other.getTitle());
    }//END EQUALS METHOD


	@Override
	public String getExtraInfo() {
		// TODO Auto-generated method stub
		return getTitle();
	}


	@Override
	public void setExtraInfo(String s) {
		setTitle(s);
		// TODO Auto-generated method stub
		
	}
    
}//END CLASS TEMP
