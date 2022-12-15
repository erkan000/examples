package tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.Test;

import example.hibernate.Hibernate;
import example.hibernate.entity2.Label;
import example.hibernate.entity2.Technology;
import example.hibernate.entity2.TechnologyLabel;

public class Entity2Test {
	
	@Test
	public void save() {
		
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Label l = new Label();
		l.setName("erg");
		Label managedLabel = em.merge(l);
		
		Technology t = new Technology();
		t.setTechnologyName("-------");
		Technology managedTechnology = em.merge(t);
		
		TechnologyLabel tl = new TechnologyLabel();
		tl.setUserName("-------");
		tl.setLabel(managedLabel);
		tl.setTechnology(managedTechnology);
		TechnologyLabel managedTechnologyLabel = em.merge(tl);
		
		System.out.println(managedTechnologyLabel);
		
		tx.commit();		
	}
	
	public void criteria() {
		Session session = getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Item> cr = cb.createQuery(Item.class);
		Root<Item> root = cr.from(Item.class);
		cr.select(root);

		Query<Item> query = session.createQuery(cr);
		List<Item> results = query.getResultList();
	}
	
	private EntityManager getEntityManager(){
		Hibernate test = new Hibernate();		
		test.setup();		
		return test.sessionFactory.openSession().getEntityManagerFactory().createEntityManager();
	}
	
	private Session getSession(){
		Hibernate test = new Hibernate();		
		test.setup();		
		return test.sessionFactory.openSession();
	}

}
