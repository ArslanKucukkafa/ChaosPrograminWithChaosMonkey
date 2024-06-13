package com.firat.project.ymgkchaos.adivces;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }

    public ProjectNotFoundException(String message, int id) {
        super(message);
    }
}
