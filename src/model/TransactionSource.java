package model;

import java.util.List;

public interface TransactionSource {
	
	public void writeData(List<Transaction> transactions);
}
