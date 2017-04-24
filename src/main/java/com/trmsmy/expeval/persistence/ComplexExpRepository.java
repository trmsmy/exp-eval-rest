package com.trmsmy.expeval.persistence;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.trmsmy.expeval.persistence.entity.ComplexExpEntity;

public interface ComplexExpRepository extends Repository<ComplexExpEntity, Integer>{ 
	public List<ComplexExpEntity> findAll();
	public ComplexExpEntity findById(Integer id);
}