package br.com.jloja.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.util.HibernateUtil;

@SuppressWarnings({ "deprecation", "unused" })
public class FabricanteDAO {
	
	public void adicionar(FabricanteEntity Fabricante){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(Fabricante);
			transacao.commit();
		} catch(Exception ex){
			if(transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
	
	public void editar(FabricanteEntity Fabricante){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(Fabricante);
			transacao.commit();
		} catch(Exception ex){
			if(transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void excluir(FabricanteEntity fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(fabricante);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao !=null ) {
				transacao.rollback();
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public FabricanteEntity buscarPorCodigo(long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		FabricanteEntity fabricante = null;
	try {
		Query consulta = sessao.getNamedQuery("FabricanteEntity.buscarPorCodigo");
		consulta.setLong("codigo", codigo);
		fabricante = (FabricanteEntity) consulta.getSingleResult();
	} catch (RuntimeException ex) {
		throw ex;
		
	} finally {
		sessao.close();
	}
	return fabricante;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FabricanteEntity> listar() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<FabricanteEntity> fabricantes = null;
		
		try {
			Query consulta = sessao.getNamedQuery("FabricanteEntity.listar");
			fabricantes = consulta.list();

		} catch (RuntimeException ex) {
			
			throw ex;
		
		} finally {
			
			sessao.close();
			
		}
		
		return fabricantes;
	}
}
