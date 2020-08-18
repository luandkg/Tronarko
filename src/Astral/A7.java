package Astral;

import Tronarko.Harrempluz.Harrempluz.Harrem;
import Tronarko.Harrempluz.Harrempluz.HarremMegarko;
import Tronarko.Harrempluz.Harrempluz.HarremSigno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import AssetContainer.ArquivoTexto;
import AssetContainer.AssetContainer;
import Empacotador.Empacotador;
import Empacotador.Identificador;
import Empacotador.Pacote;

public class A7 {

	private AssetContainer mAssetContainer ;

	public A7(String mArquivoHarrempluz) {
		
		mAssetContainer = new AssetContainer();
		mAssetContainer.abrir(mArquivoHarrempluz);
		
		//mAssetContainer.listarTabelaDeArquivos();
		
	}

	public  Harrem getHarrem(int eTronarko) {

		int mEspaco = Astral.getEspaco(eTronarko);
		int mSubEspaco = Astral.getSubEspaco(eTronarko);
		
		String Espaco=	"E" + mEspaco ;
		String SubEspaco =  "S" + mSubEspaco;	
		String Arquivo =  "Harrempluz_" + eTronarko + ".tronarko";

		System.out.println("Carregando Harrempluz :: " + eTronarko + " -->> " + mEspaco + " :: " + mSubEspaco + " :: " + Arquivo);

		
		ArquivoTexto at = new ArquivoTexto( mAssetContainer.getPasta(Espaco).getPasta(SubEspaco).getArquivo(Arquivo));
		
		String eConteudo =at.getConteudo();
		
		Empacotador Empacotar = new Empacotador();

		Empacotar.Parser(eConteudo);
		
		Pacote PHarrem = Empacotar.UnicoPacote("Harrempluz");


		int Tronarko = Integer.parseInt(PHarrem.Identifique("Tronarko").getValor());

		Harrem eHarrem = new Harrem(Tronarko);

		for (Pacote PacoteMegarko : PHarrem.getPacotes()) {

			int Megarko = Integer.parseInt(PacoteMegarko.Identifique("Megarko").getValor());

			HarremMegarko HarremMegarkoC = eHarrem.HarremMegarko(Megarko);

			for (Pacote PacoteSigno : PacoteMegarko.getPacotes()) {

				String SignoNome = PacoteSigno.getNome();

				HarremSigno HarremSignoC = HarremMegarkoC.Signo(SignoNome);

				for (Identificador IDC : PacoteSigno.getIdentificadores()) {

					HarremSignoC.HarremItem(IDC.getNome(), IDC.getValor());
				}

			}

		}
		return eHarrem;
	}
	

    public static String getData() {

        Calendar c = Calendar.getInstance();

        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH) + 1;
        int ano = c.get(Calendar.YEAR);

        int hora = c.get(Calendar.HOUR);
        int minutos = c.get(Calendar.MINUTE);
        int segundos = c.get(Calendar.SECOND);

        return dia + "/" + mes + "/" + ano + " " + hora + ":" + minutos + ":" + segundos;

    }
}
