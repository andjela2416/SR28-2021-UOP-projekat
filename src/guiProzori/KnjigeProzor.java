
package guiProzori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Administrator;
import projekat.Knjiga;
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

public class KnjigeProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNaslov;
	private JTextField textOrgNaslov;
	private JTextField textPisac;
	private JTextField textGodObj;
	private JTextField textOpis;
	private JTextField textZanr;
	private JTextField textJezik;
	private JComboBox comboBox;
	private DefaultTableModel modelTabele;
	private DefaultTableModel tableModelNovi;
	private Biblioteka biblioteka;
	private JTable table_1;
	private ArrayList<Knjiga>listaNeobrisanih;
	

	/**
	 * Launch the application.
	 */

	/* CREATE */

	private void dodaj() {
		try {
			boolean greska = false;
			String Id = textId.getText();
			String naslov = textNaslov.getText();
			String orgnaslov = textOrgNaslov.getText();
			String pisac = textPisac.getText();
			int godinaobjave= Integer.parseInt(textGodObj.getText());
			String jezik=textJezik.getText();
			String opis= textOpis.getText();
			Zanr zanr=biblioteka.nadjiZanr2(textZanr.getText());
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
		
			if (isNum(textId.getText()) == true) {
				Knjiga novi = new Knjiga(Id,naslov,orgnaslov,pisac,godinaobjave,jezik,opis,zanr,obrisan);

				String[] zaglavlja = new String[] { "ID", "Naslov Knjige", "OriginalNalov", "Pisac", "godina objavljivanja", "jezikoriginala", "opis", " zanr"};
				Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < this.listaNeobrisanih.size(); x++) {
					Knjiga knjiga = this.listaNeobrisanih.get(x);
					sadrzaj1[x][0] =knjiga.getId();
					if (sadrzaj1[x][0].equals(textId.getText())) {
						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
								JOptionPane.WARNING_MESSAGE);
						greska = true;
						break;
					}

				}
				if (greska != true) {
					biblioteka.dodajKnjigu(novi);
					biblioteka.snimiKnjige();

					sadrzaj[0] = novi.getId();
					sadrzaj[1] = novi.getNaslovKnjige();
					sadrzaj[2] = novi.getOriginalNaslovKnjige();
					sadrzaj[3] = novi.getPisac();
					sadrzaj[4] = novi.getGodinaObjavljivanja();
					sadrzaj[5] = novi.getJezikOriginala();
					sadrzaj[6] = novi.getOpis();
					sadrzaj[7] = novi.getZanr();
				
					biblioteka.snimiKnjige();
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
		String[] zaglavlja = new String[] {"ID", "Naslov Knjige", "OriginalNalov", "Pisac", "godina objavljivanja", "jezikoriginala", "opis", " zanr" };
		Object[][] sadrzaj = new Object[this.listaNeobrisanih.size()][zaglavlja.length];

		for (int i = 0; i < this.listaNeobrisanih.size(); i++) {
			Knjiga knjiga = this.listaNeobrisanih.get(i);
			sadrzaj[i][0] = knjiga.getId();
			sadrzaj[i][1] = knjiga.getNaslovKnjige();
			sadrzaj[i][2] = knjiga.getOriginalNaslovKnjige();
			sadrzaj[i][3] = knjiga.getPisac();
			sadrzaj[i][4] = knjiga.getGodinaObjavljivanja();
			sadrzaj[i][5] = knjiga.getJezikOriginala();
			sadrzaj[i][6] = knjiga.getOpis();
			sadrzaj[i][7] = knjiga.getZanr();
		

		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);
		//System.out.println(modelTabele.getValueAt(0, 1)); sto neceeeeeeeeeeeeeeeeeeeeeee
		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"ID", "Naslov Knjige", "OriginalNalov", "Pisac", "godina objavljivanja", "jezikoriginala", "opis", " zanr" };
			Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textId.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				Knjiga knjiga1 = this.listaNeobrisanih.get(rowIndex);
				boolean greska = false;
				String Id = textId.getText();
				knjiga1.setId(Id);
				String naslov = textNaslov.getText();
				knjiga1.setNaslovKnjige(naslov);
				String orgnaslov = textOrgNaslov.getText();
				knjiga1.setOriginalNaslovKnjige(orgnaslov);
				String pisac = textPisac.getText();
				knjiga1.setPisac(pisac);
				int godinaobjave= Integer.parseInt(textGodObj.getText());
				knjiga1.setGodinaObjavljivanja(godinaobjave);
				String jezik=textJezik.getText();
				knjiga1.setJezikOriginala(jezik);
				String opis= textOpis.getText();
				knjiga1.setOpis(opis);
				Zanr zanr=biblioteka.nadjiZanr2(textZanr.getText());
				knjiga1.setZanr(zanr);
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				
				String izabraniID = model.getValueAt(rowIndex, 0).toString();
				int izabraniIDint = Integer.parseInt(izabraniID);
				//comboBox.getSelectedIndex();
				//int indeks = comboBox.getSelectedIndex();
				
				boolean obrisan = false;

//				String polValue = "";
//				if (indeks == 0) {
//					polValue = "MUSKI";
//
//				} else {
//					polValue = "ZENSKI";
//				}
//				Pol pol = Pol.valueOf(polValue);

				Knjiga knjiga =biblioteka.sveNeobrisaneKnjige().get(rowIndex);
				Knjiga novi = new Knjiga(Id,naslov,orgnaslov,pisac,godinaobjave,jezik,opis,zanr,obrisan);

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

					knjiga.setId(novi.getId());
					knjiga.setNaslovKnjige(novi.getNaslovKnjige());
					knjiga.setOriginalNaslovKnjige(novi.getOriginalNaslovKnjige());
					knjiga.setPisac(novi.getPisac());
					knjiga.setGodinaObjavljivanja(novi.getGodinaObjavljivanja());
					knjiga.setJezikOriginala(novi.getJezikOriginala());
					knjiga.setOpis(novi.getOpis());
					knjiga.setZanr(novi.getZanr());
					

					model.setValueAt(knjiga.getId(), rowIndex, 0);
					model.setValueAt(knjiga.getNaslovKnjige(), rowIndex, 1);
					model.setValueAt(knjiga.getOriginalNaslovKnjige(), rowIndex, 2);
					model.setValueAt(knjiga.getPisac(), rowIndex, 3);
					model.setValueAt(knjiga.getGodinaObjavljivanja(), rowIndex, 4);
					model.setValueAt(knjiga.getJezikOriginala(), rowIndex, 5);
					model.setValueAt(knjiga.getOpis(), rowIndex, 6);
					model.setValueAt(knjiga.getZanr(), rowIndex, 7);
				

					biblioteka.snimiKnjige();
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
			Knjiga knjiga = this.listaNeobrisanih.get(indexReda);
			knjiga.setObrisan(true);
			biblioteka.snimiKnjige();
			
			textId.setText("");
			textNaslov.setText("");
			textJezik.setText("");
			textOrgNaslov.setText("");
			textPisac.setText("");
			textGodObj.setText("");
			textOpis.setText("");
			textZanr.setText("");
	
			
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
	 * @param admin
	 * @param biblioteka2
	 */
	public KnjigeProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		this.listaNeobrisanih=biblioteka.sveNeobrisaneKnjige();
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Knjige");
		ImageIcon image = new ImageIcon("src/fajlovi/archive.png");
		setIconImage(image.getImage());
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(650, 18, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Naslov");
		lblNewLabel_1.setBounds(650, 71, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Original naslov");
		lblNewLabel_2.setBounds(650, 118, 96, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Pisac");
		lblNewLabel_3.setBounds(650, 174, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Godina objavljivanja");
		lblNewLabel_4.setBounds(650, 221, 123, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Opis");
		lblNewLabel_6.setBounds(650, 327, 49, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Zanr");
		lblNewLabel_7.setBounds(650, 378, 49, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Jezik");
		lblNewLabel_8.setBounds(650, 276, 49, 14);
		contentPane.add(lblNewLabel_8);

		textId = new JTextField();
		textId.setBounds(650, 43, 96, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		textNaslov = new JTextField();
		textNaslov.setBounds(650, 90, 96, 20);
		contentPane.add(textNaslov);
		textNaslov.setColumns(10);

		textOrgNaslov = new JTextField();
		textOrgNaslov.setBounds(650, 143, 96, 20);
		contentPane.add(textOrgNaslov);
		textOrgNaslov.setColumns(10);

		textPisac = new JTextField();
		textPisac.setBounds(650, 193, 96, 20);
		contentPane.add(textPisac);
		textPisac.setColumns(10);

		textGodObj = new JTextField();
		textGodObj.setBounds(650, 245, 96, 20);
		contentPane.add(textGodObj);
		textGodObj.setColumns(10);

		textOpis = new JTextField();
		textOpis.setBounds(650, 347, 96, 20);
		contentPane.add(textOpis);
		textOpis.setColumns(10);

		textZanr = new JTextField();
		textZanr.setBounds(650, 393, 96, 20);
		contentPane.add(textZanr);
		textZanr.setColumns(10);

		textJezik = new JTextField();
		textJezik.setBounds(650, 296, 96, 20);
		contentPane.add(textJezik);
		textJezik.setColumns(10);

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
