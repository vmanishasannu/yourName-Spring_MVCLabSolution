package com.gl.lab;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CollegeServiceInf {
	public List<CollegeModel> findAll();

	public void save(CollegeModel theStudent);

	public void deleteById(int theId);

	public CollegeModel findById(int id);

	public void UpdateById(CollegeModel theCollege);
}
