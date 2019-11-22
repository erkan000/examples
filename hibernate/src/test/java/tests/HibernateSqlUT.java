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

public class HibernateSqlUT {
	
	@Test
	public void test() {
		Hibernate test = new Hibernate();		
		IslemDTO dto = new IslemDTO();
		dto.setAciklama("Hibernate");
		dto.setDegistirmeZamani(new Timestamp(87));
		dto.setButId(90);
		
		test.setup();
		try {
			test.save(dto);
			long id2 = test.save(dto);
			
			String sql = "SELECT * FROM GSS.ISLEM WHERE id = :id";
			List<IslemDTO> results = test.nativeSql(sql, "id", id2);
			assertEquals(1, results.size());
			IslemDTO islem = results.get(0);
			
			assertNotNull(islem);
			assertEquals(id2, islem.getIslemSiraNo());
			assertEquals(dto.getButId(), islem.getButId());
			assertEquals(dto.getAciklama(), islem.getAciklama());
			assertEquals(dto.getDegistirmeZamani(), islem.getDegistirmeZamani());
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		test.exit();
	}

	private final static Logger logger = LoggerFactory.getLogger(HibernateSqlUT.class);
}
