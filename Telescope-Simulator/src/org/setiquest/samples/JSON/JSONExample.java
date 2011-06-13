/*******************************************************************************

 File:    JSONExample.java
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
 * @file JSONExample.java
 *
 * Class that illustrates how to use JSON and Jackson. See
 * http://jackson.codehaus.org/ for information on Jackson.
 *
 * Project: TelescopeSimulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */

package org.setiquest.samples.JSON;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.io.Writer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



/**
 * Class that illustrates how to use JSON and Jackson.
 * @author jrichards
 *
 */
public class JSONExample 
{
	/**
	 * Default constructor.
	 */
	public JSONExample()
	{
		
	}
	
	/**
	 * Somple main() to test JSON and Jackson
	 * @param args
	 * @throws Exception
	 * @throws JsonMappingException
	 * @throws IOException
	 */

	public static void main(String[] args) throws Exception, JsonMappingException, IOException
	{
		Person person1 = new Person("Joe", "Smith", 23);
		
		//Convert m_person into JSON String.
		Writer strWriter = new StringWriter();	
		ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(strWriter, person1);
	    String s = strWriter.toString();
	    
	    //Print out the String representation in JSON format of the m_mapper object.
	    //Normally we would not print out like this in a JUnit test, but this
	    //is also to be used as an example.
	    s.hashCode();
	    System.out.println("m_person as JSON string: " + s);
	    System.out.println("m_person hash code: " + s.hashCode());
	    
	    //Assert test error if has code of string is not correct.
	    if(s.hashCode() != -182820439)
	    {
	    	System.err.println("Hash Code incorrect!");
	    	System.exit(1);
	    }
	    
	    //Change the age to 14 years in the JSON string.
	    s = s.replace("23", "14");
	    
	    //Convert the JSON string to a Person object instance
	    Person person = mapper.readValue(s, Person.class);
	    
	    //Assert test error if the person object age is NOT 14
	    if(person.getAgeYears() != 14)
	    {
	    	System.err.println("Age not 14!");
	    	System.exit(1);
	    }
	    
	    System.out.println("Passed, all OK!");
	   
	}
}


