package TronarkoMain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import AssetContainer.AssetContainer;
import Astral.A7;
import Astral.Astral;
import OmegaEngine.Windows;
import OmegaEngine.Cenarios.Cena;
import OmegaEngine.UI.BotaoCor;
import OmegaEngine.UI.Clicavel;
import OmegaEngine.Utils.Escritor;
import OmegaEngine.Utils.Imaginador;
import OmegaEngine.Utils.Local;
import OmegaEngine.Utils.Recurso;
import Tronarko.TozteCor;
import Tronarko.Tronarko;
import Tronarko.Tronarko.Hazde;
import Tronarko.Tronarko.Tozte;
import Tronarko.Eventos.Eventum;
import Tronarko.Harrempluz.Harrempluz;
import Tronarko.Harrempluz.Harrempluz.Harrem;
import Tronarko.Harrempluz.Harrempluz.HarremItem;
import Tronarko.Harrempluz.Harrempluz.HarremMegarko;
import Tronarko.Satelites.MapaCelestial;

public class HarrempluzCena extends Cena {

	private Windows mWindows;

	private Escritor TextoGrande;
	private Escritor TextoPequeno;


	private Tronarko TronarkoC;

	private int mTronarko;
	private int mMega;
	private Tozte Hoje;

	private Harrem mSignos;
	private HarremMegarko mSignosMegarko;
	private A7 mA7 ;
	
	public HarrempluzCena(Windows eWindows) {
		mWindows = eWindows;

		TextoGrande = new Escritor(30, Color.BLACK);
		TextoPequeno = new Escritor(15, Color.BLACK);


		TronarkoC = new Tronarko();

		mTronarko = -1;
		mMega = -1;
		
		
		String mArquivoHarrempluz = "harrempluz.dkgax";
		mA7 = new A7(mArquivoHarrempluz);
	
		
	}

	@Override
	public void iniciar() {
		mWindows.setTitle("Harrempluz");
	}

	@Override
	public void update(double dt) {

		Hoje = TronarkoC.getTozte();
		
	//	Hoje = Hoje.adicionar_Tronarko(6);

		
		if (mTronarko != Hoje.getTronarko()) {
			mTronarko = Hoje.getTronarko();
			
			mSignos = mA7.getHarrem( mTronarko);
		}

		if (mMega != Hoje.getMegarkoDoTronarko()) {
			mMega = Hoje.getMegarkoDoTronarko();
			mSignosMegarko = mSignos.HarremMegarko(Hoje.getMegarkoDoTronarko());
		}

	}

	@Override
	public void draw(Graphics g) {

		mWindows.Limpar(g);

		int CAIXA_X = 40;
		int CAIXA_Y = 100;

		int CAIXA_ALTURA = 300;

		draw_signo(g, 1, 1, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
		draw_signo(g, 2, 2, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);

		CAIXA_X = 400;

		draw_signo(g, 3, 0, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
		draw_signo(g, 4, 1, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
		draw_signo(g, 5, 2, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);

		CAIXA_X = 700;
		draw_signo(g, 6, 0, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
		draw_signo(g, 7, 1, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
		draw_signo(g, 8, 2, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);

		CAIXA_X = 1000;
		draw_signo(g, 9, 0, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
		draw_signo(g, 10, 1, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);

		TextoGrande.EscreveNegrito(g, "Tronarko : " + Hoje.getTronarko(), 50, CAIXA_Y);
		TextoGrande.EscreveNegrito(g, "    Mega : " + Hoje.getMegarkoDoTronarko(), 50, CAIXA_Y + 50);

	}

	public void draw_signo(Graphics g, int mHiperarko, int Faixador, int CAIXA_X, int CAIXA_Y, int CAIXA_ALTURA) {

		int i = mHiperarko - 1;
		String eSigno = Tronarko.Signos.get(i + 1).toString();
		String eTitulo = String.valueOf(i + 1) + " - " + eSigno;

		TextoGrande.EscreveNegrito(g, eTitulo, CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);

		int s = 0;

		for (HarremItem item : mSignosMegarko.Signo(eSigno).getHarremItems()) {

			String eMega = item.getNome() + " = " + item.getValor();

			int parteX = (CAIXA_X - 10);
			int parteY = (((CAIXA_ALTURA * Faixador) + 30) + CAIXA_Y) + (s * 20);

			TextoPequeno.EscreveNegrito(g, eMega, parteX, parteY);
			s += 1;
		}

	}

}
