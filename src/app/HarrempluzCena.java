package app;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import astral.A7;
import oe.ui.BotaoCor;
import oe.ui.IteracaoUI;
import oe.Windows;
import oe.cenarios.Cena;
import oe.utils.Escritor;
import tronarko.Harrempluz.Harrem;
import tronarko.Harrempluz.HarremItem;
import tronarko.Harrempluz.Harrempluz;
import tronarko.Tronarko;
import tronarko.Tozte;
import tronarko.Signos;

public class HarrempluzCena extends Cena {

    private Windows mWindows;

    private Escritor TextoGrande;
    private Escritor TextoPequeno;


    private Tronarko TronarkoC;

    private int mTronarko;
    private int mMega;
    private Tozte Hoje;

    private Harrempluz mHarrempluz;
    private ArrayList<Harrem> mSignosMegarko;
    private A7 mA7;

    private BotaoCor BTN_ESQUERDA;
    private IteracaoUI mIteracaoUI;
    private int mQuantos;

    public HarrempluzCena( ) {

        TextoGrande = new Escritor(30, Color.BLACK);
        TextoPequeno = new Escritor(15, Color.BLACK);


        TronarkoC = new Tronarko();

        mTronarko = -1;
        mMega = -1;
        mQuantos = 0;

        mA7 = new A7("harrempluz.dkgax");

        mHarrempluz = null;
        mSignosMegarko = new ArrayList<Harrem>();

        mIteracaoUI = new IteracaoUI();

        BTN_ESQUERDA = new BotaoCor(1200, 800, 100, 100, new Color(26, 80, 156));

    }

    @Override
    public void iniciar(Windows eWindows)
    {
        mWindows = eWindows;

        mWindows.setTitle("Harrempluz");
    }

    @Override
    public void update(double dt) {

        Hoje = TronarkoC.getTozte();


        mIteracaoUI.update(dt, mWindows.getMouse().Pressed());

        if (mIteracaoUI.podeClicar()) {

            int px = (int) mWindows.getMouse().x;
            int py = (int) mWindows.getMouse().y;

            if (BTN_ESQUERDA.getClicado(px, py)) {
                mQuantos += 1;
            }
        }

        if (mQuantos > 0) {
            Hoje = Hoje.adicionar_Superarko(mQuantos);
        }


        if (mTronarko != Hoje.getTronarko()) {
            mTronarko = Hoje.getTronarko();

            mHarrempluz = mA7.getHarrem(mTronarko);
        }

        if (mMega != Hoje.getMegarkoDoTronarko()) {
            mMega = Hoje.getMegarkoDoTronarko();

            mSignosMegarko.clear();

            System.out.println("Tozte = " + Hoje.getTexto());

            for (Harrem eHarrem : mHarrempluz.getHarrems()) {

                if (eHarrem.getMegarkoDoTronarko() == mMega) {

                    mSignosMegarko.add(eHarrem);

                    //   System.out.println("-->> S - Harrem { Tronarko : " + eHarrem.getTronarko() + " Hiperarko = " + eHarrem.getHiperarko() + " Megarko = " + eHarrem.getMegarko() + " Signo = " + eHarrem.getSigno() + " } ");

                } else {

                    //   System.out.println("N - Harrem { Tronarko : " + eHarrem.getTronarko() + " Hiperarko = " + eHarrem.getHiperarko() + " Megarko = " + eHarrem.getMegarko() + " Signo = " + eHarrem.getSigno() + " } ");


                }

            }

            System.out.println("Carregando megarko = " + mMega);
            System.out.println("Signos Megarko = " + mSignosMegarko.size());

        }


    }

    @Override
    public void draw(Graphics g) {

        mWindows.Limpar(g);

        BTN_ESQUERDA.draw(g);

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
        TextoGrande.EscreveNegrito(g, "Tozte : " + Hoje.getTexto(), 30, CAIXA_Y + 110);

    }

    public void draw_signo(Graphics g, int mHiperarko, int Faixador, int CAIXA_X, int CAIXA_Y, int CAIXA_ALTURA) {

        int i = mHiperarko - 1;
        String eSigno = Signos.get(i + 1).toString();
        String eTitulo = String.valueOf(i + 1) + " - " + eSigno;

        TextoGrande.EscreveNegrito(g, eTitulo, CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);

        for (Harrem eHarrem : mSignosMegarko) {

            if (eHarrem.getSigno() == i + 1) {

                int s = 0;

                for (HarremItem item : eHarrem.getItens()) {

                    String eMega = item.getNome() + " = " + item.getValor();

                    int parteX = (CAIXA_X - 10);
                    int parteY = (((CAIXA_ALTURA * Faixador) + 30) + CAIXA_Y) + (s * 20);

                    TextoPequeno.EscreveNegrito(g, eMega, parteX, parteY);
                    s += 1;
                }

            }

        }


    }

}
