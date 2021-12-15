package Khronum;

public class EventoTipoDia {

    private String mFrase;

    private String mInicio;
    private String mFim;
    private Semana mDia;
    private String mTempoInicio;
    private String mTempoFim;

    public EventoTipoDia(String eFrase, String eInicio, String eFim, Semana eDia, String eTempoInicio, String eTempoFim) {

        mFrase = eFrase;
        mInicio = eInicio;
        mFim = eFim;
        mDia = eDia;

        if (eTempoInicio.length() == 5) {
            eTempoInicio += ":00";
        }

        if (eTempoFim.length() == 5) {
            eTempoFim += ":00";
        }

        mTempoInicio = eTempoInicio;
        mTempoFim = eTempoFim;

       // System.out.println(" -->> " + eTempoInicio + " :: " + eTempoInicio.length());

    }

    public String getFrase() {
        return mFrase;
    }

    public String getInicio() {
        return mInicio;
    }

    public String getFim() {
        return mFim;
    }

    public Semana getDia() {
        return mDia;
    }

    public String getTempoInicio() {
        return mTempoInicio;
    }

    public String getTempoFim() {
        return mTempoFim;
    }

}
