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
 * @file BasicMathTest.java
 *
 * Tests for the BasicMath class.
 *
 * Project: TelescopeSimulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */

package org.setiquest.samples.jUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Class that tests the BasicMath class methods.
 */
public class BasicMathTest {

	BasicMath m_basicMath = null;
	
	@Before
	public void setUp() throws Exception 
	{
		m_basicMath = new BasicMath();
	}

	@Test
	public final void testAdd() 
	{
		assertEquals("Result", 50, m_basicMath.add(49, 1));
		assertEquals("Result", 0, m_basicMath.add(0, 0));
	}

	@Test
	public final void testSubtract() 
	{
		assertEquals("Result", 1, m_basicMath.subtract(2, 1));
	}

	@Test
	public final void testMultiply() 
	{
		assertEquals("Result", 0, m_basicMath.multiply(0, 1));
		assertEquals("Result", 50, m_basicMath.multiply(50, 1));
		assertEquals("Result", 5000000, m_basicMath.multiply(2500000, 2));
	}

	@Test
	public final void testDivide() 
	{
		//Test some simple divisions.
		try
		{
			assertEquals("Result", 0.0f, m_basicMath.divide(0, 1), 0.0f);
			assertEquals("Result", 2.0f, m_basicMath.divide(10, 5), 0.0f);
		}
		catch (Exception ex)
		{
			//Ignore - Test results will show an error
		}
		
		//Divide by zero should throw an exception.
		boolean gotError = false;
		try
		{
			assertEquals("Result", 0.0f, m_basicMath.divide(0, 0), 0.0f);
		}
		catch (Exception ex)
		{
			gotError = true;
		}
		
		if(!gotError)
		{
			fail("Divide by zero did not throw and Exception.");
		}
	}

}
