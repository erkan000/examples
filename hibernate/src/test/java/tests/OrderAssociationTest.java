package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.hibernate.Hibernate;
import example.hibernate.dto.IslemDTO;
import example.hibernate.entity.Ordeer;
import example.hibernate.entity.OrderItem;

public class OrderAssociationTest {
	
	@Test
	public void save() {
		Hibernate test = new Hibernate();	
		
		test.setup();
		
		EntityManager em = test.sessionFactory.openSession().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Ordeer o = new Ordeer(1,"test1");
		em.persist(o);
		
		
		OrderItem item = new OrderItem(5, "item5");
		
//		item.setOrder(new Ordeer(4,"test1"));
		OrderItem merged = em.merge(item);	
		
		em.merge(new OrderItem(6, "item5"));
		
		em.flush();
		tx.commit();
		
		OrderItem oo = em.find(OrderItem.class, 5L);
		
		System.out.println(oo.getId());
	}
	
//	@Test
	public void find() {
		Hibernate test = new Hibernate();	
		
		test.setup();
		
		EntityManager em = test.sessionFactory.openSession().getEntityManagerFactory().createEntityManager();
		
		OrderItem o = em.find(OrderItem.class, 1L);
		
		System.out.println("----");
		
		Ordeer o2 = em.find(Ordeer.class, 1L);
		
	}
	

}
