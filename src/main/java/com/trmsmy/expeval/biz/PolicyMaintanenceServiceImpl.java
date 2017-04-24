package com.trmsmy.expeval.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trmsmy.expeval.Expression;
import com.trmsmy.expeval.Expression.SubExp;
import com.trmsmy.expeval.model.ModelMapper;
import com.trmsmy.expeval.model.Policy;
import com.trmsmy.expeval.persistence.PolicyRepository;
import com.trmsmy.expeval.persistence.entity.ComplexExpEntity;
import com.trmsmy.expeval.persistence.entity.ComplexExpGroupEntity;
import com.trmsmy.expeval.persistence.entity.PolicyEntity;
import com.trmsmy.expeval.persistence.entity.SimpleExpEntity;

@Component
public class PolicyMaintanenceServiceImpl implements PolicyMaintanenceService {

	@Autowired
	PolicyRepository policyRepo;
	
	@Override
	public Policy addPolicy(Policy p) {
		PolicyEntity pe = ModelMapper.modelToEntity(p);
		
		Expression exp = new Expression(p.getFormulae());
		
		//TODO Configure list of Variable supported and provide the list here by default
		exp.with("A", "").with("B", "").with("C", "");
		
		
		List<SubExp> tokens = exp.tokenExp();
		List<SimpleExpEntity> simpleList = new ArrayList<>();
		List<ComplexExpGroupEntity> complexList = new ArrayList<>();
		
		
		for (SubExp subExp : tokens) {
			if (subExp.getRight() != null) {
				SimpleExpEntity see = new SimpleExpEntity();
				see.setOperant(subExp.getLeft());
				see.setFromVal(subExp.getRight());
				see.setOperator(subExp.getOp());
				see.setPolicyEntity(pe);
				
				simpleList.add(see);
			} else {
				
				ComplexExpGroupEntity cege = new ComplexExpGroupEntity();
				cege.setOperant(subExp.getLeft());
				cege.setOperator(subExp.getOp());
				cege.setPolicyEntity(pe);
				
				List<String> listOperand = subExp.getRightList();
				if (CollectionUtils.isNotEmpty(listOperand)){
					List<ComplexExpEntity> ceeList = new ArrayList<>();					
					for (String opd : listOperand) {
						ComplexExpEntity cee = new ComplexExpEntity();
						cee.setGroupEntity(cege);
						cee.setValue(opd);
						ceeList.add(cee);
					}
					
					cege.setComplexExpList(ceeList );
				}
				
				
				complexList.add(cege);
			}
		}
		
		
		pe.setSimpleExpList(simpleList);
		pe.setComplexExpList(complexList);
		policyRepo.saveAndFlush(pe );
		
		return ModelMapper.entityToModel(pe);
	}

	@Override
	public Policy updatePolicy(Policy p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePolicy(Policy p) {
		// TODO Auto-generated method stub

	}

}
