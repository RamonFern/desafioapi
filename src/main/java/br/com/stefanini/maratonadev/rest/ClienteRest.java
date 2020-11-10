package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
	
		@Inject
	    ClienteService service;

	    @GET
	    @Operation(summary = "Listar Clientes",
	            description = "Lista de clientes cadastrados")
	    @APIResponse(responseCode = "201",
	            description = "cliente",
	            content = {
	                    @Content(mediaType =  "application/json",
	                            schema = @Schema(implementation = ClienteDto.class))
	            }
	    )
	    public Response listar(){
	        return Response
	                .status(Response.Status.OK)
	                .entity(service.listar())
	                .build();
	    }
	    
	    @POST
		@Operation(summary = "Inserir cliente",
					description = "Inserir cliente")
		@APIResponse(responseCode = "201",
				description = "cliente", 
				content = { 
						@Content(mediaType = "application/json") })
		public Response inserir(ClienteDto cliente) {
			service.inserir(cliente);
			return Response.status(Status.CREATED).build();

		}
	    
	    @GET
		@Path("/{id}")
		@Operation(summary = "Buscar cliente por id",
					description = "Buscar cliente id")
		@APIResponse(responseCode = "200", 
				description = "cliente", 
				content = {
				@Content(mediaType = "application/json", 
						schema = @Schema(implementation = ClienteDto.class)) })
		public Response buscarPorId(@PathParam("id") Long id) {
			return Response.ok(service.buscarPorId(id)).build();
		}

	    
	    
	    
	    
}
