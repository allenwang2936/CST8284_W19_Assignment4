package company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/***************************************************************************
File name:Employee.java
Author:Wang Peng
Course :CST8284_303
Assignment:3
Date:12/04/2019
Professor:Dave Houtman
Purpose:company management tool prototype 
Class list:Employee

****************************************************************************/

/**
 * The class {@code Employee} represents  employees basic charactor,
 * @author  Peng Wang
 * @since   1.8
 */

public abstract class Employee {
	
	// private fields to hold relevant Employee information
    private String name;         // Employee's full name
    private int employeeNumber;  // Employee's work number
    private OurDate startDate;   // Employee's first day of work
    private double salary;       // Employee's current salary
    boolean right;
    //Math Scanner
    
    public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	public static final long
    serialVersionUID = 1L;
    // default constructor; uses values that clearly indicate default conditions;
    // chained to (String, int, OurDate, double) Employee constructor below
   
    public Employee() { this("unknown", -9, new OurDate(), -1);  }
	
    // load constructor using Employee's full name, work number, start date and salary
    /**
     * @param  name  the name
     * @param  employeeNumber  the employee number
     * @param  startDate  the date
     * @param  salary  the salary
     */
	
	
    public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		setName(name);
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
	}
    
    //abstract method which subclasses need to be executed
    public abstract void loadExtraInfo();
	
    // return's the Employee's full name as a String
    /**
    *
    * @return  the name of employee
    * @exception  BadAccountInputException  if a name is not match the form         
    */
    
	public String getName() { 
		return name; 
		
	}
	
	// return's the Employee number, as an int
	 /**
    * @return  the number of employee
    */
	public int getEmployeeNumber() { 
		return employeeNumber;  
	}
	
	// return's the Employee's starting date, as an OurDate object
	 /**
    * @return  the date of state date
    */
	public OurDate getStartDate() {  return startDate;  }
	
	// return's the Employee's salary, as a double
	 /**
    * @return  the salary
    */
	public double getSalary() {  return salary; }
	
	// Note: all setters in this class are private; all Employee properties
	// must be set through the class constructor only
	/**
    *  @param  name  the name
    *  @exception  BadAccountInputException  if name did not match format			
    *          
    */
	
	private void setName(String name) {  
		
		//String st="(^[a-zA-Z]+\\s)+[a-zA-Z]+$";
	//Pattern pattern =Pattern.compile(st);
		//Matcher matcher=pattern.matcher(name);
		//if((!matcher.matches())||name.contains(".")||name.contains("_")) {
		//	throw new BadAccountInputException("Name must contain alphabetical characters only");
		//}
		if(!input(name)) {
			throw new BadAccountInputException("name input wrong");
		}
		
		this.name = name;  
	}
	
	private static boolean input (String name) {
		return name.trim().length()!=0;
	}
	/**
    *  @param  employeeNumber  the number of employee
    *  @exception  BadAccountInputException  if  employeeNumber did not match format	  			
    */
	private void setEmployeeNumber(int employeeNumber) { 
		
		if(!Integer.toString(employeeNumber).matches("^[0-9]{1,15}$")) {
			throw new BadAccountInputException("Account number must consists of numbers separated by -, other non-numeric characters not allowed"); 
		}
		this.employeeNumber = employeeNumber;  
		
	
	}
	/**
    *  @param  startDate  the state of date
    *  			
    */
	private void setStartDate(OurDate startDate) { 
		this.startDate = startDate;
		
	}
	/**
    *  @param  department  the salary
    *  @exception  BadAccountInputException  if  salary not more than 0.		
    */
	
	private void setSalary(double salary) { 
		
		if( salary<0 ) {
			throw new BadAccountInputException("salary should be more than 0");
		}
		
		this.salary = salary; 
		
	}

	// Display employee information to the console
	/**
     * @return  a string representation of the employee
     */
	@Override
	public String toString() {
		return  getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary();
	}
	
	// Compare two employees for equality by comparing their relevant properties
	 /**
    * @param   obj the reference object with which to compare.
    * @return  {@code true} if this object is the same as the obj
    *          argument; {@code false} otherwise.
    */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Employee other = (Employee) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate())); 
				
	}//END EQUALS METHOD 
	
	public abstract String getExtraInfo();
	public abstract void setExtraInfo(String s);
	
	

}//END CLASS EMPLOYEE

