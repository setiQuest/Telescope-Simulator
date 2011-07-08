/*******************************************************************************

 File:    AntennaInfo.java
 Project: Telescope-Simulator
 Authors: Evan Uebel

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
 * @file AntennaInfo.java
 *
 * Project: TelescopeSimulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Evan Uebel
 */

package org.setiquest.AntennaInfo;

public class AntennaInfo
{
	/** The name of the Antenna. */
	private String _name;
	/** The antenna's number. */
	private Integer _number;
	/** The antenna's Easting coordinates in meters. */
	private float _easting;
	/** The antenna's Northing coordinates in meters. */
	private float _northing;
	/** The antenna's Elevation in meters. */
	private float _elevation;
	
	/**
	 * Default Constructor
	 */
	public AntennaInfo()
	{
	}
	
	/**
	 * Constructor.
	 * @param name the name of the antenna.
	 * @param number the antenna's number.
	 * @param easting the antenna's easting coordinates in meters.
	 * @param northing the antenna's northing coordinates in meters.
	 * @param elevation the antenna's elevation in meters.
	 */
	public AntennaInfo(String name, Integer number, float easting, float northing, float elevation)
	{
		_name = name;
		_number = number;
		_easting = easting;
		_northing = northing;
		_elevation = elevation;
	}
	
	/**
	 * Get the name of the antenna.
	 * @return the name of the antenna
	 */
	public String getName() { return _name; }
	
	/**
	 * Set the name of the antenna.
	 * @param name the name of the antenna
	 */
	public void setName(String name) { _name = name; }
	
	/**
	 * Get antenna's number
	 * @return antenna's number
	 */
	public Integer getNumber() { return _number; }
	
	/**
	 * Set antenna's number
	 * @param number the antenna's number
	 */
	public void setNumber(Integer number) { _number = number; }
	
	/**
	 * Get antenna's easting
	 * @return antenna's easting
	 */
	public float getEasting() { return _easting; }
	
	/**
	 * Set antenna's easting
	 * @param easting the antenna's easting
	 */
	public void setEasting(float easting) { _easting = easting; }
	
	/**
	 * Get antenna's northing
	 * @return antenna's northing
	 */
	public float getNorthing() { return _northing; }
	
	/**
	 * Set antenna's northing
	 * @param northing the antenna's northing
	 */
	public void setNorthing(float northing) { _northing = northing; }
	
	/**
	 * Get antenna's elevation
	 * @return antenna's elevation
	 */
	public float getElevation() { return _elevation; }
	
	/**
	 * Set antenna's elevation
	 * @param elevation the antenna's elevation
	 */
	public void setElevation(float elevation) { _elevation = elevation; }
	
	
}