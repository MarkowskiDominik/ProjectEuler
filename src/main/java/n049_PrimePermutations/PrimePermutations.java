package n049_PrimePermutations;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

public class PrimePermutations {

	private Integer range = 10000;
	private List<Integer> primes;
	private Logger logger;
	
	public List<Integer> calculate() {
		primes = new ArrayList<Integer>();
		logger = Logger.getLogger("PrimePermutations");
		
		generatePrimes();
		return search();
	}

	private void generatePrimes() {
		Integer index = 1000;
		while (index < range) {
			ListIterator<Integer> iterator = primes.listIterator();
			while (iterator.hasNext() && (index % iterator.next()) != 0);
			if (!iterator.hasNext()) {
				primes.add(index);
			}
			index++;
		}
	}

	private List<Integer> search() {
		List<Integer> result = null;
		List<Integer> permutations = null;
		for (Integer prime : primes) {
			result = new ArrayList<Integer>();
			result.add(prime);
			permutations = new ArrayList<Integer>();
			generatePermutations(prime.toString(), new String(), 0, permutations);
			for (Integer permutation : permutations) {
				primes.contains(permutation);
			}
		}
		logger.info(result.toString());
		return result;
	}

	private void generatePermutations(String prime, String permutation, int index, List<Integer> permutations) {
		if (index < 4) {
			for (int i = 0; i < 4; i++) {
				permutation += prime.charAt(i);
				generatePermutations(prime, permutation, index, permutations);
			}
		}
		else {
			permutations.add(Integer.parseInt(prime));
			return;
		}
	}
}
