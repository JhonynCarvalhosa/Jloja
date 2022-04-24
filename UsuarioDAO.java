package br.com.jloja.DAO;

import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class UsuarioDAO {

	public void adicionar(UsuarioEntity usuario){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(usuario);
			transacao.commit();
		} catch(Exception ex){
			if (transacao != null){
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

public void editar(UsuarioEntity usuario){
	
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	
	try{
		transacao = sessao.beginTransaction();
		sessao.update(usuario);
		transacao.commit();
	} catch(Exception ex){
		if (transacao != null){
			transacao.rollback();
		}
	} finally {
		sessao.close();
	}
}


public void excluir(UsuarioEntity usuario){
	
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	Transaction transacao = null;
	
	try{
		transacao = sessao.beginTransaction();
		sessao.delete(usuario);
		transacao.commit();
	} catch(Exception ex){
		if (transacao != null){
			transacao.rollback();
		}
	} finally {
		sessao.close();
	}
}

@SuppressWarnings("rawtypes")
public UsuarioEntity buscarPorCodigo(Long codigo){
	
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	UsuarioEntity usuario = null;
	
	try {
		Query consulta = sessao.getNamedQuery("UsuarioEntity.buscarPorCodigo");
		consulta.setLong("codigo", codigo);
		usuario = (UsuarioEntity) consulta.uniqueResult();
	} catch (RuntimeException ex){
		throw ex;
		
	}finally {
		sessao.close();
	}
	return usuario;
	}

@SuppressWarnings("rawtypes")
public UsuarioEntity autenticar(String login, String senha){
	
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	UsuarioEntity usu = null;
	
	try {
		Query consulta = sessao.getNamedQuery("UsuarioEntity.login");
		consulta.setString("login", login);
		consulta.setString("senha", senha);
		usu = (UsuarioEntity) consulta.getSingleResult();
	} catch (RuntimeException ex){
		throw ex;
	} finally {
		sessao.close();
	}
	return usu;
}


@SuppressWarnings({ "unchecked", "rawtypes" })
public List<UsuarioEntity> listar(){
	
	Session sessao = HibernateUtil.getSessionFactory().openSession();
	List<UsuarioEntity> usuarios = null;
	
	try {
		Query consulta = sessao.getNamedQuery("UsuarioEntity.listar");
		usuarios = consulta.list();
		
	}catch (RuntimeException ex) {
		
		throw ex;
	}finally {
		sessao.close();
	}
	return usuarios;
}
	
	
}