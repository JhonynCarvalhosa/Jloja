package br.com.jloja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="fabricante")
@NamedQueries({
		@NamedQuery(name = "FabricanteEntity.buscarPorCodigo",
				query = "Select fab FROM FabricanteEntity fab WHERE fab.idfabricante = :codigo"),
		@NamedQuery(name = "FabricanteEntity.listar", query = "SELECT fab FROM FabricanteEntity fab") })
public class FabricanteEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	
	@Column(name = "idfabricante")
	private long idfabricante;
		
	@Column(length = 60, nullable = false)
	private String descricao;
	

	public long getIdfabricante() {
		return idfabricante;
	}

	public void setIdfabricante(long idfabricante) {
		this.idfabricante = idfabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
