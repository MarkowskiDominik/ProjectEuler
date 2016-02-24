package n049_PrimePermutations;

import static org.junit.Assert.*;

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
	public void test1() {
		//giving
		List<Integer> expected = Arrays.asList(Integer.valueOf(1487), Integer.valueOf(4817), Integer.valueOf(8147));
		
		//when
		List<Integer> actual = primePermutations.calculate(1000);
		
		//then
		assertTrue(actual.containsAll(expected));
	}
	
	@Test
	public void test2() {
		//giving
		List<Integer> expected = Arrays.asList(Integer.valueOf(2969), Integer.valueOf(6299), Integer.valueOf(9629));
		
		//when
		List<Integer> actual = primePermutations.calculate(1488);
		
		//then
		assertTrue(actual.containsAll(expected));
	}
}
