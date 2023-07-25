package org.example.restapi;

import org.example.bean.User;
import org.example.service.UserService;
import org.example.service.UserServiceInterface;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserREST {

    private final UserServiceInterface userService = new UserService();
    @GET
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user){
        if(userService.authenticateUser(user)) {
            return  Response.status(200).entity("Successfully Logged In").build();
        }
        return Response.status(500).entity("Failed to Login ").build();
    }

    @GET
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logout(User user){
        if(userService.logout(user)) {
            return  Response.status(200).entity("Successfully Logged Out").build();
        }
        return Response.status(500).entity("Failed to Logout ").build();
    }
}
