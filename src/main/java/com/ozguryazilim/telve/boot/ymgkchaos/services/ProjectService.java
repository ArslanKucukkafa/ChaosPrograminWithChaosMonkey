package com.ozguryazilim.telve.boot.ymgkchaos.services;

import com.ozguryazilim.telve.boot.ymgkchaos.adivces.ProjectNotFoundException;
import com.ozguryazilim.telve.boot.ymgkchaos.model.Projects;
import com.ozguryazilim.telve.boot.ymgkchaos.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);

    public List<Projects> getAllProject() {
        return projectRepository.findAll();
    }

    public void updateProject(Projects request) {
        Projects project = projectRepository.findById(request.getId()).orElse(null);
        if (project == null) {
            throw new ProjectNotFoundException("Project not found");
        }
        try {
            project.setDescription(request.getDescription());
            project.setTitle(request.getTitle());
            project.setPublished(request.isPublished());
            projectRepository.save(project);
        } catch (Exception e) {
            throw new RuntimeException("Occured an error while updating project");
        }
        LOGGER.info("Project updated with {} project id", request.getId());
    }

    public void saveProject(Projects project) {
        projectRepository.save(project);
        LOGGER.info("Project entity saved successfully");
    }

    public void deleteProject(int id) {
        Projects project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            LOGGER.error("Project not found with {} project id", id);
            throw new ProjectNotFoundException("Project not found with {} project id", id);
        }
        try {
            projectRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.error("Occured an error while deleting project: {}", e.getMessage());
            throw new RuntimeException("Occured an error while deleting project");
        }
    }

}