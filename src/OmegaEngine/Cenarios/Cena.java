package OmegaEngine.Cenarios;

import OmegaEngine.Windows;

import java.awt.Graphics;

public abstract class Cena {

    private String mNome;
    private Windows mWindows;

    public void setNome(String eNome) {
        this.mNome = eNome;


    }
    public void setWindows(Windows eWindows) {
        this.mWindows = eWindows;
    }

    // Propriedades Importantes

    public String getNome() {
        return mNome;
    }
    public Windows getWindows() {
        return mWindows;
    }

    // Metodos Importantes

    public abstract void iniciar(Windows eWindows);

    public abstract void update(double dt);

    public abstract void draw(Graphics g);

}
