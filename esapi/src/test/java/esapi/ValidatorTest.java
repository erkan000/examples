package esapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.owasp.esapi.ESAPI;

public class ValidatorTest {

	@Test
	void validator() {
		boolean isValidDouble = ESAPI.validator().isValidDouble("TCKNo", "32111122554", 11111111110L, 99999999990L,
				false);
		assertTrue(isValidDouble);
	}

	@Test
	void encoder() {
		String encode = ESAPI.encoder().encodeForJSON("{\"a\"}");
		assertEquals("{\\\"a\\\"}", encode);
	}

	@Test
	void encoderHtlm() {
		String encode = ESAPI.encoder().encodeForHTML("<");
		assertEquals("&lt;", encode);
	}

}
