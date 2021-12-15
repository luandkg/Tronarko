package Khronum;

public class MinhaAgenda extends AgendaCreator {

    public void init_2021() {


        mes(Semana.Segunda, 30, "11", "2021");
        mes(Semana.Quarta, 31, "12", "2021");


        // TODOS OS DIAS
        agendarTodoDia("13/08/2021", "31/12/2021", "07:00", "10:00", "Hora de Acordar Luan !");
        agendarTodoDia("13/08/2021", "31/12/2021", "11:30", "12:30", "Tá com fome Luan ?");
        agendarTodoDia("13/08/2021", "31/12/2021", "22:00", "24:00", "Hora de Dormir Luan !");

        // DURANTE A SEMANA
        agendarDuranteASemana("13/08/2021", "22/12/2021", "12:30", "13:30", "Vamos Trabalhar Luan ?");
        agendarDuranteASemana("13/08/2021", "22/12/2021", "13:30", "17:30", "Trabalhando");
        agendarDuranteASemana("13/08/2021", "22/12/2021", "18:30", "18:59", "Vamos se preparando para assistir aula na UnB !");
        agendarDuranteASemana("13/08/2021", "22/12/2021", "19:00", "22:30", "Hora de Estudar - UnB");

        // FIM DE SEMANA
        agendarFimDeSemana("13/08/2021", "31/12/2021", "08:00", "10:00", "Momento Desenvolvedor JAVA");

        agendarDia("13/08/2021", "31/12/2021", Semana.Domingo, "16:00", "18:30", "Corridinha - Parque da Cidade");


        mostrarAgenda();
        guardarAgenda("res/agenda.js");

    }

}
