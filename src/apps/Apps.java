package apps;

import oe.Inicializador;

public class Apps {

    public static final int APP_TRONARKO = 0;
    public static final int APP_HARREMPLUZ = 1;
    public static final int APP_ALARME = 2;

    public static void INICIAR(int app){

        if (app == APP_TRONARKO) {
            Inicializador.criar("tronarko", 1500, 1020, "editor.png", new AplicacaoTronarko());
        } else if (app == APP_HARREMPLUZ) {
            Inicializador.criar("Harrempluz", 1500, 1020, "editor.png", new AplicacaoHarrempluz());
        } else if (app == APP_ALARME) {
            Inicializador.criar("Alarme", 900, 600, "res/editor.png", new AplicacaoAlarme());
        }

    }
}
