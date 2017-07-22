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

    public static long desBinarizerWord(long palavra, int[] padraoBinario) {
        int expoente = 31;
        for (int i = 0; i < 32; i++) {

            if (padraoBinario[i] > 0) {
                palavra += Math.pow(2, expoente);
            }
            expoente--;
        }
        return palavra;
    }
}
