package main.java.app;

import java.io.File;
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
    private String lastPath = new String();
    
    public void listAll()
    {
        for (var item : list.getALL()) {
            System.out.println(item.toString());
        }
        if (list.getALL().isEmpty())
            System.out.println("List is empty!");
    }

    public void zipTxt()
    {
				
	}

    public void decryptTxt() {
		// TODO Auto-generated method stub
		
	}

    public void encryptTxt() {
		// TODO Auto-generated method stub
		
	}

    public void loadXml() {
		// TODO Auto-generated method stub
		
	}

    public void saveXml() {
		// TODO Auto-generated method stub
		
	}

    public void loadJson()
    {
				
	}

    public void saveJson()
    {
				
	}

    public void loadFromTxt(File f)
    {
    	try
    	{
    		TxtIO io = new TxtIO();
    		List<AbstractItem> tmp = io.readAll(f);
    		for (AbstractItem i : tmp)
    		{
    			list.add(i);
    			map.add(i);
    		}
    		lastPath = f.getAbsolutePath();
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
    		lastPath = f.getAbsolutePath();
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
    	File f = new File(lastPath);
    	loadFromTxt(f);		
	}

    public void add(String res)
    {
		try 
		{			
			String what = res.split(";")[0];			
			if (what.equals("Cake"))
			{
			    Cake c = new Cake();
			    try {
			        c.fromCSV(res);
			        list.add(c);
			        map.add(c);
			        System.out.println("Successfully added Cake to list");
			    } catch (Exception e) {
			        System.err.println("Failed to create Cake from CSV: " + e.getMessage());
			        e.printStackTrace();
			    }
			}
			
			else if (what.equals("Pie"))
			{
			    Pie c = new Pie();
			    try {
			        c.fromCSV(res);
			        list.add(c);
			        map.add(c);
			        System.out.println("Successfully added Pie to list");
			    } catch (Exception e) {
			        System.err.println("Failed to create Pie from CSV: " + e.getMessage());
			        e.printStackTrace();
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
			        e.printStackTrace();
			    }
			}
			
			else
			{
				System.out.print("Incorrect Data!");
			}
          
        }
		catch (Exception ex)
		{
			System.out.print(ex.getMessage());
		}
    }
}
