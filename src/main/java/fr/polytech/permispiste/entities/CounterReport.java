package fr.polytech.permispiste.entities;

/**
 * This class represents a counter report.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class CounterReport {

	private int count;

	public CounterReport(long number) {
		this.count = Math.toIntExact(number);
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int number) {
		this.count = number;
	}
}