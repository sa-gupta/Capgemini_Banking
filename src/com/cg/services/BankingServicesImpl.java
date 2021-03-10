package com.cg.services;

import com.cg.bean.Customer;
import com.cg.dao.BankingDao;
import com.cg.dao.BankingDaoImpl;
import com.cg.util.BankingExceptions;

public class BankingServicesImpl implements BankingServices {
	
	private BankingDao bDao;
	
	public BankingServicesImpl() {
		bDao = new BankingDaoImpl();
	}

	@Override
	public double withdraw(long accNo,double amount) throws BankingExceptions {
		
		return bDao.withdraw(accNo,amount);
	}

	@Override
	public double getBalance(long accNo) {
		
		return bDao.getBalance(accNo);
	}

	@Override
	public boolean createCutomer(Customer cust) {
		return bDao.createCustomer(cust);
	}

	@Override
	public double deposit(long accNo, double amount) {
		
		return bDao.deposit(accNo,amount);
	}

	@Override
	public Customer getAccDetails(long accNo) throws BankingExceptions {
		
		return bDao.getAccDetails(accNo);
	}
}
