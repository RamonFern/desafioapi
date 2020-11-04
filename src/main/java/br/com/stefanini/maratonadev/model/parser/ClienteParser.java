package br.com.stefanini.maratonadev.model.parser;

import java.util.Objects;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;

public class ClienteParser {

	  public static ClienteParser get(){
	        return new ClienteParser();
	    }

		
		public Cliente toEntity(ClienteDto dto) {
			Cliente entidade = new Cliente();
			entidade.setCpf(dto.getCpf());
			
			entidade.setCep(dto.getCep());
			entidade.setEndereco(dto.getEndereco());
			entidade.setContato(dto.getContato());
			entidade.setEmail(dto.getEmail());
			entidade.setNome(dto.getNome());
			return entidade;
		}

		
		public ClienteDto dto(Cliente entidade) {
			ClienteDto dto = new ClienteDto();
			dto.setCpf(entidade.getCpf());
			dto.setCep(entidade.getCep());
			dto.setContato(entidade.getContato());
			dto.setEmail(entidade.getEmail());
			//dto.setId(entidade.getId());
			dto.setNome(entidade.getNome());
			dto.setPossuiVeiculo(Objects.nonNull(entidade.getCarro()));
			
			if (dto.isPossuiVeiculo()) {
				Carro carro = entidade.getCarro();
				dto.setPlacaCarro(carro.getPlaca());
				dto.setMarcaCarro(carro.getMarca());
				dto.setAnoCarro(carro.getAno());
				dto.setModeloCarro(carro.getModelo());
			}
			
			return dto;
		}
}

