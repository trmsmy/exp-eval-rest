package com.trmsmy.expeval.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLEX_EXP")
public class ComplexExpEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity=PolicyEntity.class)
	@JoinColumn(name = "POLICY_ID")
	private PolicyEntity policyEntity;

	@Column(name = "GROUP_ID")
	private Integer groupId;
	
	@Column(name = "OPERANT")
	String operant;

	@Column(name = "VAL")
	String value;
	
	@Column(name = "OPERATOR")
	String operator;

	public ComplexExpEntity() {
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

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getOperant() {
		return operant;
	}

	public void setOperant(String operant) {
		this.operant = operant;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "ComplexExpEntity [id=" + id + ", policyEntity=" + policyEntity + ", groupId=" + groupId + ", operant="
				+ operant + ", value=" + value + ", operator=" + operator + "]";
	}
	

}
