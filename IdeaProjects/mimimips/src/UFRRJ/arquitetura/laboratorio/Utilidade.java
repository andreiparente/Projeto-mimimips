package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 26/06/17.
 */
public class Utilidade{

    public static void binarizer(int indiceInicialDesejado, int[]padraoBinario, int binarioDesejado, int indiceFinalDesejado)
    {
        if(binarioDesejado >= 0) {
            for (int i = indiceFinalDesejado; i >= indiceInicialDesejado; i--) {
                if (binarioDesejado > 0) {
                    padraoBinario[i] = binarioDesejado % 2;
                    binarioDesejado = binarioDesejado / 2;

                } else
                    padraoBinario[i] = 0;
            }
        }

        else
        {
            binarioDesejado *= -1;

            for (int i = indiceFinalDesejado; i >= indiceInicialDesejado; i--) {
                if (binarioDesejado > 0) {
                    padraoBinario[i] = binarioDesejado % 2;
                    binarioDesejado = binarioDesejado / 2;

                } else
                    padraoBinario[i] = 0;
            }

            for (int i = indiceFinalDesejado; i >= indiceInicialDesejado; i--) {
                if(padraoBinario[i] == 1) {
                    i--;
                    while (i >= indiceInicialDesejado) {
                        if (padraoBinario[i] == 0)
                            padraoBinario[i]++;
                        else
                            padraoBinario[i]--;

                        i--;
                    }

                }
            }

        }
    }

    public static void binarizer(int indiceInicialDesejado, long[]padraoBinario, long binarioDesejado, int indiceFinalDesejado)
    {
        if(binarioDesejado >= 0) {
            for (int i = indiceFinalDesejado; i >= indiceInicialDesejado; i--) {
                if (binarioDesejado > 0) {
                    padraoBinario[i] = (binarioDesejado % 2);
                    binarioDesejado = binarioDesejado / 2;

                } else
                    padraoBinario[i] = 0;
            }
        }

        else {
            binarioDesejado *= -1;

            for (int i = indiceFinalDesejado; i >= indiceInicialDesejado; i--) {
                if (binarioDesejado > 0) {
                    padraoBinario[i] = binarioDesejado % 2;
                    binarioDesejado = binarioDesejado / 2;

                } else
                    padraoBinario[i] = 0;
            }

            for (int i = indiceFinalDesejado; i >= indiceInicialDesejado; i--) {
                if (padraoBinario[i] == 1) {
                    i--;
                    while (i >= indiceInicialDesejado) {
                        if (padraoBinario[i] == 0)
                            padraoBinario[i]++;
                        else
                            padraoBinario[i]--;

                        i--;
                    }


                }

            }
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
