package microprofile.openapi;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Car", description = "Sample car class.")
public class Car {

	@Schema(required = true, example = "Anadol")
	private String brand;
	@Schema(required = true, example = "A")
	private String model;
	private LocalDate productionDate;
	@Schema(required = true, readOnly = true, example = "1")
	private long size;
	private boolean isReady;
	private BigDecimal price;
	private double priceDouble;
	
	public Car() {
	}
	
	public Car(String brand, String model, LocalDate productionDate, long size, boolean isReady, BigDecimal price, double priceDouble) {
		this.brand = brand;
		this.model = model;
		this.productionDate = productionDate;
		this.size = size;
		this.isReady = isReady;
		this.price = price;
		this.priceDouble = priceDouble;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
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
