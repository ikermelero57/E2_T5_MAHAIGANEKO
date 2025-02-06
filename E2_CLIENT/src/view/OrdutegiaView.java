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
import resources.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;

public class OrdutegiaView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tabla;
    public DefaultTableModel modelo;

    public OrdutegiaView() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 466);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(102, 153, 255));
        setContentPane(contentPane);

        // Etiqueta principal
        JLabel lblNewLabel = new JLabel("ORDUTEGIA");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setBounds(389, 0, 232, 85);
        contentPane.add(lblNewLabel);

        // Botón para volver
        JButton btnGoBack = new JButton();
        btnGoBack.setBounds(334, 91, 313, 85);
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
        	Views.mainMenuView.setVisible(true);
        	Views.ordutegiaView.setVisible(false);
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
        scrollPane.setBounds(46, 244, 945, 151);
        contentPane.add(scrollPane);
        
        JButton btnNewButton = new JButton("Atzera bueltatu");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	Views.mainMenuView.setVisible(true);
            	Views.ordutegiaView.setVisible(false);
        	}
        });
        btnNewButton.setBounds(408, 204, 195, 23);
        contentPane.add(btnNewButton);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(167, 67, 687, 23);
        contentPane.add(separator);
    }
}
