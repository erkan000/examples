package example.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.hibernate.dto.IslemDTO;

public class Hibernate {

	public SessionFactory sessionFactory;
	private final static Logger logger = LoggerFactory.getLogger(Hibernate.class);

	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public List<IslemDTO> nativeSql(String sql,String name, Object value) {
		List<IslemDTO> results = null;
		NativeQuery<IslemDTO> query = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			query = session.createNativeQuery(sql);
			query.addEntity(IslemDTO.class);
			query.setParameter(name, value);
			results = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			logger.error(e.getMessage()); 
		} finally {
			session.close(); 
		}
		return results;
	}
	
	public List<IslemDTO> hqlList(String hql) {
		List<IslemDTO> results = null;
		Query<IslemDTO> query = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			query = session.createQuery(hql);
			results = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			logger.error(e.getMessage());
		} finally {
			session.close(); 
		}
		return results;
	}
	
	public int hqlUpdate(String hql, String name1, Object value1, String name2, Object value2) {
		int affRows = 0;
		Query<IslemDTO> query = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			query = session.createQuery(hql);
			query.setParameter(name1, value1);
			query.setParameter(name2, value2);
			affRows = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			logger.error(e.getMessage()); 
		} finally {
			session.close(); 
		}
		return affRows;
	}

	public IslemDTO read(long id) {
		IslemDTO result = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = session.get(IslemDTO.class, id); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			logger.error(e.getMessage());
		} finally {
			session.close(); 
		}
		return result;
	}

	public Long save(IslemDTO h) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Long id = null;
		try {
			tx = session.beginTransaction();
			id = (Long) session.save(h); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			logger.error(e.getMessage()); 
		} finally {
			session.close(); 
		}
		return id;
	}
	
	public void update(IslemDTO h) {		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(h);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			logger.error(e.getMessage()); 
		} finally {
			session.close(); 
		}
	}

	public void delete(IslemDTO h) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(h); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null)
				tx.rollback();
			logger.error(e.getMessage());
		} finally {
			session.close(); 
		}
	}

	public void exit() {
		sessionFactory.close();
	}

}