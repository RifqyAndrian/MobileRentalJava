package model;

import java.util.List;

public class DataSourceDecorator implements TransactionSource {

	protected TransactionSource wrapee;
	
	public DataSourceDecorator(TransactionSource source) {
		this.wrapee = source;
	}

	@Override
	public void writeData(List<Transaction> transactions) {
		wrapee.writeData(transactions);
	}

}
