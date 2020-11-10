package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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

import br.com.stefanini.maratonadev.dto.LocacoesDto;
import br.com.stefanini.maratonadev.service.LocacoesService;



@Path("locacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocacoesRest {
	
	@Inject
	LocacoesService locacoesService;

	@GET
	@Path("/{idCliente}")
	@Operation(summary = "Recuperar historico de locacoes do cliente por id", 
			description = "Recuperar historico de locacoes do cliente")
	@APIResponse(responseCode = "200", 
			description = "historico", 
			content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = LocacoesDto.class)) })
	public Response recuperarPorId(@PathParam("idCliente") Long idCliente) {
		return Response.ok(locacoesService.listarHistoricoCliente(idCliente)).build();
	}
	
	
	@PUT
	@Path("/alugar/{idCliente}/{placa}")
	@Operation(summary = "Alugar um carro", 
			description = "Alugar um carro")
	@APIResponse(responseCode = "202", 
			description = "alugar", 
			content = { 
					@Content(mediaType = "application/json") })
	public Response alugar(@PathParam("idCliente") Long idCliente, @PathParam("placa") String placa) {
		boolean aluguelAceito = locacoesService.alugar(idCliente, placa);
		if (aluguelAceito) {
			return Response.status(Status.ACCEPTED).build();
		}

		return Response.status(Status.BAD_REQUEST).build();
	}
	
	@PUT
	@Path("/devolver/{idCliente}")
	@Operation(summary = "Devolver carro", 
			description = "Devolver carro")
	@APIResponse(responseCode = "202", 
			description = "devolver", 
			content = { 
					@Content(mediaType = "application/json") })
	public Response devolver(@PathParam("idCliente") Long idCliente) {
		boolean devolucaoAceita = locacoesService.devolverCarro(idCliente);
		if (devolucaoAceita) {
			return Response.status(Status.ACCEPTED).build();
		}

		return Response.status(Status.BAD_REQUEST).build();
	}

	
	
	
}
