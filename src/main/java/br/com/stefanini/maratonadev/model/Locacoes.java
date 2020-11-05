package br.com.stefanini.maratonadev.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "locacoes")
public class Locacoes extends PanacheEntity{

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "placa_carro", nullable = false)
	private Carro carro;
	
	@CreationTimestamp
	private LocalDateTime dataAluguel;
	
	public Locacoes() {
	}

	public Locacoes(Cliente cliente2, Carro carro2) {
		this.cliente = cliente2;
		this.carro = carro2;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public LocalDateTime getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDateTime dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	
	
}
