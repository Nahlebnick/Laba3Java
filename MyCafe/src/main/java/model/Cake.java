package main.java.model;

import java.util.*;

public class Cake extends AbstractItem
{
		private String type;
		private int layers;
		private int numberOfServings;
		private double weight;
		
		// Getters/Setters
		public String getType() { return type; }
		public void setType(String type) { this.type = type; }

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
	    
	    public Cake(String name_, Date prodDate, double price_, String type,
	    		int layers, int numberOfServings, double weight)
	    {
	    		super(name_, prodDate, price_);
	    		this.type = type;
	    		this.layers = layers;
	    		this.numberOfServings = numberOfServings;
	    		this.weight = weight;
	    }
	    
	    @Override
	    public String toString()
	    {
	    		String res = super.toString();
	    		res += String.format(", type = %s, layers = %d, numbers of servings = %d, weight = %.1f", type, layers, numberOfServings, weight);
	    		return res;
	    }
		@Override
		public void fromCSV(String line) throws Exception
		{
			String[] values = line.split(";");
	        
	        if (values.length != 9 || !values[0].equals("Cake")) {
	            System.err.println("Error: Incorrect format. Length: " + values.length + ", Type: " + values[0]);
	            throw new Exception("Incorrect data format for Cake object");
	        }
	        
	        UUID id_ = UUID.fromString(values[1]);
	        
	        Date dt = sdf.parse(values[3]);
	        
	        double price_ = Double.parseDouble(values[4]);
	        
	        int layers_ = Integer.parseInt(values[6]);
	        
	        int num = Integer.parseInt(values[7]);
	        
	        double w = Double.parseDouble(values[8]);
	        
	        this.setId(id_);
	        this.setName(values[2]);
	        this.setProductionDate(dt);
	        this.setPrice(price_);
	        this.setLayers(layers_);
	        this.setNumberOfServings(num);
	        this.setWeight(w);
	        this.setType(values[5]);  
		}
		@Override
		public String toCSV() {
			String res = String.join(";",
					"Cake",
		            id.toString(),
		            name,
		            String.valueOf(productionDate.getTime()),
		            String.valueOf(price),
		            type,
		            String.valueOf(layers),
		            String.valueOf(numberOfServings),
		            String.valueOf(weight)
		        );
			return res;
		}
	    
	    
}