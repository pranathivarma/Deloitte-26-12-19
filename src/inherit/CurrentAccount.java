package inherit;

public class CurrentAccount extends account {

	public CurrentAccount(String name, long number, double balance) {
		super(name, number, balance);
		System.out.println("CurrentAccount constructor called");
		
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}
	
}
