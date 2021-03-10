package com.cg.services;

import com.cg.bean.Customer;
import com.cg.util.BankingExceptions;

public interface BankingServices {

	double withdraw(long accNo,double amount) throws BankingExceptions;

	double getBalance(long accNo);

	boolean createCutomer(Customer cust);

	double deposit(long accNo, double amount);

	Customer getAccDetails(long accNo) throws BankingExceptions;

}
