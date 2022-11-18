package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import example.hibernate.Hibernate;
import example.hibernate.entity.Ordeer;
import example.hibernate.entity.OrderItem;

public class RelationsTest {
	
	@Test
	public void save() {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Ordeer order = new Ordeer(1, "test1");
		Ordeer managedOrder = em.merge(order);		
		
		OrderItem orderItem = new OrderItem(5, "item5");		
		orderItem.setOrder5(managedOrder);
		OrderItem managedOrderItem = em.merge(orderItem);
		
		em.remove(managedOrderItem);
		
		tx.commit();		
	}
	
//	@Test
	public void find() {
		EntityManager em = getEntityManager();
		
		em.find(OrderItem.class, 1L);
		
		em.find(Ordeer.class, 1L);
		
	}
	
	private EntityManager getEntityManager(){
		Hibernate test = new Hibernate();		
		test.setup();		
		return test.sessionFactory.openSession().getEntityManagerFactory().createEntityManager();
	}

}
