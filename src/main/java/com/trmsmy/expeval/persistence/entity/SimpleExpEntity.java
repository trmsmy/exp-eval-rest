package com.trmsmy.expeval.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SIMPLE_EXP")
public class SimpleExpEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simple_exp_seq")
    @SequenceGenerator(name="simple_exp_seq", sequenceName = "SIMPLE_EXP_SEQ", allocationSize = 20)
	private Integer id;

/*	@Column(name = "POLICY_ID")
	private Integer policyId;*/
	
	@ManyToOne
	@JoinColumn(name = "POLICY_ID")
	private PolicyEntity policyEntity;

	@Column(name = "OPERANT")
	String operant;

	@Column(name = "FROM_VAL")
	String fromVal;
	
	@Column(name = "TO_VAL")
	String toVal;
	
	@Column(name = "OPERATOR")
	String operator;
	
	public SimpleExpEntity() {
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

	public String getOperant() {
		return operant;
	}

	public void setOperant(String operant) {
		this.operant = operant;
	}

	public String getFromVal() {
		return fromVal;
	}

	public void setFromVal(String fromVal) {
		this.fromVal = fromVal;
	}

	public String getToVal() {
		return toVal;
	}

	public void setToVal(String toVal) {
		this.toVal = toVal;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "SimpleExpEntity [id=" + id + ", policyEntity=" + policyEntity + ", operant=" + operant + ", fromVal="
				+ fromVal + ", toVal=" + toVal + ", operator=" + operator + "]";
	}

/*	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}*/
	
}
