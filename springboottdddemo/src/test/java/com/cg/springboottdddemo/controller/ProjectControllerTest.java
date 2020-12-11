package com.cg.springboottdddemo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.springboottdddemo.exception.ProjectNotFoundException;
import com.cg.springboottdddemo.model.Project;
import com.cg.springboottdddemo.service.ProjectService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProjectController.class)
class ProjectControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ProjectService projectService;

	@Test
	void test_getProjectDetailByProjIdentifier() throws Exception{
		
		BDDMockito.given(projectService.findProjectByProjIdentifier(Mockito.anyString())).willReturn(new Project("First Project", "fp01","First Project Description"));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/projects/First Project"))
		.andExpect(status().isOk()) //expected 200 --------actual 404
		.andExpect(jsonPath("$").isMap()) // expected {} ------- actual Blank
		.andExpect(jsonPath("name").value("First Project"))
		.andExpect(jsonPath("projIdentifier").value("fp01"))
		.andExpect(jsonPath("description").value("First Project Description"));
		
	}
	
	

	@Test
	void test_getProjectDetail_ThrowProjectNotFoundException() throws Exception{
		
		BDDMockito.given(projectService.findProjectByProjIdentifier(Mockito.anyString())).willThrow(new ProjectNotFoundException());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/projects/fp01"))
		.andExpect(status().isNotFound());
		
	}
}
