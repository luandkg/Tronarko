package Tronarko;

public  enum Hiperarkos {

    ATLAS(1), TERRON(2), IGGROX(3), OMPLO(4), UXMO(5), SALLU(6), ITHUR(7), GRAM(8), HETTIZ(9), ELLUN(10);

    private int mValor;

    Hiperarkos(int eValor) {
        mValor = eValor;
    }

    public int getValor() {
        return mValor;
    }

    public static Hiperarkos get(int eValor) {
        Hiperarkos ret = null;

        switch (eValor) {
            case 1:
                ret = Hiperarkos.ATLAS;
                break;
            case 2:
                ret = Hiperarkos.TERRON;
                break;
            case 3:
                ret = Hiperarkos.IGGROX;
                break;
            case 4:
                ret = Hiperarkos.OMPLO;
                break;
            case 5:
                ret = Hiperarkos.UXMO;
                break;
            case 6:
                ret = Hiperarkos.SALLU;
                break;
            case 7:
                ret = Hiperarkos.ITHUR;
                break;
            case 8:
                ret = Hiperarkos.GRAM;
                break;
            case 9:
                ret = Hiperarkos.HETTIZ;
                break;
            case 10:
                ret = Hiperarkos.ELLUN;
                break;
        }

        return ret;
    }

    public static String getNumerado(int eValor) {
        String ret = "";

        switch (eValor) {
            case 1:
                ret = "1 - " + Hiperarkos.ATLAS.toString();
                break;
            case 2:
                ret = "2 - " +Hiperarkos.TERRON.toString();
                break;
            case 3:
                ret = "3 - " +Hiperarkos.IGGROX.toString();
                break;
            case 4:
                ret = "4 - " +Hiperarkos.OMPLO.toString();
                break;
            case 5:
                ret = "5 - " +Hiperarkos.UXMO.toString();
                break;
            case 6:
                ret = "6 - " +Hiperarkos.SALLU.toString();
                break;
            case 7:
                ret = "7 - " +Hiperarkos.ITHUR.toString();
                break;
            case 8:
                ret = "8 - " +Hiperarkos.GRAM.toString();
                break;
            case 9:
                ret = "9 - " +Hiperarkos.HETTIZ.toString();
                break;
            case 10:
                ret = "10 - " +Hiperarkos.ELLUN.toString();
                break;
        }

        return ret;
    }

    public String toString() {
        String ret = "";

        if (mValor == 1) {
            ret = "ATLAS";
        }
        if (mValor == 2) {
            ret = "TERRON";
        }
        if (mValor == 3) {
            ret = "IGGROX";
        }
        if (mValor == 4) {
            ret = "OMPLO";
        }
        if (mValor == 5) {
            ret = "UXMO";
        }
        if (mValor == 6) {
            ret = "SALLU";
        }
        if (mValor == 7) {
            ret = "ITHUR";
        }
        if (mValor == 8) {
            ret = "GRAM";
        }
        if (mValor == 9) {
            ret = "HETTIZ";
        }
        if (mValor == 10) {
            ret = "ELLUN";
        }

        return ret;
    }
}
