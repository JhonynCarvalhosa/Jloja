package br.com.jloja.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.util.HibernateUtil;

public class ProdutoDAO {

		public void editar(ProdutoEntity produto) {
		
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try{
				transacao = sessao.beginTransaction();
				sessao.update(produto);
				transacao.commit();
			} catch(Exception ex){
				if(transacao != null) {
					transacao.rollback();
				}
			} finally {
				sessao.close();
			}
		}
		
		public void adicionar(ProdutoEntity produto) {
			
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try{
				transacao = sessao.beginTransaction();
				sessao.save(produto);
				transacao.commit();
			} catch(Exception ex){
				if(transacao != null) {
					transacao.rollback();
				}
			} finally {
				sessao.close();
			}
		}
		
		public void excluir(ProdutoEntity produto) {
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try {
				transacao = sessao.beginTransaction();
				sessao.delete(produto);
				transacao.commit();
			} catch (RuntimeException ex) {
				if (transacao !=null ) {
					transacao.rollback();
				}
			} finally {
				sessao.close();
			}
		}
		
		@SuppressWarnings({ "rawtypes", "deprecation" })
		public ProdutoEntity buscarPorCodigo(Long codigo) {
			
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			ProdutoEntity produto = null;
			
		try {
			
			Query consulta = sessao.getNamedQuery("ProdutoEntity.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			produto = (ProdutoEntity) consulta.uniqueResult();
		
		} catch (RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		return produto;
		}
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<ProdutoEntity> listar() {
			
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			List<ProdutoEntity> produtos = null;
			
			try {
				Query consulta = sessao.getNamedQuery("ProdutoEntity.listar");
				produtos = consulta.list();

			} catch (RuntimeException ex) {
				
				throw ex;
			
			} finally {
				
				sessao.close();
				
			}
			
			return produtos;
		}
}
	