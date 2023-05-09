package com.graphql.client.controller;

import com.graphql.client.request.CreateStudentRequest;
import com.graphql.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.client.response.StudentResponse;

@RestController
@RequestMapping("/api/student")
public class ClientController {
	
	@Autowired
    ClientService clientService;

	@GetMapping("/get/{id}")
	public StudentResponse getStudent(@PathVariable Integer id) {
		return clientService.getStudent(id);
	}
	
	@PostMapping("/create")
	public StudentResponse createStudent(
			@RequestBody CreateStudentRequest createStudentRequest) {
		return clientService.createStudent(createStudentRequest);
	}
	
}
