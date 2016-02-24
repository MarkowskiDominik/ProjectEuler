package n049_PrimePermutations;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import n049_PrimePermutations.PrimePermutations;

public class PrimePermutationsTest {

	private PrimePermutations primePermutations;

	@Before
	public void inincializeConsecutivePrimeSum() {
		primePermutations = new PrimePermutations();
	}
	
	@After
	public void finalizeConsecutivePrimeSum() {
		primePermutations = null;
	}

	@Test
	public void test() {
		//giving
		List<Integer> expected1 = Arrays.asList(Integer.valueOf(1487), Integer.valueOf(4817), Integer.valueOf(8147));
		List<Integer> expected2 = Arrays.asList(Integer.valueOf(2969), Integer.valueOf(6299), Integer.valueOf(9629));
		
		//when
		List<Integer> actual = primePermutations.calculate();
		
		//then
		assertEquals(expected1, actual);
	}
}
