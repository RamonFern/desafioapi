package br.com.stefanini.maratonadev.model.parser;

import java.util.Objects;

import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:33
 */
public class CarroParser {

    public static CarroParser get(){
        return  new CarroParser();
    }

    public CarroDto dto(Carro entidade){
        CarroDto dto = new CarroDto();

        dto.setPlaca(entidade.getPlaca());
        dto.setAno(entidade.getAno());
        dto.setModelo(entidade.getModelo());
        dto.setMarca(entidade.getMarca());
        dto.setEstaAlugado(Objects.nonNull(entidade.getCliente()));
        
        if (dto.getEstaAlugado() == true) {
			Cliente cliente = entidade.getCliente();
			dto.setIdCliente(cliente.id);
			dto.setNomeCliente(cliente.getNome());
		}
        return dto;
    }
}
