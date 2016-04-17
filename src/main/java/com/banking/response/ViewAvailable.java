package com.banking.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewAvailable {
	private String id;
	private String short_name;
	private String description;
	private String is_public;
	private String can_see_transaction_this_bank_account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIs_public() {
		return is_public;
	}

	public void setIs_public(String is_public) {
		this.is_public = is_public;
	}

	public String getCan_see_transaction_this_bank_account() {
		return can_see_transaction_this_bank_account;
	}

	public void setCan_see_transaction_this_bank_account(
			String can_see_transaction_this_bank_account) {
		this.can_see_transaction_this_bank_account = can_see_transaction_this_bank_account;
	}
}
