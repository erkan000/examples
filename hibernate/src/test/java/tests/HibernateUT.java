package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.hibernate.Hibernate;
import example.hibernate.dto.IslemDTO;

public class HibernateUT {
	
	@Test
	public void testHibernateCrud() {
		Hibernate test = new Hibernate();		
		IslemDTO dto = new IslemDTO();
		dto.setAciklama("Hibernate");
		dto.setDegistirmeZamani(new Timestamp(87));
		dto.setButId(982);		
		
		test.setup();
		try {
			long id = test.save(dto);
			assertNotEquals(0, id);
			
			IslemDTO islem = test.read(id);
			assertNotNull(islem);
			assertEquals(id, islem.getIslemSiraNo());
			assertEquals(dto.getButId(), islem.getButId());
			assertEquals(dto.getAciklama(), islem.getAciklama());
			assertEquals(dto.getDegistirmeZamani(), islem.getDegistirmeZamani());
				
			IslemDTO dtoUpdated = new IslemDTO();
			dtoUpdated.setAciklama("Updated");
			dtoUpdated.setButId(123);
			dtoUpdated.setDegistirmeZamani(new Timestamp(547));
			dtoUpdated.setIslemSiraNo(id);
			
			test.update(dtoUpdated);
			
			IslemDTO islemUpdated = test.read(id);
			assertNotNull(islemUpdated);
			assertEquals(id, islemUpdated.getIslemSiraNo());
			assertEquals(dtoUpdated.getButId(), islemUpdated.getButId());
			assertEquals(dtoUpdated.getAciklama(), islemUpdated.getAciklama());
			assertEquals(dtoUpdated.getDegistirmeZamani(), islemUpdated.getDegistirmeZamani());
			
			IslemDTO dtoDeleted = new IslemDTO();
			dtoDeleted.setIslemSiraNo(id);
			test.delete(dtoDeleted);
			
			IslemDTO islemDeleted = test.read(id);
			assertNull(islemDeleted);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		test.exit();
	}

	private final static Logger logger = LoggerFactory.getLogger(HibernateUT.class);
}
