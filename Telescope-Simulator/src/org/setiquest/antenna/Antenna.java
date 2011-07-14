/*******************************************************************************

 File:    Antenna.java
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
import java.util.HashMap;

/**
 * @file Antenna.java
 *
 * This is a container class for one Antenna.
 *
 * Project: Telescope-Simulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */


/**
 * Class that defines one antenna.
 * @author jrichards
 *
 */
public class Antenna implements Serializable
{

	/** serial version ID */
	private static final long serialVersionUID = 1L;
	
	/** The Map of item values */
	private HashMap<String, AntennaItemValue> _values;
	
	/**
	 * Default constructor.
	 */
	public Antenna()
	{
		_values = new HashMap<String, AntennaItemValue>();
	}
	
	/**
	 * Get the HashMap of values.
	 * @return the HashMap of values.
	 */
	public HashMap<String, AntennaItemValue> getValues() { return _values; }
	
	/**
	 * Set the HashMap of the antenna values.
	 * @param values the HashMap of the antenna values.
	 */
	public void setValues( HashMap<String, AntennaItemValue> values) { _values = values; }
	
	/**
	 * Get an item value.
	 * @param key the key of the item.
	 * @return the String representation of the value.
	 */
	public String getValue(String key) { return _values.get(key).getValue(); }
	
	/**
	 * Put or replace a value into the Values HashMap
	 * @param key the key of the item
	 * @param value the value, represented as a Sting.
	 */
	public void putValue(String key, String value) { _values.put(key, new AntennaItemValue(value)); }
	
	/**
	 * Determine if the value has changed since the last time it was retrieved.
	 * @param key the key of the item.
	 * @return true if the value has changed.
	 */
	public Boolean getValueHasChanged(String key) { return _values.get(key).hasValueChanged(); }


}
