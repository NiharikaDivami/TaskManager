package com.taskmanager.app.controller;

import com.taskmanager.app.entity.Project;
import com.taskmanager.app.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // create a project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // get project by id
    @GetMapping("/{id}")
    public Project getProject(@PathVariable UUID id) {
        return projectService.getProjectById(id);
    }

    // get all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // delete a project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
    }
}
