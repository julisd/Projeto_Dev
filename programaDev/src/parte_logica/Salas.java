package parte_logica;

	import java.io.Serializable;
	import java.util.LinkedList;
	import parte_logica.Pessoas;
	 

	public abstract class Salas implements Serializable {
		
		protected abstract void setNome(LinkedList<Pessoas> linkedList);


		private String nome;
		private LinkedList<Pessoas> pessoas = new LinkedList<Pessoas>();

		// construtores
		public Salas() {
			this.setNome(new LinkedList<Pessoas>());
		}

		public Salas(String nome) {
			this.setNome(nome);
			this.setNome(new LinkedList<Pessoas>());
		}

		// métodos


		public String toString() {
			return this.getNome();
		}

		

		// getters & setters
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			if (nome == null) {
				System.out.println("O nome não pode ser nulo.");
			}
			if (nome.isBlank()) {
				System.out.println("O nome não foi preenchido corretamente.");
			}
			this.nome = nome;
		}

		public LinkedList<Pessoas> getPessoas() {
			return pessoas;
		}

		public void setPessoas(LinkedList<Pessoas> pessoas) {
			if (pessoas == null) {
				System.out.println("O nome não pode ser nulo.");
			}
			this.pessoas = pessoas;
		}
	}


