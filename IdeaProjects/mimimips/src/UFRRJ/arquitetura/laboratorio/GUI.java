package UFRRJ.arquitetura.laboratorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by windows on 03/07/17.
 */
public class GUI {
    private JTextArea textArea1;
    private JButton button1;
    private JPanel aaa;
    private JTable table1;
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

        button1.addActionListener(e -> {
            String teste;
            teste = textArea1.getText();
            montador.montar(teste);
            interpretador.interpretar();
            System.out.println(ConjuntoRegistradores.Registradores[10].getValor());
        });


        table1.addComponentListener(new ComponentAdapter() {


            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }
        });
    }
}
