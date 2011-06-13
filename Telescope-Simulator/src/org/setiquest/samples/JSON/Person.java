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
 * @file Person.java
 *
 * This is a simple class to be used in the JSON examples. This
 * class encapsulates a person's information.
 *
 * Project: TelescopeSimulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */

package org.setiquest.samples.JSON;

/*
* Class that encapsulates a person's information.
*/
public class Person 
{
	  /** The first name of the person. */
	  private String _firstName;
	  /** The last name of the person. */
	  private String _lastName;
	  /** The age of the person in years. */
	  private Integer _ageYears;
	 
	  /**
	   * Default Constructor.
	   */
	  public Person()
	  {	  
	  }
	  
	  /**
	   * Constructor.
	   * @param firstName the first name of the person.
	   * @param lastName the last name of the person.
	   * @param ageYears the age of the person in years.
	   */
	  public Person(String firstName, String lastName, Integer ageYears)
	  {
		  _firstName = firstName;
		  _lastName = lastName;
		  _ageYears = ageYears;
	  }

	  /**
	   * Get the first name of the person.
	   * @return the first name of the person.
	   */
	  public String getFirstName() { return _firstName; }
	  
	  /**
	   * Set the first name of the person.
	   * @param firstName the first name of the person.
	   */
	  public void setFirstName(String firstName) { _firstName = firstName; }
	  
	  /**
	   * Get the last name of the person.
	   * @return the last name of the person.
	   */
	  public String getLastName() { return _lastName; }
	  
	  /**
	   * Set the last name of the person.
	   * @param lastName the last name of the person.
	   */
	  public void setLastName(String lastName) { _lastName = lastName; }
	  
	  /**
	   * Get the age of the person in years.
	   * @return the age of the person in years.
	   */
	  public Integer getAgeYears() { return _ageYears; }
	  
	  /**
	   * Set the age of the person in years.
	   * @param ageYears the age of the person in years.
	   */
	  public void setAgeYears(Integer ageYears) { _ageYears = ageYears; }
	 


}
