package br.com.fabricadeprogramador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = -1276238079628852947L;
		
	@Id
    @SequenceGenerator(name="sq_cliente", sequenceName = "sq_cliente", allocationSize=1, initialValue=1)   
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	private Integer id;
	
	private String nome;
	
	private String email;
	
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumn(name = "estado", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_estado"))
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
