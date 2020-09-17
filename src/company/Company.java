
package company;
import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/***************************************************************************
File name:Company.java
Author:Wang Peng
Course :CST8284_303
Assignment:3
Date:12/04/2019
Professor:Dave Houtman
Purpose:company management tool prototype 
Class list:Company

****************************************************************************/



/**
 * The class {@code Company} represents the change of employee include add, delete,display,find.
 * @author  Peng Wang
 * @since   1.8
 */

public class Company {

	// an arraylist to hold the employees of the company
	private ArrayList<Employee> employees;
	
	private int currentEmployee = 0;
	
	
	public void setCurrentEmployee(int currentEmployee) {
		this.currentEmployee=currentEmployee;
		
	}
	
	public int getCurrentEmp() {
		return currentEmployee;
	}
	
	// default constructor; it instantiates the Employee arraylist and pre-loads
	// three employees, to be used for demonstration purposes
	 /**
     * Initializes a newly created {@code Company} object so that it represents
     * an empty character sequence. 
     */
	public Company() {
		employees = new ArrayList<>();

		employees.add(new Manager("Alvin Spring", 21, new OurDate(2, 12, 2014), 150000,"CFO"));
		employees.add(new Manager("Grant Barge", 21, new OurDate(18, 5, 2009), 40000,"director"));
		employees.add(new Temp("Ross Chuttle", 23, new OurDate(22, 2, 2010), 43269,new OurDate(22,2,2011)));
	}

	// a getter; it returns the current number of Employees loaded in the employee
	// arraylist
	/**
     * @return  an integer representation of the current number of employee
     */
	public int currentNumberEmployees() {
		return employees.size();
	}

	// always return false
	/**
     * @return  {@code true} if not out of local memory ; {@code false} otherwise.
     * @exception  OutOfMemoryError  if out of memory.        
     */
	public boolean isMaximumEmployees()throws OutOfMemoryError {
		
		
		//Throwable
		/*
		 * try {
		 * 
		 * Long maxMemory = Runtime.getRuntime().maxMemory();
		 * System.out.println(maxMemory);
		 * 
		 * int[] matrix = new int[(int) (maxMemory + 1)]; for(int i = 0; i <
		 * matrix.length; ++i) matrix[i] = i+1; }catch(OutOfMemoryError e) {
		 * 
		 * }
		 */
	
		return false;	//OutOfMemoryException	//(numberEmployees >= MAXNUMEMPLOYEES);
	}

	// return a reference to the arraylist of Employees
	/**
     * @return  the current employees
     *         
     */
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	// Find senior employee by converting the start date of each non-null employee
	// in the employees array to its Calendar equivalent, and using Calendar's 
	// before() method to determine which date is earliest.  The index of the
	// earliest start date is used to return a new instance of the most senior
	// employee
	
	/**
     * @return  the senior employee
     *         
     */
	public Employee findSeniorEmployee() {
		
		if (employees.size()==0) return null;  // return null if no employees entered
		
		int seniorEmployeeIndex = 0; //assume first employee in arraylist is senior
		// instantiate Calendar objects for current and earliest start dates
		Calendar calEarliestStartDate = (Calendar.getInstance());  
		
		// load Calendar object to hold presumed earliest start date using first employee
		OurDate odEarliestStartDate = employees.get(seniorEmployeeIndex).getStartDate();
		calEarliestStartDate.set(odEarliestStartDate.getYear(), 
				odEarliestStartDate.getMonth(), odEarliestStartDate.getDay());

		// loop through remaining employees and compare to determine earliest start date
		for (int employeeIndex = 1;  employeeIndex < employees.size(); employeeIndex++) {
		     OurDate thisStartDate = employees.get(employeeIndex).getStartDate();
		     Calendar calThisStartDate = Calendar.getInstance();  // need to load new instance..
		     calThisStartDate.set(thisStartDate.getYear(),   
						thisStartDate.getMonth(), thisStartDate.getDay());
		     // Use calendar before() method to compare Calendar start dates
		     if (calThisStartDate.before(calEarliestStartDate)){
		    	 seniorEmployeeIndex = employeeIndex;  // set new oldest employee
		    	 calEarliestStartDate = calThisStartDate;
		     }
		}
		return employees.get(seniorEmployeeIndex);  // return employee at index with earliest startdate
	}
	


	
	// adds an employee 
	//according to the different type number to chose the relative subclass
	
	/**
    * @param  name  the name
    * @param  employeeNumber  the employee number
    * @param  date  the date
    * @param  salary  the salary
    * @param  empType  the type of employees
    */
	public void addEmployee(String name, int employeeNumber, OurDate date, double salary,int empType) {
	
		Manager m = new Manager();
		Staff s   = new Staff();
		Temp  t   = new Temp();
	 
		switch(empType) {
		 case 1:
			 m.loadExtraInfo();
			employees.add( new Manager( name, employeeNumber,date, salary,m.getTitle()));
			//currentEmployee
			//employees.indexOf(new Manager( name, employeeNumber,date, salary,m.getTitle()))
			setCurrentEmployee(employees.indexOf(new Manager( name, employeeNumber,date, salary,m.getTitle())));
			 break;
			 
		 case 2:
			 s.loadExtraInfo();
			 employees.add( new Staff( name, employeeNumber,date, salary,s.getDepartment()));
			 setCurrentEmployee(employees.indexOf( new Staff( name, employeeNumber,date, salary,s.getDepartment())));
			 break;
			 
		 case 3:
			 t.loadExtraInfo();
			 employees.add( new Temp( name, employeeNumber,date, salary,t.getEndContractDate()));
			 setCurrentEmployee(employees.indexOf( new Temp( name, employeeNumber,date, salary,t.getEndContractDate())));
			 
			 break;
		}
	}
	
	
	
	//find employees compare the employee number which now in the arraylist to the number which
	//user want to find 
	
	/**
     * @param    empNum  the employee number following the code point that should be returned
     * @return    the employee point value before the given empNum
     * @since     1.8
     */
	public Employee findEmployee(int empNum) {
		boolean find =false;
		int i;
		for( i= 0;i<employees.size();i++) {
			if(empNum==employees.get(i).getEmployeeNumber()) {
				System.out.println("the employee you find is:   " + employees.get(i));
				 setCurrentEmployee(i);
				find =true;
				break;
			}
		}
		if(!find) {
			System.out.println("An employee with that number can not be found");
			return null;
		}
		return employees.get(i);
	}
		

	
	//delete employee
	//use arraylist method remove(),delete the relative employees
	
	 /**
     * @param    empNum  the employee number following the code point that should be returned
     * @return    the deleted employee point value before the given empNum
     * @since     1.8
     */
	public Employee deleteEmployee(int empNum) {
		boolean find = false;
		int i;
		for( i= 0;i<employees.size();i++) {
			if(empNum==employees.get(i).getEmployeeNumber()) {
				System.out.println("the employee you delete is :   " + employees.get(i));
				employees.remove(i);
				 setCurrentEmployee(i);
				find =true;
				break;
			}
		}
		if(!find) {
			System.out.println("An employee with that number can not be found");
			return null;
		}
		return null;
	}
	
	
	
	
	

	public void saveEmployeesToFile( ArrayList<Employee> emplyees,String filename)  {
		
		
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			//for(int i=0;i<employees.size();i++) {
			//	oos.writeObject(employees.get(i));
		//	}
			
			for(Employee e :employees) {
				oos.writeObject(e);
				
			}
			//fos.close();	
		}catch(IOException ex){
			System.err.println();
			
		}
	}

	public void loadEmployeesFromFile(String file)  {
		
		ArrayList<Employee> list=new ArrayList<>();
		FileInputStream ips=null;
		ObjectInputStream ois=null;
		try {	
			 ips =  new FileInputStream(file);
			 ois= new ObjectInputStream(ips);
			
				Employee empObj = (Employee)(ois.readObject());
				list.add( empObj);
				//System.out.println(list.);
		
			//	for(int j =0;j<employees.size();j++) {
				//	Object employee = ois.readObject();
				//	Employee empObj = (Employee)employee;
					//System.out.println(employees.add(empObj));
			
			//}
		}catch(EOFException e) {
			System.err.println();
		} catch (IOException e) {
			System.err.println();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.err.println();
		}
		
	}
	
	
	public void addEmployee(Employee e) {
		employees.add(e);
		
		setCurrentEmployee(employees.indexOf(e));
		System.out.println("add employee "+ employees.get(currentEmployee));
	}
		
	
	
	public Employee getCurrentEmployee() {
		
		return employees.get(currentEmployee );
	
	}
	//public Employee getNextEmployee() {
	//	if(currentEmployee!=0) {
	//	System.out.println("the next employee is "+ employees.get(currentEmployee+1 ));
	//	currentEmployee=currentEmployee+1;
		//return employees.get(currentEmployee+1 );
	//	}else if(employees.get(currentEmployee+1)==null) {}
	//	return employees.get(0 );
		
	
	//}
	//public Employee getLastEmployee() {
		
	//	if(currentEmployee!=0) {
	//		System.out.println("the last employee is "+ employees.get(currentEmployee-1 ));
		//	currentEmployee=currentEmployee-1;
			//return employees.get(currentEmployee-1 );
	//	}
		
		//System.out.println("the last employee is "+ employees.get(currentEmployee-1 ));
		//return employees.get(currentEmployee-1 );
	
	
	
	//return employees.get(currentEmployee-1 );
	
	//}

}// end class 
