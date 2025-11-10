package main.java.model;

import java.util.Date;

import main.java.model.AbstractItem;

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
}
