package com.todo.resource;

import com.todo.entity.Project;
import com.todo.service.ProjectService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource {

    @Inject
    ProjectService projectService;

    @GET
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GET
    @Path("/{id}")
    public Project getProjectById(@PathParam("id") Long id) {
        return projectService.findById(id);
    }

    @POST
    public void addProject(Project project) {
        projectService.addProject(project);
    }

    @PUT
    @Path("/{id}")
    public void updateProject(@PathParam("id") Long id, Project project) {
        projectService.updateProject(project, id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProject(@PathParam("id") Long id) {
        projectService.deleteProject(id);
    }
}
