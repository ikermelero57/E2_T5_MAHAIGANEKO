package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import clientManager.OrdutegiaClient;
import clientManager.UserClient;
import model.Horarios;
import model.Users;
import resources.GlobalVariables;
import resources.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class BilerakView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tabla;
    public DefaultTableModel modelo;

    public BilerakView() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1288, 692);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(102, 153, 255));
        setContentPane(contentPane);

        // Etiqueta principal
        JLabel lblNewLabel = new JLabel("BILERAK");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setBounds(426, 27, 232, 85);
        contentPane.add(lblNewLabel);

        // Botón para volver
        JButton btnGoBack = new JButton();
        btnGoBack.setBounds(119, 39, 293, 62);
        btnGoBack.setBackground(new Color(102, 153, 255));
        btnGoBack.setBorder(null);

        ImageIcon originalIcon = new ImageIcon("img/logo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(
                btnGoBack.getWidth(),
                btnGoBack.getHeight(),
                Image.SCALE_SMOOTH
        );
        btnGoBack.setIcon(new ImageIcon(scaledImage));

        btnGoBack.addActionListener(e -> {
        	views.mainMenuView.setVisible(true);
        	views.besteOrdutegiaView.setVisible(false);
        });
        contentPane.add(btnGoBack);
        
        //CREATE TABLE 
        String[] columnas = {"Hora", "L/A", "M/A", "X", "J/O", "V/O"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        tabla.setRowSelectionAllowed(false);
        tabla.setRowHeight(25);
        tabla.setFont(new Font("Arial", Font.PLAIN, 10));

        // Configurar tamaños de columnas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50); // Columna "Hora"
        for (int i = 1; i < columnas.length; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(120); // Columnas de los días
        }

        // Agregar tabla a JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(50, 150, 945, 151);
        contentPane.add(scrollPane);
        
        JButton btnNewButton = new JButton("Return");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	views.mainMenuView.setVisible(true);
            	views.bilerakView.setVisible(false);
        	}
        });
        btnNewButton.setBounds(750, 67, 245, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(1054, 90, 177, 211);
        contentPane.add(btnNewButton_1);
        
        JButton btnOnartu = new JButton("Onartu");
        btnOnartu.setBounds(1054, 328, 177, 211);
        contentPane.add(btnOnartu);
        
        JLabel lblNewLabel_1 = new JLabel("BILERAREN XEHETASUNAK:");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 21));
        lblNewLabel_1.setBounds(50, 338, 383, 52);
        contentPane.add(lblNewLabel_1);
    }
}
