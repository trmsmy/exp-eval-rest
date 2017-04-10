package com.trmsmy.expeval.biz;

import static com.trmsmy.expeval.model.ModelMapper.entityToModel;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trmsmy.expeval.Expression;
import com.trmsmy.expeval.model.MatchPolicyRequest;
import com.trmsmy.expeval.model.MatchPolicyResponse;
import com.trmsmy.expeval.model.Policy;
import com.trmsmy.expeval.persistence.PolicyRepository;
import com.trmsmy.expeval.persistence.entity.PolicyEntity;

@Component
public class MatchPolicyServiceImpl {

	@Autowired
	private PolicyRepository policyRepo;
	private static final Logger log = LogManager.getLogger();

	public MatchPolicyResponse matchPolicy(MatchPolicyRequest req) {

		List<PolicyEntity> policies = policyRepo.findAll();

		for (PolicyEntity pe : policies) {
			try {
				Expression exp = new Expression(pe.getFormulae());
				exp.with("A", req.getA());
				exp.with("B", req.getB());
				exp.with("C", req.getC());
				//exp.with("D", req.getD());

				BigDecimal result = exp.eval();

				if (result.compareTo(BigDecimal.ONE) == 0) {
					Policy policy = entityToModel(pe);

					return new MatchPolicyResponse(policy);
				}

			} catch (Exception e) {
				log.error("Exception while validating policy[" + pe.getId() + "]," + " formuale=[" + pe.getFormulae()
						+ "]", e);
			}
		}

		return new MatchPolicyResponse(new Policy(-1, "NOT_FOUND", "NOT_FOUND"));

	}

}
