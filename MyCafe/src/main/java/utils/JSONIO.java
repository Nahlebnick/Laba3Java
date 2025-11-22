package main.java.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//8import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import main.java.model.AbstractItem;

public class JSONIO implements AbstractIO
{

	@Override
	public List<AbstractItem> readAll(File inFile)
	{
		List<AbstractItem> list = new ArrayList<>();
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			list = mapper.readValue(inFile, mapper.getTypeFactory().constructCollectionType(List.class, AbstractItem.class));
		}
		catch (Exception e)
		{
			System.err.print(e.getMessage());
		}
		return list;
	}

	@Override
	public void writeAll(File outFile, List<AbstractItem> list)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(outFile, list);
		}
		catch (Exception e)
		{
			System.err.print(e.getMessage());
		}
		
	}

}
