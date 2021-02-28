package parte_logica;

import java.io.Serializable;
import java.util.LinkedList;

public class SalaEvento  implements Serializable{
	

	private String nomeIdEvento;
	private LinkedList<Pessoas> pessoas = new LinkedList<Pessoas>();

	
	public SalaEvento (String nomeIdEvento){
		this.nomeIdEvento = nomeIdEvento;
		}
	
	public String getNomeDaSalaEvento() {
		return nomeIdEvento;
	}

	public void removerPessoa(Pessoas pessoas2) {
		
	}

	public void adicionarPessoa(Pessoas pessoas2) {
			
	}

}
