package com.trmsmy.expeval.model;

public class MatchPolicyResponse {

	private Policy matchedPolicy;

	public MatchPolicyResponse() {

	}

	public MatchPolicyResponse(Policy policy) {
		this.matchedPolicy = policy;
	}

	public Policy getMatchedPolicy() {
		return matchedPolicy;
	}

	public void setMatchedPolicy(Policy matchedPolicy) {
		this.matchedPolicy = matchedPolicy;
	}

}
