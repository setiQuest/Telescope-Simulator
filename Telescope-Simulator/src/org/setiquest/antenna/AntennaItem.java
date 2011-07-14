/*******************************************************************************

 File:    AntennaItem.java
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
 along with Telescope-Simulator.  If not, see<http://www.gnu.org/licenses/>.
 
 Implementers of this code are requested to include the caption
 "Licensed through SETI" with a link to setiQuest.org.
 
 For alternate licensing arrangements, please contact
 The SETI Institute at www.seti.org or setiquest.org. 

*******************************************************************************/

package org.setiquest.antenna;

import java.io.Serializable;

/**
 * @file AntennaItem.java
 *
 * This is a container class for one Antenna item.
 *
 * Project: Telescope-Simulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */

/*
* Class that encapsulates an antenna item.
* This class should be thread safe since the only access to data members is through
* the get and set methods, which are synchronized.
*/
public class AntennaItem implements Serializable
{
	/** the Key of this item. */
	private String _key = "";
	/** The name of the item. */
	private String _name = "";
	/** The description of the item. */
	private String _description = "";
	/** The item name abbreviation. */
	private String _abbreviation = "";
	/** 
	 * The data type of the item. The item value is represented as a String (_value),
	 * this member describes the type, such as Double, String, Float, Integer, "Double,Double",
	 * etc. It is up to the user of this class to be consistent and document well what data types
	 * are used in the application.
	 */
	private String _dataType = "";
	
	/**
	 * Default Constructor.
	 */
	public AntennaItem()
	{
	}
	
	/**
	 * Constructor.
	 * @param name the name of the data item.
	 * @param description the description of the data item.
	 * @param abbreviation the abbreviation of the data item name.
	 * @param dataType the data type of this item, represented as a String.
	 * @param value the value of this data item, represented as a String.
	 */
	public AntennaItem(String key, String name, String description, String abbreviation, String dataType)
	{
		_key = key;
		_name = name;
		_description = description;
		_abbreviation = abbreviation;
		_dataType = dataType;
	}
	
	/**
	 * Get the key of this item.
	 * @return the key of the item.
	 */
	public synchronized String getKey() { return _key; }
	
	/**
	 * Set the key of this item.
	 * @param key the key of the item.
	 */
	public synchronized void setKey(String key) { _key = key; }
	
	/**
	 * Get the name of this item.
	 * @return the name of the item.
	 */
	public synchronized String getName() { return _name; }
	
	/**
	 * Set the name of this item.
	 * @param name the name of the item.
	 */
	public synchronized void setName(String name) { _name = name; }
	
	/**
	 * Get the description of this item.
	 * @return the description of this item.
	 */
	public synchronized String getDescription() { return _description; }
	
	/**
	 * Set he description of this item.
	 * @param description the item description.
	 */
	public synchronized void setDescription(String description) { _description = description; }
	
	/**
	 * Get the abbreviation of this item's name.
	 * @return the abbreviation.
	 */
	public synchronized String getAbbreviation() { return _abbreviation; }
	
	/**
	 * Set the item's name abbreviation.
	 * @param abbreviation the abbreviation of the name.
	 */
	public synchronized void setAbbreviation(String abbreviation) { _abbreviation = abbreviation; }
	
	/** 
	 * Get the data type of this item.
	 * @return the data type of this item represented as a String.
	 */
	public synchronized String getDataType() { return _dataType; }
	
	/**
	 * Set the data type of this item.
	 * @param dataType the data type, represented as a String.
	 */
	public synchronized void setDataType(String dataType) { _dataType = dataType; }

	
}
