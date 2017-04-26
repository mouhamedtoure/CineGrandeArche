package fr.demos.formation.test;

import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.Before;
import org.junit.Test;

import fr.demos.formation.PriceInEuros;
import fr.demos.formation.PriceInEuros.PriceOperationException;

public class PriceInEurosTest {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected=PriceOperationException.class)
	public void testPrix_soustractionnegative() throws PriceOperationException {
		PriceInEuros prix1 = new PriceInEuros("20");
		PriceInEuros prix2 = new PriceInEuros("30");
		prix1.subtract(prix2);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testPrix_negatif() {
		PriceInEuros prix = new PriceInEuros("-1");
	}
	
	@Test
	public void testPrix_arrondi() {
		PriceInEuros prix = new PriceInEuros("13.135");
		// toString me permet de vérifier ce qu'il y a dans mon prix
		// répond à la question : sur quoi on vérifie ?
		//assertEquals("arrondi", "13.14", prix.toString());
		assertThat("arrondi",prix.toString(),is("13.14"));
		//Assert.assertEquals("arrondi", 100.00, prix.asBigDecimal());
	}

}
