/*******************************************************************************

 File:    Antennas.java
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

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @file AntennaItem.java
 *
 * This is a container and utility class for all the antennas.
 *
 * Project: Telescope-Simulator
 * <BR>
 * Version: 1.0
 * <BR>
 * Authors:
 * - Jon Richards
 */


public class Antennas implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** HashMap of Antenna instances. The key is the antenna name (1c, 3h, etc.) */
	private HashMap<String, Antenna> _antennas;
	
	/** HashMap of AntennaItem instances. The key is the item abbreviation. */
	private HashMap<String, AntennaItem> _items;
	
	//These are keys to items NOT found in antenna_items.xml
	static final String NAME_KEY      = "key200";
	static final String NUMBER_KEY    = "key201";
	static final String EASTING_KEY   = "key202";
	static final String NORTHING_KEY  = "key203";
	static final String ELEVATION_KEY = "key204";
	
	/**
	 * Constructor.
	 */
	public Antennas()
	{
		_antennas = new HashMap<String, Antenna>();
		_items = new HashMap<String, AntennaItem>();
	}
	
	/**
	 * Constructor that creates the fully populated list of antennas, antenna infos,
	 * and items.
	 * @param locationsFilename the path of the antenna-locations.json file
	 * @param itemsFilename the path of the antenna-items.json file
	 * @throws Exception 
	 */
	public Antennas(String locationsFilename, String itemsFilename) throws Exception
	{
		_antennas = new HashMap<String, Antenna>();
		_items = new HashMap<String, AntennaItem>();
		
		ingestAntennaLocations(locationsFilename);
		ingestItemXML(itemsFilename);
		
	}
	
	/** Get the HashMap of antennas.
	 * @return the HashMap of antennas.
	 */
	public HashMap<String, Antenna> getAntennas() { return _antennas; }
	
	/**
	 * Set the HashMap of antennas.
	 * @param antennas the HashMap for antennas
	 */
	public void setAntennas( HashMap<String, Antenna> antennas) { _antennas = antennas; }
	
	/**
	 * Get the HashMap of antenna items.
	 * @return the HashMap of items
	 */
	public HashMap<String, AntennaItem> getItems() { return _items; }
	
	/**
	 * Set the HashMap of items.
	 * @param items the HashMap of antenna items.
	 */
	public void setItems( HashMap<String, AntennaItem> items) { _items = items; }
	
	/**
	 * Set the value of an antenna item.
	 * @param antName the antenna name
	 * @param itemAbbreviation the abbreviation of the items name.
	 * @param value the value, as a String.
	 * @return true if the items was found.
	 */
	public Boolean setItemValue(String antName, String itemAbbreviation, String value)
	{
		String key = itemAbbrevToKey(itemAbbreviation);
		if(key == null) return false;
		
		Enumeration<String> e = Collections.enumeration(_antennas.keySet());
        while ( e.hasMoreElements() )
        {
            Antenna ant = _antennas.get(e.nextElement());
            if(ant.getValue(NAME_KEY).equalsIgnoreCase(antName))
            	ant.putValue(key, value);
        }
		
		return true;
	}
	
	/**
	 * Set the value of an Integer item.
	 * @param antName the antenna name
	 * @param itemAbbreviation the abbreviation of the items name.
	 * @param value the value, as an Integer.
	 * @return true if the items was found.
	 */
	public Boolean setItemValue(String antName, String itemAbbreviation, Integer value)
	{
		return setItemValue(antName, itemAbbreviation, "" + value);
	}
	
	/**
	 * Set the value of an item with the value of a float.
	 * @param antName the antenna name.
	 * @param itemAbbreviation the item abbreviation.
	 * @param value the value of the item.
	 * @return true if the value was set.
	 */
	public Boolean setItemValue(String antName, String itemAbbreviation, Float value)
	{
		return setItemValue(antName, itemAbbreviation, "" + value);
	}
	
	/**
	 * Set the value of an item with the value of a double.
	 * @param antName the antenna name.
	 * @param itemAbbreviation the item abbreviation.
	 * @param value the value of the item.
	 * @return true if the value was set.
	 */
	public Boolean setItemValue(String antName, String itemAbbreviation, Double value)
	{
		return setItemValue(antName, itemAbbreviation, "" + value);
	}
	
	/**
	 * A utility function to take the file data/antenna_locations.txt file
	 * and read it into the _antennas HashMap.
	 * This is used as a utility only to convert the raw list of antenna_locations.txt
	 * file, for the purposes of creating the JSON file containing the antenna positions.
	 * @param antennaLocationsFilename
	 */
	private void ingestAntennaLocations(String antennaLocationsFilename) throws Exception
	{	
		FileInputStream fstream = new FileInputStream(antennaLocationsFilename);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine;
	    
	    // Create the items that are not in the antenna_items.xml file. 
	    AntennaItem item = new AntennaItem(NAME_KEY, "name", "Name of the antenna", "name", "string");
	    _items.put(NAME_KEY, item);
	    item = new AntennaItem(NUMBER_KEY, "number", "Number of the antenna", "number", "integer");
	    _items.put(NUMBER_KEY, item);
	    item = new AntennaItem(EASTING_KEY, "easting", "Easting (UTM) location of the antenna", "easting", "double");
	    _items.put(EASTING_KEY, item);
	    item = new AntennaItem(NORTHING_KEY, "northing", "Northing (UTM) location of the antenna", "northing", "double");
	    _items.put(NORTHING_KEY, item);
	    item = new AntennaItem(ELEVATION_KEY, "elevation", "Elevation (meters) location of the antenna", "elevation", "double");
	    _items.put(ELEVATION_KEY, item);
	    
	    while ((strLine = br.readLine()) != null)
	    {
	      String[] parts = strLine.trim().split("\\s+");
	      if(parts[0].startsWith("#")) continue; //Ignore any line starting with #
	      Antenna ant = new Antenna();
	      
	      ant.putValue(NUMBER_KEY, parts[0]);
	      ant.putValue(NAME_KEY, parts[1]);
	      ant.putValue(EASTING_KEY, parts[2]);
	      ant.putValue(NORTHING_KEY, parts[3]);
	      ant.putValue(ELEVATION_KEY, parts[4]);
	      
	      _antennas.put(parts[1], ant);
	    }
	      
	    //Close the streams
	    in.close();
	    fstream.close();

	}
	
	/**
	 * Read in the list of items from the antenna_items.xml file and populate the
	 * _items HashMap.
	 * Only used during development to populate the Antennas instance to create
	 * the JSON file antenna-items.json.
	 * <p>Example of the part of the file we want to parse:
	 * <item id="key50" type="string" units="unk" persistence="86400.0" interval="0.0">
     * <name>OilFloat</name>
     * <abbrev>OilF</abbrev>
     * <description>Oil Float in Alidade</description>
     * <proxycall>new LongDouble( 0L, 0.0)</proxycall>
     * </item>
	 * @param itemsFilename
	 * @return
	 * @throws Exception
	 */
	private void ingestItemXML(String itemsFilename) throws Exception
	{	
		
		
		FileInputStream fstream = new FileInputStream(itemsFilename);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine;
	    String key = "";
	    String name = "";
	    String abbrev = "";
	    String desc = "";
	    String type = "";
	    
	    while ((strLine = br.readLine()) != null)
	    {
	    	int i = strLine.indexOf("id=");
	    	if(i>0) key = getNextEnclosedString(strLine.substring(i+3), "\"", "\"");
	    	i = strLine.indexOf("type=");
	    	if(i>0) type = getNextEnclosedString(strLine.substring(i+5), "\"", "\"");
	    	i = strLine.indexOf("<name>");
	    	if(i>0) name = getNextEnclosedString(strLine.substring(i), ">", "<");
	    	i = strLine.indexOf("<abbrev>");
	    	if(i>0) abbrev = getNextEnclosedString(strLine.substring(i), ">", "<");
	    	i = strLine.indexOf("<description>");
	    	if(i>0)
	    	{
	    		desc = getNextEnclosedString(strLine.substring(i), ">", "<");
	    		//System.out.println(name + "," + abbrev + "," + desc + "," + type);
	    		
	    
	    	    if(abbrev.length() == 0) abbrev = name; //Sometimes there is no abbreviation.
	    	    
	    	    //Add the item to the list of items
		    	AntennaItem item = new AntennaItem(key, name, desc, abbrev, type);
		    	_items.put(key, item);
		    	
		    	Enumeration<String> e = Collections.enumeration(_antennas.keySet());
	            while ( e.hasMoreElements() )
	            {
	                Antenna ant = _antennas.get(e.nextElement());
	                ant.putValue(key, "0");
	            }

		    	key= "";
		    	name = "";
	    	    abbrev = "";
	    	    desc = "";
	    	    type = "";
	    	}
	    }
	    
	    br.close();
	    in.close();
	    fstream.close();
	    
	}
	
	/**
	 * Get the next string enclosed by specified characters.
	 * @param line the line of text to search.
	 * @param startChar the first character delimiter.
	 * @param endEchar the end character delimiter.
	 * @return the String inbetween the characters. Empty String if not found.
	 */
	private static String getNextEnclosedString(String line, String startChar, String endChar)
	{
		int i = line.indexOf(startChar);
		if(i<0) return "";
		int j = line.substring(1).indexOf(endChar);
		if(j<0) return "";
		
		if(j <= i) return "";
		
		return line.substring(i+1, j+1);
	}
	
	/**
	 * Convert a JSON string to an instance of the AntennasInfo class.
	 * @param infos
	 * @return the JSON string converted to the AntennaInfo instance.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static Antennas fromJSON(String filename) throws JsonParseException, JsonMappingException, IOException
	{
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		return (Antennas)mapper.readValue(new File(filename), Antennas.class);
	}
	
	/**
	 * Convert this class instance to a JSON string.
	 * @return this class as a JSON string.
	 */
	public String toJSON()
    {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
            
        try
        {        
        	mapper.writeValue(os, this);
        }
        catch (JsonGenerationException e)
        {
            e.printStackTrace();
        }
        catch (JsonMappingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return os.toString();
    }

	/**
	 * Create a list of antenna names.
	 * @return a comma separated list of antenna names.
	 */
	public String createAntennaList()
	{
		String antList = "";
		
		Enumeration<String> e = Collections.enumeration(_antennas.keySet());
        while ( e.hasMoreElements() )
        {
            Antenna ant = _antennas.get(e.nextElement());
            if(antList.length() > 0) antList += ",";
            antList += ant.getValue(NAME_KEY);
        }
        
        return antList;
	}
	
	/**
	 * Create a list of antenna location information.
	 * @return line separated list of antenna locations.
	 */
	public String createLocationList()
	{
		String locationList = "";
		
		Enumeration<String> e = Collections.enumeration(_antennas.keySet());
        while ( e.hasMoreElements() )
        {
            Antenna ant = _antennas.get(e.nextElement());
            if(locationList.length() > 0) locationList += "\n";
            locationList += ant.getValue(NAME_KEY) + "," ;
            locationList += ant.getValue(NUMBER_KEY) + "," ;
            locationList += ant.getValue(EASTING_KEY) + "," ;
            locationList += ant.getValue(NORTHING_KEY) + "," ;
            locationList += ant.getValue(ELEVATION_KEY);
        }
        
        return locationList;
	}
	
	/**
	 * Create a list of all the antenna items.
	 * @return a line separated list of antenna items.
	 */
	public String createItemList()
	{
		String itemList = "";
		
		Enumeration<String> e = Collections.enumeration(_items.keySet());
        while ( e.hasMoreElements() )
        {
            AntennaItem item = _items.get(e.nextElement());
            if(itemList.length() > 0) itemList += "\n";
            itemList += item.getKey() + "," ;
            itemList += item.getName() + "," ;
            itemList += item.getAbbreviation() + "," ;
            itemList += item.getDescription() + "," ;
            itemList += item.getDataType();
        }
        
        return itemList;
	}
	
	/**
	 * Convenience method to convert an item abbreviation to the item key.
	 * @param abbrev the item abbreviation.
	 * @return the item key. null if not found.
	 */
	public String itemAbbrevToKey(String abbrev)
	{
		Enumeration<String> e = Collections.enumeration(_items.keySet());
        while ( e.hasMoreElements() )
        {
            AntennaItem item = _items.get(e.nextElement());
            if(item.getAbbreviation().equalsIgnoreCase(abbrev)) return item.getKey();
        }
        
        return null;
	}
	
	/**
	 * Get the value of an antenna's item.
	 * @param antennaName the name of the antenna.
	 * @param abbrev the item name abbreviation.
	 * @return the value as a String, if found. Else null.
	 */
	public String getValue(String antennaName, String abbrev)
	{
		String key = itemAbbrevToKey(abbrev);
		if(key == null) return null;
		
		Enumeration<String> e = Collections.enumeration(_antennas.keySet());
        while ( e.hasMoreElements() )
        {
            Antenna ant = _antennas.get(e.nextElement());
            if(ant.getValue(NAME_KEY).equalsIgnoreCase(antennaName))
            	return ant.getValue(key);
        }
		
		return null;
		
	}
	
	/**
	 * Main method. Used for testing.
	 * 
	 * @param args - not used
	 * @throws Exception
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception, JsonMappingException, IOException
	{
		//Use this constructor to populate the Antennas instance with default values, then call 
		//toJSON() to create the default antenna-items.json file contents.
		//Antennas ants = new Antennas("data/antenna_locations.txt", "data/antenna_items.xml");
		//System.out.println(ants.toJSON());
		
		//Once the antenna-items.json file is created (see commented block just above) you can
		//populate _items and _antennas with the default values using fromJSON()
		Antennas ants = Antennas.fromJSON("data/antenna-items.json");
		
		//Print out some information to prove it is working.
		System.out.println("Number of antennas: " + ants.getAntennas().size());
		System.out.println("Number of items: " + ants.getItems().size());
		//Use this to print out the JSON representation of this instance.
		//System.out.println(ants.toJSON());
		System.out.println("Antenna list: " + ants.createAntennaList());
		System.out.println("Antenna locations: \n" + ants.createLocationList());
		System.out.println();
		System.out.println("Item List: \n" + ants.createItemList());
		System.out.println();
		System.out.println("2a alidadeInTemp: " + ants.getValue("2a", "AIT"));
		//Change value to test
		ants.setItemValue("2a", "AIT", 10.11f);
		System.out.println("2a alidadeInTemp: " + ants.getValue("2a", "AIT"));
		System.out.println("1c alidadeInTemp: " + ants.getValue("1c", "AIT"));
		

	}

}
