package parte_logica;

import java.io.Serializable;
import java.util.LinkedList;

public class SalaCafe  implements Serializable{
	

	private String nomeId;
	
	public SalaCafe (String nomeId){
		this.nomeId = nomeId;
	}
	
	public String getNomeDaSalaCafe() {
		return nomeId;
	}
}




