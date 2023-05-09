package com.graphql.client.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.client.request.CreateStudentRequest;
import com.graphql.client.response.StudentResponse;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Service
public class ClientService {
	
	@Autowired
	GraphQLWebClient graphQLWebClient;

	public StudentResponse getStudent (Integer id) {
		Map<String, Object> variables = new HashMap<>();
		variables.put("id", id);
		
		String queryStr = "query student($id : Long) {\r\n"
				+ "  student(id : $id) {\r\n"
				+ "    id\r\n"
				+ "    firstName\r\n"
				+ "    lastName\r\n"
				+ "    email\r\n"
				+ "    street\r\n"
				+ "    city\r\n"
				+ "    learningSubjects (subjectNameFilter : All) {\r\n"
				+ "      id\r\n"
				+ "      subjectName\r\n"
				+ "      marksObtained\r\n"
				+ "    }\r\n"
				+ "    fullName\r\n"
				+ "  } \r\n"
				+ "}";
		
		GraphQLRequest request = GraphQLRequest.builder()
				.query(queryStr).variables(variables).build();
		
		GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
		
		return graphQLResponse.get("student", StudentResponse.class);
	}
	
	public StudentResponse createStudent(
			CreateStudentRequest createStudentRequest) {
		
		Map<String, Object> variables = new HashMap<>();
		variables.put("createStudentRequest", createStudentRequest);
		
		String mutationStr = "mutation createStudent ($createStudentRequest : CreateStudentRequest) {\r\n"
				+ "  createStudent (createStudentRequest : $createStudentRequest) {\r\n"
				+ "    id\r\n"
				+ "    firstName\r\n"
				+ "    lastName\r\n"
				+ "    email\r\n"
				+ "    street\r\n"
				+ "    city\r\n"
				+ "    learningSubjects(subjectNameFilter : All) {\r\n"
				+ "      id\r\n"
				+ "      subjectName\r\n"
				+ "      marksObtained\r\n"
				+ "    }\r\n"
				+ "    fullName\r\n"
				+ "  }\r\n"
				+ "}";
		
		GraphQLRequest request = GraphQLRequest.builder()
				.query(mutationStr).variables(variables).build();
		
		GraphQLResponse graphQLResponse = graphQLWebClient.post(request).block();
		
		return graphQLResponse.get("createStudent", StudentResponse.class);
	}
}
