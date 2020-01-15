package com.jd.accountservices;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class CreditService {

	public Double calculateTotalCredit(ArrayList<Double> creditList) {
		Double totalCredit = 0.0;
		try {
			for(Double credit: creditList) {
				totalCredit+=credit;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCredit;
	}
}
