package com.trmsmy.expeval.persistence.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLEX_EXP_GRP")
public class ComplexExpGroupEntity {

	public ComplexExpGroupEntity() {
	}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complex_exp_grp_seq")
	@SequenceGenerator(name = "complex_exp_grp_seq", sequenceName = "COMPLEX_EXP_GRP_SEQ", allocationSize = 20)
	private Integer id;

	@Column(name = "OPERANT")
	String operant;

	@Column(name = "OPERATOR")
	String operator;
	
	@ManyToOne
	@JoinColumn(name = "POLICY_ID")
	private PolicyEntity policyEntity;
    
    @OneToMany(mappedBy="groupEntity", cascade = CascadeType.ALL)
    private List<ComplexExpEntity> complexExpList;

	public List<ComplexExpEntity> getComplexExpList() {
		return complexExpList;
	}

	public void setComplexExpList(List<ComplexExpEntity> complexExpList) {
		this.complexExpList = complexExpList;
	}

	public String getOperant() {
		return operant;
	}

	public void setOperant(String operant) {
		this.operant = operant;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PolicyEntity getPolicyEntity() {
		return policyEntity;
	}

	public void setPolicyEntity(PolicyEntity policyEntity) {
		this.policyEntity = policyEntity;
	}

	@Override
	public String toString() {
		return "ComplexExpGroupEntity [id=" + id + ", operant=" + operant + ", operator=" + operator + ", policyEntity="
				+ policyEntity + ", complexExpList=" + complexExpList + "]";
	}

	 

}
