package com.cg.springboottdddemo.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.springboottdddemo.model.Project;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProjectRepositoryTest {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Test
	void test_findByName() throws Exception{
		System.out.println("---------------->"+projectRepository);
		Optional<Project> project= projectRepository.findByName("First Project");
		assertTrue(project.isPresent());
		
	}
	
	@Test
	void test_findByProjIdentifier() throws Exception{
		System.out.println("---------------->"+projectRepository);
		Optional<Project> project= projectRepository.findByProjIdentifier("fp01");
		assertTrue(project.isPresent());
		
	}

}
