package company;
import java.lang.RuntimeException;



/***************************************************************************
File name:BadAccountInputException.java
Author:Wang Peng
Course :CST8284_303
Assignment:3
Date:12/04/2019
Professor:Dave Houtman
Purpose:company management tool prototype 
Class list:BadAccountInputException

****************************************************************************/



/**
 * The class {@code Company} represents the exception 
 * @author  Peng Wang
 * @since   1.8
 */
public class BadAccountInputException extends RuntimeException  {
	
	private static final long serialVersionUID =1L;
	
	public BadAccountInputException() {
		this(" ");
		
	}
	/**
     * @param    msg  a string represent a message
     * @since     1.8
     */
	public BadAccountInputException(String msg) {
		super(msg);
		
	}

	
}
