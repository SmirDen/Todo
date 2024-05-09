package com.todo.resource;

import com.todo.dto.user.UserRequestDto;
import com.todo.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public Response getAllUsers() {
        return Response.ok(userService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Long id) {
        return Response.ok(userService.findById(id)).build();
    }

    @POST
    public Response addUser(UserRequestDto user) {
        userService.addUser(user);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserRequestDto user) {
        userService.updateUser(user, id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}

