package com.gl.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="CollegeModel")
@javax.persistence.Table(name="college")//db table name
public class CollegeModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")//db coloumn name
	private String name;
	
	@Column(name="department")//db coloumn name
	private String department;
	
	@Column(name="country")//db coloumn name
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CollegeModel() {
	}

	public CollegeModel(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{")
		        .append("\"id\":"+id)
		        .append(",\"name\":\""+name+"\"")
		        .append(",\"department\":\""+department+"\"")
		        .append(",\"country\":\""+country+"\"")
		        .append("}")
		        .toString();
		
	}
	
	
}
