package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.Cliente;
import br.com.fiap.bo.ClienteBO;

@Path("/Cliente")
public class ClienteResource {
	
	private ClienteBO clienteBo = new ClienteBO();
	
	// select
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> selecitonarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Cliente>) clienteBo.selecionarBO();
		}
	
	// insert
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Cliente cliente, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		clienteBo.inserirBo(cliente);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(cliente.getIdCliente()));
		return Response.created(builder.build()).build();
	}
	// update
	@PUT
	@Path("/{idCliente}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Cliente cliente, @PathParam("idCliente") int idCliente) throws ClassNotFoundException, SQLException {
		clienteBo.atualizarBo(cliente);
		return Response.ok().build();
	}
	// delete
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("idCliente") int idCliente) throws ClassNotFoundException, SQLException {
		clienteBo.deletarBo(idCliente);
		return Response.ok().build();	
		}
	
}
