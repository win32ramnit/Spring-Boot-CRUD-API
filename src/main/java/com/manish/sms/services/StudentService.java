package com.manish.sms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.manish.sms.entities.Student;

public interface StudentService {

	Student save(Student student);

	List<Student> findAll();

	Optional<Student> findById(int id);

	List<Student> findByCourse(String course, Pageable pageable);

	void deleteStudent(int id);
	

}
