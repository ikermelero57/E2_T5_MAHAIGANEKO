package clientManager;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Horarios;
import model.Users;
import resources.GlobalVariables;
import resources.views;
import view.LoginView;
import view.MainMenuView;

public class UserClient {

	public UserClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @return true if the login credentials apear on the db
	 */
	public void login(String email, String password) {
		try {
			Socket client = new Socket(GlobalVariables.serverIP, 54321);

			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			ObjectInputStream dis = new ObjectInputStream(client.getInputStream());

			dos.writeUTF("login");
			dos.writeUTF(email);
			dos.writeUTF(password);

			Boolean loginCredentialsOk = dis.readBoolean();
			System.out.println(loginCredentialsOk);
			if (loginCredentialsOk) {

				try {
					//READS THE USER SEND BY THE SERVER
					Users registeredUser = (Users) dis.readObject();
					
					//THE USERS TIPE IS = 3(tipe teacher)
					if (registeredUser.getTipos().getId() == 3) {
						GlobalVariables.currentUser = registeredUser;

						// Change selected teacher on BesteOrdutegiaView
						views.besteOrdutegiaView.lblTitle.setText(
								(registeredUser.getNombre() + " " + registeredUser.getApellidos() + "ren ORDUTEGIA")
										.toUpperCase());

						views.loginView.setVisible(false);
						views.mainMenuView.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(views.loginView, "Ikasleak ezin zarete sistemara sartu!",
								"KONTUZ!!", JOptionPane.ERROR_MESSAGE);
					}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(views.loginView, "Zure kredentzialak ez dira zuzenak!", "KONTUZ!!",
						JOptionPane.ERROR_MESSAGE);
			}

			dos.close();
			dis.close();
			client.close();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Gets db's all the teachers
	 * 
	 * @return ArrayList<Users>
	 */
	public ArrayList<Users> getTeachers() {
		ArrayList<Users> teachersList;

		try {
			Socket client = new Socket(GlobalVariables.serverIP, GlobalVariables.serverPort);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			ObjectInputStream dis = new ObjectInputStream(client.getInputStream());

			dos.writeUTF("getTeachers");

			try {
				teachersList = (ArrayList<Users>) dis.readObject();

				return teachersList;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			dos.close();
			dis.close();
			client.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
