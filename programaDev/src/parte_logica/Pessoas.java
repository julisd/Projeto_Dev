package parte_logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Pessoas implements Serializable{

	// atributos
		private String nome;
		private String sobrenome;
		private ArrayList<SalaEvento> salas_Eventos;
		private LinkedList<Pessoas> pessoas = new LinkedList<Pessoas>();


	
		public Pessoas (String nome, String sobrenome) {
			this.nome = nome;
			this.sobrenome = sobrenome;
		}

		// m�todos
	

		
		
		public String getNomeCompleto() {
			return this.getNome() + " " + this.getSobrenome();
		}

		// getters & setters
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			if (nome == null) {
				System.out.println("O nome n�o pode ser nulo.");
			}
			if (nome.isBlank()) {
				System.out.println("O nome n�o foi preenchido corretamente.");
			}
			this.nome = nome;
		}

		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			if (sobrenome == null) {
				System.out.println("O sobrenome n�o pode ser nulo.");
			}
			if (sobrenome.isBlank()) {
				System.out.println("O sobrenome n�o foi preenchido corretamente.");
			}
			this.sobrenome = sobrenome;
		}

		public LinkedList<Pessoas> getPessoas() {
			return pessoas;
		}
		
		// teste

		public void addSala(Pessoas sala) {
			if (sala == null) {
				System.out.println("A sala a ser adicionada n�o pode ser nula.");
			}

			if (this.getPessoas().contains(sala)) {
				System.out.println("A sala j� foi adicionada.");
			}

			this.getPessoas().add(sala);
		}

		// remove a pessoa de uma sala
		public void removerSala(SalaCafe sala) {
			if (sala == null) {
				System.out.println("A sala a ser removida n�o pode ser nula.");
			}

			if (!this.getPessoas().contains(sala)) {
				System.out.println("A sala n�o foi encontrada.");
			}

			this.getPessoas().remove(sala);
		}

		

		

	}

