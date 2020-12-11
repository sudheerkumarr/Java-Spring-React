package com.cg.springboottdddemo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.springboottdddemo.model.Project;
import com.cg.springboottdddemo.service.ProjectService;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();
	@Autowired
	ProjectService projectService;
	
	
	@Test
	void test_getProjectDetailByProjIdentifier() {
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<Project> response =restTemplate.exchange("http://localhost:"+port+"/projects/fp01", HttpMethod.GET,entity,Project.class);
		 assertEquals(HttpStatus.OK,response.getStatusCode());
	     assertEquals("First Project",response.getBody().getName());
	}

}
