package org.example.restapi;

import org.example.bean.Book;
import org.example.bean.Issue;
import org.example.bean.Student;
import org.example.service.LibrarianService;
import org.example.service.LibrarianServiceInterface;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("librarian")
public class LibrarianREST {
    private final LibrarianServiceInterface librarianService = new LibrarianService();
    @GET
    @Path("/allDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> allBooks(){
        List<Book> books = new ArrayList<Book>();
        try{
            books = librarianService.viewBooks();
        }catch (Exception ex){
            return null;
        }
        return books;
    }

    @POST
    @Path("/addBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book){
        if(librarianService.addBook(book)){
            return Response.status(200).entity("Book " + book.getName() + " successfully added ").build();
        }
        else return Response.status(500).entity("Fail to add book "+ book.getName()).build();
    }
    @POST
    @Path("/removeBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeBook(
            @NotNull
            @QueryParam("bookId") String bookId
    ){
        if(librarianService.removeBook(bookId)){
            return Response.status(200).entity("Book successfully removed ").build();
        }
        else return Response.status(500).entity("Fail to remove book").build();
    }

    @POST
    @Path("/issueBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response issueBook(
            @NotNull
            @QueryParam("bookId") String bookId,
            @NotNull
            @QueryParam("librarianId") String librarianId,
            @NotNull
            @QueryParam("studentId") String studentId

    ){
        if(librarianService.issueBook(bookId,librarianId,studentId)){
            return Response.status(200).entity("Book successfully issued ").build();
        }
        else return Response.status(500).entity("Fail to issue book").build();
    }

    @POST
    @Path("/returnBook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response returnBook(
            @NotNull
            @QueryParam("issueId") int issueId
    ){
        if(librarianService.returnBook(issueId)){
            return Response.status(200).entity("Book successfully returned ").build();
        }
        else return Response.status(500).entity("Fail to return book").build();
    }
    @GET
    @Path("/allIssueBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> allIssuedBooks(){
        List<Issue> issues = new ArrayList<Issue>();
        try{
            issues = librarianService.viewIssuedBooks();
        }catch (Exception ex){
            return null;
        }
        return issues;
    }
    @GET
    @Path("/allIssueLogs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> allIssuedLogs(){
        List<Issue> issues = new ArrayList<Issue>();
        try{
            issues = librarianService.viewAllIssueLogs();
        }catch (Exception ex){
            return null;
        }
        return issues;
    }
    @POST
    @Path("/addStudent")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student student){
        if(librarianService.addStudent(student)){
            return Response.status(200).entity(student.getName() + " is successfully added ").build();
        }
        else return Response.status(500).entity("Failed to add " + student.getName()).build() ;
    }
}

