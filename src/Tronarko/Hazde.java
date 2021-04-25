package Tronarko;

public  class Hazde {

    private int mArkos;
    private int mIttas;
    private int mUzzons;

    public int getArco() {
        return this.mArkos;
    }

    public int getItta() {
        return this.mIttas;
    }

    public int getUzzon() {
        return this.mUzzons;
    }

    public Hazde(int _arco, int _itta, int _uzzon) {
        this.mArkos = _arco;
        this.mIttas = _itta;
        this.mUzzons = _uzzon;
    }

    public Hazde getCopia() {
        return new Hazde(mArkos,mIttas,mUzzons);
    }

    public int getTotalEttons() {
        int ret = 0;

        ret += (this.getArco() - 1) * 100 * 100;
        ret += this.getItta() * 100;
        ret += this.getUzzon();

        return ret;
    }

    public String getTexto() {
        String texto = "";

        texto = this.getArco() + ":" + this.getItta() + ":" + this.getUzzon();

        return texto;
    }

    public String getTextoSemEttos() {
        String texto = "";

        texto = this.getArco() + ":" + this.getItta() + ":" + this.getUzzon();

        return texto;
    }

    public final String toString() {
        return getTexto();
    }

    public Periarkos getPeriarko() {
        Periarkos ret = null;

        if (getArco() >= 1 && getArco() <= 2) {
            ret = Periarkos.UD;
        }
        if (getArco() >= 3 && getArco() <= 5) {
            ret = Periarkos.AD;
        }
        if (getArco() >= 6 && getArco() <= 8) {
            ret = Periarkos.ED;
        }
        if (getArco() >= 9 && getArco() <= 10) {
            ret = Periarkos.OD;
        }

        return ret;
    }

    public String getPeriarko_Valor() {
        return getPeriarko().toString();
    }

    public String PeriarkoCompleto() {
        return String.valueOf(this.getArco()) + "º " + String.valueOf(this.getItta()) + " " + getPeriarko_Valor();
    }

    public Modarkos getModarko() {
       Modarkos ret = null;

        if (getArco() >= 1 && getArco() <= 2) {
            ret = Modarkos.OZZ;
        }
        if (getArco() >= 3 && getArco() <= 5) {
            ret =Modarkos.AZZ;
        }
        if (getArco() >= 6 && getArco() <= 8) {
            ret = Modarkos.AZZ;
        }
        if (getArco() >= 9 && getArco() <= 10) {
            ret = Modarkos.OZZ;
        }

        return ret;
    }

    public String getModarko_Valor() {
        return getModarko().toString();
    }

    public String ModarkoCompleto() {
        return String.valueOf(this.getArco()) + "º " + getModarko_Valor();
    }

    public Hazde adicionar_Arco(int a) {
        return modificar_Arco(this, a);
    }

    public Hazde adicionar_Itta(int i) {
        return modificar_Itta(this, i);
    }

    public Hazde adicionar_Uzzon(int u) {
        return modificar_Uzzon(this, u);
    }


    public Hazde getComEttonZerado() {
        Hazde ret = new Hazde(this.getArco(), this.getItta(), 0);

        return ret;
    }



    public Hazde modificar_Arco(Hazde sTron, int a) {

        int narco = sTron.getArco() + a;

        while (narco > 10) {
            narco -= 10;
        }

        while (narco <= 0) {
            narco += 10;
        }

        Hazde ret = new Hazde(narco, sTron.getItta(), sTron.getUzzon());

        return ret;

    }

    public Hazde modificar_Itta(Hazde sTron, int i) {

        int nitta = sTron.getItta() + i;
        int narco = 0;

        while (nitta >= 100) {
            nitta -= 100;
            narco += 1;
        }

        while (nitta < 0) {
            nitta += 100;
            narco -= 1;
        }

        Hazde ret = new Hazde(sTron.getArco(), nitta, sTron.getUzzon());

        return modificar_Arco(ret, narco);

    }

    public Hazde modificar_Uzzon(Hazde sTron, int u) {

        int nuzzon = sTron.getUzzon() + u;
        int nitta = 0;

        while (nuzzon >= 100) {
            nuzzon -= 100;
            nitta += 1;
        }

        while (nuzzon < 0) {
            nuzzon += 100;
            nitta -= 1;
        }

        Hazde ret = new Hazde(sTron.getArco(), sTron.getItta(), nuzzon);

        return modificar_Itta(ret, nitta);

    }

    // INTERNALIZAR METODOS

    public void internalizar_Arco(int a) {

        int narco = this.getArco() + a;

        while (narco > 10) {
            narco -= 10;
        }

        while (narco <= 0) {
            narco += 10;
        }

        this.mArkos = narco;

    }

    public void internalizar_Itta(int i) {

        int nitta = this.getItta() + i;
        int narco = 0;

        while (nitta >= 100) {
            nitta -= 100;
            narco += 1;
        }

        while (nitta < 0) {
            nitta += 100;
            narco -= 1;
        }

        this.mIttas = nitta;

        Hazde ret = modificar_Arco(this, narco);

        this.mArkos = ret.getArco();

        this.mUzzons = ret.getUzzon();
        this.mIttas = ret.getItta();

    }

    public void internalizar_Uzzon(int u) {

        int nuzzon = this.getUzzon() + u;
        int nitta = 0;

        while (nuzzon >= 100) {
            nuzzon -= 100;
            nitta += 1;
        }

        while (nuzzon < 0) {
            nuzzon += 100;
            nitta -= 1;
        }

        this.mUzzons = nuzzon;

        Hazde ret = modificar_Itta(this, nitta);

        this.mArkos = ret.getArco();

        this.mIttas = ret.getItta();

    }

    // COMPARADORES

    public int Compare(Hazde Outro) {
        int resposta = 0;

        if (this.getTotalEttons() == Outro.getTotalEttons()) {
            resposta=0;
        }
        if (this.getTotalEttons() < Outro.getTotalEttons()) {
            resposta = -1;
        }
        if (this.getTotalEttons() > Outro.getTotalEttons()) {
            resposta = +1;
        }

        return resposta;

    }

    public boolean MaiorQue(Hazde Outro) {
        boolean resposta = false;
        if (this.getTotalEttons() > Outro.getTotalEttons()) {
            resposta = true;
        }

        return resposta;
    }

    public boolean MenorrQue(Hazde Outro) {
        boolean resposta = false;
        if (this.getTotalEttons() < Outro.getTotalEttons()) {
            resposta = true;
        }

        return resposta;
    }

    public boolean Igual(Hazde Outro) {
        boolean resposta = false;
        if (this.getTotalEttons() == Outro.getTotalEttons()) {
            resposta = true;
        }

        return resposta;
    }

    public boolean Diferente(Hazde Outro) {
        boolean resposta = false;
        if (this.getTotalEttons() != Outro.getTotalEttons()) {
            resposta = true;
        }

        return resposta;
    }

    public boolean MaiorIgualQue(Hazde Outro) {
        boolean resposta = false;
        if (this.getTotalEttons() >= Outro.getTotalEttons()) {
            resposta = true;
        }

        return resposta;
    }

    public boolean MenorIgualQue(Hazde Outro) {
        boolean resposta = false;
        if (this.getTotalEttons() <= Outro.getTotalEttons()) {
            resposta = true;
        }

        return resposta;
    }

}

