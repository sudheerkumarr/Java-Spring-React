package com.cg.springboottdddemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.springboottdddemo.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	public Optional<Project> findByName(String name);
	public Optional<Project> findByProjIdentifier(String projIdentifier);

}
