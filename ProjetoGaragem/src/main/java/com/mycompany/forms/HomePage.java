package com.mycompany.forms;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    private JPanel titlePanel;
    private JPanel contentPanel;
    private JLabel lblTitle;
    private JLabel lblWelcome;

    public HomePage(){

        //Configuração da Janela
        this.setTitle("Projeto Garagem");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xffffff));
        this.setResizable(false);

        //Painel de Titulo
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(0xf4f4f4));
        titlePanel.setPreferredSize(new Dimension(800, 200));
        this.add(titlePanel, BorderLayout.NORTH);

        //Título
        JLabel lblTitle = new JLabel();
        lblTitle.setText("Estacionamento Rotativo");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(Color.black);
        lblTitle.setVerticalAlignment(JLabel.TOP);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(lblTitle, BorderLayout.NORTH);

        //Menssagem de Boas vindas
        JLabel lblWelcome = new JLabel();
        lblWelcome.setText("<html><div style='width:300px;'>Bem-vindo ao sistema de estacionamento rotativo! Aqui você pode cadastrar clientes, calcular o valor de uso do estacionamento e acompanhar a ocupação das vagas em tempo real de forma simples e eficiente.</div></html>");
        lblWelcome.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(lblWelcome, BorderLayout.CENTER);

    }

}
