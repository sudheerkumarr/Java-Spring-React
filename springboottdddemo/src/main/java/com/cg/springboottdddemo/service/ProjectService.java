package com.cg.springboottdddemo.service;

import com.cg.springboottdddemo.model.Project;

public interface ProjectService {

	Project findProjectByName(String name);

	Project findProjectByProjIdentifier(String projIdentifier);

}
