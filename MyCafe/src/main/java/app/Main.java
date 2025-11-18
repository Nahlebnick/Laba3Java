package main.java.app;

import java.util.Scanner;

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
				case 3: app.update(); break;
				case 4: app.delete(); break;
				case 5: app.sortByPrice(); break;
				case 6: app.saveTxt(getPath()); break;
				case 7: app.loadFromTxt(getPath()); break;
				case 8: app.saveJson(); break;
				case 9: app.loadJson(); break;
				case 10: app.saveXml(); break;
				case 11: app.loadXml(); break;
				case 12: app.encryptTxt(); break;
				case 13: app.decryptTxt(); break;
				case 14: app.zipTxt(); break;
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
                System.out.println("Incorrect type! Please enter: Cake, Pie or Cupcake\n");
                continue;
            }
			
            System.out.print("ID: "); String id = sc.nextLine().trim();
            System.out.print("Name: "); String name = sc.nextLine().trim();
            System.out.print("Price: "); String sp = sc.nextLine().trim();
            System.out.print("Production date: "); String dt = sc.nextLine().trim();
            
            
            if (what.equals("Cake"))
            {
            		System.out.print("Type: "); String type = sc.nextLine().trim();
                System.out.print("Layers: "); String layers = sc.nextLine().trim();
                System.out.print("Number of setvings: "); String numberOfServings = sc.nextLine().trim();
                System.out.print("Weight: "); String weight = sc.nextLine().trim();
                res = String.join(";", what, id, name, dt, sp, type, layers, numberOfServings, weight);
                return res;
            }
            else if (what.equals("Cupcake"))
            {
            	System.out.print("Flavour: "); String flavour = sc.nextLine().trim();
                System.out.print("Weight: "); String weight = sc.nextLine().trim();
                res = String.join(";", what, id, name, dt, sp, flavour, weight);
                return res;
            }
            else if (what.equals("Pie"))
            {
                System.out.print("Flavour: "); String flavour = sc.nextLine().trim();
                System.out.print("Crust type: "); String crustType = sc.nextLine().trim();
                res = String.join(";", what, id, name, dt, sp, flavour, crustType);
                return res;
            }
            else
            {
            	System.out.print("Incorrect data try again: \n");
            }
		} 
	}
	
	private static String getPath()
	{
		String res = new String();
		System.out.print("Enter path to file: ");
		res = sc.nextLine();
		return res;
	}
}
