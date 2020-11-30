package Tronarko;

public class Lembrete {

    private Tronarko.Tozte mTozte;
    private Tronarko.Hazde mHazde;

    public Lembrete(Tronarko.Tozte eTozte, Tronarko.Hazde eHazde) {

        mTozte = eTozte;
        mHazde = eHazde;

    }

    public Tronarko.Tozte getTozte() {
        return mTozte;
    }

    public Tronarko.Hazde getHazde() {
        return mHazde;
    }

}
