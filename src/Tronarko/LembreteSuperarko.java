package Tronarko;

public class LembreteSuperarko {

    private Tronarko.Superarkos mSuperarkos;
    private Tronarko.Hazde mHazde;

    public LembreteSuperarko(Tronarko.Superarkos eSuperarkos, Tronarko.Hazde eHazde) {

        mSuperarkos = eSuperarkos;
        mHazde = eHazde;

    }

    public Tronarko.Superarkos getSuperarkos() {
        return mSuperarkos;
    }

    public Tronarko.Hazde getHazde() {
        return mHazde;
    }

}
