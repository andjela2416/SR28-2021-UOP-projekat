
package guiProzori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Administrator;
import projekat.Pol;
import projekat.Zanr;
import biblioteka.Biblioteka;
import bibliotekaMain.BibliotekaMain;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ZanrProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textOznaka;
	private JTextField textOpis;
	private JTextField textPrezime;
	private JTextField textJmbg;
	private JTextField textAdresa;
	private JTextField textKorisnickoIme;
	private JTextField textKorisnickaSifra;
	private JTextField textPlata;
	private JComboBox comboBox;
	private DefaultTableModel modelTabele;
	private DefaultTableModel tableModelNovi;
	private Biblioteka biblioteka;
	private JTable table_1;
	private ArrayList<Zanr>listaNeobrisanih;
	

	/**
	 * Launch the application.
	 */

	/* CREATE */

	private void dodaj() {
		try {
			boolean greska = false;
			String oznaka=textOznaka.getText();
			String opis=textOpis.getText();
			boolean obrisan = false;

		
			if (isNum(textOznaka.getText()) == true) {
				Zanr novi = new Zanr(oznaka,opis,obrisan);

				String[] zaglavlja = new String[] { "oznaka","opis"};
				Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < this.listaNeobrisanih.size(); x++) {
					Zanr zanr = this.listaNeobrisanih.get(x);
					sadrzaj1[x][0] = zanr.getOznaka();
					if (sadrzaj1[x][0].equals(textOznaka.getText())) {
						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
								JOptionPane.WARNING_MESSAGE);
						greska = true;
						break;
					}

				}
				if (greska != true) {
					biblioteka.dodajZanr(novi);
					biblioteka.snimiZanrove();

					sadrzaj[0] = novi.getOznaka();
					sadrzaj[1] = novi.getOpis();
				
					biblioteka.snimiZanrove();
					modelTabele.addRow(sadrzaj);
					table_1.setModel(modelTabele);

				}
			}
		} catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "Unesite ispravno podatke", "Greska",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/* Validacija broja */

	public static boolean isNum(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID mora biti broj", "Greska", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}

	/* READ */

	private void popuniTabelu() {
		String[] zaglavlja = new String[] {"oznaka","opis" };
		Object[][] sadrzaj = new Object[this.listaNeobrisanih.size()][zaglavlja.length];

		for (int i = 0; i < this.listaNeobrisanih.size(); i++) {
			Zanr zanr = this.listaNeobrisanih.get(i);
			sadrzaj[i][0] = zanr.getOznaka();
			sadrzaj[i][1] = zanr.getOpis();
		

		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);   //DefaulListModel
		table_1 = new JTable(modelTabele);

		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"oznaka","opis" };
			Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textOznaka.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				Zanr zanr1 = biblioteka.sviNeobrisaniZanrovi().get(rowIndex);
				boolean greska = false;
				String oznaka =textOznaka.getText();
				zanr1.setOznaka(oznaka);
				String opis = textOpis.getText();
				zanr1.setOpis(opis);
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				String izabraniID = model.getValueAt(rowIndex, 0).toString();
				int izabraniIDint = Integer.parseInt(izabraniID);

				
				boolean obrisan = false;



				Zanr admin = biblioteka.sviNeobrisaniZanrovi().get(rowIndex);
				Zanr novi = new Zanr(oznaka,opis,obrisan);




				if (greska != true) {

					admin.setOznaka(novi.getOznaka());
					admin.setOpis(novi.getOpis());
			

					model.setValueAt(admin.getOznaka(), rowIndex, 0);
					model.setValueAt(admin.getOpis(), rowIndex, 1);
			

					biblioteka.snimiZanrove();
					model.fireTableRowsInserted(rowIndex, izabraniIDint);
					table_1.setModel(model);
					model.fireTableDataChanged();
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "Niste uneli dobre podatke", "Greska",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/* DELETE */
	
	private void obrisi() {
		try {
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			int indexReda = table_1.getSelectedRow();
			Zanr zanr = biblioteka.getListaZanrova().get(indexReda);
			zanr.setObrisan(true);
			biblioteka.snimiZanrove();
			
			textOznaka.setText("");
			textOpis.setText("");
		
		
			
			model.removeRow(indexReda);
			table_1.setModel(model);
			model.fireTableDataChanged();

		}catch(ArrayIndexOutOfBoundsException x) {
			JOptionPane.showMessageDialog(null, "Izaberite red.", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska (nepoznata): " + e, "Greska", JOptionPane.WARNING_MESSAGE);
		}
		}

	public ZanrProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		this.listaNeobrisanih=biblioteka.sviNeobrisaniZanrovi();
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Zanrovi");
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("Oznaka");
		lblNewLabel.setBounds(650, 18, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Opis");
		lblNewLabel_1.setBounds(650, 71, 49, 14);
		contentPane.add(lblNewLabel_1);


		textOznaka = new JTextField();
		textOznaka.setBounds(650, 43, 96, 20);
		contentPane.add(textOznaka);
		textOznaka.setColumns(10);

		textOpis = new JTextField();
		textOpis.setBounds(650, 90, 96, 20);
		contentPane.add(textOpis);
		textOpis.setColumns(10);

		textPrezime = new JTextField();
		textPrezime.setBounds(650, 143, 96, 20);
		

		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodaj();
			}
		});
		btnNewButton.setBounds(44, 445, 89, 42);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				azuriraj();
			}
		});
		btnNewButton_2.setBounds(190, 445, 96, 42);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Obrisi");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obrisi();
			}
		});
		
		btnNewButton_3.setBounds(475, 445, 96, 42);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(86, 39, 441, 342);
		contentPane.add(scrollPane);
		

		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(Color.WHITE);

	
}
}
