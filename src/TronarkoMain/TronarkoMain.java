package TronarkoMain;

import Khronum.MinhaAgenda;
import OmegaEngine.Inicializador;
import Tronarko.Intervalos.Tozte_Intervalo;
import Tronarko.Tronarko;

import javax.imageio.ImageIO;
import javax.swing.border.StrokeBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TronarkoMain {

    public static void main(String[] args) {

        MinhaAgenda eMinhaAgenda = new MinhaAgenda();
        eMinhaAgenda.init_2021();


        int App = 2;

        if (App == 0) {

            Inicializador.criar("Tronarko", 1500, 1020, "editor.png", new TronarkoCena());

        } else if (App == 1) {

            Inicializador.criar("Harrempluz", 1500, 1020, "editor.png", new HarrempluzCena());

        } else if (App == 2) {

            Inicializador.criar("Alarme", 900, 600, "editor.png", new Alarme());

        }

        BufferedImage imagem = new BufferedImage(500, 500, BufferedImage.TYPE_4BYTE_ABGR);

        Graphics2D g = (Graphics2D) imagem.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHints(rh);

        int comecar = 0;
        int tamanho = 45;


        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5f));
        g.drawArc(50, 50, 300, 300, comecar + 90, tamanho);

        try {
            ImageIO.write(imagem, "PNG", new File("res/tron.png"));
        } catch (Exception e) {

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
