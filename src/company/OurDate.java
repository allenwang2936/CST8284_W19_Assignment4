package company;
import java.text.ParseException;
import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;  // Note: OurDate wraps Calendar

//import cst8284.lab6.BadAccountInputException;

/***************************************************************************
File name:OurDate.java
Author:Wang Peng
Course :CST8284_303
Assignment:3
Date:12/04/2019
Professor:Dave Houtman
Purpose:company management tool prototype 
Class list:OurDate

****************************************************************************/



/**
 * The class {@code OurDate} represents the date
 * @author  Peng Wang
 * @since   1.8
 */

public class OurDate {

	// private fields for day, month, year
	private int day;
	private int month;
	private int year;
	
	// each OurDate object wraps a Calendar object; Calendar's functionality can then
	// be used for initialization, comparison, etc.
	private static final Calendar CALENDAR = Calendar.getInstance();
  
    // initialization of OurDate default constructor uses today's day, month, 
	// and year, as returned by the Calendar object's methods.  (See, for example,
	// https://www.geeksforgeeks.org/calendar-class-in-java-with-examples/)
	// This constructor is chained to the (int day, int month, int year) constructor below.  
	// Note that the months are 1-based, not 0-based.  Hence January = 1, 
	// February = 2, etc. 
    public OurDate() { this(CALENDAR.get(Calendar.DATE), 
		   CALENDAR.get(Calendar.MONTH + 1), 
		   CALENDAR.get(Calendar.YEAR) ); }
	
    // base constructor.  Note input format: day, month, year, NOT year, month, day
    // as used in Calendar constructor
    
    /**
     * @param   day    the day of the month between 1-31.
     * @param   month   the month between 0-11.
     * @param   year    the year 
     */
	public OurDate(int day, int month, int year) {	
		setDay(day);
		setMonth(month);
		setYear(year);	
	}
	//SecureRandom num = new SecureRandom();
	
	public OurDate(String startDate) {
		setOurDate(startDate);
	}
	
	// private setter for day of month
    /**
     * @param   date    the day of the month between 1-31.
     *  @exception  BadAccountInputException  if day did not match format
     */
	private void setDay(int day) {  
		if(day<0 ||day>31) {

			throw new BadAccountInputException("day should be  between 1-31.");
	}
		this.day = day; 
	}
	// private setter for month
	 /**
     * @param   month    the month of the year between 1-12.
     *  @exception  BadAccountInputException  if month did not match format
     */
	private void setMonth(int month) { 
		if(month<0 ||month>12) {

			throw new BadAccountInputException("month should be  between 1-12.");
			
			
		}
		this.month = month; 
		
	}
	
	// private setter for year
	 /**
     * @param  year   the year 
     *  @exception  BadAccountInputException  if year did not match format
     */
	private void setYear(int year) { 
		if( year<0 ) {
			throw new BadAccountInputException("year should be more than 0");
		}
		this.year = year;  
	}
	
	// returns the day of the month
	 /**
     * @return  the day of the month represented by this date.
     */
	public int getDay() { 
		
		return day; 
		
	}
	
	// returns the month as an int, where January = 1, February = 2, etc.
	
	/**
     * @return  the month
     */
	public int getMonth() {  return month; }
	
	// returns the year
	/**
     * @return  the year
     */
	public int getYear() {  return year;  }

	// prints date to console in day/month/year format
	/**
     * @return  a string representation of the ourdate
     */
	
	@Override
	public String toString() {  return this.day +"/" +this.month + "/" + this.year; }

	// compares two OurDate objects for equality
	 /**
     * @param   obj the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
	public boolean setOurDate(String s) {
		boolean result = true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			String[] dmy = s.split("/");
			setYear(Integer.parseInt(dmy[2]));
			setMonth(Integer.parseInt(dmy[1]));
			setDay(Integer.parseInt(dmy[0]));
			CALENDAR.setTime(dateFormat.parse(s));  // use calendar to check for impossible dates
			return result;
		} catch(NumberFormatException e) {
			throw new BadAccountInputException("Bad input value; date " + s + " contains non-numeric value");
			//System.out.println(e);
			
		}catch(IllegalArgumentException e) {
			throw new BadAccountInputException("Bad data type passed to an internal method");
			
		}catch(ParseException e) {
			throw new BadAccountInputException("Date " + s + " not possible");
			
		}catch(RuntimeException e) {
			throw new BadAccountInputException( "General runtime exception thrown setting start date");
			
		}
	
	}

	@Override
	public boolean equals(Object obj) {

		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		OurDate other = (OurDate) obj;
	    return (this.getDay() == other.getDay() && 
	    		this.getMonth() == other.getMonth() && 
	    		this.getYear() == other.getYear() ) ; 
			
	}//END EQUALS METHOD 
	
}//END CLASS EMPLOYEE
