package com.firat.project.ymgkchaos.controller;

import com.firat.project.ymgkchaos.model.Projects;
import com.firat.project.ymgkchaos.services.ProjectService;
import com.firat.project.ymgkchaos.model.SaveProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("result", "");
        return "index";
    }

    @PostMapping("/chaosmonkey/assaults")
    public String applyChaos(@RequestParam("level") int level, Model model) {
        String url = "http://hybrid-circle-426017-j4.rj.r.appspot.com/actuator/chaosmonkey/assaults";
        String payload = String.format("{\"level\": \"%d\", \"latencyActive\": false, \"exceptionsActive\": true}",
                level);
        ResponseEntity<String> response = restTemplate.postForEntity(url, payload, String.class);

        model.addAttribute("result", response.getBody());
        return "index";
    }

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
