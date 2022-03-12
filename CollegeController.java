package com.gl.lab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class CollegeController {
	@Autowired
	CollegeServiceInf collegeServiceInterface;

	/*
	 * Usage Details //http://localhost:8080/lab_Spring_college/college/list no auth
	 * set request type as get
	 */
	@RequestMapping("/list")
	public ResponseEntity<String> loadHome() {
		List<CollegeModel> theCollege = collegeServiceInterface.findAll();// get College from db
		System.out.println("list college record :" + theCollege);
		return new ResponseEntity<>(theCollege.toString(), HttpStatus.OK);
	}

	/*
	 * Usage Details - Set the below in params id:1 name:Veena department:B.Com
	 * country:Canada once you set the param url will look like below
	 * http://localhost:8080/lab_Spring_college/college/save?id=1&name=Veena&
	 * department=B.Com&country=Canada set request type as post response type is
	 * text
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		CollegeModel theCollege;

		if (id != 0 && collegeServiceInterface.findById(id) != null) {
			theCollege = collegeServiceInterface.findById(id);
			theCollege.setName(name);
			theCollege.setDepartment(department);
			theCollege.setCountry(country);
		} else {
			theCollege = new CollegeModel(name, department, country);
		}
		// save the College
		collegeServiceInterface.save(theCollege);
		System.out.println("save new college record :" + theCollege.toString());

		return new ResponseEntity<>("Saved!", HttpStatus.OK);

	}

	/*
	 * set request type as post
	 * http://localhost:8080/lab_Spring_college/college/update?id=1&name=Veena&
	 * department=B.Com&country=Newyork
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity<String> studentUpdate(@RequestParam("id") int theId, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		CollegeModel theCollege = collegeServiceInterface.findById(theId);
		System.out.println("id found : " + theCollege);
		if (theId != 0 && theCollege != null) {
			theCollege.setName(name);
			theCollege.setDepartment(department);
			theCollege.setCountry(country);
			collegeServiceInterface.UpdateById(theCollege); // save the College
		} else {
			return new ResponseEntity<>("ID not Found!", HttpStatus.OK);
		}

		return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		// delete the Student
		collegeServiceInterface.deleteById(theId);

		return "Deleted Record";

	}

}
