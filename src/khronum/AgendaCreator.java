package khronum;

import empacotador.Texto;
import tronarko.Tronarko;

import java.util.ArrayList;

public class AgendaCreator {

    private ArrayList<Dia> mDias;
    private ArrayList<EventoTipoDia> mEventosTipoDia;

    public AgendaCreator() {

        mDias = new ArrayList<Dia>();
        mEventosTipoDia = new ArrayList<EventoTipoDia>();

    }

    public void mostrar() {
        int ret = 0;

        for (Dia eDia : mDias) {
            System.out.println(">> " + eDia.getData() + " :: " + ret);
            ret += 1;
        }
    }

    public void normal() {
        for (Dia eDia : mDias) {
            System.out.println(" -->> " + eDia.getData() + " :: " + eDia.getDia().toString());

            for (EventoDia evento : eDia.getEventos()) {
                System.out.println("\t :: " + evento.getComecar() + " _ " + evento.getTerminar() + " -- " + evento.getAviso());
            }

        }
    }


    public void mostrarAgenda() {

        System.out.println("");
        System.out.println("");
        System.out.println("MINHA AGENDA");

        Tronarko eTronarko = new Tronarko();

        for (Dia eDia : mDias) {

            System.out.println(" -->> " + eTronarko.getData(eDia.getData()).getTexto() + " :: " + eTronarko.getData(eDia.getData()).Superarko_nome());

            if (eDia.getEventos().size() > 0) {

                //  System.out.println(" -->> " + eTronarko.getData(eDia.getData()).getSuperarkosTotal() + " :: " + eTronarko.getData(eDia.getData()).Superarko_nome());

                for (EventoDia evento : eDia.getEventos()) {
                    //  System.out.println("\t :: " + eTronarko.getHora(evento.getComecar()).getTextoSemUzzons() + " _ " + eTronarko.getHora(evento.getTerminar() ).getTextoSemUzzons()+ " -- " + evento.getAviso());
                    // System.out.println("\t :: " + eTronarko.getHora(evento.getComecar()).getTotalEttons() + " _ " + eTronarko.getHora(evento.getTerminar()).getTotalEttons() + " -- " + evento.getAviso());

                    // System.out.println("\t :: " + eTronarko.getHora(evento.getComecar()).getTextoZerado() + " _ " + eTronarko.getHora(evento.getTerminar()).getTextoZerado() + " -- " + evento.getAviso());
                    System.out.println("\t :: " + eTronarko.getHora(evento.getComecar()).getTextoSemUzzonZerado() + " _ " + eTronarko.getHora(evento.getTerminar()).getTextoSemUzzonZerado() + " -- " + evento.getAviso());

                }


            }


        }

    }

    public void guardarAgenda(String eArquivo) {

        Tronarko eTronarko = new Tronarko();


        ArrayList<String> todos = new ArrayList<String>();

        for (Dia eDia : mDias) {

            //  System.out.println(" -->> " + eTronarko.getData(eDia.getData()).getTexto() + " :: " + eTronarko.getData(eDia.getData()).Superarko_nome());



            if (eDia.getEventos().size() > 0) {

                //  System.out.println(" -->> " + eTronarko.getData(eDia.getData()).getSuperarkosTotal() + " :: " + eTronarko.getData(eDia.getData()).Superarko_nome());


                for (EventoDia evento : eDia.getEventos()) {
                    //  System.out.println("\t :: " + eTronarko.getHora(evento.getComecar()).getTextoSemUzzons() + " _ " + eTronarko.getHora(evento.getTerminar() ).getTextoSemUzzons()+ " -- " + evento.getAviso());
                    // System.out.println("\t :: " + eTronarko.getHora(evento.getComecar()).getTotalEttons() + " _ " + eTronarko.getHora(evento.getTerminar()).getTotalEttons() + " -- " + evento.getAviso());

                    //  System.out.println("\t :: " + eTronarko.getHora(evento.getComecar()).getTextoZerado() + " _ " + eTronarko.getHora(evento.getTerminar()).getTextoZerado() + " -- " + evento.getAviso());

                    todos.add("{ tozte: " + eTronarko.getData(eDia.getData()).getSuperarkosTotal()  + " , inicio: " + eTronarko.getHora(evento.getComecar()).getTotalEttons() + ", fim : " + eTronarko.getHora(evento.getTerminar()).getTotalEttons() + " , aviso : '" + evento.getAviso() + "'}");


                }


            }



        }

        int ultimo = todos.size() - 1;
        int passando = 0;

        String eDocumento = "";

        eDocumento += "\n var agenda = [ ";

        for (String eAviso : todos) {
            if (passando == ultimo) {
                eDocumento += "\n\t " + eAviso + "";
            } else {
                eDocumento += "\n\t " + eAviso + " , ";
            }
            passando += 1;
        }


        eDocumento += "\n ];";

        Texto.Escrever(eArquivo, eDocumento);
    }


    public void agendarDuranteASemana(String eInicio, String eFim, String eTempoInicio, String eTempoFim, String eAviso) {

        agendarDia(eInicio, eFim, Semana.Segunda, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Terca, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Quarta, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Quinta, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Sexta, eTempoInicio, eTempoFim, eAviso);

    }

    public void agendarTodoDia(String eInicio, String eFim, String eTempoInicio, String eTempoFim, String eAviso) {

        agendarDia(eInicio, eFim, Semana.Segunda, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Terca, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Quarta, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Quinta, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Sexta, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Sabado, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Domingo, eTempoInicio, eTempoFim, eAviso);

    }

    public void agendarFimDeSemana(String eInicio, String eFim, String eTempoInicio, String eTempoFim, String eAviso) {

        agendarDia(eInicio, eFim, Semana.Sabado, eTempoInicio, eTempoFim, eAviso);
        agendarDia(eInicio, eFim, Semana.Domingo, eTempoInicio, eTempoFim, eAviso);

    }

    public void agendarDia(String eInicio, String eFim, Semana eDia, String eTempoInicio, String eTempoFim, String eAviso) {

        EventoTipoDia eEventoTipoDia = new EventoTipoDia(eAviso, eInicio, eFim, eDia, eTempoInicio, eTempoFim);
        mEventosTipoDia.add(eEventoTipoDia);

        int ei = getOrdem(eInicio);
        int eo = getOrdem(eFim);

        // System.out.println("DIA :: " + eInicio + " -->> " + ei);
        //   System.out.println("DIA :: " + eFim + " -->> " + eo);

        int diaContador = 0;

        for (Dia eDiaPassando : mDias) {
            if (diaContador >= ei && diaContador <= eo) {
                if (eDiaPassando.getDia() == eDia) {
                    eDiaPassando.evento(eAviso, eEventoTipoDia.getTempoInicio(), eEventoTipoDia.getTempoFim());
                }
            }
            diaContador += 1;
        }

    }

    public void mes(Semana eDiaSemanal, int eQuantidade, String eMes, String eAno) {

        for (int i = 1; i <= eQuantidade; i++) {

            String sDia = String.valueOf(i);
            if (sDia.length() == 1) {
                sDia = "0" + sDia;
            }

            mDias.add(new Dia(sDia + "/" + eMes + "/" + eAno, eDiaSemanal));
            eDiaSemanal = proximoDia(eDiaSemanal);

        }

    }

    public Semana proximoDia(Semana hoje) {
        Semana eAmanha = hoje;

        if (hoje == Semana.Domingo) {
            eAmanha = Semana.Segunda;
        } else if (hoje == Semana.Segunda) {
            eAmanha = Semana.Terca;
        } else if (hoje == Semana.Terca) {
            eAmanha = Semana.Quarta;
        } else if (hoje == Semana.Quarta) {
            eAmanha = Semana.Quinta;
        } else if (hoje == Semana.Quinta) {
            eAmanha = Semana.Sexta;
        } else if (hoje == Semana.Sexta) {
            eAmanha = Semana.Sabado;
        } else if (hoje == Semana.Sabado) {
            eAmanha = Semana.Domingo;
        }

        return eAmanha;
    }


    public int getOrdem(String eDiaEscolhido) {
        int ret = 0;

        boolean enc = false;

        for (Dia eDia : mDias) {
            if (eDia.getData().contentEquals(eDiaEscolhido)) {
                enc = true;
                break;
            }
            ret += 1;
        }

        if (enc) {
            return ret;
        } else {
            return -1;
        }

    }
}
