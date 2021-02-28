package parte_interface;

import java.lang.invoke.SwitchPoint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


import catalogos.CatalogoPessoa;
import catalogos.CatalogoSalaEvento;
import catalogos.CatalogoSalaCafe;
import catalogos.Evento;
import parte_logica.Pessoas;
import parte_logica.SalaEvento;
import parte_logica.Salas;
import parte_logica.SalaCafe;

import persistencia.PersistenciaEvento;



public class Menu {

	private Scanner teclado = new Scanner(System.in);
	PersistenciaEvento persistencia = new PersistenciaEvento();
	CatalogoPessoa catalogoPessoa;
	CatalogoSalaEvento catalogoSalaEvento;
	CatalogoSalaCafe catalogoSalaCafe;
	SalaEvento salaEvento;
	Evento evento;

	public void mostrar() {

		evento = persistencia.carregar();
		catalogoPessoa = evento.getCatalogoPessoas();
		catalogoSalaEvento = evento.getCatalogoSalaEvento();
		catalogoSalaCafe = evento.getCatalogoSalaCafe();

		persistencia.salvarCatalogo();

		boolean continuar = true;
		while (continuar) {

			System.out.println();
			System.out.println("Evento:");
			System.out.println();
			System.out.println("1 - Cadastrar/remover salas do Evento");
			System.out.println("2 - Cadastrar/remover salas do Café");
			System.out.println("3 - Cadastrar/remover Pessoas");
			System.out.println("4 - Consultas");
			System.out.println("0 - Sair");
			System.out.println();
			System.out.println(">> Escolha uma das opções:");
			int opcao = teclado.nextInt();

			switch (opcao) {

			case 1:
				menuSalaEvento();
				break;

			case 2:
				menuSalaCafe();
				break;

			case 3:
				menuPessoas();
				break;
			case 4:
				menuConsultas();
				break;
			
			case 0:
				continuar = false;
				System.out.println("Obrigada e volte sempre!");
				break;

			default:
				System.out.println("Opção inválida!");
			}
		}
	}

	private void menuPessoas() {

		System.out.println("1 - Cadastrar Pessoa");
		System.out.println("2 - Remover Pessoa");
		System.out.println("Escolha uma das opções:");
		int opcao = teclado.nextInt();
		teclado.nextLine();

		switch (opcao) {

		case 1:
			cadastrarPessoa();
			persistencia.salvarCatalogo();
			break;

		case 2:
			removerPessoa();
			persistencia.salvarCatalogo();
			break;

		default:
			System.out.println("Opção inválida!");
		}
	}
	
	
	private void cadastrarPessoa() {



		System.out.println("Nome Completo:");
		String nomeCompleto = teclado.nextLine();
		
	

		
		ArrayList<SalaEvento> listaSalas = catalogoSalaEvento.obterLista();
		for (int i = 0; i < listaSalas.size(); i++) {
			System.out.println("Nome da sala de Evento: " + listaSalas.get(i).getNomeDaSalaEvento());
			
		}

		if (listaSalas.size() > 0) {
	
		
		System.out.print("Digite o nome da Sala de Evento que deseja se alocar:");
		String salaAlocada = teclado.nextLine();		
		
		
		
		Pessoas novoCadastro = new Pessoas(nomeCompleto, salaAlocada);
		String nome = novoCadastro.getNome();
		System.out.println(nome);
		
		catalogoPessoa.adicionarPessoa(novoCadastro);
		
		
		
		
		LinkedList<Pessoas> locada = novoCadastro.getPessoas();
		System.out.println(salaAlocada);
		
		catalogoPessoa.adicionarPessoaSalas(novoCadastro);

		}else {
			System.out.print("Necessário cadastrar uma sala antes");

		}

		ArrayList<SalaCafe> listaEspaco = catalogoSalaCafe.obterLista();
		for (int x = 0; x < listaEspaco.size(); x++) {
			System.out.println("Nome da sala de Café: " + listaEspaco.get(x).getNomeDaSalaCafe());

		if (listaEspaco.size() > 0) {
			
			
			System.out.print("Digite o nome da Sala de Café que deseja se alocar:");
			String salaCafe = teclado.nextLine();		
			
			
			
			Pessoas novoCadastro = new Pessoas(nomeCompleto, salaCafe);
			String nome = novoCadastro.getNome();
			System.out.println(nome);
			
			catalogoPessoa.adicionarPessoa(novoCadastro);
			
			
			LinkedList<Pessoas> locada = novoCadastro.getPessoas();
			System.out.println(salaCafe);
			
			catalogoPessoa.adicionarPessoaSalasCafe(novoCadastro);

			}else {
				System.out.print("Necessário cadastrar uma sala antes");

			}
		}

		

	}
	
	private void removerPessoa() {
		ArrayList<Pessoas> listaNomes = catalogoPessoa.obterLista();
		for (int i = 0; i < listaNomes.size(); i++) {
			System.out.println(i + " - " + listaNomes.get(i).getNome());
		}
		if (listaNomes.size() > 0) {
			System.out.println("Digite o nome para exclusão:");
			String nomeExcluir = teclado.nextLine();
			for (int i = 0; i < listaNomes.size(); i++) {
				if (listaNomes.get(i).getNome().equalsIgnoreCase(nomeExcluir)) {
					listaNomes.remove(listaNomes.get(i));
					System.out.println("Nome excluido com sucesso!");
				}
			}
		} else {
			System.out.println("Não há nomes cadastrados!");
		}
	}
	
	private void menuConsultas() {

		System.out.println("1 - Consultar Sala de Eventos");
		System.out.println("2 - Consultar Sala de Café");
		System.out.println("Escolha uma das opções:");
		int opcao = teclado.nextInt();
		teclado.nextLine();

		switch (opcao) {

		case 1:
			consultarSalaDeEvento();
			persistencia.salvarCatalogo();
			break;

		case 2:
			consultarSalaDeCafe();
			persistencia.salvarCatalogo();
			break;

		default:
			System.out.println("Opção inválida!");
		}
	}

	
	private void consultarSalaDeEvento() {
		System.out.print("Pessoas Cadastradas e suas respectivas salas iniciais: \n");

		
		ArrayList<Pessoas> listaPessoasSalas = catalogoPessoa.obterListaPessoasSalas();
		for (int i = 0; i < listaPessoasSalas.size(); i++) {
			System.out.println(i + " - " + "Nome:" + listaPessoasSalas.get(i).getNomeCompleto()+ "- Respectiva Sala de Evento alocada");
		}
	}
		
		private void consultarSalaDeCafe() {
		
		ArrayList<Pessoas> listaPessoasSalaCafe = catalogoPessoa.obterListaPessoasSalaCafe();
		for (int i = 0; i < listaPessoasSalaCafe.size(); i++) {
			System.out.println(i + " - " + "Nome:" + listaPessoasSalaCafe.get(i).getNomeCompleto() + "- Respectiva Sala de Café alocada");
		}

	}
	
	

	private void menuSalaEvento() {

		System.out.println("1 - Cadastrar sala do evento e lotação");
		System.out.println("2 - Remover sala do Evento");
		System.out.println("Escolha uma das opções:");
		int opcao = teclado.nextInt();
		teclado.nextLine();

		switch (opcao) {

		case 1:
			cadastrarSalaEvento();
			persistencia.salvarCatalogo();
			break;

		case 2:
			removerSalaEvento();
			persistencia.salvarCatalogo();
			break;

		default:
			System.out.println("Opção inválida!");
			persistencia.salvarCatalogo();
		}
	}

	private void cadastrarSalaEvento() {
		System.out.println("1 - Nome da sala:");
		String nomeEvento = teclado.nextLine();
		
		System.out.println("Lotação da sala:");
		int lotacaoEvento = teclado.nextInt();
		teclado.nextLine();

		SalaEvento novaSalaEvento = new SalaEvento (nomeEvento);

		catalogoSalaEvento.adicionarSala(novaSalaEvento);
	}
	


	private void removerSalaEvento() {

		ArrayList<SalaEvento> listaSalas = catalogoSalaEvento.obterLista();
		for (int i = 0; i < listaSalas.size(); i++) {
			System.out.println("Nome da sala ocupada: " + listaSalas.get(i).getNomeDaSalaEvento());
		}
		if (listaSalas.size() > 0) {
			System.out.println("Digite o nome da sala para a exclusão:");
			String salaEventoExcluir = teclado.nextLine();
			
			for (int i = 0; i < listaSalas.size(); i++) {
				if (listaSalas.get(i).getNomeDaSalaEvento().equalsIgnoreCase(salaEventoExcluir)) {
					listaSalas.remove(listaSalas.get(i));
					System.out.println("Sala Evento excluido com sucesso!");
			
				}
			}
		} else {
			System.out.println("Não há salas cadastradas!");
		}
	}
	



	private void menuSalaCafe() {

		System.out.println("1 - Cadastrar Sala do Café e lotação");
		System.out.println("2 - Remover Sala do Café ");
		System.out.println("Escolha uma das opções:");
		int opcao = teclado.nextInt();
		teclado.nextLine();

		switch (opcao) {

		case 1:
			cadastrarSalaCafe();
			persistencia.salvarCatalogo();
			break;

		case 2:
			removerSalaCafe();
			persistencia.salvarCatalogo();
			break;

		default:
			System.out.println("Opção inválida!");
		}

	}

	private void cadastrarSalaCafe() {

		System.out.println("1 - Nome da sala:");
		String nomeCafe = teclado.nextLine();
		
		System.out.println("Lotação da sala:");
		int lotacao = teclado.nextInt();
		teclado.nextLine();

		SalaCafe novaSala = new SalaCafe (nomeCafe);

		catalogoSalaCafe.adicionarEspaco(novaSala);
	}


	private void removerSalaCafe() {

		ArrayList<SalaCafe> listaEspaco = catalogoSalaCafe.obterLista();
		for (int i = 0; i < listaEspaco.size(); i++) {
			System.out.println("Nome da sala ocupada: " + listaEspaco.get(i).getNomeDaSalaCafe());
		}
		if (listaEspaco.size() > 0) {
			System.out.println("Digite o nome da sala para a exclusão:");
			String salaExcluir = teclado.nextLine();
			
			for (int i = 0; i < listaEspaco.size(); i++) {
				if (listaEspaco.get(i).getNomeDaSalaCafe().equalsIgnoreCase(salaExcluir)) {
					listaEspaco.remove(listaEspaco.get(i));
					System.out.println("Sala Evento excluido com sucesso!");
			
				}
			}
		} else {
			System.out.println("Não há salas cadastradas!");
		}
	}
	
}
		