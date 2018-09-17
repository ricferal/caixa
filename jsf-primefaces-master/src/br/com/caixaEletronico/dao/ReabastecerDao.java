package br.com.caixaEletronico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caixaEletronico.modelo.Cedula;

public class ReabastecerDao {

	public Cedula existe(Cedula cedula) {
		Cedula resultado = null;
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Cedula> query = em.createQuery(" select c from Cedula c " + " where c.valor = :valor", Cedula.class);

		query.setParameter("valor", cedula.getValor());

		try {
			resultado = query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}

		em.close();

		return resultado;
	}

	public List<Cedula> obterCedulas() {

		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Query q = session.createQuery("select c from Cedula c");
		/// q.setParameter("id", id);
		List<Cedula> list = (List<Cedula>) q.list();

		return list;

	}

		public void atualizarCedula(Cedula cedula,int quantidade){
			
		
		 AnnotationConfiguration configuration = new AnnotationConfiguration();
	     configuration.configure();
	     
	     SessionFactory factory = configuration.buildSessionFactory();
	     Session session = factory.openSession();
	     
	     // carrega o produto do banco de dados
	     Cedula cedulaUpdate = (Cedula) session.load(Cedula.class, cedula.getId());
	     
	     Transaction tx = session.beginTransaction();
	     cedulaUpdate.setQuantidade(quantidade);
	     session.update(cedulaUpdate);
	     tx.commit();
	   }
}
