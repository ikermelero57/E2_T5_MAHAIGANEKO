package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clientManager.UserClient;

public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tFEmail;
    private JPasswordField passwordField;
    private JLabel labelImagen;

    public LoginView() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 434, 330);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 153, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSaioa = new JLabel("HASI SAIOA");
        lblSaioa.setForeground(Color.WHITE);
        lblSaioa.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblSaioa.setBounds(137, 93, 165, 70);
        contentPane.add(lblSaioa);

        JLabel lblNewLabel = new JLabel("Email:");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(127, 158, 46, 14);
        contentPane.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(127, 206, 74, 14);
        contentPane.add(lblPassword);

        tFEmail = new JTextField();
        tFEmail.setBounds(127, 175, 206, 20);
        contentPane.add(tFEmail);
        tFEmail.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(127, 221, 204, 20);
        contentPane.add(passwordField);

        JButton btnLogIn = new JButton("Aurrera");
        btnLogIn.addActionListener(e -> login());
        btnLogIn.setBackground(Color.WHITE);
        btnLogIn.setForeground(Color.BLACK);
        btnLogIn.setBounds(127, 252, 122, 23);
        contentPane.add(btnLogIn);
        
        // Evento para cambiar el foco al campo de contraseña al presionar Enter
        tFEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordField.requestFocus();
                }
            }
        });
        
        // Evento para iniciar sesión al presionar Enter en la contraseña
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        ImageIcon icon = new ImageIcon("img/logo.png");
        Image img = icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(img);
        labelImagen = new JLabel(iconoEscalado);
        labelImagen.setBounds(73, 0, 260, 141);
        contentPane.add(labelImagen);

        JSeparator separator = new JSeparator();
        separator.setBounds(48, 145, 311, 14);
        contentPane.add(separator);
    }

    private void login() {
        UserClient userclient = new UserClient();
        userclient.login(tFEmail.getText(), new String(passwordField.getPassword()));
    }
}
