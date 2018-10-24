package tamgiac;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TamGiacTest {
	TamGiac tamGiacTest;

	@Before
	public void setUp() throws Exception {
		tamGiacTest = new TamGiac();
	}

	@Test
	public void testKiemTraDoDai() {
		boolean result =  1 + 2 > 3;
		assertEquals(result, tamGiacTest.kiemTraDoDai(1, 2, 3));
	}

	@Test
	public void testIsTamGiac() {
		boolean result = true;
		assertEquals(result, tamGiacTest.isTamGiac(3, 4, 5));
	
		result = false;
		assertEquals(result, tamGiacTest.isTamGiac(0, 0, 0));
		assertEquals(result, tamGiacTest.isTamGiac(-1, 2, 4));
		assertEquals(result, tamGiacTest.isTamGiac(-1, -2, 4));
		assertEquals(result, tamGiacTest.isTamGiac(-1, -2, -4));
		assertEquals(result, tamGiacTest.isTamGiac(5, 3, 2));
		assertEquals(result, tamGiacTest.isTamGiac(3, 4, 7));
		assertEquals(result, tamGiacTest.isTamGiac(2, 6, 8));
	}

}
