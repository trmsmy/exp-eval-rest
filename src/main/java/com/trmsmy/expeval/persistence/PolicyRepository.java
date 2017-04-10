package com.trmsmy.expeval.persistence;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.trmsmy.expeval.persistence.entity.PolicyEntity;

public interface PolicyRepository extends Repository<PolicyEntity, Integer>{
	public List<PolicyEntity> findAll();
	public PolicyEntity findById(Integer id);
}
