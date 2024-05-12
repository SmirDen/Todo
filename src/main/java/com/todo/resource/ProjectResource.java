package com.todo.resource;

import com.todo.dto.project.ProjectRequestDto;
import com.todo.service.project.ProjectResourceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("api/v1/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource {

    @Inject
    ProjectResourceService projectResourceService;

    @GET
    public Response getAllProjects() {
        return Response.ok(projectResourceService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getProjectById(@PathParam("id") Long id) {
        return Response.ok(projectResourceService.findById(id)).build();
    }

    @POST
    public Response addProject(ProjectRequestDto project) {
        projectResourceService.addProject(project);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProject(@PathParam("id") Long id, ProjectRequestDto project) {
        projectResourceService.updateProject(project, id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProject(@PathParam("id") Long id) {
        projectResourceService.deleteProject(id);
        return Response.noContent().build();
    }
}
