package controler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import com.mysql.fabric.xmlrpc.Client;

import dao.DaoHorarios;
import dao.DaoReuniones;
import dao.DaoUser;
import dao.DaoIkastetxeak;
import model.Horarios;
import model.Ikastetxea;
import model.Reuniones;
import model.Users;

public class ServerThread extends Thread {

	DataInputStream inputManager;
	ObjectOutputStream objectOutputManager;
	//ObjectInputStream objectInputManager;

	public Socket client;

	public ServerThread(Socket client) {
		this.client = client;
		try {
			this.inputManager = new DataInputStream(client.getInputStream());
		//	this.objectInputManager = new ObjectInputStream(client.getInputStream());
			this.objectOutputManager = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String inputMessage = "";

		try {
			// READ USERS MESSAGE/ACCTION
			inputMessage = inputManager.readUTF();
			System.out.println("CLIENT: " + inputMessage);

			switch (inputMessage) {

			case "login":

				try {
					login();
				} catch (IOException e) {
					System.out.println("Error in login function");
					e.printStackTrace();
				}

				break;

			case "getHorarios":

				try {
					getHorarios();
				} catch (IOException e) {
					System.out.println("Error in getHorarios function");
					e.printStackTrace();
				}

				break;
			case "getHorariosByStudent":
				try {
					getHorariosByStudentId();
				} catch (IOException e) {
					System.out.println("Error in getHorarios function");
					e.printStackTrace();
				}

				break;
			case "getReuniones":

				try {
					getReuniones();
				} catch (IOException e) {
					System.out.println("Error in getReuniones function");
					e.printStackTrace();
				}

				break;
			case "setReunionState":

				try {
					setReunionState();
				} catch (IOException e) {
					System.out.println("Error in setReunionState function");
					e.printStackTrace();
				}

				break;
			case "getTeachers":

				try {
					getTeachers();
				} catch (IOException e) {
					System.out.println("Error in getTeachers function");
					e.printStackTrace();
				}

				break;
			case "getStudents":

				try {
					getStudents();
				} catch (Exception e) {
					System.out.println("Error in getIkastetxeak function");
					e.printStackTrace();
				}

				break;

			case "getIkastetxeak":

				try {
					getIkastetxeak();
				} catch (Exception e) {
					System.out.println("Error in getIkastetxeak function");
					e.printStackTrace();
				}

				break;
			case "pasahitzaAldatu":
				try {
					pasahitzaAldatu();
				} catch (IOException e) {
					System.out.println("Error in pasahitzaAldatu function");
					e.printStackTrace();
				}
				break;
			
				
			}
            // CLOSE CONNECTION
			
			objectOutputManager.close();
			inputManager.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void login() throws IOException {
		Boolean loginCredentialsOk = false;

		String email = inputManager.readUTF();
		String password = inputManager.readUTF();

		DaoUser daoUsers = new DaoUser();
		loginCredentialsOk = daoUsers.login(email, password);

		objectOutputManager.writeBoolean(loginCredentialsOk);
		objectOutputManager.flush(); // Asegúrate de enviar inmediatamente el resultado

		if (loginCredentialsOk) {
			Users user = daoUsers.getUserByEmail(email);
			objectOutputManager.writeObject(user); // Enviar el objeto usuario
			objectOutputManager.flush(); // Asegúrate de enviar los datos
		}
	}

	public void getHorarios() throws IOException {
		DaoHorarios daoHorarios = new DaoHorarios();
		String email = inputManager.readUTF();

		ArrayList<Horarios> horariosList = daoHorarios.getHorariosByTeachersEmail(email);

		// SEND HORARIOS OBJECT TO CLIENT
		if (horariosList != null) {
			objectOutputManager.writeObject(horariosList);
		} else {
			System.out.println("Horarios not found");
			objectOutputManager.writeObject(null);
		}
	}

	public void getReuniones() throws IOException {
		DaoReuniones daoReuniones = new DaoReuniones();
		String email = inputManager.readUTF();

		ArrayList<Reuniones> reunionesList = daoReuniones.getReunionesByUsersEmail(email);

		// SEND REUNIONES OBJECT TO CLIENT
		if (reunionesList != null) {
			objectOutputManager.writeObject(reunionesList);
		} else {
			System.out.println("Reuniones not found");
			objectOutputManager.writeObject(null);
		}
	}

	public void setReunionState() throws IOException {
		DaoReuniones daoReuniones = new DaoReuniones();
		int idReunion = inputManager.readInt();

		String state = inputManager.readUTF();
		// UPDATE REUNION STATE
		daoReuniones.updateReunionState(idReunion, state);
	}

	public void getTeachers() throws IOException {
		DaoUser daoUser = new DaoUser();
		ArrayList<Users> teacherList = daoUser.getTeachers();
		// SEND TEACHERS OBJECT ARRAYLIST TO CLIENT
		if (teacherList != null) {
			objectOutputManager.writeObject(teacherList);
		} else {
			System.out.println("Teachers not found");
		}
	}

	public void getStudents() throws IOException {
		DaoUser daoUser = new DaoUser();
		ArrayList<Users> studentList = daoUser.getStudents();
		// SEND TEACHERS OBJECT ARRAYLIST TO CLIENT
		if (studentList != null) {
			objectOutputManager.writeObject(studentList);
			for(Users st : studentList) {
                System.out.println(st);
				
			}
		} else {
			System.out.println("Students not found");
		}

	}

	public void getIkastetxeak() {
		ArrayList<Ikastetxea> ikastetxeaList = DaoIkastetxeak.getIkastetxeak();

		// SEND IKASTETXEAK OBJECT ARRAYLIST TO CLIENT
		if (ikastetxeaList != null) {
			try {
				objectOutputManager.writeObject(ikastetxeaList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Ikastetxeak not found");
		}

	}

	public void getHorariosByStudentId() throws IOException {
		DaoHorarios daoHorarios = new DaoHorarios();
		String email = inputManager.readUTF();
		ArrayList<Horarios> horariosList = (ArrayList<Horarios>) daoHorarios.getHorariosByStudentId(email);

		// SEND HORARIOS OBJECT TO CLIENT
		if (horariosList != null) {
			objectOutputManager.writeObject(horariosList);
		} else {
			System.out.println("Horarios not found");
			objectOutputManager.writeObject(null);
		}
	}
	
	public void pasahitzaAldatu() throws IOException {
		DaoUser daoUser = new DaoUser();
		Emails emails = new Emails();
		String email = inputManager.readUTF();
		
		String pasahitza = daoUser.changePassword(email);
		emails.sendEmail(email, "Pasahitza aldatuta", "Pasahitza aldatu da: " + pasahitza);
	}
	
//	public void addReunion() {
//		DaoReuniones daoReuniones = new DaoReuniones();
//		Reuniones reunion = new Reuniones();
//        try {
//			Reuniones newReunion = (Reuniones) objectInputManager.readObject();
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
//        daoReuniones.addReunion(reunion);
//        reunion.getUsersByProfesorId();
//	}
	
}
