package main.java.model;

import java.util.*;

public class Pie extends AbstractItem
{
	private String flavour;
	private String crustType;	
	
	// Getters/Setters
	public String getFlavour() { return flavour; }    
    public void setFlavour(String flavour) { this.flavour = flavour; }
    
    public String getCrustType() { return crustType; }
    
    public void setCrustType(String crustType) { this.crustType = crustType; }
    
    @Override
    public String toString()
    {
    		String res = super.toString();
    		res += String.format(", crust type = %s, flavour = %s", crustType, flavour);
    		return res;
    }
    
	@Override
	public void fromCSV(String line) throws Exception
	{
		String[] values = line.split(";");
        
        if (values.length != 7 || !values[0].equals("Pie")) {
            System.err.println("Error: Incorrect format. Length: " + values.length + ", Type: " + values[0]);
            throw new Exception("Incorrect data format for Pie object");
        }
        
        UUID id_ = UUID.fromString(values[1]);
        
        Date dt = sdf.parse(values[3]);
        
        double price_ = Double.parseDouble(values[4]);
        
        String flavour_ = values[5];
        String crustType_ = values[6];
        
        this.setId(id_);
        this.setName(values[2]);
        this.setProductionDate(dt);
        this.setPrice(price_);
        this.setFlavour(flavour_);
        this.setCrustType(crustType_); 
		
	}

	@Override
	public String toCSV() throws Exception
	{
		String res = String.join(";",
				"Pie",
	            id.toString(),
	            name,
	            String.valueOf(productionDate.getTime()),
	            String.valueOf(price),
	            flavour,
	            crustType
	        );
		return res;
	}
	
}
