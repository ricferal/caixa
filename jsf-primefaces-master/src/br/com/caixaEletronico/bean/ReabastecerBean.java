package br.com.caixaEletronico.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import br.com.caixaEletronico.dao.CedulaDao;
import br.com.caixaEletronico.dao.DAO;
import br.com.caixaEletronico.dao.ReabastecerDao;
import br.com.caixaEletronico.modelo.Cedula;

@ManagedBean
@ViewScoped
public class ReabastecerBean {
	private Cedula cedula = new Cedula();
	private List<SelectItem> list;
	private String selectedItem;


	@PostConstruct
	public void carregarCedulas() {
		list = new ArrayList<SelectItem>();
		@SuppressWarnings("unchecked")
		List<Cedula> cedulas = (List<Cedula>) new ReabastecerDao().obterCedulas();
		for (Cedula cedula : cedulas) {
			list.add(new SelectItem(cedula.getValor()));

		}

	}

	public String reabastecer() {

		Cedula cedula = new ReabastecerDao().existe(this.cedula);
		int quantidade =  this.cedula.getQuantidade();
		
		//System.out.println("Gravando Quantidade " + this.cedula.getQuantidade());

		if (cedula != null && quantidade != 0) {
			new ReabastecerDao().atualizarCedula(cedula,quantidade);
			
		}

		this.cedula = new Cedula();

		return "home?faces-redirect=true";
	}

	public Cedula getCedula() {
		return cedula;
	}

	public void setCedula(Cedula cedula) {
		this.cedula = cedula;
	}

	public List<SelectItem> getList() {
		return list;
	}

	public void setList(List<SelectItem> list) {
		this.list = list;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	

}
