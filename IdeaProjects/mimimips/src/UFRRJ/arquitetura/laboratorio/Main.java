package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 23/06/17.
 */
public class Main {

    public static void main(String[] args) {

       Memoria.memValor[1] = 12;

        String teste = "lw $t2, 4($t0)";

        Montador montador = new Montador();
        //teste = "mfhi $t2";
        montador.montar(teste);
        Interpretador interpretador = new Interpretador();

        ConjuntoRegistradores.Registradores[8].setValor(0);
        ConjuntoRegistradores.Registradores[9].setValor(7);


        interpretador.interpretar();
        System.out.println(ConjuntoRegistradores.Registradores[10].getValor());

        System.out.println();
    }
}
