package example.jsonb.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbNumberFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

@JsonbNillable
public class CustomizedCar{

	@JsonbProperty("car-brand")
	private String brand;
	private String model;	
	@JsonbDateFormat("dd.MM.yyyy")
	private LocalDate productionDate;
	private long size;
	private boolean isReady;
	@JsonbNumberFormat("#0.00")
	private BigDecimal price;
	@JsonbTransient
	private double priceDouble;
	
	public CustomizedCar() {
	}
	
	public CustomizedCar(String brand, String model, LocalDate productionDate, long size, boolean isReady, BigDecimal price, double priceDouble) {
		this.brand = brand;
		this.model = model;
		this.productionDate = productionDate;
		this.size = size;
		this.isReady = isReady;
		this.price = price;
		this.priceDouble = priceDouble;
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = "<br/>";
		result.append("Brand:" + brand);
		result.append(newLine);
		result.append("Model:" + model);
		result.append(newLine);
		result.append("productionDate:" + productionDate);
		result.append(newLine);
		result.append("size:" + size);
		result.append(newLine);
		result.append("isReady:" + isReady);
		result.append(newLine);
		result.append("price:" + price);
		result.append(newLine);
		result.append("priceDouble:" + priceDouble);
		return result.toString();
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@JsonbProperty("car-model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getProductionDate() {
		return productionDate;
	}
	
	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public double getPriceDouble() {
		return priceDouble;
	}
	public void setPriceDouble(double priceDouble) {
		this.priceDouble = priceDouble;
	}

}
