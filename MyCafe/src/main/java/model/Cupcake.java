package main.java.model;

import java.util.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Cupcake extends AbstractItem
{
	@JacksonXmlProperty(localName = "flavour")
	String flavour;
	
	@JacksonXmlProperty(localName = "weight")
	double weight;
	
	// Getters/Setters
	public String getFlavour() { return flavour; }    
    public void setFlavour(String flavour) { this.flavour = flavour; }
    
    public double getWeight() { return weight; }
    
    public void setWeight(double weight) { this.weight = weight; }
    
    // Конструкторы
    public Cupcake()
    {
        super();
    }
    
    public Cupcake(String name, Date prodDate, double price, String flavour, double weight)
    {
        super(name, prodDate, price);
        this.flavour = flavour;
        this.weight = weight;
    }
    @Override
    public String toString()
    {
    		String res = super.toString();
    		res += String.format(", flavour = %s, weight = %.1f", flavour, weight);
    		return res;
    }
	
	@Override
	public void fromCSV(String line) throws Exception
	{
		String[] values = line.split(";");
        
        if (values.length != 7 || !values[0].equals("Cupcake")) {
            System.err.println("Error: Incorrect format. Length: " + values.length + ", Type: " + values[0]);
            throw new Exception("Incorrect data format for Cupcake object");
        }
        
        UUID id_ = UUID.fromString(values[1]);
        
        Date dt = sdf.parse(values[3]);
        
        double price_ = Double.parseDouble(values[4]);
        
        String flavour_ = values[5];
        double w = Double.parseDouble(values[6]);
        
        this.setId(id_);
        this.setName(values[2]);
        this.setProductionDate(dt);
        this.setPrice(price_);
        this.setFlavour(flavour_);
        this.setWeight(w); 
	}

	@Override
	public String toCSV() throws Exception
	{
		String res = String.join(";",
				"Cupcake",
	            id.toString(),
	            name,
	            sdf.format(productionDate),
	            String.valueOf(price),
	            flavour,
	            String.valueOf(weight)
	        );
		return res;
	}

}
