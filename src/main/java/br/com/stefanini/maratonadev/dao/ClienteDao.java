package br.com.stefanini.maratonadev.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Cliente;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class ClienteDao {

	 public List<Cliente> listar(){
	        return Cliente.listAll(Sort.by("nome").ascending());
	    }

	public void inserir(Cliente cliente) {
		Cliente.persist(cliente);
	}

	public Optional<Cliente> buscarPorCPF(String cpf) {
		return Optional.ofNullable(Cliente.find("cpf", cpf).firstResult());
	}

	public Cliente buscarPorId(Long id) {
		return Cliente.findById(id);
	}

}
