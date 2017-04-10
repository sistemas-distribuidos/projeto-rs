package br.edu.unirn;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.unirn.model.Pessoa;

@Path("/pessoa")
@Produces({MediaType.APPLICATION_JSON})
public class PessoaRest {

	private static List<Pessoa> pessoas = new ArrayList<>();
	
	//GET
	@GET
	public List<Pessoa> getAll(){
		return pessoas;
	}
	
	//GET/ID
	@GET
	@Path("{id}")	
	public Response get(@PathParam("id") int id){
		if(id>pessoas.size()){
			return Response.status(404).build();
		}
		return Response.status(200).entity(pessoas.get(id)).build();
	}
	
	//POST
	@POST
	public Pessoa criar(Pessoa pessoa){
		pessoas.add(pessoa);
		return pessoa;
	}
	
	//PUT/ID
	@PUT
	@Path("{id}")
	public Pessoa alterar(@PathParam("id") int id,Pessoa pessoa){
		pessoas.set(id, pessoa);
		return pessoa;
	}
	
	//DELETE/ID
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") int id){
		if(id > pessoas.size()){
			return Response.status(404).build();
		}
		pessoas.remove(id);
		return Response.status(200).build();
	}
}
