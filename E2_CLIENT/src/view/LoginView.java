package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientManager.UserClient;
import model.Users;
import resources.GlobalVariables;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private ImageIcon icon;
	private Image img;
	private ImageIcon iconoEscalado;
	private JLabel labelImagen;
	
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaioa = new JLabel("HASI SAIOA");
		lblSaioa.setForeground(new Color(255, 255, 255));
		lblSaioa.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSaioa.setBounds(245, 18, 165, 70);
		contentPane.add(lblSaioa);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(80, 100, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(52, 135, 74, 14);
		contentPane.add(lblPassword);
		
		JTextField tFEmail = new JTextField();
		tFEmail.setBounds(161, 99, 206, 20);
		contentPane.add(tFEmail);
		tFEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 134, 204, 20);
		contentPane.add(passwordField);
		
		JButton btnLogIn = new JButton("Aurrera");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserClient userclient = new UserClient();
				userclient.login(tFEmail.getText(), passwordField.getText());
				
			}
		});
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.setForeground(new Color(0, 0, 0));
		btnLogIn.setBounds(161, 179, 89, 23);
		contentPane.add(btnLogIn);
		
		
		
		ImageIcon fotoE = new ImageIcon("img/logo.png");

		JLabel foto = new JLabel(fotoE);
		
		icon = new ImageIcon("img/logo.png");
		img = icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		iconoEscalado = new ImageIcon(img);
		labelImagen = new JLabel(iconoEscalado);
		labelImagen.setBounds(10, 6, 222, 86);
		contentPane.add(labelImagen);
	}
}
