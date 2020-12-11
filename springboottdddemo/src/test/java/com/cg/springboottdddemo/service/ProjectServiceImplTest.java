package com.cg.springboottdddemo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.springboottdddemo.exception.ProjectNotFoundException;
import com.cg.springboottdddemo.model.Project;
import com.cg.springboottdddemo.repository.ProjectRepository;
import com.cg.springboottdddemo.serviceimpl.ProjectServiceImpl;

class ProjectServiceImplTest {
	
	@Mock
	ProjectRepository projectRepository;
	
	@InjectMocks
	ProjectServiceImpl projectServiceImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test_findProjectByProjIdentifier() {
		BDDMockito.given(projectRepository.findByProjIdentifier("sp02")).willReturn(Optional.of(new Project("Second Project", "sp02","Second Project Description")));
		Project project= projectServiceImpl.findProjectByProjIdentifier("sp02");
		assertNotNull(project);
		assertEquals("Second Project", project.getName());
		assertEquals("sp02", project.getProjIdentifier());
		assertEquals("Second Project Description", project.getDescription());
		
	}

	@Test
	void test_findProjectByName() {
		BDDMockito.given(projectRepository.findByName("Second Project")).willReturn(Optional.of(new Project("Second Project", "sp02","Second Project Description")));
		Project project= projectServiceImpl.findProjectByName("Second Project");
		assertNotNull(project);
		assertEquals("Second Project", project.getName());
		assertEquals("Second Project Description", project.getDescription());
		
	}
	
	@Test
	void test_findProjectByIdentifier_ThrowProjectNotFoundException() {
		BDDMockito.given(projectRepository.findByName("Second Project")).willThrow(new ProjectNotFoundException());
		assertThrows(ProjectNotFoundException.class, ()->projectServiceImpl.findProjectByName("Third Project"));
		
	}
	

}
