package TronarkoMain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
import Tronarko.Satelites.MapaCelestial;

public class TronarkoCena extends Cena {


    private Windows mWindows;

    private Escritor TextoGrande;
    private Escritor TextoGrande_Hoje;

    private Escritor TextoPequeno;
    private Escritor TextoPequeno_Sel;

    private Escritor TextoPequeno_Hoje;
    private Escritor TextoPequeno_Hoje2;

    private Tronarko TronarkoC;
    private Eventum EventumC;

    private BotaoCor BTN_MENOS;
    private BotaoCor BTN_MAIS;

    private Clicavel mClicavel;
    private int eixo_x = 0;

    private Tozte mAtualmente;
    private Tozte mHoje;
    private Hazde mAgora;

    private int mQuantos;

    public TronarkoCena(Windows eWindows) {
        mWindows = eWindows;

        TextoGrande = new Escritor(30, Color.BLACK);
        TextoGrande_Hoje = new Escritor(30, Color.RED);

        TextoPequeno = new Escritor(15, Color.BLACK);
        TextoPequeno_Sel = new Escritor(15, Color.RED);

        TextoPequeno_Hoje = new Escritor(15, Color.RED);
        TextoPequeno_Hoje2 = new Escritor(15, Color.WHITE);

        TronarkoC = new Tronarko();
        EventumC = new Eventum();

        mClicavel = new Clicavel();

        BTN_MENOS = new BotaoCor(1100, 850, 50, 100, new Color(50, 90, 156));
        BTN_MAIS = new BotaoCor(1155, 850, 50, 100, new Color(26, 188, 156));

        mAtualmente = null;
        mHoje = null;
        mQuantos = 0;
    }

    @Override
    public void iniciar() {
        mWindows.setTitle("Tronarko");
    }

    @Override
    public void update(double dt) {

        mHoje = TronarkoC.getTozte();
        mAgora = TronarkoC.getHazde();


        mClicavel.update(dt, mWindows.getMouse().Pressed());

        //System.out.println("Clicavel : " + mClicavel.getClicado());

        if (mClicavel.getClicado()) {

            int px = (int) mWindows.getMouse().x;
            int py = (int) mWindows.getMouse().y;

            if (BTN_MAIS.getClicado(px, py)) {
                mQuantos += 1;
            }

            if (BTN_MENOS.getClicado(px, py)) {
                mQuantos -= 1;
            }
        }


        mHoje = mHoje.adicionar_Superarko(mQuantos);


        if (mAtualmente == null) {
            mAtualmente = mHoje;
            olharAoRedor();
        } else {
            if (mHoje.Diferente(mAtualmente)) {
                mAtualmente = mHoje;
                olharAoRedor();
            }
        }


    }

    public void olharAoRedor() {

        System.out.println();
        System.out.println("Hoje : " + mAtualmente.getTexto());

        Tozte mAntes = mAtualmente.adicionar_Superarko(-50);
        Tozte mDepois = mAtualmente.adicionar_Superarko(+50);

        ArrayList<TozteCor> mInfos = EventumC.getToztesComCorEmIntervalo(mAntes, mDepois);

        for (TozteCor eTozteCor : mInfos) {
            System.out.println(" -->> " + eTozteCor.getNome() + " :: " + eTozteCor.getTozte().getTexto());
        }

    }

    @Override
    public void draw(Graphics g) {

        mWindows.Limpar(g);
        BTN_MENOS.draw(g);
        BTN_MAIS.draw(g);


        //Hoje = Hoje.adicionar_Tronarko(5);


        ArrayList<TozteCor> mInfos = EventumC.getToztesComCor(mHoje.getTronarko());

        int CAIXA_X = 40;
        int CAIXA_Y = 80;

        int CAIXA_ALTURA = 190;

        draw_hiperarko(g, mHoje, mInfos, 1, 0, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 3, 1, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 5, 2, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 7, 3, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 9, 4, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);

        CAIXA_X = 500;

        draw_hiperarko(g, mHoje, mInfos, 2, 0, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 4, 1, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 6, 2, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 8, 3, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);
        draw_hiperarko(g, mHoje, mInfos, 10, 4, CAIXA_X, CAIXA_Y, CAIXA_ALTURA);

        int LX = 950;
        int LY = 200;

        TextoPequeno.EscreveNegrito(g, " -->> Hoje : " + mHoje.toString(), LX, LY - 100);
        TextoPequeno.EscreveNegrito(g, " -->> Agora : " + mAgora.toString(), LX, LY - 50);


        long total = TronarkoC.getLong(mHoje, mAgora);


        //TextoPequeno.EscreveNegrito(g, " -->> Total : " +total, LX+300, LY -100);
        //
        //	TextoPequeno.EscreveNegrito(g, " -->> " + TronarkoC.setLong(total), LX+300, LY -50);


        MapaCelestial.Allux AlluxC = new MapaCelestial.Allux();
        MapaCelestial.Ettos EttosC = new MapaCelestial.Ettos();
        MapaCelestial.Unnos UnnosC = new MapaCelestial.Unnos();

        TextoPequeno.EscreveNegrito(g, " -->> Allux : " + AlluxC.getFase(mHoje).toString(), LX + 300, LY - 100);
        TextoPequeno.EscreveNegrito(g, " -->> Ettos : " + EttosC.getFase(mHoje).toString(), LX + 300, LY - 50);
        TextoPequeno.EscreveNegrito(g, " -->> Unnos : " + UnnosC.getFase(mHoje).toString(), LX + 300, LY);


        draw_hiperarko(g, mHoje, mInfos, mHoje.getHiperarko(), 0, LX + 50, 280, CAIXA_ALTURA);

        LY = 500;
        LX = 950;

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

        String eTitulo = String.valueOf(i + 1) + " - " + Tronarko.Hiperarkos.get(i + 1).toString();

        if (Hoje.getHiperarko() == (i + 1)) {

            TextoGrande_Hoje.EscreveNegrito(g, eTitulo, CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);

        } else {

            TextoGrande.EscreveNegrito(g, eTitulo, CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);

        }

        for (int s = 0; s < 10; s++) {

            String eMega = Tronarko.Superarkos.get(s + 1).getCapital();

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

                    if (comFundo){
                        TextoPequeno_Hoje2.EscreveNegrito(g, mSuperNum, QX - 2, QY);
                    }else{
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
