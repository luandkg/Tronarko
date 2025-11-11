package khronum;

import java.util.ArrayList;

public class Dia {

    private String mData;
    private Semana mDia;
    private ArrayList<EventoDia> mEventos;

    public Dia(String eData, Semana eDia) {
        mData = eData;
        mDia = eDia;
        mEventos = new ArrayList<EventoDia>();

    }

    public String getData() {
        return mData;
    }

    public Semana getDia() {
        return mDia;
    }

    public void evento(String eAviso, String eComecar, String eTerminar) {
        mEventos.add(new EventoDia(eAviso, eComecar, eTerminar));
    }

    public ArrayList<EventoDia> getEventos() {
        return mEventos;
    }
}
