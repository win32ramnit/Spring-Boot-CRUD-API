package com.manish.sms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.manish.sms.entities.Student;
import com.manish.sms.repos.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> findAll() {
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public Optional<Student> findById(int id) {
		return studentRepo.findById(id);
	}
	
	@Override
	public List<Student> findByCourse(String course, Pageable pageable) {
		
		return studentRepo.findByCourse(course, pageable);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
	}

}
