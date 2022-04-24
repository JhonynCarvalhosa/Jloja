package br.com.jloja.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.jloja.DAO.UsuarioDAO;
import br.com.jloja.entity.FabricanteEntity;

import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean (name = "usuarioMB")
@SessionScoped

public class UsuarioBean {
	
	private List<UsuarioEntity> listaUsuarios;
	private List<UsuarioEntity> listaUsuariosFiltrados;
	private UsuarioEntity usuarioEntity;
	private long codigo;
	
	private UsuarioEntity usuarioLogado;
	
	public UsuarioEntity getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new UsuarioEntity();
		}
		return usuarioLogado;
	}
	
	public void setusuarioLogado(UsuarioEntity usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public List<UsuarioEntity> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<UsuarioEntity> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public List<UsuarioEntity> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}
	public void setListaUsuariosFiltrados(List<UsuarioEntity> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	 public UsuarioBean() {
		 this.usuarioEntity = new UsuarioEntity();
	 }
	 
	 public void listarUsuario() {
		try {
			 UsuarioDAO usuDAO = new UsuarioDAO();
			 listaUsuarios = usuDAO.listar();
		} catch (Exception ex) {
			 MsgUtil.msgErro("Erro ao gravar usuário: " + ex.getMessage());
		}
	 }
	 
	 public void adicionarUsuario() {
		 try {
			 UsuarioDAO usudao = new UsuarioDAO();
			 usudao.adicionar(usuarioEntity);
			 usuarioEntity = new UsuarioEntity();
			 MsgUtil.msgInfo("Usuário gravado com Sucesso!");
		 } catch (Exception ex) {
			 MsgUtil.msgErro("Erro ao gravar usuário: " + ex.getMessage());
		 }
	 }
		public void buscarUsuarioCodigo(long codigo){
			try {
				UsuarioDAO fabDAO = new UsuarioDAO();
				usuarioEntity = fabDAO.buscarPorCodigo(codigo);
			} catch (Exception ex) {
				throw ex;
			}
		}
		
		public void autenticar() {
			try {
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuarioLogado = usuDAO.autenticar(usuarioLogado.getLogin(), usuarioLogado.getSenha());
		
				if (usuarioLogado == null) {
					MsgUtil.msgErro("Usuário e/ou senha inválido");
					usuarioEntity = new UsuarioEntity();
				} else {
					if (usuarioLogado == null) {
						MsgUtil.msgErro("Este usuário está inativo no sistema!");
					} else {
						ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
						ec.redirect("/jloja/index.xhtml");
					}
				}
			}catch (Exception ex) {
				MsgUtil.msgErro("Erro ao Autenticar usuário!");
			}
		}
				
		public void editarUsuario(FabricanteEntity fab){
			try{
				
				usuarioEntity.setFabricante_idfabricante(fab);
				UsuarioDAO usuDAO = new UsuarioDAO();
				usuDAO.editar(usuarioEntity);
				usuarioEntity = new UsuarioEntity();
				
				MsgUtil.msgInfo("Produto editado com Sucesso!");
			}catch (Exception ex){
				MsgUtil.msgErro("Erro ao tentar editar um produto: " + ex.getMessage());
			}
		}
		public void excluirUsuario() {
			try {
				UsuarioDAO usudao = new UsuarioDAO();
				usudao.excluir(usuarioEntity);
				usuarioEntity = new UsuarioEntity();
				MsgUtil.msgInfo("Usuário excluido com Sucesso!");
			}catch (Exception ex){
				MsgUtil.msgErro("Erro ao tentar excluir usuário: " + ex.getMessage());
			}
		}
		public void sair() {
			try {
				usuarioLogado = null;
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect("/jloja/view/login.xhtml!");
			} catch (IOException e) {
				MsgUtil.msgErro("Erro ao sair do sistema!");
			}
		}
}
