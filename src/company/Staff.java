package company;
import java.util.Scanner;
/***************************************************************************
File name:Staff.java
Author:Wang Peng
Course :CST8284_303
Assignment:3
Date:12/04/2019
Professor:Dave Houtman
Purpose:company management tool prototype 
Class list:Staff

****************************************************************************/



/**
 * The class {@code Staff} represents normal employees,
 * @author  Peng Wang
 * @since   1.8
 */

public class Staff extends Employee{
	
	// private fields for department
	private String department;
	
	
	// default constructor; uses values that clearly indicate default conditions;
    // chained to (String, int, OurDate, double,String) Staff constructor as below
	
	public Staff() {
		this("unknown", -9, new OurDate(), -1.1 , " "); 
	}
	

    /**
     * @param  name  the name
     * @param  employeeNumber  the employee number
     * @param  startDate  the date
     * @param  salary  the salary
     * @param  department  the department
     */
	// load constructor using Staff's full name, work number, start date, salary and department
	public Staff(String name,int employeeNumber,OurDate startDate,double salary,String department) {
		super(name, employeeNumber, startDate, salary);
		setDepartment(department);
	}
	
	// return's the Staff's department as a String
	
	 /**
     * @return  the name of department
     */
	public String getDepartment() {
		return department;
	}
	
	
	//public setter for Staff's department
	
	/**
    *  @param  department  the department
    */
	public void setDepartment(String department) {
		this.department = department;
	}

	// get normal employees' departments,users need to input their department name
	//information 
	
	@Override
	public void loadExtraInfo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your department");
		department = input.nextLine();
	}
	
	
	// Display normal employees information to the console
	/**
     * @return  a string representation of the staff
     */
	 @Override
	public String toString() {
		return  getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary() +"\t\t"+getDepartment();
	 }
	 
	 
	 // Compare two staff for equality by comparing their relevant properties
	 /**
     * @param   obj the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
	 @Override
	 public boolean equals(Object obj) {
		 if ((obj == null) || (this.getClass() != obj.getClass())) return false;
	    	Staff other = (Staff) obj;
		return  super.equals(other)&&(obj instanceof Staff)&&getDepartment().equals(other.getDepartment());
	 }//END EQUALS METHOD 



		@Override
		public String getExtraInfo() {
			// TODO Auto-generated method stub
			return getDepartment();
		}


		@Override
		public void setExtraInfo(String s) {
			
			setDepartment(s);
			// TODO Auto-generated method stub
			
		}
	    

}//END CLASS STAFF
