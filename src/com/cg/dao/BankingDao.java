package com.cg.dao;

import com.cg.bean.Customer;
import com.cg.util.BankingExceptions;

public interface BankingDao {

	double withdraw(long accNo,double amount) throws BankingExceptions;

	double getBalance(long accNo);

	double deposit(long accNo, double amount);

	boolean createCustomer(Customer cust);

	Customer getAccDetails(long accNo) throws BankingExceptions;

}
