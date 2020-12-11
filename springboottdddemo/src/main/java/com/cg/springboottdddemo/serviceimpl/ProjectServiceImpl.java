package com.cg.springboottdddemo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboottdddemo.exception.ProjectNotFoundException;
import com.cg.springboottdddemo.model.Project;
import com.cg.springboottdddemo.repository.ProjectRepository;
import com.cg.springboottdddemo.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project findProjectByName(String name) {
		Project project=null;
		Optional<Project> optionalProject =  projectRepository.findByName(name);
		if(optionalProject.isPresent()) {
			project = optionalProject.get();
		} else {
			throw new ProjectNotFoundException();
		}
		return project;
	}
	
	@Override
	public Project findProjectByProjIdentifier(String projIdentifier) {
		Project project=null;
		Optional<Project> optionalProject =  projectRepository.findByProjIdentifier(projIdentifier);
		if(optionalProject.isPresent()) {
			project = optionalProject.get();
		} else {
			throw new ProjectNotFoundException();
		}
		return project;
	}

}
