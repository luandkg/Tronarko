package AssetContainer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Pasta {

	private Ponto mPonto;
	private AssetContainer mAssetContainer;
	private boolean mAberto;
	private ArrayList<Arquivo> mArquivos;
	private ArrayList<Pasta> mPastas;

	public Pasta(AssetContainer eAssetContainer, Ponto ePonto) {

		mAssetContainer = eAssetContainer;
		mPonto = ePonto;
		mAberto = false;
		mArquivos = new ArrayList<Arquivo>();
		mPastas = new ArrayList<Pasta>();
		
	}

	public String getNome() {
		return mPonto.getNome();
	}

	public long getTipo() {
		return mPonto.getTipo();
	}

	public long getInicio() {
		return mPonto.getInicio();
	}

	public long getFim() {
		return mPonto.getFim();
	}

	private void abrir() {

		mPastas.clear();
		mArquivos.clear();

		try {

			RandomAccessFile raf = new RandomAccessFile(new File(mAssetContainer.getArquivo()), "rw");

			FileUtils fu = new FileUtils(raf);

			fu.setPonteiro(getInicio());

			int v = 0;

			while (v != 13) {
				v = (int) fu.readByte();

				if (v == 11) {

					String s1 = fu.readString();
					long l2 = fu.readLong();
					long l3 = fu.readLong();

					mPastas.add(new Pasta(mAssetContainer, new Ponto(s1, 11, l2, l3)));

				} else if (v == 12) {

					String s1 = fu.readString();
					long l2 = fu.readLong();
					long l3 = fu.readLong();

					mArquivos.add(new Arquivo(mAssetContainer, new Ponto(s1, 12, l2, l3)));

				}
			}

			raf.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Arquivo> getArquivos() {

		if (!mAberto) {
			abrir();
		}

		return mArquivos;

	}

	public ArrayList<Pasta> getPastas() {

		if (!mAberto) {
			abrir();
		}

		return mPastas;

	}

	
	public boolean existePasta(String eNome) {
		
		boolean ret = false;
		
		for (Pasta mPasta : getPastas()) {
			if (mPasta.getNome().contentEquals(eNome)) {
				ret=true;
				break;
			}
		}
		return ret;
	}
	
	public boolean existeArquivo(String eNome) {
		
		boolean ret = false;
		
		for (Arquivo mArquivo : getArquivos()) {
			if (mArquivo.getNome().contentEquals(eNome)) {
				ret=true;
				break;
			}
		}
		return ret;
	}
	
	
	public Pasta getPasta(String eNome) {
		
		Pasta ret = null;
		
		for (Pasta mPasta : getPastas()) {
			if (mPasta.getNome().contentEquals(eNome)) {
				ret=mPasta;
				break;
			}
		}
		return ret;
	}
	
	public Arquivo getArquivo(String eNome) {
		
		Arquivo ret = null;
		
		for (Arquivo mArquivo : getArquivos()) {
			if (mArquivo.getNome().contentEquals(eNome)) {
				ret=mArquivo;
				break;
			}
		}
		return ret;
	}
}
