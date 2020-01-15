package com.jd.accountservicesdao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface AccountServiceDao {

	Double calcPartialDebit(ArrayList<Double> debitList);
	Double calcTotalDebit(Double partialDebit, Double totalCredit);
	Map<String, Double> calcAllDebits(Map<String, Double> debitMap);
	
	Double calcTotalCredit(ArrayList<Double> creditList);

}
