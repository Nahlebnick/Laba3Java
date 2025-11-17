package main.java.utils;
import main.java.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtIO<T extends AbstractItem> implements AbstractIO<T>{
	
	private final Class<T> clazz;

    public TxtIO(Class<T> clazz) {
        this.clazz = clazz;
    }

	@Override
	public List<T> readAll(String path)
	{
		List<T> list = new ArrayList<>();
		File inFile = new File(path);
        if (inFile.exists())
        {
        		String line = new String();
	        try (BufferedReader br = new BufferedReader(new FileReader(inFile)))
	        {
	            while ((line = br.readLine()) != null)
	            {
	            		T elem = clazz.getDeclaredConstructor().newInstance();
	            		elem.fromCSV(line);
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

	@Override
	public void writeAll(String path, List<T> list) {
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
