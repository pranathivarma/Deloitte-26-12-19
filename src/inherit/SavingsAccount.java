package inherit;

public class SavingsAccount extends account {
	
	private static final double MINIMUM = 10000;

	public SavingsAccount(String name, long number, double balance) {
		super(name, number, balance);
		System.out.println("SavingsAccount constructor called");
	}
	
	@Override
	public void print(String s) {
		//System.out.println("printing account info"+s);
		super.print(s);
	}
	@Override
	public void withdraw(double amount) {
		if(balance - amount >= MINIMUM) {
			balance -= amount;
		}
	}

}
