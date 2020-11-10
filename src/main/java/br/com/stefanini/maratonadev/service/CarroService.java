package br.com.stefanini.maratonadev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.stefanini.maratonadev.dao.CarroDao;
import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.parser.CarroParser;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:32
 */
@RequestScoped
public class CarroService {
    @Inject
    CarroDao dao;


    public List<CarroDto> listar(){
        return dao.listar().stream().map(CarroParser.get()::dto).collect(Collectors.toList());
    }
    
    public Carro buscarPorPlaca(String placa) {
		return dao.buscarPelaPlaca(placa);
	}
	
	public CarroDto buscarPorPlacaDto(String placa) {
		return CarroParser.get().dto(this.buscarPorPlaca(placa));
	}
	
	public void inserir(Carro carro) {
		dao.inserir(carro);
	}

	public List<CarroDto> listarCarrosDisponiveis() {
		List<CarroDto> listBanco = dao.listarDisponiveis().stream().map(CarroParser.get()::dto).collect(Collectors.toList());
		List<CarroDto> listaDisponivel = new ArrayList<CarroDto>();
		for (CarroDto carroDto : listBanco) {
			if(!carroDto.getEstaAlugado()) {
				listaDisponivel.add(carroDto);
			}
		}
		return listaDisponivel;
	}
	
	
	
}
