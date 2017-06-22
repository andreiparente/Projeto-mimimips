package UFRRJ.arquitetura.laboratorio;

import java.util.HashMap;

/**
 * Created by Guilherme Cruz Freitas on 22/06/17.
 */
public class ConjuntoResgistradores {

    /**conjunto de todos os 32 registradores, feito com vetor ao invés de arraylist pois o número do registrador
     * será seu indice
     */

    //protected HashMap<String, Registrador> registradorMap;

    protected Registrador[] Registradores={
            new Registrador("$zero", 0, 0),
            new Registrador("$at", 1, 0),
            new Registrador("$v0", 2, 0),
            new Registrador("$v1", 3, 0),
            new Registrador("$a0", 4, 0),
            new Registrador("$a1", 5, 0),
            new Registrador("$a2", 6, 0),
            new Registrador("$a3", 7, 0),
            new Registrador("$t0", 8, 0),
            new Registrador("$t1", 9, 0),
            new Registrador("$t2", 10, 0),
            new Registrador("$t3", 11, 0),
            new Registrador("$t4", 12, 0),
            new Registrador("$t5", 13, 0),
            new Registrador("$t6", 14, 0),
            new Registrador("$t7", 15, 0),
            new Registrador("$s0", 16, 0),
            new Registrador("$s1", 17, 0),
            new Registrador("$s2", 18, 0),
            new Registrador("$s3", 19, 0),
            new Registrador("$s4", 20, 0),
            new Registrador("$s5", 21, 0),
            new Registrador("$s6", 22, 0),
            new Registrador("$s7", 23, 0),
            new Registrador("$t8", 24, 0),
            new Registrador("$t9", 25, 0),
            new Registrador("$k0", 26, 0),
            new Registrador("$k1", 27, 0),
            new Registrador("$gp", 28, 268468224),
            new Registrador("$sp", 29, 2147479548),
            new Registrador("$fp", 30, 0),
            new Registrador("$ra", 31, 0),

    };

    /**
     * implementação futura dos registradores pc hi lo
     */


    /**
     * conjunto de funções para setar, regatar etc informções dos registradores
     */


    /*public ConjuntoResgistradores() {
        registradorMap = new HashMap<>();

        registradorMap.put("$zero", new Registrador("$zero", 0, 0));
        registradorMap.put("$at", new Registrador("$at", 1, 0));
        registradorMap.put("$v0", new Registrador("$v0", 2, 0));
        registradorMap.put("$v1", new Registrador("$v1", 3, 0))
                new Registrador("$a0", 4, 0),
                new Registrador("$a1", 5, 0),
                new Registrador("$a2", 6, 0),
                new Registrador("$a3", 7, 0),
                new Registrador("$t0", 8, 0),
                new Registrador("$t1", 9, 0),
                new Registrador("$t2", 10, 0),
                new Registrador("$t3", 11, 0),
                new Registrador("$t4", 12, 0),
                new Registrador("$t5", 13, 0),
                new Registrador("$t6", 14, 0),
                new Registrador("$t7", 15, 0),
                new Registrador("$s0", 16, 0),
                new Registrador("$s1", 17, 0),
                new Registrador("$s2", 18, 0),
                new Registrador("$s3", 19, 0),
                new Registrador("$s4", 20, 0),
                new Registrador("$s5", 21, 0),
                new Registrador("$s6", 22, 0),
                new Registrador("$s7", 23, 0),
                new Registrador("$t8", 24, 0),
                new Registrador("$t9", 25, 0),
                new Registrador("$k0", 26, 0),
                new Registrador("$k1", 27, 0),
                new Registrador("$gp", 28, 268468224),
                new Registrador("$sp", 29, 2147479548),
                new Registrador("$fp", 30, 0);
                new Registrador("$ra", 31, 0);
    }

    public void setValorRegistrador(String nome, int valor)
    {
        registradorMap.get(nome).setValor(valor);
        for(int i = 0; i<32; i++)
        {
            if(nome == "$zero"  || nome == "$at")
            {
                break;
            }
            else if(Registradores[i].getNome() == nome)
            {
                Registradores[i].setValor(valor);
                break;
            }
        }
    }*/

    public int getValorRegistrador(String nome)
    {
        for(int i = 0; i<32; i++)
        {
            if(Registradores[i].getNome().equals(nome))
            {
                return Registradores[i].getValor();
            }
        }

        return 0;
    }

    public int getValorRegistrador(int numero)
    {
        for(int i = 0; i<32; i++)
        {
            if(Registradores[i].getNumero() == numero)
            {
                return Registradores[i].getValor();
            }
        }
        return 0;
    }





}
