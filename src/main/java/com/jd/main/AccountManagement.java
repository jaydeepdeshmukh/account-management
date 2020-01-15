package com.jd.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.jd.accountservicesdao.AccountServiceDao;
import com.jd.bean.AccountBean;

@Component
public class AccountManagement {

	@Autowired
	private AccountServiceDao accountService;

	@Autowired
	private Environment env;

	private static ApplicationContext context;
	private static final Logger logger = LoggerFactory.getLogger(AccountManagement.class);

	public static void main(String[] args) {

//		context = new AnnotationConfigApplicationContext(AccountManagement.class);
//		AccountManagement am = context.getBean(AccountManagement.class);
//		am.init();
		logger.info("inside main method");
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);	   
		AccountManagement accountManagement = context.getBean(AccountManagement.class);
		accountManagement.init();

	}

	public void init() {

		BufferedReader br = null;
		Map<String, Double> debitMap=new HashMap<String, Double>();
		Map<String, Double> creditMap=new HashMap<String, Double>();

		try {
			File bankStatementFile = ResourceUtils.getFile(env.getProperty("bank_statement_file"));
			br = new BufferedReader(new FileReader(bankStatementFile));

			String line = br.readLine();
			for(int i=0;line!=null; i++) {
				if(i>9 && !line.equals("") && Character.isDigit(line.charAt(0)))
				{
					String transArray[] = line.replaceAll("\\s+", "").split(",");
					if(!transArray[3].equals("")) debitMap.put(transArray[2], Double.parseDouble(transArray[3])); 
					if(!transArray[4].equals("")) creditMap.put(transArray[2], Double.parseDouble(transArray[4]));
				}
				line=br.readLine();
			}
//			br=null;
			br.close();

			/*
			 * Double partialDebit = accountService.calcPartialDebit(debitList);
			 * System.out.println("Partial Debit : "+partialDebit); Double totalCredit =
			 * accountService.calcTotalCredit(creditList);
			 * System.out.println("Total Credit : "+totalCredit); Double totalDebit =
			 * accountService.calcTotalDebit(partialDebit, totalCredit);
			 * System.out.println("Total Debit : "+totalDebit);
			 */

			Map<String, Double> allDebitMap = accountService.calcAllDebits(debitMap);
			for(Map.Entry<String,Double> map: allDebitMap.entrySet())
			{
				System.out.println(map.getKey() + " : "+map.getValue());
			}
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			debitMap=null;
		}

	}

}
