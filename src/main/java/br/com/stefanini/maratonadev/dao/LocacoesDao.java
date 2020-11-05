package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Locacoes;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class LocacoesDao {

	public List<Locacoes> listarHistoricoDeLocacoesCliente(Long idCliente) {
		return Locacoes.find("cliente.id", Sort.by("dataAluguel").descending(), idCliente).list();
	}

	public void inserir(Locacoes locacoes) {
		Locacoes.persist(locacoes);
	}
}
