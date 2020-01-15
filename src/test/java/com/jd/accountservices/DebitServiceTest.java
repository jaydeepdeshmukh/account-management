package com.jd.accountservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("while testing Debit service")
class DebitServiceTest {

	DebitService debitService;

	@BeforeEach
	void startup() {
		this.debitService=new DebitService();
	}
	
	@Test
	@DisplayName("testing patial debit")
	void testCalculatePartialDebit() {
		ArrayList<Double> debitList = new ArrayList<Double>();
		debitList.add(1.0);
		Double partialDebit = debitService.calculatePartialDebit(debitList);
		assertNotEquals(0.0, partialDebit, "partial debit must be greater than 0");
	}

	@Disabled
	@Test
	void testCalculateTotalDebit() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testCalculateAllDebits() {
		fail("Not yet implemented");
	}

}
