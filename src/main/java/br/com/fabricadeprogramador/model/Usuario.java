package br.com.fabricadeprogramador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 6561378085656391997L;
		
	@Id
    @SequenceGenerator(name="sq_usuario", sequenceName = "sq_usuario", allocationSize=1, initialValue=1)   
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
	private Integer id;
	
	private String nome;
	
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
