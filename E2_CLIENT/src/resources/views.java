package resources;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import clientManager.OrdutegiaClient;
import clientManager.UserClient;
import model.Horarios;
import model.Users;
import view.BesteOrdutegiaView;
import view.BilerakView;
import view.LoginView;
import view.MainMenuView;
import view.OrdutegiaView;

public class views {
	
	public static LoginView loginView;
	public static BesteOrdutegiaView besteOrdutegiaView;
	public static OrdutegiaView ordutegiaView;
	public static MainMenuView mainMenuView;
	public static BilerakView bilerakView;

    /**
     * fills the table received by parameter with the data from the arrayList also received by parameter
     * @param horariosList
     * @param modelo
     */
	public static void fillTable(ArrayList<Horarios> horariosList, DefaultTableModel modelo) {
	    	
	        String[] days = {"L/A", "M/A", "X", "J/O", "V/O"};
	        int maxHours = 5;
	        HashMap<String, String[]> horario = new HashMap<>();

	        for (String day : days) {
	            horario.put(day, new String[maxHours]);
	            for (int i = 0; i < maxHours; i++) {
	                horario.get(day)[i] = "";
	            }
	        }

	        for (Horarios h : horariosList) {
	            String dia = h.getId().getDia();
	            int hora = Integer.parseInt(h.getId().getHora()+"");
	            String asignatura = h.getModulos().getNombre();
	            if (horario.containsKey(dia)) {
	                horario.get(dia)[hora - 1] = asignatura;
	            }
	        }

	        modelo.setRowCount(0);

	        for (int i = 0; i < maxHours; i++) {
	            Object[] fila = new Object[days.length + 1];
	            fila[0] = (i + 1) + "";
	            for (int j = 0; j < days.length; j++) {
	                fila[j + 1] = horario.get(days[j])[i];
	            }
	            modelo.addRow(fila);
	        }
	    }
	
}
