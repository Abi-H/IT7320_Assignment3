// Student ID: 2151241

package Assignment3;

public class Employee {
	
	private int income, kiwisaver;
	
	public Employee(int income, int kiwisaver) {
		setIncome(income);
		setKiwisaver(kiwisaver);
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	
	public void setKiwisaver(int kiwisaver) {
		this.kiwisaver = kiwisaver;
	}
	
	public int getIncome() {
		return income;
	}
	
	public int getKiwisaver() {
		return kiwisaver;
	}
}
