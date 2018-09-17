package br.com.caixaEletronico.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caixaEletronico.modelo.Cedula;

public class CedulaDao {
	

	public List<String> algoritmoMostrarOpcoesCedulas(int valor){
		int c10=0,c20=0,c50=0,c100=0,c1=0;
		int r10 = 0,r20=0,r50=0,r100=0,r1=0;
		
		List<String> listaCedulas = new ArrayList<String>();
		
		int quantia = valor;
		
		Cedula cedula100 = new Cedula();
		cedula100.setValor(100);
		Cedula cedula50 = new Cedula();
		cedula50.setValor(50);
		Cedula cedula10 = new Cedula();
		cedula10.setValor(10);
		Cedula cedula20 = new Cedula();
		cedula20.setValor(20);

		Cedula cedula1 = new Cedula();
		cedula1.setValor(1);
		
		if(existe(cedula100)) {
			 c100 = quantia / 100;
			 r100 = quantia % 100;
		}
		
	   
		if(existe(cedula50)) {
			 c50 = r100 / 50;
			 r50 = r100 % 50;
		}
		
		if(existe(cedula20)) {
			 c20 = r50 / 20;
			 r20 = r50 % 20;
		}
		
		
		if(existe(cedula10)) {
			 c10 = r20 / 10;
			 r10 = r20 % 10;
		}
	    
	    
		if(existe(cedula1)) {
			  c1 = r10 /1;
			  r1 = r10 % 1;
		}
	    
	    
		listaCedulas.add( "100:"+c100+" 50:"+c50+" 20:"+c20+" 10:"+c10+" 1:"+c1);
		
		return listaCedulas;
	
	}
	


	public boolean existe(Cedula cedula) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Cedula> query = em.createQuery(
				  " select c from Cedula c "
				+ " where c.valor = :valor", Cedula.class);
		
		query.setParameter("valor", cedula.getValor());

		try {
			Cedula resultado =  query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		em.close();
		
		return true;
	}

}
