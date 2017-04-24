package com.trmsmy.expeval.biz;

import com.trmsmy.expeval.model.Policy;

public interface PolicyMaintanenceService {

	Policy addPolicy(Policy p);
	Policy updatePolicy(Policy p);
	void removePolicy(Policy p);
}
