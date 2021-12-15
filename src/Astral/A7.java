package Astral;

import Tronarko.Harrempluz.Harrem;
import Tronarko.Harrempluz.Harrempluz;

import java.util.Calendar;

import AssetContainer.ArquivoTexto;
import AssetContainer.AssetContainer;
import Empacotador.Empacotador;
import Empacotador.Identificador;
import Empacotador.Pacote;

public class A7 {

    private AssetContainer mAssetContainer;

    public A7(String mArquivoHarrempluz) {

        mAssetContainer = new AssetContainer();
        mAssetContainer.abrir(mArquivoHarrempluz);

        //mAssetContainer.listarTabelaDeArquivos();

    }

    public Harrempluz getHarrem(int eTronarko) {


        String mEspaco = Astral.getGrupo(eTronarko);
        String mSubEspaco = Astral.getSubGrupo(eTronarko);
        String Arquivo = Astral.getNome(eTronarko);

        System.out.println("Carregando Harrempluz :: " + eTronarko + " -->> " + mEspaco + " :: " + mSubEspaco + " :: " + Arquivo);


        ArquivoTexto at = new ArquivoTexto(mAssetContainer.getPasta("Harrempluz").getPasta(mEspaco).getPasta(mSubEspaco).getArquivo(Arquivo));

        String eConteudo = at.getConteudo();

       // System.out.println(eConteudo);

        Empacotador Empacotar = new Empacotador();

        Empacotar.Parser(eConteudo);

        Pacote PHarrem = Empacotar.UnicoPacote("Harrempluz");


        Harrempluz eHarrempluz = new Harrempluz();

        for (Pacote PacoteMegarko : PHarrem.getPacotes()) {

            int eHiperarko = Integer.parseInt(PacoteMegarko.Identifique("Hiperarko").getValor());
            int eMegarko = Integer.parseInt(PacoteMegarko.Identifique("Megarko").getValor());
            int eSigno = Integer.parseInt(PacoteMegarko.Identifique("Signo").getValor());

            Harrem eHarrem = new Harrem(eTronarko, eHiperarko, eMegarko, eSigno);

            for (Identificador IDC : PacoteMegarko.getIdentificadores()) {

                if (IDC.getNome().contentEquals("Hiperarko")) {
                } else if (IDC.getNome().contentEquals("Megarko")) {
                } else if (IDC.getNome().contentEquals("Signo")) {
                }else{
                    eHarrem.criarItem(IDC.getNome(),IDC.getValor());
                }
            }

            eHarrempluz.adicionar(eHarrem);

        }
        return eHarrempluz;
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
