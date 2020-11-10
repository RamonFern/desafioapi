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

		
		public ClienteDto dto(Cliente cliente) {
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setCpf(cliente.getCpf());
			clienteDto.setCep(cliente.getCep());
			clienteDto.setContato(cliente.getContato());
			clienteDto.setEmail(cliente.getEmail());
			//clienteDto.setId(cliente.id);
			clienteDto.setNome(cliente.getNome());
			clienteDto.setPossuiVeiculo(Objects.nonNull(cliente.getCarro()));
			
			if (clienteDto.isPossuiVeiculo()) {
				Carro carro = cliente.getCarro();
				clienteDto.setPlacaCarro(carro.getPlaca());
				clienteDto.setMarcaCarro(carro.getMarca());
				clienteDto.setAnoCarro(carro.getAno());
				clienteDto.setModeloCarro(carro.getModelo());
			}
			
			return clienteDto;
		}
}

