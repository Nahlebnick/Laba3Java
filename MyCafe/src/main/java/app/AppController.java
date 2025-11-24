package main.java.app;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import main.java.model.*;
import main.java.repository.ListCollection;
import main.java.repository.MapCollecton;
import main.java.utils.*;

public class AppController
{

    private ListCollection list = new ListCollection();
    private MapCollecton map = new MapCollecton();
    private String lastPathTxt = new String();
    private String lastPathJSON = new String();
    private String lastPathXML = new String();
    
    public void listAll()
    {
        for (var item : list.getALL())
        {
            System.out.println(item.toString());
        }
        if (list.getALL().isEmpty())
            System.out.println("List is empty!");
    }

    public void zipTxt(String src, String zip)
    {
		try
		{
			ZipUtil.zipFile(src, zip);
			System.out.print(String.format("Successfully zipped %s in %s", src, zip));
		}
		catch (IOException e)
		{
			
		}
	}

    public void decryptTxt(String src, String enc)
    {
		try
		{
			CryptoUtil.decrypt(src, enc);
			System.out.print(String.format("%s was successfully decrypted in %s", src, enc));
		}
		catch (Exception e)
		{
			System.err.print(e.getMessage());
		}
	}

    public void encryptTxt(String src, String enc)
    {
		try
		{
			CryptoUtil.encrypt(src, enc);			
			System.out.print(String.format("%s was successfully encrypted in %s", src, enc));
		}
		catch (Exception e)
		{
			System.err.print(e.getMessage());
		}
	}

    public void loadXml(File f)
    {
    	try
		{
			XMLIO io = new XMLIO();
			List<AbstractItem> tmp = io.readAll(f);
			for (AbstractItem i : tmp)
    		{
			if (!i.equals(null))
    			{
    				list.add(i); map.add(i);
    			}
    		}
			lastPathXML = f.getAbsolutePath();
    		System.out.print(String.format("Successfully loaded from %s", f.getAbsoluteFile()));
		}
		catch (Exception ex)
    	{
    		System.err.print(ex.getMessage());
    	}		
	}

    public void saveXml(File f)
    {
    	try
		{
			XMLIO io = new XMLIO();
			io.writeAll(f, list.getALL());
			lastPathJSON = f.getAbsolutePath();
			lastPathXML = f.getAbsolutePath();
    		System.out.print(String.format("Saved in %s", f.getAbsoluteFile()));
		}
		catch (Exception ex)
    	{
    		System.err.print(ex.getMessage());
    	}	
	}

    public void loadJson(File f)
    {
    	try
		{
			JSONIO io = new JSONIO();
			List<AbstractItem> tmp = io.readAll(f);
			for (AbstractItem i : tmp)
    		{
			if (!i.equals(null))
    			{
    				list.add(i); map.add(i);
    			}
    		}
			lastPathJSON = f.getAbsolutePath();
    		System.out.print(String.format("Successfully loaded from %s", f.getAbsoluteFile()));
		}
		catch (Exception ex)
    	{
    		System.err.print(ex.getMessage());
    	}
	}

    public void saveJson(File f)
    {
		try
		{
			JSONIO io = new JSONIO();
			io.writeAll(f, list.getALL());
			lastPathJSON = f.getAbsolutePath();
    		System.out.print(String.format("Saved in %s", f.getAbsoluteFile()));
		}
		catch (Exception ex)
    	{
    		System.err.print(ex.getMessage());
    	}
		
	}

    public void loadFromTxt(File f)
    {
    	try
    	{
    		TxtIO io = new TxtIO();
    		List<AbstractItem> tmp = io.readAll(f);
    		for (AbstractItem i : tmp)
    		{
    			if (!i.equals(null))
    			{
    				list.add(i); map.add(i);
    			}
    			
    		}
    		lastPathTxt = f.getAbsolutePath();
    		System.out.print(String.format("Successfully loaded from %s", f.getAbsolutePath()));
    		
    	}
    	catch (Exception ex)
    	{
    		System.out.print(ex.getMessage());
    	}
	}

    public void saveTxt(File f)
    {
    	try
    	{
    		TxtIO io = new TxtIO();
    		io.writeAll(f, list.getALL());
    		lastPathTxt = f.getAbsolutePath();
    		System.out.print(String.format("Saved in %s", f.getAbsoluteFile()));
    		
    	}
    	catch (Exception ex)
    	{
    		System.out.print(ex.getMessage());
    	}		
	}

    public void sortByPrice()
    {
		list.sort();
		System.out.print("Sorted");
	}

    public void delete(String IDstr)
    {
    	UUID id= UUID.fromString(IDstr);
		list.delete(list.get(id));
		map.delete(map.get(id));
		System.out.println("Successfully deleted element with id " + IDstr);
	}

    public void update()
    {
	    	if (!lastPathTxt.equals(null))
	    	{
	    		File f = new File(lastPathTxt);
	    		saveJson(f);
	    	}
	    	
	    	if (!lastPathJSON.equals(null))
	    	{
	    		File f = new File(lastPathJSON);
	    		saveJson(f);
	    	}
	    	
	    	if (!lastPathXML.equals(null))
	    	{
	    		File f = new File(lastPathXML);
	    		saveXml(f);
	    	}    	
	}

    public void add(String res)
    {	
    	String what = res.split(";")[0];			
		if (what.equals("Cake"))
		{
		    Cake c = new Cake();
		    try
		    {
		        c.fromCSV(res);
		        list.add(c);
		        map.add(c);
		        System.out.println("Successfully added Cake to list");
		    }
		    catch (Exception e)
		    {
		        System.err.println("Failed to create Cake from CSV: " + e.getMessage());
		    }
		}
		
		else if (what.equals("Pie"))
		{
		    Pie c = new Pie();
		    try
		    {
		        c.fromCSV(res);
		        list.add(c);
		        map.add(c);
		        System.out.println("Successfully added Pie to list");
		    }
		    catch (Exception e)
		    {
		        System.err.println("Failed to create Pie from CSV: " + e.getMessage());
		    }
		}
		else if (what.equals("Cupcake"))
		{
		    Cupcake c = new Cupcake();
		    try
		    {
		        c.fromCSV(res);
		        list.add(c);
		        map.add(c);
		        System.out.println("Successfully added Cupcake to list");
		    }
		    catch (Exception e)
		    {
		        System.err.println("Failed to create Cupcake from CSV: " + e.getMessage());
		    }
		}
		
		//update();	
    }
}
