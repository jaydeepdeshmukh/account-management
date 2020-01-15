package com.jd.bean;

public class AccountBean {

	private String accountNo;
	private String month;
	private Double debit;
	private Double totalDebit;
	private Double totalCredit;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Double getDebit() {
		return debit;
	}
	public void setDebit(Double debit) {
		this.debit = debit;
	}
	public Double getTotalDebit() {
		return totalDebit;
	}
	public void setTotalDebit(Double totalDebit) {
		this.totalDebit = totalDebit;
	}
	public Double getTotalCredit() {
		return totalCredit;
	}
	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "AccountBean [accountNo=" + accountNo + ", month=" + month + ", debit=" + debit + ", totalDebit="
				+ totalDebit + ", totalCredit=" + totalCredit + "]";
	}
}
