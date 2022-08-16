package com.manish.sms.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.manish.sms.entities.Student;
import com.manish.sms.execptions.GlobalExceptionHandler;
import com.manish.sms.execptions.RecordNotFoundException;
import com.manish.sms.services.StudentService;

@Controller
@RestController
public class StudentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	private static final int PAGE_SIZE = 4; // Default page size
	private static final int PAGE_NUMBER = 0; // Default page number

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getStudents() {

		List<Student> theStudent = studentService.findAll();
		if (theStudent.isEmpty()) {
			LOG.error("[getStudents] Student record(s) not found");
			throw new RecordNotFoundException("Record(s) not found");
		}
		LOG.info("[getStudents] Retreived All Student record(s)");
		return new ResponseEntity<>(theStudent, HttpStatus.OK);
	}

	@GetMapping(path = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {

		Optional<Student> theStudent = studentService.findById(id);

		if (!theStudent.isPresent()) {
			LOG.error("[getStudent] Student id '" + id + "' does no exist");
			throw new RecordNotFoundException("Student id '" + id + "' does no exist");
		} else {
			Student newStudent = theStudent.get();
			LOG.info("[getStudent] Retrieved student with id '" + id + "' successfully");
			return new ResponseEntity<>(newStudent, HttpStatus.OK);
		}

	}
	
	@DeleteMapping(path = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {

		Optional<Student> theStudent = studentService.findById(id);

		if (!theStudent.isPresent()) {
			LOG.error("[deleteStudent] Student id '" + id + "' does no exist");
			throw new RecordNotFoundException("Student id '" + id + "' does no exist");
		} else {
			Student newStudent = theStudent.get();
			studentService.deleteStudent(newStudent.getId());
			LOG.info("[deleteStudent] Student deleted with id '" + id + "' successfully");
			return new ResponseEntity<>(newStudent, HttpStatus.OK);
		}

	}

	@PostMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		Student theStudent = studentService.save(student);
		if (theStudent == null) {
			LOG.error("[createStudent] Student id cannot be created");
			return null;
		} else {
			LOG.info("[createStudent] Student record is created with id '" + theStudent.getId() + "'");
			return new ResponseEntity<>("StudentId: " + theStudent.getId(), HttpStatus.CREATED);
		}

	}

	@ExceptionHandler(RecordNotFoundException.class)
	@PutMapping(path = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {

		Optional<Student> studentData = studentService.findById(id);

		if (studentData.isPresent()) {
			Student theStudent = studentData.get();
			theStudent.setName(student.getName());
			theStudent.setCourse(student.getCourse());
			theStudent.setAddresses(student.getAddresses());
			LOG.info("[updateStudent] Student upadated with id '" + id + "'");
			return new ResponseEntity<>(studentService.save(theStudent), HttpStatus.OK);
		} else {
			LOG.error("[updateStudent] Student id '" + id + "' does no exist");
			throw new RecordNotFoundException("Student id '" + id + "' does no exist");
		}
	}

	@GetMapping(path = "/students/{class}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> readAll(@PathVariable("class") String course,
			@PathVariable("page") int pageNumber) {
		// @RequestParam(name = "class") String course, @RequestParam(name = "start")
		// int start
		// @RequestParam Map<String,String> allParams
		// String course = allParams.get("class");
		// int start = Integer.parseInt(allParams.get("start"));

		//System.out.println(">>>>>>>>>>: " + course + "<<<<<<<<<<: " + pageNumber);
		if (course.trim().isEmpty()) {
			LOG.error("[readAll] Required params is missing");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Required params is missing");
		}
		pageNumber = pageNumber - 1;
		if (pageNumber < 0) {
			pageNumber = PAGE_NUMBER;
		}

		Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);

		List<Student> theStudent = studentService.findByCourse(course, pageable);
		if (theStudent.isEmpty()) {
			LOG.error("[readAll] Student record(s) not found by Course: '" +course +"'");
			throw new RecordNotFoundException("Record(s) not found");
		}
		LOG.info("[readAll] Student record(s) found by Course: '" +course +"'");
		return new ResponseEntity<>(theStudent, HttpStatus.OK);
	}

}
