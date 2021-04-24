package OmegaEngine.UI;

import OmegaEngine.Utils.Cronometro;

public class IteracaoUI {

    private Cronometro mCrono;

    private boolean mSeraClicavel = false;
    private boolean mPodeClicar = false;

    public IteracaoUI() {

        mCrono = new Cronometro(200);

    }

    public void update(double dt, boolean ePrecionado) {

        mPodeClicar = false;

        mCrono.Esperar();

        if (mCrono.Esperado()) {
            mSeraClicavel = true;
        }

        if (mSeraClicavel) {
            if (ePrecionado == true) {
                mCrono.Zerar();
                mSeraClicavel = false;
                mPodeClicar = true;
            }
        }


    }

    public boolean podeClicar() {
        return mPodeClicar;
    }
}
