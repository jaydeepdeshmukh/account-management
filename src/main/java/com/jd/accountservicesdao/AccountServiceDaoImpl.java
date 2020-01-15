package com.jd.accountservicesdao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jd.accountservices.CreditService;
import com.jd.accountservices.DebitService;

@Component
public class AccountServiceDaoImpl implements AccountServiceDao {

	@Autowired
	DebitService debitService;
	
	@Autowired
	CreditService creditService;
	
	@Override
	public Double calcPartialDebit(ArrayList<Double> debitList) {
		return debitService.calculatePartialDebit(debitList);
	}

	@Override
	public Double calcTotalDebit(Double partialDebit, Double totalCredit) {
		return debitService.calculateTotalDebit(partialDebit, totalCredit);
	}

	@Override
	public Double calcTotalCredit(ArrayList<Double> creditList) {
		return creditService.calculateTotalCredit(creditList);
	}

	@Override
	public Map<String, Double> calcAllDebits(Map<String, Double> debitMap) {
		return debitService.calculateAllDebits(debitMap);
	}

}
