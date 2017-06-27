package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 26/06/17.
 */
public class Utilidade{

    public static void binarizer(int indiceInicialDesejado, int[]padraoBinario, int binarioDesejado, int indiceFinalDesejado)
    {
        for(int i = indiceFinalDesejado; i>= indiceInicialDesejado; i--)
        {
            if(binarioDesejado > 0)
            {
                padraoBinario[i] = binarioDesejado % 2;
                binarioDesejado = binarioDesejado / 2;

            }

            else
                padraoBinario[i] = 0;
        }
    }
}
