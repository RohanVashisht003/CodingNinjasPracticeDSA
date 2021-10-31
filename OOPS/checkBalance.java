package OOPS;

import java.util.*;

class SavingsAccount {
	private int balance;
	private double interest;

	public SavingsAccount(int initialBalance, double initialInterest) {
		this.balance = initialBalance;
		this.interest = initialInterest;
	}

	public void deposit(int amount) {
		this.balance = this.balance + amount;
	}

	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}

	public void addInterest() {
		this.balance = this.balance + (int) ((this.interest) * (this.balance));
	}

	public int getBalance() {
		return balance;
	}

}

public class checkBalance {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int balance = s.nextInt();
		double interest = s.nextDouble();
		SavingsAccount sa = new SavingsAccount(balance, interest);

		int x = s.nextInt();
		while (x != -1) {
			if (x == 1) {
				int add = s.nextInt();
				sa.deposit(add);
			} else if (x == 2) {
				int with = s.nextInt();
				sa.withdraw(with);
			} else if (x == 3)
				sa.addInterest();
			x = s.nextInt();
		}
		System.out.println(sa.getBalance());

	}

}
