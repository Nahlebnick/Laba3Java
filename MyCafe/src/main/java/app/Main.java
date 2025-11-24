package main.java.app;

import java.io.File;
import java.util.Scanner;
import main.java.utils.*;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Menu menu = new Menu(sc);
		AppController app = new AppController();
		
		
		menu.setListener(value-> {
			switch(value)
			{
				case 1: app.listAll(); break;
				case 2: app.add(getInfoAboutCake()); break;
				case 4: app.delete(getID()); break;
				case 5: app.sortByPrice(); break;
				case 6: app.saveTxt(getFile(false)); break;
				case 7: app.loadFromTxt(getFile(true)); break;
				case 8: app.saveJson(getFile(false)); break;
				case 9: app.loadJson(getFile(true)); break;
				case 10: app.saveXml(getFile(false)); break;
				case 11: app.loadXml(getFile(true)); break;
				case 12: app.encryptTxt(getFile(true).getPath(), getFile(false).getPath()); break;
				case 13: app.decryptTxt(getFile(true).getPath(), getFile(false).getPath()); break;
				case 14: app.zipTxt(getFile(true).getPath(), getFile(false).getPath()); break;
		        case 0: System.out.print("Good bye!"); return;
	            default: System.out.println("Unknown"); 
			}
		});
		
		menu.run();
	}
	
	private static String getInfoAboutCake()
	{
		while(true)
		{	
			String res = new String();
			
			System.out.print("Cake/Pie/Cupcake: "); 
            String what = sc.nextLine().trim();
            
            if (!what.equals("Cake") && !what.equals("Pie") && !what.equals("Cupcake"))
            {
                System.err.println("Incorrect type! Please enter: Cake, Pie or Cupcake\n");
                continue;
            }
			
            try
            {
	            System.out.print("ID: "); String id = sc.nextLine().trim();
	            Validator.parseID(id);
	            System.out.print("Name: "); String name = sc.nextLine().trim();
	            Validator.isNotEmpty(name);
	            System.out.print("Price: "); String sp = sc.nextLine().trim();
	            Validator.parseDouble(sp, "Price");
	            System.out.print("Production date: "); String dt = sc.nextLine().trim();
	            Validator.parseDate(dt);
	            
	            
	            if (what.equals("Cake"))
	            {
	                System.out.print("Layers: "); String layers = sc.nextLine().trim();
	                Validator.parseInteger(layers, "Layers");
	                System.out.print("Number of setvings: "); String numberOfServings = sc.nextLine().trim();
	                Validator.parseInteger(numberOfServings, "Number of servings");
	                System.out.print("Weight: "); String weight = sc.nextLine().trim();
	                Validator.parseDouble(weight, "Weight");
	                res = String.join(";", what, id, name, dt, sp, layers, numberOfServings, weight);
	                return res;
	            }
	            else if (what.equals("Cupcake"))
	            {
	            	System.out.print("Flavour: "); String flavour = sc.nextLine().trim();
	            	Validator.isNotEmpty(flavour);
	                System.out.print("Weight: "); String weight = sc.nextLine().trim();
	                Validator.parseDouble(weight, "Weight");
	                res = String.join(";", what, id, name, dt, sp, flavour, weight);
	                return res;
	            }
	            else if (what.equals("Pie"))
	            {
	                System.out.print("Flavour: "); String flavour = sc.nextLine().trim();
	                Validator.isNotEmpty(flavour);
	                System.out.print("Crust type: "); String crustType = sc.nextLine().trim();
	                Validator.isNotEmpty(crustType);
	                res = String.join(";", what, id, name, dt, sp, flavour, crustType);
	                return res;
	            }
            }
            catch (Exception e)
            {
            	System.err.print(e.getMessage() + "\n");
            	System.out.print("Try again: " + "\n");
            }
		} 
	}
	
	private static String getID()
	{	
		String res = new String();
		while (true)
		{
			try {			
				System.out.print("Enter id of the element to delete: ");
				res = sc.nextLine();
				Validator.parseID(res);
				return res;
			}
			catch (Exception e)
			{
				System.err.println("Error: " + e.getMessage() + ". Please try again.");
			}
		}	
	}
	
	private static File getFile(boolean shouldExist)
	{
		while (true)
		{
			System.out.print("Enter file path: ");
			String path = sc.nextLine();
			try
			{
	            File file = Validator.parseFile(path, shouldExist);
	            if (file != null)
	            {
	                return file;
	            }
	            else
	            {
	                System.err.println("Invalid file path. Please try again.");
	            }
	        }
			catch (Exception e)
			{
	            System.err.println("Error: " + e.getMessage() + ". Please try again.");
	        }
		}
	}
}
