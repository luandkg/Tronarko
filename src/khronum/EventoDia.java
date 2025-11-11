package khronum;

public class EventoDia {

    private String mComecar;
    private String mTerminar;
    private String mAviso;

    public EventoDia(String eAviso, String eComecar, String eTerminar) {
        mAviso = eAviso;
        mComecar = eComecar;
        mTerminar = eTerminar;
    }

    public String getAviso(){return mAviso;}
    public String getComecar(){return mComecar;}
    public String getTerminar(){return mTerminar;}


}
