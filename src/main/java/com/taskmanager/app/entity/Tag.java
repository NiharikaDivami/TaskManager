package com.taskmanager.app.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "text")
    private String description;
    
    
    @ManyToMany(mappedBy = "tags")
    private List<Task> tasks;


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    } 

    public String getDescription() {
        return description;
    }

    public void setId(UUID id) {
        this.id = id;
    } 

    public void setName(String name) {
        this.name = name;
    } 

    public void setDescription(String description) {
        this.description = description;
    }
}
