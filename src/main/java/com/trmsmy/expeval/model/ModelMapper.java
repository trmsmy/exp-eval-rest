package com.trmsmy.expeval.model;

import com.trmsmy.expeval.persistence.entity.PolicyEntity;

public class ModelMapper {

    public static Policy entityToModel(PolicyEntity pe) {
        if(pe == null) return null;
        return new Policy(pe.getId(), pe.getFormulae(), pe.getComment());
    }

}
