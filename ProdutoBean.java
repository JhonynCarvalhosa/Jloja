package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jloja.DAO.ProdutoDAO;
import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "produtoMB")
@SessionScoped

public class ProdutoBean {
	
	private List<ProdutoEntity> listaProdutos;
	private List<ProdutoEntity> listaProdutosFiltrados;
	private ProdutoEntity produtoEntity;
	private Long codigo;
	
	public ProdutoBean() {
		this.produtoEntity = new ProdutoEntity();
	}
	
	public void listarProduto() {
		try {
			ProdutoDAO proDAO = new ProdutoDAO();
			listaProdutos = proDAO.listar();
		}catch (Exception ex){
			throw ex;
		}
	}
	
	public void adicionarProduto(UsuarioEntity user, FabricanteEntity fab) {
		try {
			produtoEntity.setUsuario_idusuario(user);
			produtoEntity.setFabricante_idfabricante(fab);
			
			ProdutoDAO prodao = new ProdutoDAO();
			prodao.adicionar(produtoEntity);
			
			produtoEntity = new ProdutoEntity();
			
			MsgUtil.msgInfo("Produto gravado com Sucesso!");
			
		}catch (Exception ex){
			MsgUtil.msgErro("Erro ao gravar produto: " + ex.getMessage());
		}
	}
	
	public void buscarProdutoCodigo(Long codigo){
		try {
			ProdutoDAO proDAO = new ProdutoDAO();
			produtoEntity = proDAO.buscarPorCodigo(codigo);
		}catch(Exception ex){
			throw ex;
		}
	}
	
	public void editarProduto(FabricanteEntity fab){
		try{
			
			produtoEntity.setFabricante_idfabricante(fab);
			ProdutoDAO prodao = new ProdutoDAO();
			prodao.editar(produtoEntity);
			produtoEntity = new ProdutoEntity();
			
			MsgUtil.msgInfo("Produto editado com Sucesso!");
		}catch (Exception ex){
			MsgUtil.msgErro("Erro ao tentar editar um produto: " + ex.getMessage());
		}
	}
	
	public void excluirProduto() {
		try {
			ProdutoDAO prodao = new ProdutoDAO();
			prodao.excluir(produtoEntity);
			produtoEntity = new ProdutoEntity();
			MsgUtil.msgInfo("Produto excluido com Sucesso!");
		}catch (Exception ex){
			MsgUtil.msgErro("Erro ao tentar excluir produto: " + ex.getMessage());
		}
	}	
	
		public List<ProdutoEntity> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<ProdutoEntity> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public List<ProdutoEntity> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}
	public void setListaProdutosFiltrados(List<ProdutoEntity> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}
	public ProdutoEntity getProdutoEntity() {
		return produtoEntity;
	}
	public void setProdutoEntity(ProdutoEntity produtoEntity) {
		this.produtoEntity = produtoEntity;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}