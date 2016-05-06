package com.banking.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.banking.comparator.TransactionResponseComparator;
import com.banking.response.Body;
import com.banking.response.From;
import com.banking.response.TransactionResponse;

public class Utils {
	public static String getTransactionData(String jsonResponse, String count) {
		jsonResponse = "{" + "\"transactionResponses\":"
				+ jsonResponse.substring(0, jsonResponse.length()) + "}";
		try {
			ObjectMapper mapper = new ObjectMapper();
			String erroResp = null;
			boolean flag = false;
			List<TransactionResponse> oldList = new ArrayList<TransactionResponse>();

			JsonNode jsonNode = mapper.readTree(jsonResponse);
			if (jsonNode != null) {
				JsonNode jsonNode2 = jsonNode.get("transactionResponses");
				if (jsonNode2 != null) {
					JsonNode jsonNode3 = jsonNode2
							.get("transaction_requests_with_charges");
					if (null != jsonNode3) {
						for (int i = 0; i < jsonNode3.size(); i++) {
							TransactionResponse response = new TransactionResponse();
							response.setTransactionId(jsonNode3.get(i)
									.get("id").asText());
							response.setType(jsonNode3.get(i).get("type")
									.asText());
							response.setTransaction_ids(jsonNode3.get(i)
									.get("transaction_ids").asText());
							response.setStatus(jsonNode3.get(i).get("status")
									.asText());
							response.setStart_date(jsonNode3.get(i)
									.get("start_date").asText());
							response.setEnd_date(jsonNode3.get(i)
									.get("end_date").asText());
							response.setFrom(mapper.readValue(jsonNode3.get(i)
									.get("from"), From.class));
							response.setBody(mapper.readValue(jsonNode3.get(i)
									.get("body"), Body.class));
							oldList.add(response);
						}
					} else {
						flag = true;
						erroResp = jsonResponse;
					}
				}
			}
			/*
			 * List<TransactionResponse> transactionResponses2 =
			 * transactionResponses .getTransactionResponses();
			 */
			Collections.sort(oldList, new TransactionResponseComparator());

			/*
			 * oldList = transactionResponses .getTransactionResponses();
			 */
			if (erroResp != null) {
				return erroResp;
			} else if (oldList == null || oldList.isEmpty()) {
				return null;
			} else {
				int size = oldList.size();
				;
				int counter = Integer.parseInt(count);
				return flag ? mapper.writeValueAsString(erroResp) : mapper
						.writeValueAsString(oldList.subList(0,
								size > counter ? counter : size));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
