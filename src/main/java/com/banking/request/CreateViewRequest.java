/**
 * 
 */
package com.banking.request;

/**
 * @author tbhendar
 *
 */
public class CreateViewRequest {
	// { "name":"Name of view to create", "description":"Description of view
	// (this example is public, uses the public alias,
	// and has limited access to account
	// data)",  "is_public":true,  "which_alias_to_use":"_public_",
	// "hide_metadata_if_alias_used":true,
	// "allowed_actions":["can_see_transaction_start_date","can_see_bank_account_label","can_see_tags"]}
	private String name;
	private String description;
	private Boolean is_public;
	private String which_alias_to_use;
	private Boolean hide_metadata_if_alias_used;
	private String[] allowed_actions;
public CreateViewRequest(){}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIs_public() {
		return is_public;
	}

	public void setIs_public(Boolean is_public) {
		this.is_public = is_public;
	}

	public String getWhich_alias_to_use() {
		return which_alias_to_use;
	}

	public void setWhich_alias_to_use(String which_alias_to_use) {
		this.which_alias_to_use = which_alias_to_use;
	}

	public Boolean getHide_metadata_if_alias_used() {
		return hide_metadata_if_alias_used;
	}

	public void setHide_metadata_if_alias_used(
			Boolean hide_metadata_if_alias_used) {
		this.hide_metadata_if_alias_used = hide_metadata_if_alias_used;
	}

	public String[] getAllowed_actions() {
		return allowed_actions;
	}

	public void setAllowed_actions(String[] allowed_actions) {
		this.allowed_actions = allowed_actions;
	}
}
