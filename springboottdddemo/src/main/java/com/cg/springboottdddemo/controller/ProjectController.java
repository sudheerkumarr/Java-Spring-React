package com.cg.springboottdddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboottdddemo.model.Project;
import com.cg.springboottdddemo.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/{projIdentifier}")
	public ResponseEntity<Project> getProjectDetailByProjIdentifier(@PathVariable String projIdentifier) throws Exception{
		Project project=projectService.findProjectByProjIdentifier(projIdentifier);
		
		return new ResponseEntity<>(project,HttpStatus.OK);
	}
	
	

}
