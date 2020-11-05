package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.LocacoesDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Locacoes;

public class LocacoesParser {

	 public static LocacoesParser get(){
	        return new LocacoesParser();
	    }

		public Locacoes entity(LocacoesDto dto) {
			return null;
		}

		public LocacoesDto toDto(Locacoes entidade) {
			LocacoesDto dto = new LocacoesDto();
			Carro carro = entidade.getCarro();
			Cliente cliente = entidade.getCliente();
			dto.setDataAluguel(entidade.getDataAluguel());
			
			// Carro
			dto.setPlacaCarro(carro.getPlaca());
			dto.setAnoCarro(carro.getAno());
			dto.setMarcaCarro(carro.getMarca());
			dto.setModeloCarro(carro.getModelo());
			
			// Cliente
			dto.setNomeCliente(cliente.getNome());
			dto.setIdCliente(cliente.id);
			
			return dto;
		}
}
