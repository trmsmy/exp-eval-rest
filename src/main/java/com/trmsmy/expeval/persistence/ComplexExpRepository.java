package com.trmsmy.expeval.persistence;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.trmsmy.expeval.persistence.entity.ComplexExpEntity;
import com.trmsmy.expeval.persistence.entity.PolicyEntity;

public interface ComplexExpRepository extends Repository<ComplexExpEntity, Integer>{ 
	public List<ComplexExpEntity> findAll();
	public ComplexExpEntity findById(Integer id);
	public List<ComplexExpEntity> findByPolicyEntity(PolicyEntity policyEntity);
	public List<ComplexExpEntity> findByOperantAndOperator(String operant,String operator);
	public List<ComplexExpEntity> findByOperant(String operant);
}