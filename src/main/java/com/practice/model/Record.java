package com.practice.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblrecord")
public class Record {

	@Id
	@GeneratedValue		
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	public Record() {
		
	}
	
	public Record(String name) {
		this.name=name;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}