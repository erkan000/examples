package example.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
	
	@Id
	private Long id;
	
	@Column
	private String name;
	
    @ManyToOne
    @JoinColumn(name = "fk_order")
    private Ordeer order5;
	
//	@OneToOne(mappedBy = "orderItem6")
//	@JoinColumn(nullable = false)
//    private Ordeer order3;
    
//	 @ManyToMany
//	 @JoinTable(name = "store_product",
//	           joinColumns = { @JoinColumn(name = "fk_store") },
//	           inverseJoinColumns = { @JoinColumn(name = "fk_product") })
//	private Set<Ordeer> products = new HashSet<Ordeer>();
    
//	public Ordeer getOrder3() {
//		return order3;
//	}
//	public void setOrder3(Ordeer order3) {
//		this.order3 = order3;
//	}
    public Ordeer getOrder5() {
    	return order5;
    }
    public void setOrder5(Ordeer order) {
    	this.order5 = order;
    }
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

}