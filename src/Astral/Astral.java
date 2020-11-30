package Astral;

import java.io.File;
import java.util.Calendar;

import Empacotador.Empacotador;
import Empacotador.Pacote;
import Tronarko.Harrempluz.Harrem;
import Tronarko.Harrempluz.Harrempluz;

public class Astral {

	public void criar(String eNome, String eLocal) {
		
		String mInicio = A7.getData();


		for (int t = 0; t < 10000; t++) {

			System.out.println(eNome + " " + t + " -->> " + getEspaco(t) + " :: " + getSubEspaco(t));

			 criar( "res//E" + getEspaco(t) + "//" + "S" + getSubEspaco(t) + "//", t);

		}

		String mFim = A7.getData();

		System.out.println("INICIO -->> " + mInicio);
		System.out.println("FIM -->> " + mFim);
		
	}
	
	public static int getEspaco(int nTronarko) {
		int mEspaco = 0;
		while(nTronarko>=1000) {		
			nTronarko=nTronarko-1000;	
			mEspaco+=1;
		}
		return mEspaco;
	}
	
	public static int getSubEspaco(int nTronarko) {
		int mEspaco = 0;
		while(nTronarko>=1000) {		
			nTronarko=nTronarko-1000;	
			mEspaco+=1;
		}
		
		int mSubEspaco = 0;
		while(nTronarko>=100) {		
			nTronarko=nTronarko-100;	
			mSubEspaco+=1;
		}
		
		return mSubEspaco;
	}
	
	public static void criar(String LocalPadrao,int eTronarko) {
		
		Harrempluz HarrempluzC = new Harrempluz();

		String Arquivo = LocalPadrao + "Harrempluz_" + eTronarko + ".tronarko";
		File AFile = new File(Arquivo);


		//	Harrem HarremSalvar = HarrempluzC.Criar_Harrempluz(eTronarko);
		//	Salvar(HarremSalvar, Arquivo);

	

		
	}
	
	public static void Salvar(Harrem eHarrem, String eArquivo) {

		Empacotador Empacotar = new Empacotador();

		Pacote PHarrem = Empacotar.UnicoPacote("Harrempluz");

		PHarrem.Identifique("Tronarko", eHarrem.getTronarko());
		PHarrem.Identifique("Criado", getData());

		//for (HarremMegarko HarremMegarkoC : eHarrem.getHarremMegarkos()) {

		//	Pacote PMega = PHarrem.CriarPacote("Megarko");

		//	PMega.Identifique("Megarko", HarremMegarkoC.getMegarko());
//
		//	for (HarremSigno HarremSignoC : HarremMegarkoC.getHarremSignos()) {

		//		Pacote PSigno = PMega.UnicoPacote(HarremSignoC.getSigno());
//
		//		for (HarremItem HarremItemC : HarremSignoC.getHarremItems()) {

			//		PSigno.Identifique(HarremItemC.getNome(), HarremItemC.getValor());
			//	}

			//}

		//}

	//	Empacotar.Salvar(eArquivo);

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


	public static String getGrupo(int t) {

		int g = 0;

		while (t > 999) {
			t -= 1000;
			g += 1;
		}

		return "GT" + g;
	}

	public static String getSubGrupo(int t) {
		String ret = "";

		int g = 0;
		int e = 0;

		while (t > 999) {
			t -= 1000;
			g += 1;
		}

		while (t > 100) {
			t -= 100;
			e += 1;
		}

		return gerarTT(e);
	}

	public static String getNome(int t) {
		return "Tronarko_" + gerarTronarko(t) + ".harrempluz";
	}

	public static String gerarTT(int t) {
		String e = String.valueOf(t);
		if (t < 10) {
			e = "0" + e;
		}
		return "TT" + e;
	}

	public static String gerarTronarko(int t) {
		String e = String.valueOf(t);

		if (t < 10) {
			e = "000" + e;
		} else if (t >= 10 && t < 100) {
			e = "00" + e;
		} else if (t >= 100 && t < 1000) {
			e = "0" + e;
		}

		return e;
	}



}
