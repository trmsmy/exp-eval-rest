package com.trmsmy.expeval.persistence;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.trmsmy.expeval.persistence.entity.PolicyEntity;
import com.trmsmy.expeval.persistence.entity.SimpleExpEntity;

public interface SimpleExpRepository extends Repository<SimpleExpEntity, Integer>{ 
	public List<SimpleExpEntity> findAll();
	public SimpleExpEntity findById(Integer id);
	public List<SimpleExpEntity> findByPolicyEntity(PolicyEntity policyEntity);
	public List<SimpleExpEntity> findByOperantAndOperator(String operant,String operator);
	public List<SimpleExpEntity> findByOperant(String operant);
}
