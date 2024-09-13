package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVDecorator extends DataSourceDecorator {

	public CSVDecorator(TransactionSource transactionSource) {
		super(transactionSource);
	}
	
	public void writeData(List<Transaction> transactions) {
		
		List<String> strArr = new ArrayList<>();
		strArr.add(Transaction.exportHeader(","));
		for(int i = 0;i < transactions.size(); i++) {
			strArr.add(transactions.get(i).exportFormat(","));
		}
		
		File csvOutputFile = new File("transaction_history.csv");
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
			for (int x = 0;x < strArr.size(); x++) {
				pw.println(strArr.get(x));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

}
