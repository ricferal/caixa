package br.com.caixaEletronico.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caixaEletronico.dao.CedulaDao;
import br.com.caixaEletronico.dao.DAO;
import br.com.caixaEletronico.dao.UsuarioDao;
import br.com.caixaEletronico.modelo.Cedula;
import br.com.caixaEletronico.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	public String cadastro(){
		 return "cadastro?faces-redirect=true";
	}
	
	

	public String voltar(){
		 return "index?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		System.out.println("fazendo login do usuario " + this.usuario.getEmail());
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = new UsuarioDao().existe(this.usuario);
		if(existe ) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "Home?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado"));
		
		return "index?faces-redirect=true";
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "index?faces-redirect=true";
	}
	
	
	public String cadastrar(){
		
		
		  //  usuario   = new Usuario();
			
			boolean existe = new UsuarioDao().existe(this.usuario);
			
			System.out.println("Gravando CEDULA " + this.usuario.getEmail());

			if (this.usuario.getId() == null &&  !this.usuario.getEmail().isEmpty() && !existe) {
				new DAO<Usuario>(Usuario.class).adiciona(this.usuario);
			} 
			//else {
			//	new DAO<Cedula>(Cedula.class).atualiza(this.cedula);
			//}

			this.usuario = new Usuario();

			return "index?faces-redirect=true";
		
	}
}
