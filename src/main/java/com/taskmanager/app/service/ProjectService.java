package com.taskmanager.app.service;

import com.taskmanager.app.entity.Project;
import com.taskmanager.app.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // create project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // get project by id
    public Project getProjectById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    // get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // delete project
    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }
}
