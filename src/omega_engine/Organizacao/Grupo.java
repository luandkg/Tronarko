package omega_engine.Organizacao;

import java.util.ArrayList;

import omega_engine.Componentes.Entidade;

public class Grupo {

	private String mNome;
	private ArrayList<Entidade> mEntidades;

	public Grupo(String eNome) {

		mNome = eNome;

		mEntidades = new ArrayList<Entidade>();

	}

	public String getNome() {
		return mNome;
	}

	public ArrayList<Entidade> getEntidades() {
		return mEntidades;
	}

	public void AdicionarEntidade(Entidade eEntidade) {
		mEntidades.add(eEntidade);
	}

}
