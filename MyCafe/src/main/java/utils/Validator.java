package main.java.utils;

import java.io.File;
import java.text.*;
import java.util.*;

public class Validator
{
	public static boolean isNotEmpty(String s)
	{ 
		if (s == null || s.isBlank())
		{
			throw new IllegalArgumentException("Empty string");
		}
		return true;
	}
	
	public static UUID parseID(String id) throws IllegalArgumentException
	{
	    if (id == null || id.trim().isEmpty()) {
	        throw new IllegalArgumentException("ID cannot be null or empty");
	    }
	    
	    String trimmedId = id.trim();
	    try
	    {
	        return UUID.fromString(trimmedId);
	    }
	    catch (IllegalArgumentException e)
	    {
	        throw new IllegalArgumentException("Invalid UUID format: " + trimmedId + 
	                                         ". Example: 123e4567-e89b-12d3-a456-426614174000");
	    }
	}
	
	public static Date parseDate(String dateStr) throws IllegalArgumentException
	{
	    if (dateStr == null || dateStr.trim().isEmpty())
	    {
	        throw new IllegalArgumentException("Date cannot be null or empty");
	    }
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String trimmedDate = dateStr.trim();
	    try
	    {
	        sdf.setLenient(false);
	        return sdf.parse(trimmedDate);
	    }
	    catch (ParseException e)
	    {
	        throw new IllegalArgumentException("Invalid date format. Expected: " + sdf.toPattern() + ", got: " + trimmedDate);
	    }
	}
	
	public static int parseInteger(String number, String fieldName) throws IllegalArgumentException {
	    if (number == null || number.trim().isEmpty()) {
	        throw new IllegalArgumentException(fieldName + " cannot be null or empty");
	    }
	    
	    String trimmedNumber = number.trim();
	    try
	    {
	        int value = Integer.parseInt(trimmedNumber);
	        if (value < 0)
	        {
	            throw new IllegalArgumentException(fieldName + " cannot be negative: " + value);
	        }
	        return value;
	    }
	    catch (NumberFormatException e)
	    {
	        throw new IllegalArgumentException("Invalid " + fieldName + " format. Expected integer, got: " + trimmedNumber);
	    }
	}

	public static double parseDouble(String number, String fieldName) throws IllegalArgumentException {
	    if (number == null || number.trim().isEmpty())
	    {
	        throw new IllegalArgumentException(fieldName + " cannot be null or empty");
	    }
	    
	    String trimmedNumber = number.trim();
	    try
	    {
	        double value = Double.parseDouble(trimmedNumber);
	        if (value < 0)
	        {
	            throw new IllegalArgumentException(fieldName + " cannot be less than " + 0 + ": " + value);
	        }
	        return value;
	    }
	    catch (NumberFormatException e)
	    {
	        throw new IllegalArgumentException("Invalid " + fieldName + " format. Expected number, got: " + trimmedNumber);
	    }
	}
	
	public static File parseFile(String path, boolean shouldExist) throws IllegalArgumentException
	{
		if (path == null || path.trim().isEmpty())
		{
	        throw new IllegalArgumentException("Path cannot be null or empty");
	    }
	    
	    File file = new File(path.trim());
	    
	    if (shouldExist && !file.exists())
	    {
	    	throw new IllegalArgumentException("File does not exist" + path);
	    }
	    
	    if (shouldExist && file.isDirectory())
	    {
	        throw new IllegalArgumentException("Path is a directory, not a file: " + path);
	    }	    
	    return file;
		
	}
}
