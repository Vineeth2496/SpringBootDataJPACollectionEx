package com.SpringBootJDataJPA.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_tab")
public class Employee {
	@Id
	@Column(name = "eid")
	private Integer empId;
	@Column(name = "ename")
	private String empName;
	@Column(name = "esal")
	private Double empSal;

	//collection variables
	
	@ElementCollection
	@CollectionTable(
				name = "emp_prjs",
				joinColumns = @JoinColumn(name="eid")
					)
	@Column(name = "proj")
	private Set<String> empPrjs;
	
	@ElementCollection
	@CollectionTable(
					name="emp_modules",
					joinColumns = @JoinColumn(name="eid")
					)
	@OrderColumn(name = "epos")
	@Column(name = "module")
	private List<String> empModules;
	
	@ElementCollection
	@CollectionTable(
					name = "emp_clients_tab",
					joinColumns = @JoinColumn(name="eid")
					)
	@MapKeyColumn(name = "cindex")
	@Column(name = "cname")
	private Map<String, String> empClients;
}
