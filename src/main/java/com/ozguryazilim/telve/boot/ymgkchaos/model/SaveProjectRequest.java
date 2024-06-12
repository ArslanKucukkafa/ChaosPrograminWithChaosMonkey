package com.ozguryazilim.telve.boot.ymgkchaos.model;

public class SaveProjectRequest {

private String title;
    private String description;
    private boolean published;

    public SaveProjectRequest() {
    }

    public SaveProjectRequest(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public Projects SaveProjectRequestToProjects(SaveProjectRequest saveProjectRequest) {
        Projects projects = new Projects();
        projects.setTitle(saveProjectRequest.getTitle());
        projects.setDescription(saveProjectRequest.getDescription());
        projects.setPublished(saveProjectRequest.isPublished());
        return projects;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublished() {
        return published;
    }
}
