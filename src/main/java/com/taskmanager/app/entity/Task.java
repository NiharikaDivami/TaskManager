package com.taskmanager.app.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id;

    private String summary;

    @Column(columnDefinition = "text")
    private String description;

    private Boolean completed = Boolean.FALSE;

   
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;


    @ManyToMany
    @JoinTable(
        name = "task_tags",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    
    
    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask")
    private List<Task> subTasks;


    public UUID getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Project getProject() {
        return project;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
