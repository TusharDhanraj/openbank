/**
 * 
 */
package com.banking.comparator;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.banking.response.TransactionResponse;

/**
 * @author tbhendar
 *
 */
public class TransactionResponseComparator implements
		Comparator<TransactionResponse> {

	public int compare(TransactionResponse o1, TransactionResponse o2) {
		try {
			int i = 0;
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:SS'Z'");
			if (o1.getStart_date() != null && o2.getStart_date() != null) {
				Date date1 = dateFormat.parse(o1.getStart_date());
				Date date2 = dateFormat.parse(o2.getStart_date());

				String l1 = date1.getTime() + "";
				String l2 = date2.getTime() + "";
				i = l2.compareToIgnoreCase(l1);
			}
			return i;
		} catch (Exception e) {
			return 0;
		}
	}

}
