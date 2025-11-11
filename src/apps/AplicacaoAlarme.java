package apps;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import oe.Windows;
import oe.cenarios.Cena;
import oe.ui.BotaoCor;
import oe.ui.IteracaoUI;
import oe.utils.Escritor;
import tronarko.TozteCor;
import tronarko.Tronarko;
import tronarko.Tozte;
import tronarko.Hazde;
import tronarko.Superarkos;
import tronarko.Hiperarkos;

import tronarko.eventos.Eventum;
import tronarko.satelites.MapaCelestial;
import tronarko.utils.DispensadorDeAlarme;
import tronarko.utils.Organizador;
import tronarko.utils.Lembrete;
import tronarko.utils.Cronometro;

public class AplicacaoAlarme extends Cena {


    private Windows mWindows;

    private Escritor TextoGrande;
    private Escritor TextoGrande_Hoje;

    private Escritor TextoPequeno;
    private Escritor TextoPequeno_Sel;

    private Escritor TextoPequeno_Hoje;
    private Escritor TextoPequeno_Hoje2;

    private Tronarko TronarkoC;
    private Eventum EventumC;

    private BotaoCor BTN_DISPENSADOR;

    private IteracaoUI mIteracaoUI;
    private int eixo_x = 0;

    private Tozte mAtualmente;
    private Tozte mHoje;
    private Hazde mAgora;

    private int mQuantos;
    private Organizador mOrganizador;

    private int mTocar;

    private Cronometro mCron;
    private boolean mLigarCron;
    private Hazde mCronLigar;

    private DispensadorDeAlarme mDispensador;


    public AplicacaoAlarme() {

        TextoGrande = new Escritor(30, Color.BLACK);
        TextoGrande_Hoje = new Escritor(30, Color.RED);

        TextoPequeno = new Escritor(15, Color.BLACK);
        TextoPequeno_Sel = new Escritor(15, Color.RED);

        TextoPequeno_Hoje = new Escritor(15, Color.RED);
        TextoPequeno_Hoje2 = new Escritor(15, Color.WHITE);

        TronarkoC = new Tronarko();
        EventumC = new Eventum();

        mIteracaoUI = new IteracaoUI();

        BTN_DISPENSADOR = new BotaoCor(600, 480, 200, 50, new Color(50, 90, 156));

        mAtualmente = null;
        mHoje = null;
        mQuantos = 0;

        mOrganizador = new Organizador();
        mDispensador = new DispensadorDeAlarme();

        mOrganizador.marcarSimples(TronarkoC.getTozte(), TronarkoC.getHazde().adicionar_Itta(-2).getComEttonZerado());
        mOrganizador.marcarSimples(TronarkoC.getTozte(), TronarkoC.getHazde().getComEttonZerado());
        mOrganizador.marcarSimples(TronarkoC.getTozte(), TronarkoC.getHazde().adicionar_Itta(+1).getComEttonZerado());
        mOrganizador.marcarSimples(TronarkoC.getTozte(), TronarkoC.getHazde().adicionar_Itta(+2).getComEttonZerado());
        mOrganizador.marcarSimples(TronarkoC.getTozte(), TronarkoC.getHazde().adicionar_Itta(+3).getComEttonZerado());
        mOrganizador.marcarSimples(TronarkoC.getTozte(), TronarkoC.getHazde().adicionar_Itta(+4).getComEttonZerado());

        mOrganizador.marcarSuperarko(Superarkos.ALFA, new Hazde(2, 0, 0));
        mOrganizador.marcarSuperarko(Superarkos.ALFA, new Hazde(6, 30, 0));
        mOrganizador.marcarSuperarko(Superarkos.ALFA, new Hazde(8, 50, 0));

        mOrganizador.marcarSuperarko(Superarkos.GAMA, new Hazde(5, 0, 0));

        mOrganizador.marcarSuperarko(Superarkos.IOTA, new Hazde(6, 30, 0));
        mOrganizador.marcarSuperarko(Superarkos.IOTA, new Hazde(8, 30, 0));

        mTocar = 1;

        mLigarCron = false;
        mCronLigar = new Hazde(6, 61, 0);

    }

    @Override
    public void iniciar(Windows eWindows) {
        mWindows = eWindows;
        mWindows.setTitle("Alarme");
    }

    @Override
    public void update(double dt) {

        mHoje = TronarkoC.getTozte();
        mAgora = TronarkoC.getHazde();


        mIteracaoUI.update(dt, mWindows.getMouse().Pressed());

        //System.out.println("Clicavel : " + mClicavel.getClicado()); 


        if (mIteracaoUI.podeClicar()) {

            int px = (int) mWindows.getMouse().x;
            int py = (int) mWindows.getMouse().y;

            if (BTN_DISPENSADOR.getClicado(px, py)) {
                mDispensador.dispensar(mAgora);
                System.out.println("Dispensar : " + mDispensador.getDispensado().getTexto());

            }

        }


        mHoje = mHoje.adicionar_Superarko(mQuantos);

        // System.out.println("Cron Ligar : " + mCronLigar.getTexto());

        if (mLigarCron) {
            mCron.atualizar();

            if (mCron.foiEsperado()) {
                mLigarCron = false;
                mCronLigar = mAgora.adicionar_Uzzon(50);
            }

        } else {
            if (mAgora.MaiorIgualQue(mCronLigar)) {
                mLigarCron = true;
                mCron = new Cronometro(12);
                mCron.iniciar();
            }
        }

    }


    @Override
    public void draw(Graphics g) {

        mWindows.Limpar(g);
        BTN_DISPENSADOR.draw(g);

        //Hoje = Hoje.adicionar_Tronarko(5);

        ArrayList<TozteCor> mInfos = EventumC.getToztesComCorHiperarko(mHoje.getHiperarko(), mHoje.getTronarko());

        int CAIXA_ALTURA = 190;

        int LX = 50;
        int LY = 200;

        TextoPequeno.EscreveNegrito(g, " -->> Hoje : " + mHoje.toString(), LX, LY - 100);
        TextoPequeno.EscreveNegrito(g, " -->> Agora : " + mAgora.toString(), LX, LY - 50);

        if (mLigarCron) {
            TextoPequeno.EscreveNegrito(g, " -->> Cron : " + mCron.getEsperado(), LX, LY);
        }

        int LS = 150;

        MapaCelestial.Allux AlluxC = new MapaCelestial.Allux();
        MapaCelestial.Ettos EttosC = new MapaCelestial.Ettos();
        MapaCelestial.Unnos UnnosC = new MapaCelestial.Unnos();

        TextoPequeno.EscreveNegrito(g, " -->> Allux : " + AlluxC.getFase(mHoje).toString(), LX + 300, LS - 60);
        TextoPequeno.EscreveNegrito(g, " -->> Ettos : " + EttosC.getFase(mHoje).toString(), LX + 300, LS - 30);
        TextoPequeno.EscreveNegrito(g, " -->> Unnos : " + UnnosC.getFase(mHoje).toString(), LX + 300, LS);


        TextoPequeno.EscreveNegrito(g, " AGENDA : " + mHoje.getSuperarko_Status().toString(), 650, 100);

        int eLY = 150;

        for (Lembrete eLembrete : mOrganizador.getLembretes(mHoje)) {

            boolean estaTocando = mDispensador.estaTocando(eLembrete, mTocar, mAgora);

            if (estaTocando) {
                TextoPequeno_Sel.EscreveNegrito(g, " -> " + eLembrete.getTozte().getTexto() + " " + eLembrete.getHazde().getTextoSemEttos(), 650, eLY);
            } else {
                TextoPequeno.EscreveNegrito(g, " -> " + eLembrete.getTozte().getTexto() + " " + eLembrete.getHazde().getTextoSemEttos(), 650, eLY);
            }

            eLY += 50;

        }


        draw_hiperarko(g, mHoje, mInfos, mHoje.getHiperarko(), 0, LX + 50, 280, CAIXA_ALTURA);

        LX = 50;
        LY = 500;

        for (TozteCor InfoC : EventumC.getLegenda(mInfos)) {

            g.setColor(InfoC.getCor());
            g.fillRect(LX, LY - 15, 20, 20);

            if (InfoC.getNome().contains("Reciclum")) {
                TextoPequeno.EscreveNegrito(g, InfoC.getNome(), LX + 50, LY);
            } else {
                TextoPequeno.EscreveNegrito(g, InfoC.getNome() + " -->> " + InfoC.getComplemento(), LX + 50, LY);
            }

            LY += 50;

        }

    }

    public void draw_hiperarko(Graphics g, Tozte Hoje, ArrayList<TozteCor> mInfos, int mHiperarko, int Faixador,
                               int CAIXA_X, int CAIXA_Y, int CAIXA_ALTURA) {

        int eTronarko = Hoje.getTronarko();

        int i = mHiperarko - 1;

        String eTitulo = String.valueOf(i + 1) + " - " + Hiperarkos.get(i + 1).toString();

        if (Hoje.getHiperarko() == (i + 1)) {
            TextoGrande_Hoje.EscreveNegrito(g, eTitulo, CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);
        } else {
            TextoGrande.EscreveNegrito(g, eTitulo, CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);
        }

        for (int s = 0; s < 10; s++) {

            String eMega = Superarkos.get(s + 1).getCapital();

            if ((Hoje.getTronarko() == eTronarko) && (Hoje.getHiperarko() == mHiperarko)) {

                if (eMega.contentEquals(Hoje.Superarko_capital())) {
                    TextoPequeno_Sel.EscreveNegrito(g, eMega, (CAIXA_X - 10) + (s * 40),
                            ((CAIXA_ALTURA * Faixador) + 30) + CAIXA_Y);

                } else {
                    TextoPequeno.EscreveNegrito(g, eMega, (CAIXA_X - 10) + (s * 40),
                            ((CAIXA_ALTURA * Faixador) + 30) + CAIXA_Y);

                }

            } else {

                TextoPequeno.EscreveNegrito(g, eMega, (CAIXA_X - 10) + (s * 40),
                        ((CAIXA_ALTURA * Faixador) + 30) + CAIXA_Y);

            }

        }

        int mSuperarko = 1;

        for (int m = 0; m < 5; m++) {

            for (int s = 0; s < 10; s++) {

                int QX = (CAIXA_X - 10) + (s * 40) + 5;
                int QY = (((CAIXA_ALTURA * Faixador) + 30) + ((m + 1) * 20)) + CAIXA_Y + 10;

                Tozte mTozte = new Tozte(mSuperarko, mHiperarko, eTronarko);

                Color mCor = Color.WHITE;

                boolean comFundo = false;

                for (TozteCor InfoC : mInfos) {

                    if (mTozte.Igual(InfoC.getTozte())) {
                        mCor = InfoC.getCor();
                        comFundo = true;
                        break;
                    }

                }

                g.setColor(mCor);
                g.fillRect(QX - 3, QY - 15, 25, 20);

                String mSuperNum = numeral(mSuperarko);

                if ((Hoje.getTronarko() == eTronarko) && (Hoje.getHiperarko() == mHiperarko)
                        && (Hoje.getSuperarko() == mSuperarko)) {

                    if (comFundo) {
                        TextoPequeno_Hoje2.EscreveNegrito(g, mSuperNum, QX - 2, QY);
                    } else {
                        TextoPequeno_Hoje.EscreveNegrito(g, mSuperNum, QX - 2, QY);
                    }

                    if ((mCor.getRed() == 255) && (mCor.getGreen() == 0) && (mCor.getBlue() == 0)) {
                    } else {
                    }

                } else {

                    TextoPequeno.Escreve(g, mSuperNum, QX, QY);

                }

                mSuperarko += 1;

            }

        }

    }

    public String numeral(int i) {

        String r = String.valueOf(i);
        if (r.length() == 1) {
            r = "0" + r;
        }
        return r;
    }

}
