package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dao.LocacoesDao;
import br.com.stefanini.maratonadev.dto.LocacoesDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Locacoes;
import br.com.stefanini.maratonadev.model.parser.LocacoesParser;


@RequestScoped
public class LocacoesService {
	
	@Inject
	LocacoesDao locacoesDao;
	
	@Inject
	ClienteDao clienteDao;
	
	@Inject
	CarroService carroService;
	
		
	public List<LocacoesDto> listarHistoricoCliente(Long idCliente) {
		List<Locacoes> entidades = locacoesDao.listarHistoricoDeLocacoesCliente(idCliente);
		return (List<LocacoesDto>) entidades.stream().map(LocacoesParser.get()::toDto).collect(Collectors.toList());
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void inserir(Locacoes locacoes) {
		locacoesDao.inserir(locacoes);
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean alugar(Long idCliente, String placa) {
		Cliente cliente = clienteDao.buscarPorId(idCliente);
		Carro carro = carroService.buscarPorPlaca(placa);
		
		if (!(cliente.getCarro() == null) || !(carro.getCliente() == null)) {
			return false;
		}
		cliente.setCarro(carro);
		carro.setCliente(cliente);

		clienteDao.inserir(cliente);
		carroService.inserir(carro);

		locacoesDao.inserir(new Locacoes(cliente, carro));

		return true;
	}

	@Transactional(rollbackOn = Exception.class)
	public boolean devolverCarro(Long idCliente) {
		Cliente cliente = clienteDao.buscarPorId(idCliente);
		Carro carro = carroService.buscarPorPlaca(cliente.getCarro().getPlaca());
		
		if ((cliente.getCarro() == null) || (carro.getCliente() == null)) {
			return false;
		}
		//System.out.println("chegou depois do if");
		cliente.setCarro(null);
		carro.setCliente(null);
		
		clienteDao.inserir(cliente);  /// CONSERTAR DEVOLVER CARRO
		carroService.inserir(carro);
		
		locacoesDao.inserir(new Locacoes(cliente, carro));
		return true;
	}

}
