package com.C_SpringBootMvc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.C_SpringBootMvc.Model.Student;

//public interface StudentRepository extends CrudRepository<Student,Integer>{//here student is class name whose object we gone store in database or gone perform crud operation it
	//Integer is datatype of primary key
	
	//2.//custom finder method
public interface StudentRepository extends JpaRepository<Student,Integer>{
	public List<Student> findByUsernameAndPassword(String username, String password);

	public void deleteByName(String name);

	

}
