
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import clientManager.IkastetxeakClient;
import clientManager.OrdutegiaClient;
import clientManager.ReunionesClient;
import model.Horarios;
import model.Ikastetxea;
import model.Reuniones;
import resources.Availables;
import resources.Views;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;

public class BilerakView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public DefaultTableModel modelo;
	public JTable table;
	private Reuniones selectedReunion;
	public ArrayList<Reuniones> reunionesList;

	public BilerakView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(102, 153, 255));
		setContentPane(contentPane);
		// Etiqueta principal
		JLabel lblNewLabel = new JLabel("BILERAK");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(425, 11, 232, 85);
		contentPane.add(lblNewLabel);
		// Botón para volver
		JButton btnGoBack = new JButton();
		btnGoBack.setBounds(353, 107, 316, 103);
		btnGoBack.setBackground(new Color(102, 153, 255));
		btnGoBack.setBorder(null);
		ImageIcon originalIcon = new ImageIcon("img/logo.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(btnGoBack.getWidth(), btnGoBack.getHeight(),
				Image.SCALE_SMOOTH);
		btnGoBack.setIcon(new ImageIcon(scaledImage));
		btnGoBack.addActionListener(e -> {
			Views.mainMenuView.setVisible(true);
			Views.bilerakView.setVisible(false);
		});

		contentPane.add(btnGoBack);
		JButton btnNewButton = new JButton("Atzera bueltatu");
		btnNewButton.addActionListener(e -> {
			Views.mainMenuView.setVisible(true);
			Views.bilerakView.setVisible(false);
		});

		btnNewButton.setBounds(642, 448, 366, 23);
		contentPane.add(btnNewButton);

		JButton btnEzeztatu = new JButton("<html><center>EZEZTATU<br>BILERA</center></html>");
		btnEzeztatu.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Views.bilerakView, "BILERA EZEZTATU EGIN DA", "ADI !",
						JOptionPane.INFORMATION_MESSAGE);
				ReunionesClient.setReunionState(selectedReunion.getIdReunion(), "Ezeztatuta");
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Views.bilerakView.fillTableWReuniones();
			}
		});
		btnEzeztatu.setBounds(642, 508, 159, 115);
		contentPane.add(btnEzeztatu);
		btnEzeztatu.setEnabled(false);

		JButton btnOnartu = new JButton("<html><center>ONARTU<br>BILERA</center></html>");
		btnOnartu.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnOnartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Views.bilerakView, "BILERA ONARTU EGIN DA", "ADI !",
						JOptionPane.INFORMATION_MESSAGE);
				ReunionesClient.setReunionState(selectedReunion.getIdReunion(), "Onartuta");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				Views.bilerakView.fillTableWReuniones();
			}
		});
		btnOnartu.setBounds(849, 508, 159, 115);
		contentPane.add(btnOnartu);
		btnOnartu.setEnabled(false);

		JLabel lblNewLabel_1 = new JLabel("BILERAREN KOKAPENAREN XEHETASUNAK:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNewLabel_1.setBounds(60, 429, 550, 52);
		contentPane.add(lblNewLabel_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 233, 958, 185);
		contentPane.add(scrollPane);
		// Configuración de la tabla
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "NOREKIN", "IZENBURUA", "GAIA", "EGOERA", "GELA", "DATA" });
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		// KOkAPENAREN XEHEATASUNAK:
		JLabel lblIzena = new JLabel();
		lblIzena.setForeground(new Color(255, 255, 255));
		lblIzena.setBounds(250, 492, 210, 14);
		contentPane.add(lblIzena);

		JLabel lblKokapena = new JLabel();
		lblKokapena.setForeground(new Color(255, 255, 255));
		lblKokapena.setBounds(250, 529, 316, 14);
		contentPane.add(lblKokapena);

		JLabel lblKontaktuEmail = new JLabel();
		lblKontaktuEmail.setForeground(new Color(255, 255, 255));
		lblKontaktuEmail.setBounds(250, 569, 210, 14);
		contentPane.add(lblKontaktuEmail);

		JLabel lblKontaktuTelf = new JLabel();
		lblKontaktuTelf.setForeground(new Color(255, 255, 255));
		lblKontaktuTelf.setBounds(250, 605, 210, 14);
		contentPane.add(lblKontaktuTelf);

		JLabel lblNewLabel_2 = new JLabel("IZENA:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(100, 492, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("HELBIDEA:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(100, 529, 98, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("KONTAKTU EMAIL:");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setBounds(100, 569, 116, 14);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("KONTAKTU TELEFONOA:");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setBounds(100, 605, 210, 14);
		contentPane.add(lblNewLabel_2_3);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(50, 80, 941, 16);
		contentPane.add(separator);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) { // Evita múltiples disparos del evento
					int selectedRow = table.getSelectedRow();

					// Verificamos que hay una fila seleccionada
					if (selectedRow != -1) {
						selectedReunion = reunionesList.get(selectedRow);

						// IMPLEMENTAR FUNCION QUE BUSQUE POR ID CENTRO
						Ikastetxea selectedIkastetxea = IkastetxeakClient
								.getIkastetxeById(Integer.parseInt(selectedReunion.getIdCentro()));
						lblIzena.setText(selectedIkastetxea.getNom());
						lblKokapena.setText(selectedIkastetxea.getDomi() + ", " + selectedIkastetxea.getDmunic() + ", "
								+ selectedIkastetxea.getDterre());
						lblKontaktuEmail.setText(selectedIkastetxea.getEmail());
						lblKontaktuTelf.setText(selectedIkastetxea.getTel1() + "");

						if (selectedReunion.getEstadoEus().toLowerCase().equals("onartzeke")
								|| selectedReunion.getEstadoEus().toLowerCase().equals("gatazka")) {
							btnOnartu.setEnabled(true);
							btnEzeztatu.setEnabled(true);
						} else {
							btnOnartu.setEnabled(false);
							btnEzeztatu.setEnabled(false);
						}
					} else {
						// Si no hay fila seleccionada, deshabilitar botones
						btnOnartu.setEnabled(false);
						btnEzeztatu.setEnabled(false);
					}
				}
			}
		});

	}

	/**
	 * METOD which fills the table with the data from
	 */
	public void fillTableWReuniones() {

		Views.bilerakView.table.clearSelection();
		this.reunionesList = ReunionesClient.getReunionesByTeacher();
		modelo.setRowCount(0); // Limpia la tabla antes de añadir datos

		for (Reuniones r : reunionesList) {
			ArrayList<Horarios> horarios = OrdutegiaClient.getHorariosByTeachersEmail(r.getUsersByAlumnoId().getEmail());
			
			if (Availables.isConflict(r.getFecha().toString(), horarios)) {
				r.setEstadoEus("gatazka");
				}
			
			modelo.addRow(new Object[] { r.getUsersByAlumnoId().getNombre(), r.getTitulo(), r.getAsunto(),
					r.getEstadoEus(), r.getAula(), r.getFecha() });
	
		}

		// Render personalizado para cambiar colores según el estado
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				String state = table.getValueAt(row, 3).toString();

				switch (state.toLowerCase()) {
				case "onartzeke":
					c.setBackground(Color.ORANGE);
					break;
				case "onartuta":
					c.setBackground(Color.GREEN);
					break;
				case "ezeztatuta":
					c.setBackground(Color.RED);
					break;
				case "gatazka":
					c.setBackground(Color.GRAY);
					break;
				default:
					c.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
					break;
				}

				c.setForeground(Color.BLACK);

				return c;
			}
		});
	}
}
