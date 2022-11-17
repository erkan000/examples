package example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	private Long id;
	
	@Column
	private String name;
 
    @ManyToOne
    private Ordeer order;
    
    
    
	public OrderItem() {
	}
	public OrderItem(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Ordeer getOrder() {
		return order;
	}
	public void setOrder(Ordeer order) {
		this.order = order;
	}
}