package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 23/06/17.
 */
public class Main {

    public static void main(String[] args) {

        Montador montador = new Montador();

        //Memoria.memValor[2] = 13;

        String teste = "jal 1000";
        montador.montar(teste);
        //teste = "blez $t1, 666";
        //montador.montar(teste);
        Interpretador interpretador = new Interpretador();

        ConjuntoRegistradores.Registradores[8].setValor(-5);
        ConjuntoRegistradores.Registradores[9].setValor(-1);


        interpretador.interpretar();
        //System.out.println(Memoria.memValor[2]);
        System.out.println(ConjuntoRegistradores.Registradores[31].getValor());
        System.out.println(ConjuntoRegistradores.Registradores[32].getValor());

        System.out.println();
    }
}
