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
@Table(name = "COMPLEX_EXP")
public class ComplexExpEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complex_exp_seq")
    @SequenceGenerator(name="complex_exp_seq", sequenceName = "COMPLEX_EXP_SEQ", allocationSize = 20)
	private Integer id;

	@Column(name = "VAL")
	String value;
	
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	private ComplexExpGroupEntity groupEntity;
	
	public ComplexExpEntity() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ComplexExpGroupEntity getGroupEntity() {
		return groupEntity;
	}

	public void setGroupEntity(ComplexExpGroupEntity groupId) {
		this.groupEntity = groupId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "ComplexExpEntity [id=" + id +  ", groupId=" + groupEntity + 
				", value=" + value + "]";
	}
	

}
