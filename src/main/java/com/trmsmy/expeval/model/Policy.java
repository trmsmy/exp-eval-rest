package com.trmsmy.expeval.model;

public class Policy {

	private Integer id;
	String formulae;
	String comment;

	public Policy(Integer id2, String formulae2, String comment2) {
		this.id = id2;
		this.formulae = formulae2;
		this.comment = comment2;
	}

	public Policy() {
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

}
