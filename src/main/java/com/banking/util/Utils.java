package com.banking.util;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.banking.comparator.TransactionResponseComparator;
import com.banking.response.TransactionResponse;
import com.banking.response.TransactionResponses;

public class Utils {
	public static String getTransactionData(String jsonResponse, String count) {
		jsonResponse = "{" + "\"transactionResponses\":"
				+ jsonResponse.substring(0, jsonResponse.length()) + "}";
		try {
			ObjectMapper mapper = new ObjectMapper();
			TransactionResponses transactionResponses = mapper.readValue(
					jsonResponse, TransactionResponses.class);
			List<TransactionResponse> transactionResponses2 = transactionResponses
					.getTransactionResponses();
			Collections.sort(transactionResponses2,
					new TransactionResponseComparator());

			transactionResponses2 = transactionResponses
					.getTransactionResponses();
			if (transactionResponses2 == null
					|| transactionResponses2.isEmpty()) {
				return null;
			} else {
				int size = transactionResponses2.size();
				;
				int counter = Integer.parseInt(count);
				return mapper.writeValueAsString(transactionResponses2.subList(
						0, size > counter ? counter: size));
			}
		} catch (Exception e) {
			return null;
		}

	}
}
