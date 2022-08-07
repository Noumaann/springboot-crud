package com.example.springbootdemo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootdemo.entities.Trainee;
import com.example.springbootdemo.responses.RespInfo;
import com.example.springbootdemo.services.TraineeService;

@RestController
public class TraineeController {
	@Autowired
	private TraineeService ts;
	//create
	@PostMapping("/trainees")
	public ResponseEntity<RespInfo> insertTrainee(@Valid @RequestBody Trainee t, HttpServletRequest req) {
		String msg = ts.insert(t);
		RespInfo ri = new RespInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(),msg,req.getRequestURI());
		ResponseEntity<RespInfo> re = new ResponseEntity<>(ri,HttpStatus.CREATED);
		return re;
	}
	//get / read
	@GetMapping("/trainees")
	public List<Trainee> getAllTrainees(){
	return ts.getAll();
	}
	//get by name
	@GetMapping("/trainees/name/{name}")
	public Trainee listTraineeByName(@PathVariable("name") String name) {
		return ts.findByName(name);
	}
    //get by id
	@GetMapping("/trainees/{id}")
	public Trainee listTraineeById(@PathVariable("id") int id) {
		return ts.getTraineeById(id);
	}
	//update
	@PutMapping("/trainees/id/{id}")
	public ResponseEntity<RespInfo> updateTrainee(@Valid @PathVariable("id") int id,@RequestBody Trainee t,HttpServletRequest req) {
		String msg = ts.updateTrainee(id, t);
		RespInfo ri = new RespInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(),msg,req.getRequestURI());
		ResponseEntity<RespInfo> re = new ResponseEntity<>(ri,HttpStatus.CREATED);
		return re;
	}
	//delete
	@DeleteMapping("/trainees/id/{id}")
	public ResponseEntity<RespInfo> deleteTraineeById(@PathVariable("id") int id,HttpServletRequest req,Trainee t) {
		String msg = ts.delete(t, id);
		RespInfo ri = new RespInfo(HttpStatus.CREATED.value(), HttpStatus.ACCEPTED.name(),msg,req.getRequestURI());
		ResponseEntity<RespInfo> re = new ResponseEntity<>(ri,HttpStatus.ACCEPTED);
		return re;
	}
	
	
}