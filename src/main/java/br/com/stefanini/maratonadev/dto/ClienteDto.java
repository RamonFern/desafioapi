package br.com.stefanini.maratonadev.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ClienteDto {
	
	   private Long id;

		@NotBlank
		@Length(min = 3, max = 100, message = "Nome deve ter entre 3 a 100 caracteres.")
	    private String nome;
		
		@NotNull
	    @Column(name = "cpf", nullable = false, length = 11, unique = true)
	    private String cpf;
		
		@NotNull
	    @Column(nullable = false)
	    private String contato;
		
		@NotBlank
	    @Column(nullable = false)
	    private String email;

		@NotBlank
		@Column(nullable = false)
	    private String cep;
		
		@NotBlank
		@Column(nullable = false)
		private String endereco;
	   	    
	    private String placaCarro;
	    private int anoCarro;
	    private String marcaCarro;
	    private String modeloCarro;
	    
	    private boolean possuiVeiculo;

	    
		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getPlacaCarro() {
			return placaCarro;
		}

		public void setPlacaCarro(String placaCarro) {
			this.placaCarro = placaCarro;
		}

		public int getAnoCarro() {
			return anoCarro;
		}

		public void setAnoCarro(int anoCarro) {
			this.anoCarro = anoCarro;
		}

		public String getMarcaCarro() {
			return marcaCarro;
		}

		public void setMarcaCarro(String marcaCarro) {
			this.marcaCarro = marcaCarro;
		}

		public String getModeloCarro() {
			return modeloCarro;
		}

		public void setModeloCarro(String modeloCarro) {
			this.modeloCarro = modeloCarro;
		}

		public boolean isPossuiVeiculo() {
			return possuiVeiculo;
		}

		public void setPossuiVeiculo(boolean possuiVeiculo) {
			this.possuiVeiculo = possuiVeiculo;
		}
	    
	    

}
