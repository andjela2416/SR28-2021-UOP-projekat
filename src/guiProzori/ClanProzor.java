
package guiProzori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import projekat.ClanBiblioteke;
import projekat.Pol;
import projekat.Tip;
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
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ClanProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJmbg;
	private JTextField textAdresa;
	private JTextField textDatum;
	private JTextField textBrojMeseci;
	private JTextField textBrCK;
	private JComboBox comboBox;
	private DefaultTableModel modelTabele;
	private DefaultTableModel tableModelNovi;
	private Biblioteka biblioteka;
	private JTable table_1;
	private JTextField textPol;
	private JTextField textField;
	private JTextField textField_1;
	private String brojclankarte;
	private int brojmeseciclan;
	private LocalDate datumposluplate;
	private boolean aktivan;
	private Tip tip;
	
	

	/**
	 * Launch the application.
	 */

	/* CREATE */

	private void dodaj() {
		try {
			boolean greska = false;
			String Id = textId.getText();
			boolean obrisan = false;
//			Tip tip= Tip.valueOf(textField_1.getText());
			brojclankarte = textBrCK.getText();
			datumposluplate = LocalDate.parse(textDatum.getText());
			brojmeseciclan = Integer.parseInt(textBrojMeseci.getText());
			Tip tipClanarine = biblioteka.nadjiTip(textField_1.getText());
			boolean aktivan = Boolean.parseBoolean(textField.getText());

			Pol pol = Pol.valueOf(textPol.getText());
			if (isNum(textId.getText()) == true) {
			
				ClanBiblioteke novi = new ClanBiblioteke(Id, textIme.getText(), textPrezime.getText(),
						textJmbg.getText(), textAdresa.getText(), pol, obrisan,brojclankarte,datumposluplate,brojmeseciclan,aktivan,tipClanarine);

				String[] zaglavlja = new String[] { "ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Br. clanske karte", "Datum pos. uplate",
						"Br. meseci clanarine","Aktivan","Tip"  };
				Object[][] sadrzaj1 = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < biblioteka.sviNeobrisaniClanovi().size(); x++) {
					ClanBiblioteke clan = biblioteka.sviNeobrisaniClanovi().get(x);
					sadrzaj1[x][0] = clan.getId();
					if (sadrzaj1[x][0].equals(textId.getText())) {
						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
								JOptionPane.WARNING_MESSAGE);
						greska = true;
						break;
					}

				}
				if (greska != true) {
					biblioteka.dodajClana(novi);
					biblioteka.snimiClanove();

					sadrzaj[0] = novi.getId();
					sadrzaj[1] = novi.getIme();
					sadrzaj[2] = novi.getPrezime();
					sadrzaj[3] = novi.getJmbg();
					sadrzaj[4] = novi.getAdresa();
					sadrzaj[5] = novi.getPol();
					sadrzaj[6] = novi.getBrojClanskeKarte();
					sadrzaj[7] = novi.getDatumPoslUplate();
					sadrzaj[8] = novi.getBrojMeseciClan();
					sadrzaj[9] = novi.isAktivan();
					sadrzaj[10] = novi.getTip().getId();
					
					
					biblioteka.snimiClanove();
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
		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Br. clanske karte", "Datum pos. uplate",
				"Br. meseci clanarine","Aktivan","Tip"  };
		
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];

		for (int i = 0; i < biblioteka.sviNeobrisaniClanovi().size(); i++) {
			ClanBiblioteke clan = biblioteka.sviNeobrisaniClanovi().get(i);
			sadrzaj[i][0] = clan.getId();
			sadrzaj[i][1] = clan.getIme();
			sadrzaj[i][2] = clan.getPrezime();
			sadrzaj[i][3] = clan.getJmbg();
			sadrzaj[i][4] = clan.getAdresa();
			sadrzaj[i][5] = clan.getPol();
			sadrzaj[i][6] = clan.getBrojClanskeKarte();
			sadrzaj[i][7] = clan.getDatumPoslUplate();
			sadrzaj[i][8] = clan.getBrojMeseciClan();
			sadrzaj[i][9] = clan.isAktivan();
			sadrzaj[i][10] = clan.getTip().getId();
		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);
		//System.out.println(modelTabele.getValueAt(0, 1)); sto neceeeeeeeeeeeeeeeeeeeeeee
		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Br. clanske karte", "Datum pos. uplate",
					"Br. meseci clanarine","Aktivan","Tip"  };
			Object[][] sadrzaj1 = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textId.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				ClanBiblioteke clan = biblioteka.sviNeobrisaniClanovi().get(rowIndex);
				boolean greska = false;
				String Id = textId.getText();
				clan.setId(Id);   ///////set svaki
				String ime = textIme.getText();
				clan.setIme(ime);
				String Prezime =  textPrezime.getText();
				clan.setPrezime(Prezime);
				String jmbg = textJmbg.getText();
				clan.setJmbg(jmbg);
				String adresa = textAdresa.getText();
				clan.setAdresa(adresa);
				String textBrojCK = textBrCK.getText();
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				String izabraniID = model.getValueAt(rowIndex, 0).toString();
				int izabraniIDint = Integer.parseInt(izabraniID);
				LocalDate datum= LocalDate.parse(textDatum.getText());
				clan.setDatumPoslUplate(datum);
				brojmeseciclan = Integer.parseInt(textBrojMeseci.getText());
				clan.setBrojMeseciClan(brojmeseciclan);
				Tip tipClanarine = biblioteka.nadjiTip(textField_1.getText());
				clan.setTip(tipClanarine);
				
				//comboBox.getSelectedIndex();
				//int indeks = comboBox.getSelectedIndex();
				Pol pol = Pol.valueOf(textPol.getText());
				clan.setPol(pol);
				boolean obrisan = false;
				clan.setBrojClanskeKarte(textBrojCK);

//				String polValue = "";
//				if (indeks == 0) {
//					polValue = "MUSKI";
//
//				} else {
//					polValue = "ZENSKI";
//				}
//				Pol pol = Pol.valueOf(polValue);

				
//				ClanBiblioteke novi = new ClanBiblioteke(Id, textIme.getText(), textPrezime.getText(),
//						textJmbg.getText(), textAdresa.getText(), pol, obrisan,brojclankarte,datumposluplate,brojmeseciclan,aktivan,tip
//						);

//				for (int x = 0; x < biblioteka.getclanistratori().size(); x++) {
//					clanistrator uneti = biblioteka.getclanistratori().get(x);
//					sadrzaj1[x][0] = uneti.getId();
//					if (sadrzaj1[x][0] == clan.getId()) {
//						break;
//					} else if (sadrzaj1[x][0].equals(textId.getText())) {
//						JOptionPane.showMessageDialog(null, "Postoji entitet sa istim id-om", "Greska",
//							JOptionPane.WARNING_MESSAGE);
//						greska = true;
//						break;
//					}
//
//				}
				//biblioteka.getListaClanova().add(novi);
				biblioteka.snimiClanove();

				if (greska != true) {

					clan.setId(clan.getId());
					clan.setIme(clan.getIme());
					clan.setPrezime(clan.getPrezime());
					clan.setJmbg(clan.getJmbg());
					clan.setAdresa(clan.getAdresa());
					clan.setPol(clan.getPol());
					clan.setBrojClanskeKarte(clan.getBrojClanskeKarte());
					clan.setDatumPoslUplate(clan.getDatumPoslUplate());
					clan.setBrojMeseciClan(clan.getBrojMeseciClan());
					clan.setAktivan(clan.isAktivan());
					clan.setTip(clan.getTip());

					model.setValueAt(clan.getId(), rowIndex, 0);
					model.setValueAt(clan.getIme(), rowIndex, 1);
					model.setValueAt(clan.getPrezime(), rowIndex, 2);
					model.setValueAt(clan.getJmbg(), rowIndex, 3);
					model.setValueAt(clan.getAdresa(), rowIndex, 4);
					model.setValueAt(clan.getPol(), rowIndex, 5);
					model.setValueAt(clan.getBrojClanskeKarte(), rowIndex, 6);
					model.setValueAt(clan.getDatumPoslUplate(), rowIndex, 7);
					model.setValueAt(clan.getBrojMeseciClan(), rowIndex, 8);
					model.setValueAt(clan.isAktivan(), rowIndex, 9);
					model.setValueAt(clan.getTip(), rowIndex, 10);

					biblioteka.snimiClanove();
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
			String izabraniID = model.getValueAt(indexReda, 0).toString();
			int izabraniIDint = Integer.parseInt(izabraniID);
			ClanBiblioteke clan = biblioteka.getListaClanova().get(indexReda);
			clan.setObrisan(true);
			biblioteka.snimiClanove();
			
			textId.setText("");
			textIme.setText("");
			textBrCK.setText("");
			textPrezime.setText("");
			textJmbg.setText("");
			textAdresa.setText("");
			textDatum.setText("");
			textBrojMeseci.setText("");
			textPol.setText("");
			textField.setText("");
			textField_1.setText("");
			
			
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

	/**
	 * Create the frame.
	 * 
	 * @param clan
	 * @param biblioteka2
	 */
	public ClanProzor(Biblioteka biblioteka, boolean clan
			) {
		this.biblioteka = biblioteka;
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Clanovi");
		setSize(1000, 600);
		ImageIcon image = new ImageIcon("src/fajlovi/archive.png");
		setIconImage(image.getImage());
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(812, 24, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(812, 71, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(812, 116, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("JMBG");
		lblNewLabel_3.setBounds(812, 161, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Adresa");
		lblNewLabel_4.setBounds(812, 206, 49, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Pol");
		lblNewLabel_5.setBounds(812, 382, 49, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Datum posl uplate:");
		lblNewLabel_6.setBounds(812, 296, 106, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Broj meseci clan:");
		lblNewLabel_7.setBounds(812, 339, 125, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Broj clanske karte:");
		lblNewLabel_8.setBounds(812, 251, 145, 14);
		contentPane.add(lblNewLabel_8);

		textId = new JTextField();
		textId.setBounds(812, 40, 96, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		textIme = new JTextField();
		textIme.setBounds(812, 85, 96, 20);
		contentPane.add(textIme);
		textIme.setColumns(10);

		textPrezime = new JTextField();
		textPrezime.setBounds(812, 130, 96, 20);
		contentPane.add(textPrezime);
		textPrezime.setColumns(10);

		textJmbg = new JTextField();
		textJmbg.setBounds(812, 175, 96, 20);
		contentPane.add(textJmbg);
		textJmbg.setColumns(10);

		textAdresa = new JTextField();
		textAdresa.setBounds(812, 220, 96, 20);
		contentPane.add(textAdresa);
		textAdresa.setColumns(10);

		textDatum = new JTextField();
		textDatum.setBounds(812, 308, 96, 20);
		contentPane.add(textDatum);
		textDatum.setColumns(10);

		textBrojMeseci = new JTextField();
		textBrojMeseci.setBounds(812, 351, 96, 20);
		contentPane.add(textBrojMeseci);
		textBrojMeseci.setColumns(10);

		textBrCK = new JTextField();
		textBrCK.setBounds(812, 265, 96, 20);
		contentPane.add(textBrCK);
		textBrCK.setColumns(10);

		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodaj();
			}
		});
		btnNewButton.setBounds(109, 486, 89, 42);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				azuriraj();
			}
		});
		btnNewButton_2.setBounds(279, 486, 96, 42);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Obrisi");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obrisi();
			}
		});
		
		btnNewButton_3.setBounds(577, 486, 96, 42);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(22, 110, 736, 320);
		contentPane.add(scrollPane);
		

		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(Color.WHITE);
		
		textPol = new JTextField();
		textPol.setBounds(812, 393, 96, 19);
		contentPane.add(textPol);
		textPol.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(812, 437, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(812, 486, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Aktivan:");
		lblNewLabel_9.setBounds(812, 423, 49, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Tip:");
		lblNewLabel_10.setBounds(812, 468, 49, 14);
		contentPane.add(lblNewLabel_10);

	
}
}
