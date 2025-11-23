package main.java.model;

import java.util.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Cake extends AbstractItem
{
		@JacksonXmlProperty(localName = "layers")
		private int layers;
		
		@JacksonXmlProperty(localName = "numberOfServings")
		private int numberOfServings;
		
		@JacksonXmlProperty(localName = "weight")
		private double weight;
		
		// Getters/Setters

		public int getLayers() { return layers; }
		public void setLayers(int layers) { this.layers = layers; }

		public int getNumberOfServings() { return numberOfServings; }
		public void setNumberOfServings(int numberOfServings) { this.numberOfServings = numberOfServings; }

		public double getWeight() { return weight; }
		public void setWeight(double weight) { this.weight = weight; }
	    
	    public Cake()
	    {
	    	super();
	    }
	    
	    public Cake(String name_, Date prodDate, double price_,
	    		int layers, int numberOfServings, double weight)
	    {
	    		super(name_, prodDate, price_);
	    		this.layers = layers;
	    		this.numberOfServings = numberOfServings;
	    		this.weight = weight;
	    }
	    
	    @Override
	    public String toString()
	    {
	    		String res = super.toString();
	    		res += String.format(", layers = %d, numbers of servings = %d, weight = %.1f", layers, numberOfServings, weight);
	    		return res;
	    }
		@Override
		public void fromCSV(String line) throws Exception
		{
			String[] values = line.split(";");
	        
	        if (values.length != 8 || !values[0].equals("Cake")) {
	            System.err.println("Error: Incorrect format. Length: " + values.length + ", Type: " + values[0]);
	            throw new Exception("Incorrect data format for Cake object");
	        }
	        
	        UUID id_ = UUID.fromString(values[1]);
	        
	        Date dt = sdf.parse(values[3]);
	        
	        double price_ = Double.parseDouble(values[4]);
	        
	        int layers_ = Integer.parseInt(values[5]);
	        
	        int num = Integer.parseInt(values[6]);
	        
	        double w = Double.parseDouble(values[7]);
	        
	        this.setId(id_);
	        this.setName(values[2]);
	        this.setProductionDate(dt);
	        this.setPrice(price_);
	        this.setLayers(layers_);
	        this.setNumberOfServings(num);
	        this.setWeight(w); 
		}
		@Override
		public String toCSV()
		{
			String res = String.join(";",
					"Cake",
		            id.toString(),
		            name,
		            String.valueOf(productionDate.getTime()),
		            String.valueOf(price),
		            String.valueOf(layers),
		            String.valueOf(numberOfServings),
		            String.valueOf(weight)
		        );
			return res;
		}
	    
	    
}