package com.trmsmy.expeval.persistence.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POLICY")
public class PolicyEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "FORMULAE")
	String formulae;

	@Column(name = "COMMENT")
	String comment;

    @OneToMany(fetch = FetchType.LAZY, targetEntity=SimpleExpEntity.class )
    @JoinColumn(name = "POLICY_ID")
    private Set<SimpleExpEntity> simpleExpList;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity=ComplexExpEntity.class )
    @JoinColumn(name = "POLICY_ID")
    private Set<ComplexExpEntity> complexExpList;
    
	public PolicyEntity() {
	}
	public PolicyEntity(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFormulae() {
		return formulae;
	}

	public void setFormulae(String formulae) {
		this.formulae = formulae;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "PolicyEntity [id=" + id + ", formulae=" + formulae + ", comment=" + comment + "]";
	}

	public Set<SimpleExpEntity> getSimpleExpList() {
		return simpleExpList;
	}

	public void setSimpleExpList(Set<SimpleExpEntity> simpleExpList) {
		this.simpleExpList = simpleExpList;
	}

	public Set<ComplexExpEntity> getComplexExpList() {
		return complexExpList;
	}

	public void setComplexExpList(Set<ComplexExpEntity> complexExpList) {
		this.complexExpList = complexExpList;
	}
}
