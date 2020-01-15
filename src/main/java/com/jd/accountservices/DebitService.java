package com.jd.accountservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DebitService {

	public Double calculatePartialDebit(ArrayList<Double> debitList) {
		Double debitAmount = 0.0;
		try {
			for(Double debit: debitList) {
				debitAmount+=debit;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return debitAmount;
	}
	
	public Double calculateTotalDebit(Double partialDebit, Double totalCredit) {
		return totalCredit-partialDebit;
	}
	
	public Map<String, Double> calculateAllDebits(Map<String, Double> debitMap) {
		Map<String, Double> allDebitMap = new HashMap<String, Double>();
		
		Double debitTotal = 0.0;
		Double debitATM = 0.0;
		Double debitFood = 0.0;
		Double debitFlipkart = 0.0;
		Double debitAmazon = 0.0;
		Double debitBills = 0.0;
		Double debitUPI = 0.0;
		
		try {
			for(Map.Entry<String, Double> map : debitMap.entrySet()) 
			{
				debitTotal+=map.getValue();
				if(map.getKey().toUpperCase().contains("ATM")) debitATM+=map.getValue();
				else if(map.getKey().toUpperCase().contains("FLIPKART")) debitFlipkart+=map.getValue();
				else if(map.getKey().toUpperCase().contains("AMAZON")) debitAmazon+=map.getValue();
				else if(map.getKey().toUpperCase().contains("ECOM PUR")) debitFood+=map.getValue();
				else if(map.getKey().toUpperCase().contains("MAHALAXMI")) debitBills+=map.getValue();
				else if(map.getKey().toUpperCase().contains("UPI")) debitUPI+=map.getValue();
			}
			allDebitMap.put("debitTotal", debitTotal);
			allDebitMap.put("debitATM", debitATM);
			allDebitMap.put("debitFood", debitFood);
			allDebitMap.put("debitFlipkart", debitFlipkart);
			allDebitMap.put("debitAmazon", debitAmazon);
			allDebitMap.put("debitBills", debitBills);
			allDebitMap.put("debitUPI", debitUPI);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allDebitMap;
	}
}
