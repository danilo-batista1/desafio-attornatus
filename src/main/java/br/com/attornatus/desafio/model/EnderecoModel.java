package br.com.attornatus.desafio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "endereco")
	public class EnderecoModel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer codigo;

	    @Column(nullable = false, length = 50)
	    private String logradouro;

	    @Column(nullable = false, length = 10)
	    private String numero;

	    @Column(nullable = false, length = 8)
	    private String cep;

	    @Column(nullable = false, length = 50)
	    private String cidade;
	    
	    @Column(nullable = false)
	    public boolean principal;
	    
	    //getters and setters
	    public Integer getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(Integer codigo) {
	        this.codigo = codigo;
	    }

	    public String getLogradouro() {
	        return logradouro;
	    }

	    public void setLogradouro(String logradouro) {
	        this.logradouro = logradouro;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }

	    public String getCep() {
	        return cep;
	    }

	    public void setCep(String cep) {
	        this.cep = cep;
	    }

	    public String getCidade() {
	        return cidade;
	    }

	    public void setCidade(String cidade) {
	        this.cidade = cidade;
	    }

		public boolean isPrincipal() {
			return principal;
		}

		public void setPrincipal(boolean principal) {
			this.principal = principal;
		}
}
