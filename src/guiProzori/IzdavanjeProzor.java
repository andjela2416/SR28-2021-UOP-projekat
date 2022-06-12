
package guiProzori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Administrator;
import projekat.ClanBiblioteke;
import projekat.IzdavanjeKnjige;
import projekat.Pol;
import projekat.PrimerakKnjige;
import projekat.Tip;
import projekat.Zaposleni;
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

public class IzdavanjeProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textDatumI;
	private JTextField textDatumV;
	private JTextField textZapos;
	private JTextField textClan;
	private JTextField textAdresa;
	private JTextField textKorisnickoIme;
	private JTextField textKorisnickaSifra;
	private JTextField textPlata;
	private JComboBox comboBox;
	private DefaultTableModel modelTabele;
	private DefaultTableModel tableModelNovi;
	private Biblioteka biblioteka;
	private JTable table_1;
	private JTextField textPrimerak;
	

	/**
	 * Launch the application.
	 */

	/* CREATE */

	private void dodaj() {
		try {
			int rowIndex = table_1.getSelectedRow();
			IzdavanjeKnjige knjiga= biblioteka.svaNeobrisanaIzdavanja().get(rowIndex);
			boolean greska = false;
			String Id = textDatumI.getText();
			double textPlataDouble = Double.parseDouble(textPlata.getText());
			boolean obrisan = false;
			LocalDate datum= LocalDate.parse(textDatumI.getText());
			knjiga.setDatumIznajmljivanja(datum);
			LocalDate datum2= LocalDate.parse(textDatumV.getText());
			knjiga.setDatumVracanja(datum2);
			Zaposleni zaposleni = biblioteka.pronadjiZaposlenog(textZapos.getText());
			knjiga.setZaposleni(zaposleni);
			ClanBiblioteke clan = biblioteka.nadjiClana(textClan.getText());
			knjiga.setClan(clan);
			PrimerakKnjige primerak = biblioteka.pronadjiPrimerak(textPrimerak.getText());
			knjiga.setPrimerak(primerak);
//			int indeks = comboBox.getSelectedIndex();

//			String polValue = "";
//			if (indeks == 0) {
//				polValue = "MUSKI";
//
//			} else {
//				polValue = "ZENSKI";
//			}
//			Pol pol = Pol.valueOf(polValue);
			Pol pol = Pol.valueOf(textPrimerak.getText());
			if (isNum(textDatumI.getText()) == true) {
				IzdavanjeKnjige izdavanje = new IzdavanjeKnjige(datum,datum2,zaposleni,clan,primerak);

				String[] zaglavlja = new String[] { "datum Iznajmljivanja","datum vracanja","zaposleni","clan","primerak"};
				Object[][] sadrzaj1 = new Object[biblioteka.svaNeobrisanaIzdavanja().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

//				for (int x = 0; x < biblioteka.svaNeobrisanaIzdavanja().size(); x++) {
//					IzdavanjeKnjige primerak3 = biblioteka.svaNeobrisanaIzdavanja().get(x);
//					//sadrzaj1[x][0] = primerak3.getId();
//					if (sadrzaj1[x][0].equals(textDatumI.getText())) {
//						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
//								JOptionPane.WARNING_MESSAGE);
//						greska = true;
//						break;
//					}
//
//				}
				if (greska != true) {
					biblioteka.dodajIzdavanjeKnjige(knjiga);
					biblioteka.snimiIznajmljivanje("izdavanje.txt");

					sadrzaj[0] = knjiga.getDatumIznajmljivanja();
					sadrzaj[1] = knjiga.getDatumVracanja();
					sadrzaj[2] = knjiga.getZaposleni();
					sadrzaj[3] = knjiga.getClan();
					sadrzaj[4] = knjiga.getPrimerak();
			
					biblioteka.snimiIznajmljivanje("izdavanje.txt");
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
		String[] zaglavlja = new String[] {"datum Iznajmljivanja","datum vracanja","zaposleni","clan","primerak" };
		Object[][] sadrzaj = new Object[biblioteka.svaNeobrisanaIzdavanja().size()][zaglavlja.length];

		for (int i = 0; i < biblioteka.svaNeobrisanaIzdavanja().size(); i++) {
			IzdavanjeKnjige primerak = biblioteka.svaNeobrisanaIzdavanja().get(i);
			sadrzaj[i][0] = primerak.getDatumIznajmljivanja();
			sadrzaj[i][1] = primerak.getDatumVracanja();
			sadrzaj[i][2] = primerak.getZaposleni();
			sadrzaj[i][3] = primerak.getClan();
			sadrzaj[i][4] = primerak.getPrimerak();
		
		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);
		//System.out.println(modelTabele.getValueAt(0, 1)); sto neceeeeeeeeeeeeeeeeeeeeeee
		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"datum Iznajmljivanja","datum vracanja","zaposleni","clan","primerak"};
			Object[][] sadrzaj1 = new Object[biblioteka.svaNeobrisanaIzdavanja().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textDatumI.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				IzdavanjeKnjige knjiga= biblioteka.svaNeobrisanaIzdavanja().get(rowIndex);
				boolean greska = false;
				
				LocalDate datum= LocalDate.parse(textDatumI.getText());
				knjiga.setDatumIznajmljivanja(datum);
				LocalDate datum2= LocalDate.parse(textDatumV.getText());
				knjiga.setDatumVracanja(datum2);
				Zaposleni zaposleni = biblioteka.pronadjiZaposlenog(textZapos.getText());
				knjiga.setZaposleni(zaposleni);
				ClanBiblioteke clan = biblioteka.nadjiClana(textClan.getText());
				knjiga.setClan(clan);
				PrimerakKnjige primerak = biblioteka.pronadjiPrimerak(textPrimerak.getText());
				knjiga.setPrimerak(primerak);
				
				String Id = textDatumI.getText();
				double textPlataDouble = Double.parseDouble(textPlata.getText());
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				
				String izabraniID = model.getValueAt(rowIndex, 0).toString();
				int izabraniIDint = Integer.parseInt(izabraniID);
				//comboBox.getSelectedIndex();
				//int indeks = comboBox.getSelectedIndex();
				Pol pol = Pol.valueOf(textPrimerak.getText());
				boolean obrisan = false;

//				String polValue = "";
//				if (indeks == 0) {
//					polValue = "MUSKI";
//
//				} else {
//					polValue = "ZENSKI";
//				}
//				Pol pol = Pol.valueOf(polValue);

				IzdavanjeKnjige knjiga1 = biblioteka.svaNeobrisanaIzdavanja().get(rowIndex);
				IzdavanjeKnjige nova = new IzdavanjeKnjige(datum,datum2,zaposleni,clan,primerak);

//				for (int x = 0; x < biblioteka.getAdministratori().size(); x++) {
//					Administrator uneti = biblioteka.getAdministratori().get(x);
//					sadrzaj1[x][0] = uneti.getId();
//					if (sadrzaj1[x][0] == admin.getId()) {
//						break;
//					} else if (sadrzaj1[x][0].equals(textId.getText())) {
//						JOptionPane.showMessageDialog(null, "Postoji entitet sa istim id-om", "Greska",
//							JOptionPane.WARNING_MESSAGE);
//						greska = true;
//						break;
//					}
//
//				}

				if (greska != true) {

					knjiga1.setDatumIznajmljivanja(nova.getDatumIznajmljivanja());
					knjiga1.setDatumVracanja(nova.getDatumVracanja());
					knjiga1.setZaposleni(nova.getZaposleni());
					knjiga1.setClan(nova.getClan());
					knjiga1.setPrimerak(nova.getPrimerak());
				

					model.setValueAt(knjiga1.getDatumIznajmljivanja(), rowIndex, 0);
					model.setValueAt(knjiga1.getDatumVracanja(), rowIndex, 1);
					model.setValueAt(knjiga1.getZaposleni(), rowIndex, 2);
					model.setValueAt(knjiga1.getClan(), rowIndex, 3);
					model.setValueAt(knjiga1.getPrimerak(), rowIndex, 4);
			

					biblioteka.snimiIznajmljivanje("izdavanje.txt");
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
			IzdavanjeKnjige izdavanje= biblioteka.getListaIzdavanja().get(indexReda);
			izdavanje.setObrisan(true);
			//izdavanje.setId("0");
			biblioteka.snimiIznajmljivanje(izabraniID);
			
			textDatumI.setText("");
			textDatumV.setText("");
			textPlata.setText("");
			textZapos.setText("");
			textClan.setText("");
			textAdresa.setText("");
			textKorisnickoIme.setText("");
			textKorisnickaSifra.setText("");
			textPrimerak.setText("");
			
			model.removeRow(izabraniIDint);
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
	 * @param admin
	 * @param biblioteka2
	 */
	public IzdavanjeProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Izdavanje knjige");
		ImageIcon image = new ImageIcon("src/fajlovi/archive.png");
		setIconImage(image.getImage());
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("Datum Iznajmljivanja:");
		lblNewLabel.setBounds(650, 18, 69, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Datum vracanja:");
		lblNewLabel_1.setBounds(650, 71, 83, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Zaposleni:");
		lblNewLabel_2.setBounds(650, 121, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Clan:");
		lblNewLabel_3.setBounds(650, 174, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Primerak:");
		lblNewLabel_4.setBounds(650, 221, 49, 14);
		contentPane.add(lblNewLabel_4);


		textDatumI = new JTextField();
		textDatumI.setBounds(650, 43, 96, 20);
		contentPane.add(textDatumI);
		textDatumI.setColumns(10);

		textDatumV = new JTextField();
		textDatumV.setBounds(650, 90, 96, 20);
		contentPane.add(textDatumV);
		textDatumV.setColumns(10);

		textZapos = new JTextField();
		textZapos.setBounds(650, 143, 96, 20);
		contentPane.add(textZapos);
		textZapos.setColumns(10);

		textClan = new JTextField();
		textClan.setBounds(650, 193, 96, 20);
		contentPane.add(textClan);
		textClan.setColumns(10);


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
		
		textPrimerak = new JTextField();
		textPrimerak.setBounds(650, 235, 96, 19);
		contentPane.add(textPrimerak);
		textPrimerak.setColumns(10);

	
}
}
