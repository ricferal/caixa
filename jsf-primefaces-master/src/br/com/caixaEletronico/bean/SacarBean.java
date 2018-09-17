package br.com.caixaEletronico.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import br.com.caixaEletronico.dao.CedulaDao;
import br.com.caixaEletronico.dao.ReabastecerDao;
import br.com.caixaEletronico.dao.SacarDao;
import br.com.caixaEletronico.modelo.Cedula;



@ManagedBean
@ViewScoped
public class SacarBean {
	
	private Cedula cedula = new Cedula();
	private List<SelectItem> list;
	private String selectedItem;
    private List<String> listas = null;
	
	
	public void sacar(){
		
	}
	

	//@PostConstruct
	public void carregaroOpcoesCedulas() {
		
		int valor =  this.cedula.getValor();
		list = new ArrayList<SelectItem>();
		
		if(valor != 0 ){
			
			listas = new CedulaDao().algoritmoMostrarOpcoesCedulas(valor);
		}
	
		for (String lista : listas) {
			list.add(new SelectItem(lista));

		}

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
