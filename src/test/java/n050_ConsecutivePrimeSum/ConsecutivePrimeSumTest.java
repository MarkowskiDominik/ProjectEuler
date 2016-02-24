package n050_ConsecutivePrimeSum;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import n050_ConsecutivePrimeSum.ConsecutivePrimeSum;

public class ConsecutivePrimeSumTest {

	private ConsecutivePrimeSum consecuticePrimeSum;
	
	@Before
	public void inincializeConsecutivePrimeSum() {
		consecuticePrimeSum = new ConsecutivePrimeSum();
	}
	
	@After
	public void finalizeConsecutivePrimeSum() {
		consecuticePrimeSum = null;
	}
	
	@Test
	public void under100_return41() {
		//giving
		System.out.println("test 100");
		Integer expected = 41;
		
		//when
		Integer actual = consecuticePrimeSum.calculate(100);
		
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void under1000_return953() {
		//giving
		System.out.println("test 1000");
		Integer expected = 953;
		
		//when
		Integer actual = consecuticePrimeSum.calculate(1000);
		
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void under1000000_return543() {
		//giving
		System.out.println("test 1 000 000");
		Integer expected = 997651;
		
		//when
		Integer actual = consecuticePrimeSum.calculate(1000000);
		
		//then
		assertEquals(expected, actual);
	}

}
