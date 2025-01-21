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

public class BesteOrdutegiaView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tabla;
    public DefaultTableModel modelo;
    public JLabel lblTitle;

    public BesteOrdutegiaView() {
    	
        ArrayList<Users> teachersList = new UserClient().getTeachers();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(102, 153, 255));
        setContentPane(contentPane);
        
    	// Etiqueta principal
        lblTitle = new JLabel(" ORDUTEGIA");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblTitle.setBounds(46, 111, 945, 85);
        contentPane.add(lblTitle);
        // Botón para volver
        JButton btnGoBack = new JButton();
        btnGoBack.setBounds(327, 38, 293, 62);
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
        	views.besteOrdutegiaView.setVisible(false);
        	views.mainMenuView.setVisible(true);
        });
        contentPane.add(btnGoBack);

        // ComboBox Teachers
        JComboBox<String> comboTeachers = new JComboBox<>();
        comboTeachers.setBounds(715, 47, 276, 21);
        contentPane.add(comboTeachers);

        for (Users teacher : teachersList) {
            comboTeachers.addItem(teacher.getNombre() + " " + teacher.getApellidos());
        }

        // ComboBox listener
        comboTeachers.addActionListener(e -> {
            int selectedIndex = comboTeachers.getSelectedIndex();
            if (selectedIndex != -1) {
            	
                Users selectedTeacher = teachersList.get(selectedIndex);
                
                System.out.println("Teacher selected: " + selectedTeacher.getUsername());
                
                ArrayList<Horarios> horariosPorProfesor = OrdutegiaClient.getHorariosByTeachersEmail(selectedTeacher.getEmail());
                
                views.fillTable(horariosPorProfesor, modelo);
                
                lblTitle.setText((selectedTeacher.getNombre()+" "+selectedTeacher.getApellidos()+"ren ORDUTEGIA").toUpperCase());
            }
        });

        //Create table and his model
        String[] columnas = {"Hora", "L/A", "M/A", "X", "J/O", "V/O"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        tabla.setRowSelectionAllowed(false);
        tabla.setRowHeight(25);
        tabla.setFont(new Font("Arial", Font.PLAIN, 10));

        //Configure table columns size
        tabla.getColumnModel().getColumn(0).setPreferredWidth(25); //Column hora
        for (int i = 1; i < columnas.length; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(120); //Column day
        }

        //Add table to the sroll panel
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(46, 233, 945, 151);
        contentPane.add(scrollPane);
        
        JButton btnNewButton = new JButton("Return");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	views.mainMenuView.setVisible(true);
            	views.besteOrdutegiaView.setVisible(false);
        	}
        });
        btnNewButton.setBounds(715, 79, 276, 23);
        contentPane.add(btnNewButton);
        
        
        
  
    }
}
