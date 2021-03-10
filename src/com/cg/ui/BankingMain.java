package com.cg.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.bean.Customer;
import com.cg.services.BankingServices;
import com.cg.services.BankingServicesImpl;
import com.cg.util.BankingExceptions;
import com.cg.util.BankingMessages;

public class BankingMain {

	private BankingServices bService;

	public BankingMain() {
		bService = new BankingServicesImpl();
	}

	public void execute() {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Create Customer");
				System.out.println("Enter <Name> <mobile> <acc type> <balance>");
				Customer cust = new Customer(0,scan.next(),scan.nextLong(),scan.next(),scan.nextDouble());
//				Customer cust = new Customer(1,"sachin",8965231470L,"savings",1500);
				boolean success = bService.createCutomer(cust);
				if(success) {
					System.out.println("Customer created with Account number : "+cust.getAccNo());
				}else {
					System.out.println("Failed to create customer");
				}
				break;
			case 2:
				System.out.println("Deposit Amount");
				System.out.println("Enter <Account Number> <Amount to deposit>");
				long accNo = scan.nextLong();
				double amount = scan.nextDouble();
				double balance = bService.deposit(accNo, amount);
				System.out.println("Deposited amount, balance: " + balance);
				break;
			case 3:
				System.out.println("Withdraw Amount");
				System.out.println("Enter <Account Number> <Amount to withdraw>");
				
				 balance = 0;
				try {
					accNo = scan.nextLong();
					amount = scan.nextDouble();
					balance = bService.withdraw(accNo, amount);
					System.out.println("Amount withdrawn, balance: " + balance);
				} catch (BankingExceptions e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e1) {
					System.out.println("Enter correct Acc No. Or Amount");
					scan.nextLine();
				}
				break;
			case 4:
				System.out.println("Check Balance");
				System.out.println("Enter <Account Number>");
				accNo = scan.nextLong();
				balance = bService.getBalance(accNo);
				System.out.println("Balance is " + balance);
				break;
			case 5:
				
				try {
					System.out.println("Enter <Account Number> ");
					accNo = scan.nextLong();
					Customer custDetails = bService.getAccDetails(accNo);
					System.out.println("Account Details : ");
					System.out.println("Account No. : "+custDetails.getAccNo());
					System.out.println("Name : "+custDetails.getName());
					System.out.println("Type of Account : "+custDetails.getAccType());
					System.out.println("Mobile : "+custDetails.getMobile());
					System.out.println("Balance : "+custDetails.getBalance());
				} catch(BankingExceptions e) {
//					e.printStackTrace();
					System.out.println(BankingMessages.ACCOUNT_NOT_FOUND);
				} catch(InputMismatchException e1) {
					System.out.println("Enter correct Account number !!");
					scan.nextLine();
				}
				
				break;
			case 6:
				System.out.println("Exiting system, thank you");
				System.exit(0);
				break;

			default:
				System.out.println("Enter 1 to 6 only");
				break;
			}
		}

	}

	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("Banking System");
		System.out.println("1. Create Customer");
		System.out.println("2. Deposit Amount");
		System.out.println("3. Withdraw Amount");
		System.out.println("4. Check Balance");
		System.out.println("5. Account Details");
		System.out.println("6. Exit System");
		System.out.println("Please enter your choice");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Enter a number");
			scan.nextLine(); // consume the keyboard value
		}
		return choice;
	}

	public static void main(String[] args) {
		new BankingMain().execute();
	}
}
