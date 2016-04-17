package com.banking.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponses {
	private List<TransactionResponse> transactionResponses;

	public List<TransactionResponse> getTransactionResponses() {
		return transactionResponses;
	}

	public void setTransactionResponses(
			List<TransactionResponse> transactionResponses) {
		this.transactionResponses = transactionResponses;
	}
}
