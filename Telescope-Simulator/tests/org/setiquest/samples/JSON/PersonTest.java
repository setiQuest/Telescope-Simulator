/*******************************************************************************

 File:    Person.java
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
 * @file PersonTest.java
 *
 * Tests for the Person class.
 *
 * Project: TelescopeSimulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */

package org.setiquest.samples.JSON;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * Class to test the Person class.
 * @author jrichards
 *
 */
public class PersonTest 
{
	Person m_person = null;
	
	@Before
	public void setUp() throws Exception 
	{
		m_person = new Person("Joe", "Smith", 23);
	}

	@Test
	public void testGetFirstName() 
	{
		assertEquals("First name error.", "Joe", m_person.getFirstName());
	}

	@Test
	public void testSetFirstName() 
	{
		m_person.setFirstName("Sam");
		assertEquals("First name error.", "Sam", m_person.getFirstName());
		m_person.setFirstName("Joe");
		assertEquals("First name error.", "Joe", m_person.getFirstName());
	}

	@Test
	public void testGetLastName() 
	{
		assertEquals("First name error.", "Smith", m_person.getLastName());
	}

	@Test
	public void testSetLastName() 
	{
		m_person.setLastName("Bush");
		assertEquals("last name error.", "Bush", m_person.getLastName());
		m_person.setLastName("Smith");
		assertEquals("Last name error.", "Smith", m_person.getLastName());
	}

	@Test
	public void testGetAgeYears() 
	{
		assertEquals("Age Error.", 23, (int)m_person.getAgeYears());
	}

	@Test
	public void testSetAgeYears() 
	{
		m_person.setAgeYears(14);
		assertEquals("age error.", 14, (int)m_person.getAgeYears());
		m_person.setAgeYears(23);
		assertEquals("age error.", 23, (int)m_person.getAgeYears());
	}
	
	@Test
	public void testJSON() throws JsonGenerationException, JsonMappingException, IOException, Exception
	{
		//Convert m_person into JSON String.
		Writer strWriter = new StringWriter();	
		ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(strWriter, m_person);
	    String s = strWriter.toString();
	    
	    //Print out the String representation in JSON format of the m_mapper object.
	    //Normally we would not print out like this in a JUnit test, but this
	    //is also to be used as an example.
	    s.hashCode();
	    System.out.println("m_person as JSON string: " + s);
	    System.out.println("m_person hash code: " + s.hashCode());
	    
	    //Assert test error if has code of string is not correct.
	    assertEquals("JSON conversion hash error.", -597509411, s.hashCode());
	    
	    //Change the age to 14 years in the JSON string.
	    s = s.replace("23", "14");
	    
	    //Convert the JSON string to a Person object instance
	    Person person = mapper.readValue(s, Person.class);
	    
	    //Assert test error if the person object age is NOT 14
	    assertEquals("JSON string 2 instance error, age: ", 14, (int)person.getAgeYears());
		
	}

}
