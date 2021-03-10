package com.cg.bean;

public class Customer {
	private long accNo;
	private String name;
	private long mobile;
	private String accType;
	private double balance;
	public Customer() {
	}
	public Customer(long accNo, String name, long mobile, String accType, double balance) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.mobile = mobile;
		this.accType = accType;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", name=" + name + ", mobile=" + mobile + ", accType=" + accType
				+ ", balance=" + balance + "]";
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
