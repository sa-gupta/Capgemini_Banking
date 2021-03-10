package com.cg.jTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.bean.Customer;
import com.cg.dao.BankingDao;
import com.cg.dao.BankingDaoImpl;
import com.cg.util.BankingExceptions;

public class BankingTest {

	BankingDao bDao = new BankingDaoImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcreateCustomer() {
		boolean success = bDao.createCustomer(new Customer(12345L,"Sachin",8523697410L,"Savings",1000)); 
		assertTrue(success);
	}
	
	@Test
	public void testWithdraw() throws BankingExceptions{
		boolean success = bDao.createCustomer(new Customer(25191000100L,"Sachin",8523697410L,"Savings",1500));
//		double balance = bDao.deposit(741258L, 1000);
		double balance = bDao.withdraw(25191000100L,500);
		assertEquals(1000, balance, 0.1);
		
	}

	@Test
	public void testGetBalance() {
//		fail("Not yet implemented");
		boolean success = bDao.createCustomer(new Customer(25191000100L,"Sachin",8523697410L,"Savings",1000));
		double balance = bDao.getBalance(25191000100L);
		assertEquals(1000,balance,0.1);
	}

	@Test
	public void testDeposit() {
//		fail("Not yet implemented");
		boolean success = bDao.createCustomer(new Customer(25191000100L,"Sachin",8523697410L,"Savings",1000));
		double balance = bDao.deposit(25191000100L, 1000);
		assertEquals(2000,balance,0.1);
	}

}
