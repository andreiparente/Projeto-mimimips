package UFRRJ.arquitetura.laboratorio;

import java.util.ArrayList;

/**
 * Created by windows on 29/06/17.
 */
public class Memoria {

    public static int[] memValor = new int[128];//memoria que irá guardar os storewords etc
    public static ArrayList<Integer> memWord = new ArrayList<Integer>();//memoria que irá guadar as words, array list pq vai ter que ser em sequencia msm, então meh
    //todo lógica do stackpointer


    public static int index = 0;//index global que irá ser a quantidade de words até o momento, vai servir de guia na hora de percorre-la


}
