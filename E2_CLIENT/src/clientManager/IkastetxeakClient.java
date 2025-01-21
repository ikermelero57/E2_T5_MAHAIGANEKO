package clientManager;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.ArrayList;

import model.Horarios;
import model.Ikastetxea;
import resources.GlobalVariables;

public class IkastetxeakClient {

	public static void main(String[] args) {
		System.out.println("Ikastetxeak:");
		try {
			ArrayList<Ikastetxea> ikastetxeList = getIkastetxe();
			for (Ikastetxea i : ikastetxeList) {
				System.out.println(i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Ikastetxea> getIkastetxe() {
		ArrayList<Ikastetxea> ikastetxeList = new ArrayList<Ikastetxea>();

		try{
			Socket client = new Socket(GlobalVariables.serverIP, GlobalVariables.serverPort);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			ObjectInputStream dis = new ObjectInputStream(client.getInputStream());

			dos.writeUTF("getIkastetxeak");

			try {
				ikastetxeList = (ArrayList<Ikastetxea>) dis.readObject();
				for (Ikastetxea i : ikastetxeList) {
					System.out
							.println(i);
				}
				return ikastetxeList;
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

		return ikastetxeList;
	}
}
