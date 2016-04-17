/**
 * 
 */
package com.banking.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author tbhendar
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Challenge {
	private String id;
	private Integer allowed_attempts;
	private String challenge_type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAllowed_attempts() {
		return allowed_attempts;
	}

	public void setAllowed_attempts(Integer allowed_attempts) {
		this.allowed_attempts = allowed_attempts;
	}

	public String getChallenge_type() {
		return challenge_type;
	}

	public void setChallenge_type(String challenge_type) {
		this.challenge_type = challenge_type;
	}

}
