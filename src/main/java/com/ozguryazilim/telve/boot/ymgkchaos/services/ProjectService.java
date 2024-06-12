package com.ozguryazilim.telve.boot.ymgkchaos.services;

import com.ozguryazilim.telve.boot.ymgkchaos.model.Projects;
import com.ozguryazilim.telve.boot.ymgkchaos.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    public List<Projects> getAllProject() {
        return projectRepository.findAll();
    }

    public void updateProject(Projects request) {
        Projects project = projectRepository.findById(request.getId()).orElse(null);
        if (project == null) {
            throw new RuntimeException("Project not found");
        }
        try {
            project.setDescription(request.getDescription());
            project.setTitle(request.getTitle());
            project.setPublished(request.isPublished());
            projectRepository.save(project);
        } catch (Exception e) {
            throw new RuntimeException("Occured an error while updating project");
        }
    }

    public void saveProject(Projects project) {
        projectRepository.save(project);
    }

    public void deleteProject(int id) {
        Projects project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            throw new RuntimeException("Project not found");
        }
        try {
            projectRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Occured an error while deleting project");
        }
    }

}