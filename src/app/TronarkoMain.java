package app;

import khronum.MinhaAgenda;
import oe.Inicializador;
import tronarko.Tronarko;

import java.awt.*;

public class TronarkoMain {

    public static void main(String[] args) {

        MinhaAgenda eMinhaAgenda = new MinhaAgenda();
        eMinhaAgenda.init_2021();


        int App = 0;

        if (App == 0) {

            Inicializador.criar("tronarko", 1500, 1020, "editor.png", new TronarkoCena());

        } else if (App == 1) {

            Inicializador.criar("Harrempluz", 1500, 1020, "editor.png", new HarrempluzCena());

        } else if (App == 2) {

            Inicializador.criar("Alarme", 900, 600, "res/editor.png", new Alarme());

        }



        Tronarko a = new Tronarko();
        System.out.println("\nMEU ANIVERSARIO");
        System.out.println("\t27/07/1992 :: " + a.getData("27/07/1992").toString());
        System.out.println("\t27/07/2021 :: " + a.getData("27/07/2021").toString());
        System.out.println("\t27/07/2022 :: " + a.getData("27/07/2022").toString());

     //   System.out.println("\tD1 :: " + a.getIntervalo("D1", a.getData("27/07/2020"), a.getData("27/07/2021")).getSuperarkos());
       // System.out.println("\tD2 :: " + a.getIntervalo("D2", a.getData("27/07/2021"), a.getData("27/07/2022")).getSuperarkos());

        System.out.println("\tEpoca :: " + a.getTozte().getEpoca().toString() + " em " + a.getTozte().getTronarkosDaEpoca());

    }
}
