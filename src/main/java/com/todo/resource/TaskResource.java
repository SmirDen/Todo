package com.todo.resource;

import com.todo.entity.Task;
import com.todo.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("api/v1/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    TaskService taskService;

    @GET
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GET
    @Path("/{id}")
    public Task getTaskById(@PathParam("id") Long id) {
        return taskService.findById(id);
    }

    @POST
    public void addTask(Task task) {
        taskService.addTask(task);
    }

    @PUT
    @Path("/{id}")
    public void updateTask(@PathParam("id") Long id, Task task) {
        taskService.updateTask(task, id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        taskService.deleteTask(id);
    }
}

