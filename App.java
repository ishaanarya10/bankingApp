package bankingApplication;

import java.util.Scanner;

public class App {
	
	static class BankAccount{
		
		int balance;
		int prevTransaction;
		String CustomerName;
		String CustomerID;
		
		public BankAccount(String customerName, String customerID) {
			
			this.CustomerName = customerName;
			this.CustomerID = customerID;
			
		}
		
		void deposit(int amount) {
			
			if(amount != 0) {
				balance += amount;
				prevTransaction = amount;
			}
		}
		
		void withdraw(int amount) {
			
			if(amount != 0) {
				balance -= amount;
				prevTransaction = -amount;
			}
		}
		
		void getPreviousTransaction() {
			if(prevTransaction > 0) {
				System.out.println("Deposited: " +prevTransaction);
			}else if(prevTransaction < 0){
				System.out.println("Withdrawn: " +Math.abs(prevTransaction));
			}else {
				System.out.println("No transaction occured.0");
			}
		}
		
		void showMenu() {
			
			char option = '0';
			
			System.out.println("Welcome "+CustomerName);
			System.out.println("Your ID is "+CustomerID);
			System.out.println();
			System.out.println("A. Check Balance");
			System.out.println("B. Deposit Amount");
			System.out.println("C. Withdraw Amount");
			System.out.println("D. Previous Transaction");
			System.out.println("E. Exit");
			
			do {
				System.out.println("===");
				System.out.println("Enter your option: ");
				System.out.println("===");
				Scanner s = new Scanner(System.in);
				option = s.next().charAt(0);
				System.out.println();
				
				switch(option) {
				
				case 'A':
					System.out.println("***");
					System.out.println("Balance: "+balance);
					System.out.println("***");
					break;
					
					
				case 'B':
					System.out.println("***");
					System.out.println("Enter amount to deposit");
					System.out.println("***");
					
					int amount = s.nextInt();
					deposit(amount);
					break;
					
				case 'C':
					System.out.println("***");
					System.out.println("Enter amount to withdraw: ");
					System.out.println("***");
					
					int amount2 = s.nextInt();
					withdraw(amount2);
					break;
					
				case 'D':
					System.out.println("***");
					getPreviousTransaction();
					System.out.println("***");
					break;
					
				case 'E':
					System.out.println("***");
					break;
					
				default:
					System.out.println("Invalid Option! Please enter again.");
					break;
					
					
				}
			}
			
			while(option != 'E'); 
				System.out.println("Thank you for using our services. Have a nice day. :)");
				
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
	
		BankAccount obj = new BankAccount("Ishaan", "ABC001");
		obj.showMenu();
	}

}
