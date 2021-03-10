package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.Customer;
import com.cg.util.BankingExceptions;
import com.cg.util.BankingMessages;

public class BankingDaoImpl implements BankingDao {

	private Map<Long, Customer> custMap = new HashMap<>();
	private long accNoAuto = 25191000100L;
	public static final double MIN_BALANCE = 1000.0;

	@Override
	public double withdraw(long accNo, double amount) throws BankingExceptions {
		Customer cust = custMap.get(accNo);
		double bal = 0;
		if (cust != null) {
			bal = cust.getBalance() - amount;
			if (bal < MIN_BALANCE) {
				throw new BankingExceptions(BankingMessages.INSUFFICIENT_BALANCE);
			}
		} else {
			throw new BankingExceptions(BankingMessages.ACCOUNT_NOT_FOUND);
		}
		return bal;
	}

	@Override
	public double getBalance(long accNo) {
		Customer cust = custMap.get(accNo);
		return cust.getBalance();
	}

	@Override
	public double deposit(long accNo, double amount) {
		Customer cust = custMap.get(accNo);
		double bal = cust.getBalance() + amount;
		cust.setBalance(bal);
		return bal;
	}

	@Override
	public boolean createCustomer(Customer cust) {
		cust.setAccNo(accNoAuto);
		custMap.put(accNoAuto, cust);
		accNoAuto += 1;
//		System.out.println(cust);
		return true;
	}

	@Override
	public Customer getAccDetails(long accNo) throws BankingExceptions {
		Customer cust = custMap.get(accNo);
		if (cust == null) {
			throw new BankingExceptions(BankingMessages.ACCOUNT_NOT_FOUND);
		}
		return cust;
	}

}
