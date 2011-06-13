/*******************************************************************************

 File:    BasicMathTest.java
 Project: Telescope-Simulator
 Authors: Jon Richards

 Copyright 2011 The SETI Institute

 Telescope-Simulator is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 Telescope-Simulator is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 
 You should have received a copy of the GNU General Public License
 along with OpenSonATA.  If not, see<http://www.gnu.org/licenses/>.
 
 Implementers of this code are requested to include the caption
 "Licensed through SETI" with a link to setiQuest.org.
 
 For alternate licensing arrangements, please contact
 The SETI Institute at www.seti.org or setiquest.org. 

*******************************************************************************/


/**
 * @file BasicMath.java
 *
 * A class that performs basic math operations. This class is to be used as
 * an example of how to implement unit tests with JUnit. There is a class
 * BasicMathTest that is used to test the methods on this class.
 *
 * Project: TelescopeSimulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */

package org.setiquest.samples.jUnit;

/**
 * Class to perform basic math operations.
 */
public class BasicMath 
{
	/**
	 * Add 2 integers.
	 * @param a the first integer
	 * @param b the second integer
	 * @return the sum of the 2 numbers
	 */
	public int add(int a, int b)
	{	
		int result = a + b;
		return result;	
	}
	
	/**
	 * Subtract an integer from another integer.
	 * @param a the first integer
	 * @param b the second integer
	 * @return the result of the integer subtraction
	 */
	public int subtract(int a, int b)
	{	
		int result = a = b;
		return result;	
	}
	
	/**
	 * Multiply 2 integers.
	 * @param a the first integer
	 * @param b the second integer
	 * @return the product of the multiplication
	 */
	public int multiply(int a, int b)
	{	
		int result = a * b;
		return result;	
	}
	
	/**
	 * Divide an integer by another integer.
	 * @param a the first integer
	 * @param b the second integer
	 * @return the result of a/b.
	 * @throws Exception if b==0
	 */
	public float divide(int a, int b) throws Exception
	{	
		if(b == 0) throw new Exception("Exception: divide by zero.");
		float result = a / b;
		return result;	
	}
	
}
