package example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ordeer {
	
	@Id
	private long id;
	
	@Column
	private String brand;
	
	
	
	public Ordeer() {
	}
	public Ordeer(long id, String brand) {
		this.id = id;
		this.brand = brand;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}	
}