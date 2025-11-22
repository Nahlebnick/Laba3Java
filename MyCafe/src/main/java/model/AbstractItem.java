package main.java.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.*;
import java.text.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Cake.class, name = "cake"),
    @JsonSubTypes.Type(value = Pie.class, name = "pie"),
    @JsonSubTypes.Type(value = Cupcake.class, name = "cupcake")})

@JacksonXmlRootElement(localName = "item")
public abstract class AbstractItem implements Comparable<AbstractItem> {
	@JacksonXmlProperty(localName = "id")
	protected UUID id = UUID.randomUUID();
	
	@JacksonXmlProperty(localName = "name")
	protected String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JacksonXmlProperty(localName = "productionDate")
	protected Date productionDate;
	
	@JacksonXmlProperty(localName = "price")
	protected double price;
	
	protected static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
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
	
	public String getType()
	{
        return this.getClass().getSimpleName().toLowerCase();
    }
	
	@Override
	public String toString()
	{
		String res = String.format("ID = %s, name = %s, production date = %s, price = %.2f", id, name, sdf.format(productionDate), price);
		return res;
	}
	
	@Override
	public int compareTo(AbstractItem elem)
	{
		return Double.compare(this.price, elem.price);
	}
	
	public abstract void fromCSV(String line) throws Exception;
	public abstract String toCSV() throws Exception;
}
