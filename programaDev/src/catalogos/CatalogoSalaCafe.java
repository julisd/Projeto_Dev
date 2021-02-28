package catalogos;

import java.io.Serializable;
import java.util.ArrayList;

import parte_logica.SalaCafe;

public class CatalogoSalaCafe implements Serializable{

		private ArrayList<SalaCafe> listaEspaco = new ArrayList<SalaCafe>();

		public void adicionarEspaco(SalaCafe espacoCafe) {
			listaEspaco.add(espacoCafe);
		}

		public ArrayList<SalaCafe> obterLista() {
			return listaEspaco;
		}

		
	}


