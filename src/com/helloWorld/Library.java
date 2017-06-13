package com.helloWorld;

import com.helloWorld.Book;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;

@Path("/library")	// Root Resource
public class Library {
	HashMap lib = new HashMap<Integer, Book>();

	@GET
	@Path("/book/{isbn}")	// SUB Resource
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getBookIsbn(@PathParam("isbn") int isbn){
		System.out.println("ISBN Search");
		Book book = (Book) lib.get(isbn);
		
		return Response.ok().entity(book).build();
	}

	@GET
	@Path("/book")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getBookbyTitle(@QueryParam("title") String title){
		System.out.println("Title Search");
		return Response.ok().build();
		
	}

	@POST
	@Path("/addBook")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addBook(Book book){
		int isbn = book.getIsbn();
		this.lib.put(isbn, book);
		System.out.println(book);
		return Response.ok().build();
	}

	@GET
	@Path("/test")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response test(){
		Book b1 = new Book(1, "alpha");
		Book b2 = new Book(2, "Beta");
		System.out.println("IM HERE");
		this.lib.put(1,  b1);
		this.lib.put(2,  b2);
		return Response.ok().build();
	}
	
}
