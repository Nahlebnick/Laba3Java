package main.java.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import main.java.model.AbstractItem;

public class XMLIO implements AbstractIO{

	@Override
	public List<AbstractItem> readAll(File inFile)
	{
		List<AbstractItem> list = new ArrayList<>();
		try
		{
			XmlMapper xmlMapper = new XmlMapper();
			list = xmlMapper.readValue(inFile, xmlMapper.getTypeFactory().constructCollectionType(List.class, AbstractItem.class));
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
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.writeValue(outFile, list);
		}
		catch (Exception e)
		{
			System.err.print(e.getMessage());
		}
		
	}

}
