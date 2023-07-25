package org.example.restapi;


import org.example.bean.Book;
import org.example.bean.Student;
import org.example.service.StudentService;
import org.example.service.StudentServiceInterface;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/student")
public class StudentREST {
   private final StudentServiceInterface studentService  = new StudentService();

    @GET
    @Path("/issuedBooks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> listBooks(
            @NotNull
            @QueryParam("studentId") final String studentId
    ){
        List<Book> books = new ArrayList<Book>();
        try{
            books = studentService.issuedBooks(studentId);
        }catch (Exception ex){
            return null;
        }
        return books;
    }

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Student details(
            @NotNull
            @QueryParam("studentID") final String studentId
    ){
        Student student = new Student();
        try{
            student = studentService.viewDetails(studentId);
        }catch (Exception ex){
            return null;
        }
        return student;
    }

    @GET
    @Path("/allDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> allDetails(){
        List<Student> students = new ArrayList<Student>();
            try{
                students = studentService.viewALLStudentDetails();
            }catch (Exception ex){
                return null;
            }
            return students;
        }
}

