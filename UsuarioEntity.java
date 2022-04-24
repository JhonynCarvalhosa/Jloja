package br.com.jloja.entity;

import br.com.jloja.entity.UsuarioEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="usuario")
@NamedQueries({
	@NamedQuery(name = "UsuarioEntity.buscarPorCodigo",
			query = "SELECT usu FROM UsuarioEntity usu WHERE usu.idusuario = :codigo"),
	
	@NamedQuery(name = "UsuarioEntity.listar",
	query = "SELECT usu FROM UsuarioEntity usu"),
	
	@NamedQuery(name = "UsuarioEntity.login",
	query = "SELECT usu FROM UsuarioEntity usu WHERE usu.situacao = :situacao")
})
	
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	
	
	
	@Column(name = "idusuario")
	private long idusuario;
		
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 20, nullable = false)
	private String login;
	
	@Column(length = 50, nullable = false)
	private String senha;
	
	@Column(length = 1)
	private char situacao;
	
	public long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}

	public void setFabricante_idfabricante(FabricanteEntity fab) {
		// TODO Auto-generated method stub
		
	}

}