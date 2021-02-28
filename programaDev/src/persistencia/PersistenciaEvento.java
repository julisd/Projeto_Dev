package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import catalogos.CatalogoPessoa;
import catalogos.CatalogoSalaCafe;
import catalogos.CatalogoSalaEvento;

import catalogos.Evento;

public class PersistenciaEvento {

	// Catalogo que sera armezenado em disco
	private Evento evento;
	private String nomeArquivo = "catalogo.ser";

	public Evento carregar() {

		evento = null;
		try {
			FileInputStream fileIn = new FileInputStream(nomeArquivo);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			evento = (Evento) in.readObject();
			
			System.out.println("Catálogo existente carregado!");
			in.close();
			fileIn.close();
		} catch (IOException i) {
			System.out.println("Catálogo nao encontrado, vamos criar");
		} catch (ClassNotFoundException c) {
			System.out.println("Classe Catálogo não encontrada!");
			c.printStackTrace();
			// return null;
		}

		if (evento == null) {
			evento = new Evento();
		}

		return evento;

	}

	public void salvarCatalogo() {
		try {
			FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(evento);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
