package org.example.restapi;
import org.example.bean.*;
import org.example.service.AdminService;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/Admin")
public class AdminREST {
    AdminService adminService = new AdminService();

    @POST
    @Path("/addLibrarian")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLibrarian(@NotNull final Librarian librarian ,@QueryParam("password") final String password  ) {
        User user = new User();
        user.setRoleId(2);
        user.setPassword(password);
        user.setUserName(librarian.getLibrarianId());
        if (adminService.addLibrarian(user, librarian)) {
            return Response.status(200).entity("Successfully Add Librarian "+ librarian.getName()).build();
        }
        else {
            System.out.println("500 error");
           return  Response.status(500).entity("Something unexpected happened ").build();
        }
    }

    @GET
    @Path("/fetchLibrarians")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Librarian> viewLibrarian(){
        List<Librarian> allLibrarians = new ArrayList<Librarian>();
        try{
         allLibrarians =adminService.viewLibrarians();
        }catch(Exception ex){
            return null;
        }
        return allLibrarians;
    }

    @POST
    @Path("/removeLibrarian")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeLibrarian (
            @NotNull
            @QueryParam("librarianId") String librarianId
    ){
       if(adminService.deleteLibrarian(librarianId)) {
           return Response.status(200).entity("Librarian " + librarianId + " successfully removed").build();
       }
        else {
           return Response.status(500).entity("Fail to remove " + librarianId).build();
       }
    }

}
