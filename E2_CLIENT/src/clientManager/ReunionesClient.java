package clientManager;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.ArrayList;

import model.Horarios;
import model.Reuniones;
import resources.GlobalVariables;

public class ReunionesClient {

	public static void setReunionState(int idReunion, String state) {

		try
		{
			Socket client = new Socket(GlobalVariables.serverIP, GlobalVariables.serverPort);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			ObjectInputStream dis = new ObjectInputStream(client.getInputStream());

			dos.writeUTF("setReunionState");
			dos.writeInt(idReunion);
			dos.writeUTF(state);

			dos.close();
			dis.close();
			client.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static ArrayList<Reuniones> getReunionesByTeacher() {
		ArrayList<Reuniones> reunionesList = new ArrayList<Reuniones>();
		try

		{
			Socket client = new Socket(GlobalVariables.serverIP, GlobalVariables.serverPort);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			ObjectInputStream dis = new ObjectInputStream(client.getInputStream());

			dos.writeUTF("getReuniones");
			dos.writeUTF(GlobalVariables.currentUser.getEmail());

			try {
				reunionesList = (ArrayList<Reuniones>) dis.readObject();
				
				for(Reuniones r : reunionesList) {
                    System.out.println(r.getFecha() + " " + r.getAsunto() + " " + r.getEstado());
                }

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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

		return reunionesList;
	}
}
