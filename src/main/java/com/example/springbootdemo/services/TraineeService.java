package com.example.springbootdemo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootdemo.entities.Trainee;
import com.example.springbootdemo.exceptions.TraineeIdNotFoundException;
import com.example.springbootdemo.exceptions.TraineeNameNotFoundException;
import com.example.springbootdemo.repository.ITraineeRepository;

@Service("ts")
public class TraineeService {

	@Autowired
	ITraineeRepository tr;
	
	//create or post
	public String insert(Trainee t) {
		Trainee t1=tr.save(t);
		return "Record Inserted Successfully with Trainee Id : "+t1.getTraineeId();
	}
	
	public List<Trainee> getAll(){
		return tr.findAll();
	}
	//get by id
	public Trainee getTraineeById(int id) {
		Optional<Trainee> op = tr.findById(id);
		if(op.isPresent())
			return op.get();
		else
			throw new TraineeIdNotFoundException("Trainee not found for Id : "+id);
	}
	//delete by id
	public String delete(Trainee t,int id) {
		if(t.getTraineeId()==id) {
			tr.deleteById(id);
			return "Employee with id "+id+" is Deleted!";
		}else {
			throw new TraineeIdNotFoundException("Trainee not found for Id : "+id);
			
		}
	}
	//update
	public String updateTrainee(int id,Trainee t) {
		if(t.getTraineeId()==id) {
			Trainee t1=tr.save(t);
			return "Save Successfull for trainee Id : "+t1.getTraineeId()+" Name : "+t1.getTraineeName()+" Domain : "+t1.getTraineeDomain();
		}else {
			throw new TraineeIdNotFoundException("Please check given id matches!!");
		}
	}
	//get by name
	public Trainee findByName(String name) {
		Optional<Trainee> op = tr.findByTraineeName(name);
		if(op.isPresent())
			return op.get();
		else
			throw new TraineeNameNotFoundException("Trainee with name : "+name+" : not available.");
	}
}
