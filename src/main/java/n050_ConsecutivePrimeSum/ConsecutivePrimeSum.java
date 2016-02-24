package n050_ConsecutivePrimeSum;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

public class ConsecutivePrimeSum {

	private Integer range;
	private List<Integer> primes;
	private Logger logger;

	public Integer calculate(Integer range) {
		this.range = range;
		primes = new ArrayList<Integer>();
		logger = Logger.getLogger("ConsecutivePrimeSum");

		generatePrimes();
		return search();
	}

	private void generatePrimes() {
		Integer index = 2;
		while (index < range) {
			ListIterator<Integer> iterator = primes.listIterator();
			while (iterator.hasNext() && (index % iterator.next()) != 0);
			if (!iterator.hasNext()) {
				primes.add(index);
			}
			index++;
		}
	}

	private Integer search() {
		Integer maxSumOfPrimeString = 0;
		Integer maxLenghtOfPrimeString = 0;

		Integer backIterator = primes.size()-6;
		while (backIterator > 0) {
			Integer prime = primes.get(--backIterator);
			Integer sumOfPrimeString = 0;

			Integer startString = 0;
			Integer endString = 0;
			while (!prime.equals(sumOfPrimeString) && !endString.equals(backIterator)) {
				if (sumOfPrimeString < prime) {
					sumOfPrimeString += primes.get(endString++);
				} else {
					sumOfPrimeString -= primes.get(startString++);
				}
			}

			if (!startString.equals(backIterator)) {
				Integer lenghtOfPrimeString = endString - startString;
				if (lenghtOfPrimeString > maxLenghtOfPrimeString) {
					logger.info(prime.toString() + " " + lenghtOfPrimeString.toString());
					maxLenghtOfPrimeString = lenghtOfPrimeString;
					maxSumOfPrimeString = sumOfPrimeString;
				}
			}
		}
		return maxSumOfPrimeString;
	}
}
