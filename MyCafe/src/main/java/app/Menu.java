package main.java.app;

import java.util.*;
import java.io.*;
import main.java.repository.*;
import main.java.model.*;

public class Menu
{
	private final Scanner sc;

    public Menu(Scanner sc) {
        this.sc = sc;
    }

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
            int value = Integer.parseInt(sc.nextLine());
            
            if (listener != null)
            {
            	listener.onInput(value);
            }
            if (value == 0) return;
        }
    }

	
}
