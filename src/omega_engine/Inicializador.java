package omega_engine;


import omega_engine.Cenarios.Cena;
import omega_engine.Utils.Imaginador;
import omega_engine.Utils.Local;

public class Inicializador {

    public static void criar(String eNome, int eLargura, int eAltura, String icone, Cena eCena) {

        Windows mWindows = new Windows(eNome, eLargura, eAltura);

        mWindows.setIconImage(Imaginador.CarregarStream(Local.Carregar(icone)));

        eCena.setWindows(mWindows);

        mWindows.CriarCenarioAplicavel(eCena);

        Thread mThread = new Thread(mWindows);
        mThread.start();

    }

}
