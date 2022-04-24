package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.jloja.DAO.FabricanteDAO;
import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "fabricanteMB")
@ViewScoped
public class FabricanteBean {
	
	private List<FabricanteEntity> listaFabricante;
	private List<FabricanteEntity> listaFabricanteFiltrados;
	private FabricanteEntity fabricanteEntity;
	
	public List<FabricanteEntity> getListaFabricante() {
		return listaFabricante;
	}
	public void setListaFabricante(List<FabricanteEntity> listaFabricante) {
		this.listaFabricante = listaFabricante;
	}
	public List<FabricanteEntity> getListaFabricanteFiltrados() {
		return listaFabricanteFiltrados;
	}
	public void setListaFabricanteFiltrados(List<FabricanteEntity> listaFabricanteFiltrados) {
		this.listaFabricanteFiltrados = listaFabricanteFiltrados;
	}
	public FabricanteEntity getFabricanteEntity() {
		return fabricanteEntity;
	}
	public void setFabricanteEntity(FabricanteEntity fabricanteEntity) {
		this.fabricanteEntity = fabricanteEntity;
	}
	
	public void listarFabricante() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			listaFabricante = fabDAO.listar();
		} catch (Exception ex) {
			throw ex;
		}
	}
		
		public FabricanteBean() {
			this.fabricanteEntity = new FabricanteEntity();
	}
	
	public void adicionarFabricante() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			fabDAO.adicionar(fabricanteEntity);
			fabricanteEntity = new FabricanteEntity();
			MsgUtil.msgInfo("Fabricante gravado com sucesso!");
		}catch(Exception ex) {
			MsgUtil.msgErro("Erro ao gravar fabricante: " + ex.getMessage());
		}
	}
	
	public void buscarFabricanteCodigo(long codigo) {
		try {
			FabricanteDAO fabDAO =new FabricanteDAO();
			fabricanteEntity = fabDAO.buscarPorCodigo(codigo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public void editarFabricante() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			fabDAO.editar(fabricanteEntity);
			fabricanteEntity = new FabricanteEntity();
			MsgUtil.msgInfo("Fabricante editado com sucesso!");
		}catch (Exception ex) {
			MsgUtil.msgErro("Erro ao tentar editar um fabricante: " + ex.getMessage());
		}
	}
	
	public void excluirFabricante() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			fabDAO.excluir(fabricanteEntity);
			fabricanteEntity = new FabricanteEntity();
			MsgUtil.msgInfo("Fabricante excluído com sucesso!");
		}catch (Exception ex) {
			MsgUtil.msgErro("Erro ao tentar excluir um fabricante: " + ex.getMessage());
		}
	}
	
	public void limpar() {
		fabricanteEntity = new FabricanteEntity();
	}
}


