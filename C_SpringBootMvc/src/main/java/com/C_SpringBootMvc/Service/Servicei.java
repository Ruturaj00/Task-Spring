package com.C_SpringBootMvc.Service;

import java.util.List;

import com.C_SpringBootMvc.Model.Student;

public interface Servicei {
	void save(Student s);

	List<Student> LoginStudent(String username, String password);

	void deletByname(String username);

	List<Student> getAll();

	Student Edit(int rollno);

	List<Student> UpdateStudent(Student s);
   
	 List<Student> paging(int pageNo,int size);
	




}
