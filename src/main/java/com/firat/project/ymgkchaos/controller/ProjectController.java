package com.firat.project.ymgkchaos.controller;

import com.firat.project.ymgkchaos.model.Projects;
import com.firat.project.ymgkchaos.services.ProjectService;
import com.firat.project.ymgkchaos.model.SaveProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Projects>> getAllProjects() {
        var projects = projectService.getAllProject();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateProject(@RequestBody Projects projects) {
        try {
            projectService.updateProject(projects);
        } catch (Exception e) {
            return new ResponseEntity<>("Project not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Project updated", HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<String> saveProject(@RequestBody SaveProjectRequest project) {
        projectService.saveProject(project.SaveProjectRequestToProjects(project));
        return new ResponseEntity<>("Project saved", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") int id) {
        try {
            projectService.deleteProject(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Project deleted", HttpStatus.OK);
    }

}
