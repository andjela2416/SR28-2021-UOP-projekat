
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
import projekat.PrimerakKnjige;
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

public class PrimerakProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textBrojstrana;
	private JTextField textMekpovez;
	private JTextField textGodina;
	private JTextField textJezik;
	private JTextField textKnjiga;
	private JTextField textIznajm;
	private JComboBox comboBox;
	private DefaultTableModel modelTabele;
	private DefaultTableModel tableModelNovi;
	private Biblioteka biblioteka;
	private JTable table_1;
	private ArrayList<PrimerakKnjige>listaNeobrisanih;
	

	/**
	 * Launch the application.
	 */

	/* CREATE */

	private void dodaj() {
		try {
			boolean greska = false;
			String Id = textId.getText();
			int brojstrana= Integer.parseInt(textBrojstrana.getText());
			boolean mekpovez =Boolean.parseBoolean(textMekpovez.getText());
			int godinastampanja= Integer.parseInt(textGodina.getText());
			String jezikstampanja= textJezik.getText();			
			boolean iznajmljena=Boolean.parseBoolean(textIznajm.getText());
			Knjiga knjiga= biblioteka.nadjiKnjigu2(textKnjiga.getText());
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
				PrimerakKnjige novi = new PrimerakKnjige(Id,brojstrana,mekpovez,godinastampanja,jezikstampanja,iznajmljena,knjiga,obrisan);

				String[] zaglavlja = new String[] { "ID", "broj strana","mek povez","godina stampanja","jezik stampanja","iznamljena","knjiga" };
				Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x <this.listaNeobrisanih.size(); x++) {
					PrimerakKnjige primerak = this.listaNeobrisanih.get(x);
					sadrzaj1[x][0] = primerak.getId();
					if (sadrzaj1[x][0].equals(textId.getText())) {
						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
								JOptionPane.WARNING_MESSAGE);
						greska = true;
						break;
					}

				}
				if (greska != true) {
					biblioteka.dodajPrimerakKnjige(novi);
					biblioteka.snimiPrimerkeKnjiga();

					sadrzaj[0] = novi.getId();
					sadrzaj[1] = novi.getBrojStrana();
					sadrzaj[2] = novi.isMekPovez();
					sadrzaj[3] = novi.getGodinaStampanja();
					sadrzaj[4] = novi.getJezikStampanja();
					sadrzaj[5] = novi.isIznajmljena();
					sadrzaj[6] = novi.getKnjiga();
				
				
					biblioteka.snimiPrimerkeKnjiga();
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
		String[] zaglavlja = new String[] {"ID", "broj strana","mek povez","godina stampanja","jezik stampanja","iznamljena","knjiga"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniPrimerciKnjiga().size()][zaglavlja.length];

		for (int i = 0; i <this.listaNeobrisanih.size(); i++) {
			PrimerakKnjige primerak= this.listaNeobrisanih.get(i);
			sadrzaj[i][0] = primerak.getId();
			sadrzaj[i][1] = primerak.getBrojStrana();
			sadrzaj[i][2] = primerak.isMekPovez();
			sadrzaj[i][3] = primerak.getGodinaStampanja();
			sadrzaj[i][4] = primerak.getJezikStampanja();
			sadrzaj[i][5] = primerak.isIznajmljena();
			sadrzaj[i][6] = primerak.getKnjiga().getId();
			

		

		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);
		//System.out.println(modelTabele.getValueAt(0, 1)); sto neceeeeeeeeeeeeeeeeeeeeeee
		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"ID", "broj strana","mek povez","godina stampanja","jezik stampanja","iznamljena","knjiga"};
			Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textId.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				PrimerakKnjige primerak1 = biblioteka.sviNeobrisaniPrimerciKnjiga().get(rowIndex);
				boolean greska = false;
				String Id = textId.getText();
				primerak1.setId(Id);
				int brojstrana= Integer.parseInt(textBrojstrana.getText());
				primerak1.setBrojStrana(brojstrana);
				boolean mekpovez =Boolean.parseBoolean(textMekpovez.getText());
				primerak1.setMekPovez(mekpovez);
				int godinastampanja= Integer.parseInt(textGodina.getText());
				primerak1.setGodinaStampanja(godinastampanja);
				String jezikstampanja= textJezik.getText();
				primerak1.setJezikStampanja(jezikstampanja);
				boolean iznajmljena=Boolean.parseBoolean(textIznajm.getText());
				primerak1.setIznajmljena(iznajmljena);
				Knjiga knjiga= biblioteka.nadjiKnjigu2(textKnjiga.getText());
				primerak1.setKnjiga(knjiga);
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

				PrimerakKnjige primerak = biblioteka.sviNeobrisaniPrimerciKnjiga().get(rowIndex);
				PrimerakKnjige novi = new PrimerakKnjige(Id,brojstrana,mekpovez,godinastampanja,jezikstampanja,iznajmljena,knjiga,obrisan);

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

					primerak.setId(novi.getId());
					primerak.setBrojStrana(novi.getBrojStrana());
					primerak.setMekPovez(novi.isMekPovez());
					primerak.setGodinaStampanja(novi.getGodinaStampanja());
					primerak.setJezikStampanja(novi.getJezikStampanja());
					primerak.setIznajmljena(novi.isIznajmljena());
					primerak.setKnjiga(novi.getKnjiga());
				

					model.setValueAt(primerak.getId(), rowIndex, 0);
					model.setValueAt(primerak.getBrojStrana(), rowIndex, 1);
					model.setValueAt(primerak.isMekPovez(), rowIndex, 2);
					model.setValueAt(primerak.getGodinaStampanja(), rowIndex, 3);
					model.setValueAt(primerak.getJezikStampanja(), rowIndex, 4);
					model.setValueAt(primerak.isIznajmljena(), rowIndex, 5);
					model.setValueAt(primerak.getKnjiga().getId(), rowIndex, 6);
				

					biblioteka.snimiPrimerkeKnjiga();
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
			PrimerakKnjige primerak = biblioteka.getListaPrimeraka().get(indexReda);
			primerak.setObrisan(true);
			biblioteka.snimiPrimerkeKnjiga();
			
			textId.setText("");
			textBrojstrana.setText("");
			textIznajm.setText("");
			textMekpovez.setText("");
			textGodina.setText("");
			textJezik.setText("");
			textKnjiga.setText("");
	
			
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
	public PrimerakProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		this.listaNeobrisanih=biblioteka.sviNeobrisaniPrimerciKnjiga();
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Primerci Knjiga");
		ImageIcon image = new ImageIcon("src/fajlovi/archive.png");
		setIconImage(image.getImage());
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(650, 18, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("broj strana");
		lblNewLabel_1.setBounds(650, 71, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("mek povez");
		lblNewLabel_2.setBounds(650, 121, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("godina stampanja");
		lblNewLabel_3.setBounds(650, 174, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("jezik stampanja");
		lblNewLabel_4.setBounds(650, 221, 49, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("knjiga");
		lblNewLabel_6.setBounds(650, 327, 49, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("iznamljena");
		lblNewLabel_8.setBounds(650, 276, 49, 14);
		contentPane.add(lblNewLabel_8);

		textId = new JTextField();
		textId.setBounds(650, 43, 96, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		textBrojstrana = new JTextField();
		textBrojstrana.setBounds(650, 90, 96, 20);
		contentPane.add(textBrojstrana);
		textBrojstrana.setColumns(10);

		textMekpovez = new JTextField();
		textMekpovez.setBounds(650, 143, 96, 20);
		contentPane.add(textMekpovez);
		textMekpovez.setColumns(10);

		textGodina = new JTextField();
		textGodina.setBounds(650, 193, 96, 20);
		contentPane.add(textGodina);
		textGodina.setColumns(10);

		textJezik = new JTextField();
		textJezik.setBounds(650, 245, 96, 20);
		contentPane.add(textJezik);
		textJezik.setColumns(10);

		textKnjiga = new JTextField();
		textKnjiga.setBounds(650, 347, 96, 20);
		contentPane.add(textKnjiga);
		textKnjiga.setColumns(10);

		textIznajm = new JTextField();
		textIznajm.setBounds(650, 296, 96, 20);
		contentPane.add(textIznajm);
		textIznajm.setColumns(10);

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
		scrollPane.setBounds(44, 39, 483, 342);
		contentPane.add(scrollPane);
		

		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(Color.WHITE);

	
}
}
