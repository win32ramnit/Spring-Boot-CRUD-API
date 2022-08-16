package com.manish.sms.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.manish.sms.entities.Student;

@Repository
public interface StudentRepo extends PagingAndSortingRepository<Student, Integer> {
	
	List<Student> findByCourse(String course,Pageable pageable);

}
