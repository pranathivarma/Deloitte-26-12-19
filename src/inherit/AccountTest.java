package inherit;

public class AccountTest {
	
	
	
	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount("neha", 123, 100000);
		System.out.println(sa);
		sa.withdraw(4000);
		System.out.println(sa);
		CurrentAccount ca = new CurrentAccount("nani",321, 1000000);
		System.out.println(ca);
		ca.withdraw(4000);
		System.out.println(ca);
		
		account ac= new SavingsAccount("amit", 567, 3000000);
		System.out.println(ac);
		ac.withdraw(5000);
		System.out.println(ac);
		System.out.println("-------------------");
		showBalance(ac);
		System.out.println("-------------------");
		showBalance(sa);
		
		ac.print("hello account");
		sa.print("from savings..");
		ac.print("hello account");
		
		printAccount(ac, new ConcolePrinter());
		printAccount(ac, new FilePrinter());

	}
	public static void showBalance(account ac) {
		System.out.println(ac.getBalance());
	}

	public static void printAccount(account ac, Printer p) {
		ac.print("from accounts");
		p.print("from printer class");
	}
}
