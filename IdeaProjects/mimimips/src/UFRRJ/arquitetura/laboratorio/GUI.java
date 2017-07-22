package UFRRJ.arquitetura.laboratorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by windows on 03/07/17.
 */
public class GUI {
    private JTextArea textArea1;
    private JButton button1;
    private JPanel aaa;
    private JTable Registradores;
    private Montador montador;
    Interpretador interpretador;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().aaa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public GUI() {

        montador = new Montador();
        interpretador = new Interpretador();
        ConjuntoRegistradores.Registradores[8].setValor(2);
        ConjuntoRegistradores.Registradores[9].setValor(2);
        String[] colunas = {"Registrador","Número","Valor"};
        String[][] dados = {{"a"}};

        DefaultTableModel res = new DefaultTableModel();
        res.setColumnIdentifiers(colunas);

        Registradores.setModel(res);

        button1.addActionListener(e -> {
            String teste;
            teste = textArea1.getText();//pega toodo o texto e manda para uma string a ser tokenizada e jogada no montador
            montador.montar(teste);//monta e joga na memoria
            interpretador.interpretar();//pega na memoria e interpreta
            System.out.println(ConjuntoRegistradores.Registradores[10].getValor());//printa no terminal, é provisório, apenas para acompanharmos como está indo
            System.out.println(dados[0][0]);



        });




    }


}
