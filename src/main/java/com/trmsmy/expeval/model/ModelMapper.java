package com.trmsmy.expeval.model;

import com.trmsmy.expeval.persistence.entity.PolicyEntity;

public class ModelMapper {

    public static Policy entityToModel(PolicyEntity pe) {
        if(pe == null) return null;
        return new Policy(pe.getId(), pe.getFormulae(), pe.getComment());
    }

    public static PolicyEntity modelToEntity (Policy p) {
        if(p == null) return null;
        PolicyEntity policyEntity = new PolicyEntity(p.getId(), p.getFormulae(), p.getComment());
        policyEntity.setSimpleExpList(null);
        policyEntity.setComplexExpList(null);
		return policyEntity;
    }

    
}
