package model;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextFileTransactionSource implements TransactionSource {

	public TextFileTransactionSource() {

	}

	@Override
	public void writeData(List<Transaction> transactions) {
		
		String str = Transaction.exportHeader("|") + "\n";
		for(int i = 0;i < transactions.size(); i++) {
			str += transactions.get(i).exportFormat("|") + "\n";
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("transaction_history.txt"));
		    writer.write(str);
		    
		    writer.close();	
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

}
