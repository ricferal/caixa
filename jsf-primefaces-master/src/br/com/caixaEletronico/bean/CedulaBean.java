package br.com.caixaEletronico.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.caixaEletronico.dao.CedulaDao;
import br.com.caixaEletronico.dao.DAO;
import br.com.caixaEletronico.dao.UsuarioDao;
import br.com.caixaEletronico.modelo.Cedula;

@ManagedBean
//(name = "cedulaBean")
@ViewScoped
public class CedulaBean {

	private Cedula cedula = new Cedula();

	private Integer cedulaId;


	public void carregarCedulaPelaId() {
		this.cedula = new DAO<Cedula>(Cedula.class).buscaPorId(cedulaId);
	}

	public String gravar() {

//		 cedula = new Cedula();
		
		boolean existe = new CedulaDao().existe(this.cedula);
		
		System.out.println("Gravando CEDULA " + this.cedula.getValor());

		if (this.cedula.getId() == null &&  this.cedula.getValor() != 0 && !existe) {
			new DAO<Cedula>(Cedula.class).adiciona(this.cedula);
		} 
		//else {
		//	new DAO<Cedula>(Cedula.class).atualiza(this.cedula);
		//}

		this.cedula = new Cedula();

		return "home?faces-redirect=true";
	}

	public Cedula getCedula() {
		return cedula;
	}

	public void setCedula(Cedula cedula) {
		this.cedula = cedula;
	}

	public Integer getCedulaId() {
		return cedulaId;
	}

	public void setCedulaId(Integer cedulaId) {
		this.cedulaId = cedulaId;
	}

}
