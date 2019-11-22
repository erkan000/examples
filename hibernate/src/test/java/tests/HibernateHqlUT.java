package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.hibernate.Hibernate;
import example.hibernate.dto.IslemDTO;

public class HibernateHqlUT {
	
	@Test
	public void test() {
		Hibernate test = new Hibernate();		
		IslemDTO dto = new IslemDTO();
		dto.setAciklama("Hibernate");
		dto.setDegistirmeZamani(new Timestamp(87));
		dto.setButId(90);
		
		test.setup();
		try {
			long id1 = test.save(dto);
			long id2 = test.save(dto);
			
			String hql = "FROM ENT_ISLEM";
			List<IslemDTO> results = test.hqlList(hql);
			assertEquals(2, results.size());
			IslemDTO islem1 = results.get(0);
			IslemDTO islem2 = results.get(1);
			
			assertNotNull(islem1);
			assertEquals(id1, islem1.getIslemSiraNo());
			assertNotNull(islem2);
			assertEquals(id2, islem2.getIslemSiraNo());
			
			hql = "UPDATE ENT_ISLEM set aciklama = :aciklama WHERE id = :id";
			int affRows = test.hqlUpdate(hql, "aciklama", "updated", "id" ,id1);
			assertEquals(1, affRows);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		test.exit();
	}
	
	private final static Logger logger = LoggerFactory.getLogger(HibernateHqlUT.class);

}
