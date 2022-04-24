package br.com.jloja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="produto")
@NamedQueries({
	@NamedQuery(name = "ProdutoEntity.buscarPorCodigo",
			query = "Select pro FROM ProdutoEntity pro WHERE pro.idproduto = :codigo"),
	@NamedQuery(name = "ProdutoEntity.listar", query = "SELECT pro FROM ProdutoEntity pro") })
public class ProdutoEntity {
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private long idproduto;
		
	@Column(length = 60)
	private String descricao;
	
	@Column (precision = 7, scale = 2)
	private double valor;
	
	@Column
	private long quantidade;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante", referencedColumnName = "idfabricante", nullable=false)
	private FabricanteEntity fabricante_idfabricante;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario", referencedColumnName = "idusuario", nullable=false)
	private UsuarioEntity usuario_idusuario;
	
	public long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(long idproduto) {
		this.idproduto = idproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public UsuarioEntity getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(UsuarioEntity usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}

	public FabricanteEntity getFabricante_idfabricante() {
		return fabricante_idfabricante;
	}

	public void setFabricante_idfabricante(FabricanteEntity fabricante_idfabricante) {
		this.fabricante_idfabricante = fabricante_idfabricante;
	}
	
	
}
	

