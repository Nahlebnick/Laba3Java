package main.java.app;

import java.util.*;
import java.io.*;
import main.java.repository.*;
import main.java.model.*;

public class Menu
{
	private Scanner sc = new Scanner(System.in);
	private ListCollection list = new ListCollection();
	private MapCollecton map;
	
	private MenuListener listener;

    public void setListener(MenuListener listener) {
        this.listener = listener;
    }
    
	public void run()
	{
        while (true) {
            System.out.println(
                "\n1) List all\n2) Add\n3) Update\n4) Delete\n" +
                "5) Sort by price\n6) Save TXT\n7) Load TXT\n" +
                "8) Save JSON\n9) Load JSON\n" +
                "10) Save XML\n11) Load XML\n" +
                "12) Encrypt TXT\n13) Decrypt TXT\n" +
                "14) Zip TXT\n0) Exit");
            switch (sc.nextLine()) {
                case "1": listAll(); break;
                case "2": add(); break;
                case "3": update(); break;
                case "4": delete(); break;
                case "5": sortByPrice(); break;
                case "6": saveTxt(); break;
                case "7": loadFromTxt(); break;
                case "8": saveJson(); break;
                case "9": loadJson(); break;
                case "10": saveXml(); break;
                case "11": loadXml(); break;
                case "12": encryptTxt(); break;
                case "13": decryptTxt(); break;
                case "14": zipTxt(); break;
                case "0": return;
                default: System.out.println("Unknown"); 
            }
        }
    }

	private void zipTxt() {
		// TODO Auto-generated method stub
		
	}

	private void decryptTxt() {
		// TODO Auto-generated method stub
		
	}

	private void encryptTxt() {
		// TODO Auto-generated method stub
		
	}

	private void loadXml() {
		// TODO Auto-generated method stub
		
	}

	private void saveXml() {
		// TODO Auto-generated method stub
		
	}

	private void loadJson() {
		// TODO Auto-generated method stub
		
	}

	private void saveJson() {
		// TODO Auto-generated method stub
		
	}

	private void loadFromTxt() {
		// TODO Auto-generated method stub
		
	}

	private void saveTxt() {
		// TODO Auto-generated method stub
		
	}

	private void sortByPrice() {
		// TODO Auto-generated method stub
		
	}

	private void delete() {
		// TODO Auto-generated method stub
		
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private void add() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
				String res = new String();
				System.out.print("Cake/Pie/Cupcake"); String what = sc.nextLine();
	            System.out.print("ID: "); String id = sc.nextLine();
	            System.out.print("Name: "); String name = sc.nextLine();
	            System.out.print("Price: "); String sp = sc.nextLine();
	            System.out.print("Production date: "); String dt = sc.nextLine();
	            
	            
	            if (what.equals("Cake"))
	            {
	            		System.out.print("Type: "); String type = sc.nextLine();
	                System.out.print("Layers: "); String layers = sc.nextLine();
	                System.out.print("Number of setvings: "); String numberOfServings = sc.nextLine();
	                System.out.print("Weight: "); String weight = sc.nextLine();
	                res = String.join(";", what, id, name, dt, sp, type, layers, numberOfServings, weight);
	                System.out.print(res);
	                
	                Cake c = new Cake();
	                c.fromCSV(res);
	                System.out.print(c.toString());
	                list.add(c);
	                map.add(c);
	                break;
	            }
	            else
	            {
	            	System.out.print("Incorrect data try again: \n");
	            }
			}
            
            
            
            
            	
            
        } catch (Exception ex) {
            
        }
    }

	private void listAll() {
		for (int i = 0; i < list.getALL().size(); i++)
		{
			System.out.print(list.getALL().get(i).toString());
		}
		
		if (list.getALL().size() == 0) System.out.print("List is empty!");
			
	}
}
