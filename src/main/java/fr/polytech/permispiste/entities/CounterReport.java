package fr.polytech.permispiste.entities;

/**
 * This class represents a counter report.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class CounterReport {

	private double number;

	public CounterReport(double number) {
		this.number = number;
	}

	public double getNumber() {
		return this.number;
	}

	public void setNumber(double number) {
		this.number = number;
	}
}