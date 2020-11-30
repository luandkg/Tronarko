package TronarkoMain;

import OmegaEngine.Windows;
import OmegaEngine.Utils.Imaginador;
import OmegaEngine.Utils.Local;

public class TronarkoMain {

    public static void main(String[] args) {

        Windows mWindows = null;

        int App = 0;

        if (App == 0) {

            mWindows = new Windows("Tronarko", 1500, 1020);
            mWindows.CriarCenarioAplicavel(new TronarkoCena(mWindows));

        } else if (App == 1) {

            mWindows = new Windows("Harrempluz", 1500, 1020);
            mWindows.CriarCenarioAplicavel(new HarrempluzCena(mWindows));

        } else {

            mWindows = new Windows("Alarme", 900, 600);
            mWindows.CriarCenarioAplicavel(new Alarme(mWindows));

        }


        mWindows.setIconImage(Imaginador.CarregarStream(Local.Carregar("editor.png")));

        Thread mThread = new Thread(mWindows);
        mThread.start();

    }
}
