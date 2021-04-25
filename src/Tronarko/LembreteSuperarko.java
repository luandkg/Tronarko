package Tronarko;

public class LembreteSuperarko {

    private Superarkos mSuperarkos;
    private Hazde mHazde;

    public LembreteSuperarko(Superarkos eSuperarkos,Hazde eHazde) {

        mSuperarkos = eSuperarkos;
        mHazde = eHazde;

    }

    public Superarkos getSuperarkos() {
        return mSuperarkos;
    }

    public Hazde getHazde() {
        return mHazde;
    }

}
