package com.SpringBootJDataJPA.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SpringBootJDataJPA.model.Employee;
import com.SpringBootJDataJPA.repo.EmployeeRepository;
@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		repo.save(
				new Employee(11, "A", 3.3,
						Set.of("P1", "P2", "P3"),
						List.of("M1", "M2"),
						Map.of("C1","VIE", "C2","ORCL")
						)
				);
		System.out.println("DONE");
	}

}
