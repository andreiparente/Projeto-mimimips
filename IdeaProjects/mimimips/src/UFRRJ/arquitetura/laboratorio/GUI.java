package UFRRJ.arquitetura.laboratorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by windows on 03/07/17.
 */
public class GUI {
    private JTextArea campoDeCodigo;
    private JButton compilar;
    private JPanel Janela;
    private JTable Registradores;
    private JTabbedPane tabbedPane1;
    private JPanel Código;
    private JTable table1;
    private Montador montador;
    Interpretador interpretador;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().Janela);
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

        DefaultTableModel res = new DefaultTableModel();
        res.setColumnIdentifiers(colunas);



        Registradores.setModel(res);

        compilar.addActionListener(e -> {
            String teste;
            teste = campoDeCodigo.getText();//pega toodo o texto e manda para uma string a ser tokenizada e jogada no montador
            montador.montar(teste);//monta e joga na memoria
            interpretador.interpretar();//pega na memoria e interpreta
            System.out.println(ConjuntoRegistradores.Registradores[10].getValor());//printa no terminal, é provisório, apenas para acompanharmos como está indo

            while(res.getRowCount()>0){
                res.removeRow(0);}
            for (int index = 0; index < 35; index++)
            {
                res.addRow(new Object[]{ConjuntoRegistradores.Registradores[index].getNome(),
                                        ConjuntoRegistradores.Registradores[index].getValor(),
                                        ConjuntoRegistradores.Registradores[index].getValor()}
                                        );
            }

            for (int index = 0; index < 35; index++)
            {
                ConjuntoRegistradores.Registradores[index].setValor(ConjuntoRegistradores.Registradores[index].getValorBase());
            }

            ConjuntoRegistradores.Registradores[8].setValor(2);
            ConjuntoRegistradores.Registradores[9].setValor(2);

        });
    }
}
