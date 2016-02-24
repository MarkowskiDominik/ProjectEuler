package n049_PrimePermutations;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

public class PrimePermutations {
	private static final int RANGE = 10000;
	private List<Integer> primes;
	private Logger logger;

	public List<Integer> calculate(int index) {
		primes = new ArrayList<Integer>();
		logger = Logger.getLogger("PrimePermutations");

		generatePrimes();
		return search(index);
	}

	private void generatePrimes() {
		/*
		 * 1. Generate a list of primes below between 1000 and 10000
		 */
		int index = 2;
		Integer range = RANGE;
		while (index < range) {
			ListIterator<Integer> iterator = primes.listIterator();
			while (iterator.hasNext() && (index % iterator.next()) != 0);
			if (!iterator.hasNext()) {
				primes.add(index);
			}
			index++;
		}
	}

	private List<Integer> search(int index) {
		/* 
		 * 2. Take two primes i and j with i < j and calculate k = j + (j-i)
		 * 3. Check if k < 10000 and check if k is a prime, if not go to 2
		 * 4. Check if i and j are permutations of each other and check if i and k are permutations of each other. If not go to 2
		 * 5. Found the triple, so exit
		 */
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				Integer k = 2 * primes.get(j) - primes.get(i);
				if (k < RANGE && primes.contains(k) && isPermutation(primes.get(i), primes.get(j))
						&& isPermutation(primes.get(i), k)) {
					result.add(primes.get(i));
					result.add(primes.get(j));
					result.add(k);
				}
			}
		}
		logger.info(result.toString());
		return result;
	}

	private Boolean isPermutation(int first, int second) {
		int[] digits = new int[10];

		while (first > 0) {
			digits[first % 10]++;
			first /= 10;
		}

		while (second > 0) {
			digits[second % 10]--;
			second /= 10;
		}

		for (int index = 0; index < 10; index++) {
			if (digits[index] != 0) {
				return Boolean.FALSE;
			}
		}

		return Boolean.TRUE;
	}
}
