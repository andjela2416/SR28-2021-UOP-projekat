
package guiProzori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Administrator;
import projekat.Pol;
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

public class AdminProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJmbg;
	private JTextField textAdresa;
	private JTextField textKorisnickoIme;
	private JTextField textKorisnickaSifra;
	private JTextField textPlata;
	private DefaultTableModel modelTabele;
	private DefaultTableModel tableModelNovi;
	private Biblioteka biblioteka;
	private JTable table_1;
	private JTextField textPol;
	private ArrayList<Administrator>listaNeobrisanih;
	

	/**
	 * Launch the application.
	 */

	/* CREATE */

	private void dodaj() {
		try {
			
			boolean greska = false;
			String Id = textId.getText();
			double textPlataDouble = Double.parseDouble(textPlata.getText());
			boolean obrisan = false;
//			int indeks = comboBox.getSelectedIndex();

//			String polValue = "";
//			if (indeks == 0) {
//				polValue = "MUSKI";
//
//			} else {
//				polValue = "ZENSKI";
//			}
//			Pol pol = Pol.valueOf(polValue);
			Pol pol = Pol.valueOf(textPol.getText());
			if (isNum(textId.getText()) == true) {
				Administrator novi = new Administrator(Id, textIme.getText(), textPrezime.getText(),
						textJmbg.getText(), textAdresa.getText(), pol, obrisan,textPlataDouble,textKorisnickoIme.getText(),
						textKorisnickaSifra.getText());

				String[] zaglavlja = new String[] { "ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Korisnicko Ime", "Korisnicka Sifra",
						"Plata" };
				Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < this.listaNeobrisanih.size(); x++) {
					Administrator admin = this.listaNeobrisanih.get(x);
					sadrzaj1[x][0] = admin.getId();
					if (sadrzaj1[x][0].equals(textId.getText())) {
						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
								JOptionPane.WARNING_MESSAGE);
						greska = true;
						break;
					}

				}
				if (greska != true) {
					biblioteka.dodajAdministratora(novi);
					biblioteka.snimiAdministratore();
					sadrzaj[0] = novi.getId();
					sadrzaj[1] = novi.getIme();
					sadrzaj[2] = novi.getPrezime();
					sadrzaj[3] = novi.getJmbg();
					sadrzaj[4] = novi.getAdresa();
					sadrzaj[5] = novi.getPol();
					sadrzaj[6] = novi.getPlata();
					sadrzaj[7] = novi.getKorisnickoIme();
					sadrzaj[8] = novi.getLozinka();
					biblioteka.snimiAdministratore();
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
		
		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Korisnicko Ime", "Korisnicka Sifra",
				"Plata" };
		Object[][] sadrzaj = new Object[this.listaNeobrisanih.size()][zaglavlja.length];

		for (int i = 0; i <this.listaNeobrisanih.size(); i++) {
			Administrator admin = this.listaNeobrisanih.get(i);
			sadrzaj[i][0] = admin.getId();
			sadrzaj[i][1] = admin.getIme();
			sadrzaj[i][2] = admin.getPrezime();
			sadrzaj[i][3] = admin.getJmbg();
			sadrzaj[i][4] = admin.getAdresa();
			sadrzaj[i][5] = admin.getPol();
			sadrzaj[i][6] = admin.getKorisnickoIme();
			sadrzaj[i][7] = admin.getLozinka();
			sadrzaj[i][8] = admin.getPlata();

		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);
		
		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Korisnicko Ime", "Korisnicka Sifra",
					"Plata"  };
			Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textId.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				Administrator admin1 = biblioteka.sviNeobrisaniAdministratori().get(rowIndex);
				boolean greska = false;
				String Id = textId.getText();
				admin1.setId(Id);
				String ime = textIme.getText();
				admin1.setIme(ime);
				String Prezime =  textPrezime.getText();
				admin1.setPrezime(Prezime);
				String jmbg = textJmbg.getText();
				admin1.setJmbg(jmbg);
				String adresa = textAdresa.getText();
				admin1.setAdresa(adresa);
				double textPlataDouble = Double.parseDouble(textPlata.getText());
				admin1.setPlata(textPlataDouble);
				String korime = textKorisnickoIme.getText();
				admin1.setKorisnickoIme(korime);
				String korsifra =textKorisnickaSifra.getText();
				admin1.setLozinka(korsifra);
				Pol pol = Pol.valueOf(textPol.getText());
				admin1.setPol(pol);
				
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				String izabraniID = model.getValueAt(rowIndex, 0).toString();
				int izabraniIDint = Integer.parseInt(izabraniID);
				
				boolean obrisan = false;


				Administrator admin =biblioteka.sviNeobrisaniAdministratori().get(rowIndex);
				Administrator novi = new Administrator(Id, textIme.getText(), textPrezime.getText(),
						textJmbg.getText(), textAdresa.getText(), pol,obrisan,textPlataDouble, textKorisnickoIme.getText(),
						textKorisnickaSifra.getText());


				if (greska != true) {

					admin.setId(novi.getId());
					admin.setIme(novi.getIme());
					admin.setPrezime(novi.getPrezime());
					admin.setJmbg(novi.getJmbg());
					admin.setAdresa(novi.getAdresa());
					admin.setPol(novi.getPol());
					admin.setPlata(novi.getPlata());
					admin.setKorisnickoIme(novi.getKorisnickoIme());
					admin.setLozinka(novi.getLozinka());

					model.setValueAt(admin.getId(), rowIndex, 0);
					model.setValueAt(admin.getIme(), rowIndex, 1);
					model.setValueAt(admin.getPrezime(), rowIndex, 2);
					model.setValueAt(admin.getJmbg(), rowIndex, 3);
					model.setValueAt(admin.getAdresa(), rowIndex, 4);
					model.setValueAt(admin.getPol(), rowIndex, 5);
					model.setValueAt(admin.getPlata(), rowIndex, 6);
					model.setValueAt(admin.getKorisnickoIme(), rowIndex, 7);
					model.setValueAt(admin.getLozinka(), rowIndex, 8);

					biblioteka.snimiAdministratore();
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
			Administrator admin = biblioteka.sviNeobrisaniAdministratori().get(indexReda);
			admin.setObrisan(true);
			biblioteka.snimiAdministratore();
			
			textId.setText("");
			textIme.setText("");
			textPlata.setText("");
			textPrezime.setText("");
			textJmbg.setText("");
			textAdresa.setText("");
			textKorisnickoIme.setText("");
			textKorisnickaSifra.setText("");
			textPol.setText("");
			
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

	public AdminProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		this.listaNeobrisanih=biblioteka.sviNeobrisaniAdministratori();
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Administratori");
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(650, 18, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(650, 71, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(650, 121, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("JMBG");
		lblNewLabel_3.setBounds(650, 174, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Adresa");
		lblNewLabel_4.setBounds(650, 221, 49, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Pol");
		lblNewLabel_5.setBounds(650, 424, 49, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Kor. Ime");
		lblNewLabel_6.setBounds(650, 327, 49, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Kor. Sifra");
		lblNewLabel_7.setBounds(650, 378, 49, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Plata");
		lblNewLabel_8.setBounds(650, 276, 49, 14);
		contentPane.add(lblNewLabel_8);

		textId = new JTextField();
		textId.setBounds(650, 43, 96, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		textIme = new JTextField();
		textIme.setBounds(650, 90, 96, 20);
		contentPane.add(textIme);
		textIme.setColumns(10);

		textPrezime = new JTextField();
		textPrezime.setBounds(650, 143, 96, 20);
		contentPane.add(textPrezime);
		textPrezime.setColumns(10);

		textJmbg = new JTextField();
		textJmbg.setBounds(650, 193, 96, 20);
		contentPane.add(textJmbg);
		textJmbg.setColumns(10);

		textAdresa = new JTextField();
		textAdresa.setBounds(650, 245, 96, 20);
		contentPane.add(textAdresa);
		textAdresa.setColumns(10);

		textKorisnickoIme = new JTextField();
		textKorisnickoIme.setBounds(650, 347, 96, 20);
		contentPane.add(textKorisnickoIme);
		textKorisnickoIme.setColumns(10);

		textKorisnickaSifra = new JTextField();
		textKorisnickaSifra.setBounds(650, 393, 96, 20);
		contentPane.add(textKorisnickaSifra);
		textKorisnickaSifra.setColumns(10);

		textPlata = new JTextField();
		textPlata.setBounds(650, 296, 96, 20);
		contentPane.add(textPlata);
		textPlata.setColumns(10);

		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodaj();
			}
		});
		btnNewButton.setBounds(50, 445, 89, 42);
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
		scrollPane.setBounds(30, 50, 570, 342);
		contentPane.add(scrollPane);
		

		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(Color.WHITE);
		
		textPol = new JTextField();
		textPol.setBounds(650, 445, 96, 19);
		contentPane.add(textPol);
		textPol.setColumns(10);

	
}
}
