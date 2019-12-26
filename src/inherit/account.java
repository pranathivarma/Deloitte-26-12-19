package inherit;

public abstract class account implements Printer{
	
	protected String name;
	protected long number;
	protected double balance;
	public account(String name, long number, double balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
		System.out.println("Account constructor called");
	}
	
	public void print(String s) {
		System.out.println("Printing account info..."+s);
	}
	
	public abstract  void withdraw(double amount);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "account [name=" + name + ", number=" + number + ", balance=" + balance + "]";
	}
	

}
