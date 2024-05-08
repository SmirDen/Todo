package com.todo.resource;

import com.todo.entity.User;
import com.todo.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id) {
        return userService.findById(id);
    }

    @POST
    public void addUser(User user) {
        userService.addUser(user);
    }

    @PUT
    @Path("/{id}")
    public void updateUser(@PathParam("id") Long id, User user) {
        userService.updateUser(user, id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }
}

