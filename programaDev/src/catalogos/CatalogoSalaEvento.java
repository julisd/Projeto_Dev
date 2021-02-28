package catalogos;
import java.io.Serializable;
import java.util.ArrayList;

import parte_logica.SalaEvento;

public class CatalogoSalaEvento implements Serializable {

	private ArrayList<SalaEvento> listaSalas = new ArrayList<SalaEvento>();

	public void adicionarSala(SalaEvento salasEvento) {
		listaSalas.add(salasEvento);
	}

	public ArrayList<SalaEvento> obterLista() {
		return listaSalas;
	}

}
