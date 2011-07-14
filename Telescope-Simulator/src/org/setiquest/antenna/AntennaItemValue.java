/*******************************************************************************

 File:    AntennaItemValue.java
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
 * @file AntennaItemValue.java
 *
 * This is a container class for values.
 *
 * Project: Telescope-Simulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */

/**
 * Class that contains an item value.
 */
public class AntennaItemValue implements Serializable
{
	/** The value as a String. */
	private String _value = "";
	
	/** Has this value changed since last time. */
	private Boolean _hasChanged;
	
	/**
	 * Default Constructor
	 */
	public AntennaItemValue()
	{
		_value = "";
		_hasChanged = false;
	}

	/**
	 * Constructor.
	 * @param value the value of this item as a String.
	 */
	public AntennaItemValue(String value)
	{
		_value = value;
		_hasChanged = true;
	}
	
	/**
	 * Get the value.
	 * @return the item value as a String.
	 */
	public String getValue() { _hasChanged = false; return _value; }
	
	/**
	 * Set the value.
	 * @param value the new value as a string.
	 */
	public void setValue(String value) { _value = value; _hasChanged = true;}
	
	/**
	 * Determine if the value has changed since last accessed.
	 * @return true if has changed.
	 */
	public Boolean hasValueChanged() { return _hasChanged; }
	
	/**
	 * Set the value of hasChanged.
	 * @param hasChanged the value of hasChanged.
	 */
	public void hasValueChanged(Boolean hasChanged) { this._hasChanged = hasChanged; }
}
