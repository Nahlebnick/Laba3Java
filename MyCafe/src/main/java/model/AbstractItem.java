package main.java.model;
import java.util.*;

public abstract class AbstractItem {
	protected UUID id = UUID.fromString("0");
	protected String name;
	
	protected Date productionDate;
	
	protected double price;
	
	public AbstractItem()
	{
		productionDate = new Date(); 
	}
	
	public AbstractItem(String name_, Date prodDate, double price_)
	{
		name = name_; productionDate = prodDate; price = price_;
	}
	
	//Getters/setters
	public UUID getId() { return id; }
	public void setId(UUID id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public Date getProductionDate() { return productionDate; }
	public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }

	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	
	@Override
	public String toString()
	{
		String res = String.format("ID = %s, name = %s, production date = %s, price = %.2f", id, name, productionDate, price);
		return res;
	}
}
