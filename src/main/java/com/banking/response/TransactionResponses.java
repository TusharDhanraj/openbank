package com.banking.response;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponses {
	private List<TransactionResponse> transactionResponses;
	private ArrayList<TransactionResponse> transaction_requests_with_charges;

	public ArrayList<TransactionResponse> getTransaction_requests_with_charges() {
		return transaction_requests_with_charges;
	}

	public void setTransaction_requests_with_charges(
			ArrayList<TransactionResponse> transaction_requests_with_charges) {
		this.transaction_requests_with_charges = transaction_requests_with_charges;
	}

	public List<TransactionResponse> getTransactionResponses() {
		return transactionResponses;
	}

	public void setTransactionResponses(
			List<TransactionResponse> transactionResponses) {
		this.transactionResponses = transactionResponses;
	}
}
