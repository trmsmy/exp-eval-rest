package com.trmsmy.expeval.persistence.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "POLICY")
public class PolicyEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_seq")
    @SequenceGenerator(name="policy_seq", sequenceName = "POLICY_SEQ", allocationSize = 20)
	private Integer id;

	@Column(name = "FORMULAE")
	String formulae;

	@Column(name = "COMMENT")
	String comment;

    @OneToMany(mappedBy="policyEntity", cascade = CascadeType.ALL)
    private List<SimpleExpEntity> simpleExpList;
    
    @OneToMany(mappedBy="policyEntity", cascade = CascadeType.ALL)
    private List<ComplexExpGroupEntity> complexExpGroupList;
    
	public PolicyEntity() {
	}
	
	public PolicyEntity(Integer id, String formulae, String comment) {
		super();
		this.id = id;
		this.formulae = formulae;
		this.comment = comment;
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

	public List<SimpleExpEntity> getSimpleExpList() {
		return simpleExpList;
	}

	public void setSimpleExpList(List<SimpleExpEntity> simpleExpList) {
		this.simpleExpList = simpleExpList;
	}

	public List<ComplexExpGroupEntity> getComplexExpGroupList() {
		return complexExpGroupList;
	}

	public void setComplexExpList(List<ComplexExpGroupEntity> complexExpList) {
		this.complexExpGroupList = complexExpList;
	}
}
