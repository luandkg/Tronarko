package Tronarko.Utils;

import Tronarko.Hazde;

public class DispensadorDeAlarme {

    private boolean mDispensar;
    private Hazde mDispensadoCom;

    public DispensadorDeAlarme() {

        mDispensar = false;
        mDispensadoCom = null;

    }

    public void dispensar(Hazde eAgora) {
        mDispensar = true;
        mDispensadoCom = eAgora;
    }

    public boolean foiDispensado() {
        return mDispensar;
    }

    public Hazde getDispensado() {
        return mDispensadoCom;
    }

    public void autoDispensar(Lembrete eLembrete, int mTocar, Hazde mAgora) {

        Hazde mIniciar = eLembrete.getHazde();
        Hazde mFinalizar = eLembrete.getHazde().adicionar_Itta(mTocar);

        if (mIniciar.MaiorIgualQue(mDispensadoCom)) {

            if (mAgora.MaiorIgualQue(mIniciar) && mAgora.MenorIgualQue(mFinalizar)) {
                mDispensar = false;
            }

        }

    }

    public boolean lembreteTocando(Lembrete eLembrete, int mTocar, Hazde mAgora) {

        Hazde mIniciar = eLembrete.getHazde();
        Hazde mFinalizar = eLembrete.getHazde().adicionar_Itta(mTocar);

        boolean tocando = false;

        if (mAgora.MaiorIgualQue(mIniciar) && mAgora.MenorIgualQue(mFinalizar)) {
            tocando = true;
        }

        return tocando;
    }

    public boolean estaTocando(Lembrete eLembrete, int mTocar, Hazde mAgora) {

        boolean selecionado = false;

        if (foiDispensado()) {
            autoDispensar(eLembrete, mTocar, mAgora);
        } else if (lembreteTocando(eLembrete, mTocar, mAgora)) {
            selecionado = true;
        }

        return selecionado;
    }

}
