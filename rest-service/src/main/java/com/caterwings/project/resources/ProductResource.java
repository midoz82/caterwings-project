package com.caterwings.project.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.caterwings.project.persistence.DatabaseOperations;
import com.caterwings.project.models.Product;

@Path("/product")
public class  ProductResource{

//
    private DatabaseOperations operations = new DatabaseOperations();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer createProduct(Product product) {
        return operations.addProduct(product);
    }

    @GET
    @Path("/read1/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public String test(@PathParam("title") String name) {
        return operations.getProductByName1(name);
    }
    @GET
    @Path("/read/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product[] readProduct(@PathParam("title") String name) {
        List<Product> products = operations.getProductByName(name);


        return products.toArray(new Product[]{});

    }
//
//    @GET
//    @Path("/read/{name}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public long readProductByName(@QueryParam("name") String name) {
//        logger.info("Getting line numbers of the file.");
//        return service.getLinesNumber(path);
//    }
//    @GET
//    @Path("/read/{description}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public long readProductByDescription(@QueryParam("description") String description) {
//        logger.info("Getting line numbers of the file.");
//        return service.getLinesNumber(path);
//    }
//
//
    @GET
    @Path("/read-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> readAllProducts() {
        //logger.info(".");
        return operations.getAllProducts();
    }
//
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateProduct(Product product) {
        //logger.info(".");
        return operations.updateProduct(product);
    }
//
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteProduct(@PathParam("id") int id) {
        //logger.info(".");
        return operations.deleteProduct(id);
    }


}
