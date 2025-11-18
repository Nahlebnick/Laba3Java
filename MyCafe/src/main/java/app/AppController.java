package main.java.app;

import java.util.List;

import main.java.model.*;
import main.java.repository.ListCollection;
import main.java.repository.MapCollecton;
import main.java.utils.*;

public class AppController
{

    private ListCollection list = new ListCollection();
    private MapCollecton map = new MapCollecton();
    
    public void listAll()
    {
        for (var item : list.getALL()) {
            System.out.println(item.toString());
        }
        if (list.getALL().isEmpty())
            System.out.println("List is empty!");
    }

    public void zipTxt() {
		// TODO Auto-generated method stub
		
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

    public void loadJson() {
		// TODO Auto-generated method stub
		
	}

    public void saveJson() {
		// TODO Auto-generated method stub
		
	}

    public void loadFromTxt(String path)
    {
    	try
    	{
    		TxtIO io = new TxtIO();
    		List<AbstractItem> tmp = io.readAll(path);
    		for (AbstractItem i : tmp)
    		{
    			list.add(i);
    			map.add(i);
    		}
    		System.out.print(String.format("Successfully loaded from %s", path));
    		
    	}
    	catch (Exception ex)
    	{
    		System.out.print(ex.getMessage());
    	}
	}

    public void saveTxt(String path)
    {
    	try
    	{
    		TxtIO io = new TxtIO();
    		io.writeAll(path, list.getALL());
    		System.out.print(String.format("Saved in %s", path));
    		
    	}
    	catch (Exception ex)
    	{
    		System.out.print(ex.getMessage());
    	}		
	}

    public void sortByPrice() {
		// TODO Auto-generated method stub
		
	}

    public void delete() {
		// TODO Auto-generated method stub
		
	}

    public void update()
    {
				
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
