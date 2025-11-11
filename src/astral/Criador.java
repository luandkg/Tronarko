package astral;

import tronarko.harrempluz.Colecao;
import tronarko.Signos;

import java.util.ArrayList;

public class Criador {

    private ArrayList<String> mSignos;
    private ArrayList<Colecao> mColecoes;

    public Criador(){

        mSignos = new ArrayList<String>();
        mColecoes = new ArrayList<Colecao>();


        mSignos.add(Signos.TIGRE.toString());
        mSignos.add(Signos.RAPOSA.toString());
        mSignos.add(Signos.LEOPARDO.toString());
        mSignos.add(Signos.LEAO.toString());
        mSignos.add(Signos.TOURO.toString());
        mSignos.add(Signos.LOBO.toString());
        mSignos.add(Signos.GATO.toString());
        mSignos.add(Signos.CARPA.toString());
        mSignos.add(Signos.GAVIAO.toString());
        mSignos.add(Signos.SERPENTE.toString());



        mColecoes.add(new Colecao("COR", "AMARELO VERDE VERMELHO AZUL CINZA PRETO ROSA ROXO BRANCO MARRON LARANJA "));
        mColecoes.add(new Colecao("ELEMENTO", "AGUA TERRA VENTO FOGO "));

        mColecoes.add(new Colecao("METAL", "LATaO COBRE ESTANHO ZINCO AaO FERRO BRONZE PRATA OURO "));
        mColecoes.add(new Colecao("QUALIDADE",
                "adoravel afavel afetivo agradavel ajuizado alegre altruasta amavel amigavel amoroso aplicado assertivo atencioso atento autantico aventureiro bacana benavolo bondoso brioso calmo carinhoso carismatico caritativo cavalheiro cavico civilizado companheiro compreensivo comunicativo confiante confiavel consciencioso corajoso cordial cortas credavel criativo criterioso cuidadoso curioso decente decoroso dedicado descontraado desenvolto determinado digno diligente disciplinado disponavel divertido doce educado eficiente eloquente empatico empenhado empreendedor encantador engraaado entusiasta escrupuloso esforaado esmerado esperanaoso esplandido excelente extraordinario extrovertido feliz fiel fofo forte franco generoso gentil genuano habilidoso honesto honrado honroso humanitario humilde idaneo imparcial independente inovador antegro inteligente inventivo justo leal legal livre maduro maravilhoso meigo modesto natural nobre observador organizado otimista ousado pacato paciente perfeccionista perseverante persistente perspicaz ponderado pontual preocupado preparado prestativo prestavel proativo produtivo prudente racional respeitador responsavel sabio sagaz sensato sensavel simpatico sincero solacito solidario sossegado ternurento tolerante tranquilo transparente valente valoroso verdadeiro zeloso "));
        mColecoes.add(new Colecao("DEFEITO",
                "agressivo ansioso antipatico antissocial apatico apressado arrogante atrevido autoritario avarento birrento bisbilhoteiro bruto calculista casmurro chato canico ciumento colarico comodista covarde cratico cruel debochado depressivo desafiador desbocado descarado descomedido desconfiado descortas desequilibrado desleal desleixado desmazelado desmotivado desobediente desonesto desordeiro despatico desumano discriminador dissimulado distraado egoasta estourado estressado exigente falso fingido fraco frio fravolo fatil ganancioso grosseiro grosso hipacrita ignorante impaciente impertinente impetuoso impiedoso imponderado impostor imprudente impulsivo incompetente inconstante inconveniente incorreto indeciso indecoroso indelicado indiferente infiel inflexavel injusto inseguro insensato insincero instavel insuportavel interesseiro intolerante intransigente irracional irascavel irrequieto irresponsavel irritadiao malandro maldoso malicioso malvado mandão manhoso maquiavalico medroso mentiroso mesquinho narcisista negligente nervoso neuratico obcecado odioso oportunista orgulhoso pedante pessimista pa-frio possessivo precipitado preconceituoso preguiaoso prepotente presunaoso problematico quezilento rancoroso relapso rigoroso rabugento rude sarcastico sedentario teimoso tamido tirano traiaoeiro traidor trapaceiro tendencioso trocista vagabundo vaidoso vulneravel vigarista xenafobo "));
        mColecoes.add(new Colecao("NUMERO_10", "0 1 2 3 4 5 6 7 8 9 "));
        mColecoes.add(new Colecao("NUMERO_100",
                "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 "));
        mColecoes.add(new Colecao("VOGAL", "A E I O U "));
        mColecoes.add(new Colecao("CONSOANTE", "B C D F G H J K L M N P Q R S T V W X Y Z "));
        mColecoes.add(new Colecao("LETRA", "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z "));
        mColecoes.add(new Colecao("CRISTAL",
                "Alexandrita Ametista Aquamarine Citrino Diamante Esmeralda Granada Jade lazali Opala Turmalina Parolas Peridoto Rubi Safira Espinela Tanzanite Topazio Turmalina Turquesa Zircania Morganite agata Amazonita ambar Cornalina Fluorita Hematita Jaspe Malaquita Nacar Sodalita "));

        mColecoes.add(new Colecao("DIRECAO", "NORTE SUL LESTE OESTE NORDESTE SUDESTE NOROESTE SUDOESTE "));


    }

    //public Harrem Criar_Harrempluz(int eTronarko) {

      //  Harrem HarremC = new Harrem(eTronarko);

     //  for (int eMega = 1; eMega <= 50; eMega++) {

         //   for (String SignoC : mSignos) {

              //  for (Colecao ColecaoC : mColecoes) {

                 //   HarremItem(ColecaoC.getNome(), ColecaoC.SorteieQualquer());

              //  }

           // }

       // }

       // return HarremC;
   // }


}
