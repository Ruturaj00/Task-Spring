package com.C_SpringBootMvc.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.C_SpringBootMvc.Model.Student;
import com.C_SpringBootMvc.Repository.StudentRepository;

@Service
public class ServiceiImplement implements Servicei {
     @Autowired
     StudentRepository studentrepository;
     //Repository method
     //	1.Predefined methods : 
     //such as .save(s),findAll(),findAllById(),findById()
     //deleteAll(),deleteAllById(),deleteById()
     //just use it in service class no need to write implementation
     //or specify in it repository class
     
	@Override
	public void save(Student s) {
		studentrepository.save(s);	
	
		
	}
	@Override
	public List<Student> LoginStudent(String username, String password) {
	//	username = username.trim();
	//	password = password.trim();
		;
		if ((username.equals("admin") && password.equals("admin"))) {
			List<Student> ls = (List<Student>) studentrepository.findAll();
			return ls;
		}
		else {
			return studentrepository.findByUsernameAndPassword(username,password);
		}
	//	return ls;
	}
	
	
	/*
	 * optional come in java 8 features while search object
	 * by id if not present then it gives null pointer exception
	 * to solve this problem it define Optional know more through google
	 * */
	@Override
	public Student Edit(int rollno) {
		Optional<Student> op = studentrepository.findById(rollno);
		if(op.isPresent()) {//student exist
			return op.get();
		}return null;
	}
	
	@Override
	public List<Student> UpdateStudent(Student s){
		studentrepository.save(s);//save can perform both update and save
		return (List<Student>) studentrepository.findAll();
	}
	
	
	//2.custom finder method : this all method we have define by own in repository
	//but no need to write implementation just specified it according to following syntax
	//.findByUsername =  syntax = findByattributename() //it search object with that attribute value
	//and we need to define this method in repository class you can see it as i define it 
	//.findByUsernameAndPassword = findByattribute1Andattribute ()
	//.findByUsernameOrPassword = findByattribute1Andattribute()
	//.deleteByUsername = deleteByattribute() but above this method we must have to write annotation
	//@Transactional @Modifying when we are writing delete method in custom define no need to write in predefine delete
	//.deleteAllByattribute() = 
	//MMMMMMORE IMPPPP == Attribute first letter must capital
	//for ex.String username ; findByUsername() here we make U capital
	@Transactional
	@Modifying
	@Override
	public void deletByname(String name) {
		studentrepository.deleteByName(name);
		
	}
	@Override
	public List<Student> getAll() {
		return (List<Student>) studentrepository.findAll();
	}
	//till this method we are using crudrepository as we are performing crud operation
	//but for paging and sorting we have to use pagingandsortingrepsitory but it cannot support
	//crud operation so to use both we change repository name to jpa repsitory support both 
	//pagigingandsorting repository and crud repository
	@Override
	public List<Student> paging(int pageNo, int size) {
		Pageable p = PageRequest.of(pageNo, size,Sort.by("rollno").ascending());
	
		return studentrepository.findAll(p).getContent();
	}
	

}
