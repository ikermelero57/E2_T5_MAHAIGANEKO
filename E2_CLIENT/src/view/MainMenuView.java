package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clientManager.OrdutegiaClient;
import model.Horarios;
import resources.GlobalVariables;
import resources.views;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private ImageIcon icon;
	private Image img;
	private ImageIcon iconoEscalado;
	private JLabel labelImagen;

	public MainMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(LoginView.getFrames()[0]);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon fotoE = new ImageIcon("img/logo.png");
 
		JLabel foto = new JLabel(fotoE);
		
		icon = new ImageIcon("img/logo.png");
		img = icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH);
		iconoEscalado = new ImageIcon(img);
		labelImagen = new JLabel(iconoEscalado);
		labelImagen.setBounds(115, 0, 222, 86);
		contentPane.add(labelImagen);
		
		JLabel lblMainMenu = new JLabel((String) null);
		lblMainMenu.setBounds(279, 31, 46, 14);
		contentPane.add(lblMainMenu);
		
		JButton btnDisconect = new JButton("Deskonektatu");
		btnDisconect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GlobalVariables.currentUser = null;
				views.loginView.setVisible(true);
			    views.mainMenuView.setVisible(false);
				
			}
		});
		btnDisconect.setBounds(31, 91, 376, 23);
		contentPane.add(btnDisconect);
		
		JButton btnGetOrdutegia = new JButton("Ordutegia");
		btnGetOrdutegia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				views.mainMenuView.setVisible(false);
				views.ordutegiaView.setVisible(true);
				ArrayList<Horarios> horarios;
				views.fillTable(horarios = new OrdutegiaClient().getHorarios(), views.ordutegiaView.modelo);
			}
		});
		btnGetOrdutegia.setBounds(31, 125, 376, 23);
		contentPane.add(btnGetOrdutegia);
		
		JButton btnGetBesteOrdutegia = new JButton("Beste ordutegia");
		btnGetBesteOrdutegia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				views.mainMenuView.setVisible(false);
				views.besteOrdutegiaView.setVisible(true);
				ArrayList<Horarios> horariosList;
				views.fillTable(horariosList = new OrdutegiaClient().getHorarios(), views.besteOrdutegiaView.modelo);
			}
		});
		btnGetBesteOrdutegia.setBounds(31, 159, 376, 23);
		contentPane.add(btnGetBesteOrdutegia);
		
		JButton btnGetBilerak = new JButton("Bilerak kontsultatu");
		btnGetBilerak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.mainMenuView.setVisible(false);
				views.bilerakView.setVisible(true);
			}
		});
		btnGetBilerak.setBounds(31, 193, 376, 23);
		contentPane.add(btnGetBilerak);

	}
}
