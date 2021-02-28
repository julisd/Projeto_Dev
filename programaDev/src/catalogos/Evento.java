package catalogos;

import java.io.Serializable;

import parte_logica.SalaCafe;
import parte_logica.SalaEvento;
import parte_logica.Pessoas;


public class Evento implements Serializable {

	private CatalogoPessoa catalogoPessoas;
	private CatalogoSalaEvento catalogoSalaEvento;
	private CatalogoSalaCafe catalogoSalaCafe;

	
	
	public Evento(){
		this.catalogoPessoas = new CatalogoPessoa();
		this.catalogoSalaEvento = new CatalogoSalaEvento();
		this.catalogoSalaCafe = new CatalogoSalaCafe();
		
	}

	public CatalogoPessoa getCatalogoPessoas() {
		return catalogoPessoas;
	}

	public CatalogoSalaEvento getCatalogoSalaEvento() {
		return catalogoSalaEvento;
	}
	
	public CatalogoSalaCafe getCatalogoSalaCafe () {
		return catalogoSalaCafe;
	}
	
}
