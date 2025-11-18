package main.java.utils;
import main.java.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtIO implements AbstractIO
{
	@Override
	public List<AbstractItem> readAll(String path)
	{
		List<AbstractItem> list = new ArrayList<>();
		File inFile = new File(path);
        if (inFile.exists())
        {
        		String line = new String();
	        try (BufferedReader br = new BufferedReader(new FileReader(inFile)))
	        {
	            while ((line = br.readLine()) != null)
	            {
	            		AbstractItem elem = createItemFromCSV(line);
	            		list.add(elem);
	            }
	        }
	        catch(Exception e)
	        {
	        		System.err.println("Error parsing line: " + line + " : " + e.getMessage());
	        }
        }
		return list;
	}
	
	private AbstractItem createItemFromCSV(String line) {
        try {
            String[] values = line.split(";");
            if (values.length == 0) return null;
            
            String type = values[0].trim();
            AbstractItem item = null;
            
            switch (type) {
                case "Cake":
                    item = new Cake();
                    break;
                case "Pie":
                    item = new Pie();
                    break;
                case "Cupcake":
                    item = new Cupcake();
                    break;
                default:
                    System.err.println("Unknown item type: " + type);
                    return null;
            }
            
            item.fromCSV(line);
            return item;
            
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line + " : " + e.getMessage());
            return null;
        }
    }

	@Override
	public void writeAll(String path, List<AbstractItem> list) {
		File outFile = new File(path);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile)))
        {
        	
        		for (int i = 0; i < list.size(); i++)
        		{
        			bw.write(list.get(i).toCSV());
        			bw.newLine();
        		}
        }
        catch(Exception e)
        {
        		System.err.println(e.getMessage());
        }    
		
	};
}
