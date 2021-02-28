package catalogos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import parte_logica.Pessoas;

public class CatalogoPessoa implements Serializable {

	private ArrayList<Pessoas> listaNomes = new ArrayList<Pessoas>();
	private ArrayList<Pessoas> listaPessoasSalas = new ArrayList<Pessoas>();
	private ArrayList<Pessoas> listaPessoasSalaCafe = new ArrayList<Pessoas>();


	private String nomeIdEvento;
	private String nome;
	private String pessoas;
	private String pessoasSala;
	private String pessoasSalaCafe;
	private LinkedList<Pessoas> pessoasSalas = new LinkedList<Pessoas>();

		
		public void adicionarPessoa(Pessoas nome){
			listaNomes.add(nome);
		}
		
		public ArrayList<Pessoas> obterLista(){
			return listaNomes;
		}
		public void adicionarPessoaSalas(Pessoas pessoasSala){
			listaPessoasSalas.add(pessoasSala);
		}
		
		public ArrayList<Pessoas> obterListaPessoasSalas(){
			return listaPessoasSalas;
		}
		
		public String getNomeDaSalaEvento() {
			return nomeIdEvento;
		}

		public String getPessoas() {
			return pessoas;
		}
		
		public String getNome() {
			return nome;
		}

		public void adicionarPessoaSalasCafe(Pessoas pessoaCafe) {
			listaPessoasSalaCafe.add(pessoaCafe);
			
		}
		public ArrayList<Pessoas> obterListaPessoasSalaCafe(){
			return listaPessoasSalaCafe;
		}
		
		


}
