package clientManager;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.ArrayList;

import model.Horarios;
import resources.GlobalVariables;

public class OrdutegiaClient {

	public OrdutegiaClient() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Get current loged user's timetable
	 * @return ArrayList<Horarios>
	 */
	public ArrayList<Horarios> getHorarios() {
		ArrayList<Horarios> horariosList = new ArrayList<Horarios>();
		try

		{
			Socket client = new Socket(GlobalVariables.serverIP, GlobalVariables.serverPort);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			ObjectInputStream dis = new ObjectInputStream(client.getInputStream());

			dos.writeUTF("getHorarios");
			dos.writeUTF(GlobalVariables.currentUser.getEmail());

			try {
				horariosList = (ArrayList<Horarios>) dis.readObject();
				for (Horarios h : horariosList) {
					System.out
							.println(h.getId().getDia() + " " + h.getId().getHora() + " " + h.getModulos().getNombre());
				}
				return horariosList;
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
	
	/**
	 * Returns teachers timetable
	 * @param email teacher's email
	 * @return ArrayList<Horarios>
	 */
	public static ArrayList<Horarios> getHorariosByTeachersEmail(String email) {
		ArrayList<Horarios> horariosList = new ArrayList<Horarios>();
		try

		{
			Socket client = new Socket(GlobalVariables.serverIP, GlobalVariables.serverPort);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			ObjectInputStream dis = new ObjectInputStream(client.getInputStream());

			dos.writeUTF("getHorarios");
			dos.writeUTF(email);

			try {
				horariosList = (ArrayList<Horarios>) dis.readObject();
				for (Horarios h : horariosList) {
					System.out
							.println(h.getId().getDia() + " " + h.getId().getHora() + " " + h.getModulos().getNombre());
				}
				return horariosList;
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
