package UFRRJ.arquitetura.laboratorio;

/**
 * Created by Guilherme Cruz Freitas on 21/06/17.
 */

//possíveis novos campos: descrição da utilização devida do tipo do registrador
public class Registrador {

    private final String nome;// $
    private final int valorBase;// valor inicial 0 ou no caso de ponteiros o referente a memora ($sp ou $gp)
    private int valor;//valor passado pelo usuario
    private final int numero;// numero do registrador e tambem o indice do vetor que irá ser o conjunto de registradores


    public Registrador(String nome, int numero, int valorBase) {
        this.nome = nome;
        this.valorBase = valorBase;
        this.valor = valorBase;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getValorBase() {
        return valorBase;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }


}
