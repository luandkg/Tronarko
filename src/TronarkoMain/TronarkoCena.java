package TronarkoMain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import OmegaEngine.Windows;
import OmegaEngine.Cenarios.Cena;
import OmegaEngine.UI.BotaoCor;
import OmegaEngine.UI.IteracaoUI;
import OmegaEngine.Utils.Escritor;
import Tronarko.TozteCor;
import Tronarko.Tronarko;
import Tronarko.Tozte;
import Tronarko.Hazde;
import Tronarko.Superarkos;
import Tronarko.Hiperarkos;

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

    private Tronarko mTronarkum;
    private Eventum mEnventum;

    private BotaoCor BTN_MENOS;
    private BotaoCor BTN_MAIS;

    private IteracaoUI mIteracaoUI;

    private Tozte mAtualmente;
    private Tozte mHoje;
    private Hazde mAgora;

    private int mQuantos;


    @Override
    public void iniciar(Windows eWindows) {
        mWindows = eWindows;
        mWindows.setTitle("Tronarko");

        TextoGrande = new Escritor(30, Color.BLACK);
        TextoGrande_Hoje = new Escritor(30, Color.RED);

        TextoPequeno = new Escritor(15, Color.BLACK);
        TextoPequeno_Sel = new Escritor(15, Color.RED);

        TextoPequeno_Hoje = new Escritor(15, Color.RED);
        TextoPequeno_Hoje2 = new Escritor(15, Color.WHITE);

        mTronarkum = new Tronarko();
        mEnventum = new Eventum();

        mIteracaoUI = new IteracaoUI();

        BTN_MENOS = new BotaoCor(1100, 870, 50, 100, new Color(50, 90, 156));
        BTN_MAIS = new BotaoCor(1155, 870, 50, 100, new Color(26, 188, 156));

        mAtualmente = null;
        mHoje = null;
        mQuantos = 0;

    }

    @Override
    public void update(double dt) {


        mHoje = mTronarkum.getTozte();
        mAgora = mTronarkum.getHazde();

        mIteracaoUI.update(dt, mWindows.getMouse().Pressed());

        if (mIteracaoUI.podeClicar()) {

            if (BTN_MAIS.getClicado(mWindows.getMouse())) {
                mQuantos += 1;
            }

            if (BTN_MENOS.getClicado(mWindows.getMouse())) {
                mQuantos -= 1;
            }
        }


     //   mHoje = mHoje.adicionar_Superarko(mQuantos);
        mAgora = mAgora.adicionar_Arco(mQuantos);

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

        ArrayList<TozteCor> mInfos = mEnventum.getToztesComCorEmIntervalo(mAntes, mDepois);

        for (TozteCor eTozteCor : mInfos) {
            System.out.println(" -->> " + eTozteCor.getNome() + " :: " + eTozteCor.getTozte().getTexto() + " -->> " + getDistancia(mAtualmente, eTozteCor.getTozte()));
        }


    }


    public int getDistancia(Tozte eReferencia, Tozte eAlgumTozte) {

        int dif = 0;
        Tozte eOutro_Ref = eReferencia.getCopia();
        Tozte eOutro_AlgumTozte = eAlgumTozte.getCopia();

        if (eOutro_Ref.MaiorQue(eOutro_AlgumTozte)) {

            while (eOutro_Ref.MaiorQue(eOutro_AlgumTozte)) {
                eOutro_Ref = eOutro_Ref.adicionar_Superarko(-1);
                dif += 1;
            }

        } else if (eOutro_Ref.MenorrQue(eOutro_AlgumTozte)) {

            while (eOutro_Ref.MenorrQue(eOutro_AlgumTozte)) {
                eOutro_Ref = eOutro_Ref.adicionar_Superarko(+1);
                dif -= 1;
            }

        } else {
            dif = 0;
        }

        return dif;

    }


    @Override
    public void draw(Graphics g) {


        mWindows.Limpar(g);
        BTN_MENOS.draw(g);
        BTN_MAIS.draw(g);


        ArrayList<TozteCor> mInfos = mEnventum.getToztesComCor(mHoje.getTronarko());
        //ArrayList<TozteCor> mInfos = mEnventum.getToztesComCorHizarko(mHoje.getTronarko());


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

        int ePosY = 100;

        TextoPequeno.EscreveNegrito(g, " -->> Hoje : " + mHoje.toString(), LX, ePosY);
        TextoPequeno.EscreveNegrito(g, " -->> Agora : " + mAgora.toString(), LX, ePosY + 50);
        TextoPequeno.EscreveNegrito(g, " -->> Falta : " + mAgora.getTotalEttonsParaAcabarFormatado(), LX, ePosY + 100);

        mAgora.getTotalEttonsParaAcabar();


        MapaCelestial.Allux AlluxC = new MapaCelestial.Allux();
        MapaCelestial.Ettos EttosC = new MapaCelestial.Ettos();
        MapaCelestial.Unnos UnnosC = new MapaCelestial.Unnos();

        TextoPequeno.EscreveNegrito(g, " -->> Allux : " + AlluxC.getFase(mHoje).toString(), LX + 300, LY - 100);
        TextoPequeno.EscreveNegrito(g, " -->> Ettos : " + EttosC.getFase(mHoje).toString(), LX + 300, LY - 50);
        TextoPequeno.EscreveNegrito(g, " -->> Unnos : " + UnnosC.getFase(mHoje).toString(), LX + 300, LY);


        draw_hiperarko(g, mHoje, mInfos, mHoje.getHiperarko(), 0, LX + 50, 280, CAIXA_ALTURA);

        int mTamanho = 380;

        double eTaxa = (double) mTamanho / 50.0;
        int eCompleto = (int) (eTaxa * (double) mHoje.getSuperarko());

        g.setColor(Color.BLACK);
        g.fillRect(LX + 33, 435, 5, 20);
        g.fillRect(LX + 40, 435, 5, 20);
        g.fillRect(LX + 45, 442, mTamanho, 5);

        g.setColor(Color.RED);
        g.fillRect(LX + 45, 440, eCompleto, 10);


        LY = 500;
        LX = 950;

        for (TozteCor InfoC : mEnventum.getLegenda(mInfos)) {

            g.setColor(InfoC.getCor());
            g.fillRect(LX, LY - 15, 20, 20);

            g.setColor(Color.WHITE);
            g.fillRect(LX + 5, LY - 15 + 5, 10, 10);


            if (InfoC.getNome().contains("Reciclum")) {
                TextoPequeno.EscreveNegrito(g, InfoC.getNome(), LX + 30, LY);
            } else {
                TextoPequeno.EscreveNegrito(g, InfoC.getNome(), LX + 30, LY);
                TextoPequeno.EscreveNegrito(g, " -->> " + InfoC.getComplemento(), LX + 250, LY);
            }

            LY += 50;

        }

    }


    public void draw_hiperarko(Graphics g, Tozte Hoje, ArrayList<TozteCor> mInfos, int mHiperarko, int Faixador,
                               int CAIXA_X, int CAIXA_Y, int CAIXA_ALTURA) {

        int eTronarko = Hoje.getTronarko();

        if (Hoje.getHiperarko() == (mHiperarko)) {
            TextoGrande_Hoje.EscreveNegrito(g, Hiperarkos.getNumerado(mHiperarko), CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);
        } else {
            TextoGrande.EscreveNegrito(g, Hiperarkos.getNumerado(mHiperarko), CAIXA_X - 10, (CAIXA_ALTURA * Faixador) + CAIXA_Y);
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

        String mAtualInfoNome = "";
        String mPassadoInfoNome = "";

        for (int m = 0; m < 5; m++) {

            boolean anteriorComFundo = false;

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
                        mAtualInfoNome = InfoC.getNome();
                        break;
                    }

                }

                g.setColor(mCor);
                g.fillRect(QX - 3, QY - 15, 25, 20);


                if (comFundo & anteriorComFundo && s < 10) {

                    if (mPassadoInfoNome.contentEquals(mAtualInfoNome)) {
                        g.setColor(mCor);
                        g.fillRect(QX - 3 - 18, QY - 7, 20, 5);
                    }

                }

                anteriorComFundo = comFundo;


                mPassadoInfoNome = mAtualInfoNome;

                String mSuperNum = String.valueOf(mSuperarko);
                if (mSuperNum.length() == 1) {
                    mSuperNum = "0" + mSuperNum;
                }


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


}
