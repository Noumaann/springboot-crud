package com.example.springbootdemo.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springbootdemo.entities.Trainee;

@Repository("tr")
public interface ITraineeRepository extends JpaRepository<Trainee, Integer>{
	Optional<Trainee> findByTraineeName(String name);
}
