package br.com.jloja.main;

import br.com.jloja.util.HibernateUtil;

public class MainBanco {

	public static void main(String[] args) {
		try{
			HibernateUtil.getSessionFactory();
			HibernateUtil.getSessionFactory().close();
			System.out.println("Conexão realizada com sucesso!!!");
		}catch(RuntimeException ex) {
			throw ex;
		}
		
	}
	
}
