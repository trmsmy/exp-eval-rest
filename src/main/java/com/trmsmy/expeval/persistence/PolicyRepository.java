package com.trmsmy.expeval.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trmsmy.expeval.persistence.entity.PolicyEntity;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Integer>{
	//public List<PolicyEntity> findAll();
	public PolicyEntity findById(Integer id);
	//public PolicyEntity persist(PolicyEntity pe);
}
