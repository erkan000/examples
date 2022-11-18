package example.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ordeer {
	
	@Id
	private long id;
	
	@Column
	private String brand;
	
//	@OneToOne
//	@JoinColumn(nullable = false)
//	private OrderItem orderItem6;
	
	@OneToMany(mappedBy = "order5")
	private List<OrderItem> items = new ArrayList<OrderItem>();	
	
//	public OrderItem getOrderItem6() {
//		return orderItem6;
//	}
//	public void setOrderItem6(OrderItem orderItem6) {
//		this.orderItem6 = orderItem6;
//	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
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