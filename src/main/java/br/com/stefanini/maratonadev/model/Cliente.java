package br.com.stefanini.maratonadev.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "cliente")
public class Cliente extends PanacheEntity{

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@OneToOne
	@JoinColumn(name = "placa_carro", nullable = true)
	private Carro carro;

	@OneToMany(mappedBy = "cliente")
	private List<Locacoes> locacoes;

	@Column(name = "cpf", nullable = false, length = 11, unique = true)
	private String cpf;

	@Column(nullable = false)
	private String contato;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String endereco;
	
	

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Locacoes> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacoes> locacoes) {
		this.locacoes = locacoes;
	}

	
	


}
