
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
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class IzdavanjeProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textDatumI;
	private JTextField textDatumV;
	private JTextField textZapos;
	private JTextField textClan;
	private DefaultTableModel modelTabele;
	private Biblioteka biblioteka;
	public JTable table_1;
	
	private ArrayList <IzdavanjeKnjige> listaNeobrisanih;
	private JTextField textID;
	private IzdavanjeKnjige izdavanje;
	private JCheckBox checkBox;
	private ArrayList<JCheckBox> listaBox = new ArrayList<JCheckBox>();
	
	public IzdavanjeProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		this.listaNeobrisanih=biblioteka.svaNeobrisanaIzdavanja();
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
		lblNewLabel.setBounds(648, 74, 69, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Datum vracanja:");
		lblNewLabel_1.setBounds(648, 120, 83, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Zaposleni:");
		lblNewLabel_2.setBounds(650, 166, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Clan:");
		lblNewLabel_3.setBounds(650, 211, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Primerci:");
		lblNewLabel_4.setBounds(650, 256, 131, 14);
		contentPane.add(lblNewLabel_4);


		textDatumI = new JTextField();
		textDatumI.setBounds(650, 89, 96, 20);
		contentPane.add(textDatumI);
		textDatumI.setColumns(10);

		textDatumV = new JTextField();
		textDatumV.setBounds(650, 135, 96, 20);
		contentPane.add(textDatumV);
		textDatumV.setColumns(10);

		textZapos = new JTextField();
		textZapos.setBounds(650, 180, 96, 20);
		contentPane.add(textZapos);
		textZapos.setColumns(10);

		textClan = new JTextField();
		textClan.setBounds(650, 225, 96, 20);
		contentPane.add(textClan);
		textClan.setColumns(10);
		
		/*Dodavanje boxova******************************************************************/
		
		
		int m=30;
		for(PrimerakKnjige p : biblioteka.sviNeobrisaniPrimerciKnjiga()) {
			String i = String.valueOf(p.getId());
			
			JCheckBox checkBox = new JCheckBox(i + ".primerak ");
			if (p.isIznajmljena()) {
				checkBox.setEnabled(false);
			}
			checkBox.setName(i);
			listaBox.add(checkBox);
			
			checkBox.setBounds(650, 245 + m, 99, 23);
			m = m + 30;
			
//			if(!p.isIznajmljena()) {
//				
			contentPane.add(checkBox);
//			}
			
			
		}
		
		/*if(izdavanje != null) {
			for(String x  :izdavanje.getPrimerci()) {
				JCheckBox b = pronadjiCheckBox(x);
				add(b);
			}
		}*/
		/***********************************************************************************************/


		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodaj();
			}
		});
		btnNewButton.setBounds(76, 445, 89, 42);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				azuriraj();
			}
		});
		btnNewButton_2.setBounds(265, 445, 96, 42);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Obrisi");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obrisi();
			}
		});
		
		
		btnNewButton_3.setBounds(463, 445, 96, 42);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(85, 39, 441, 342);
		contentPane.add(scrollPane);
		
		
		

		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(Color.WHITE);
		
		textID = new JTextField();
		textID.setBounds(648, 43, 96, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel labelID = new JLabel("ID:");
		labelID.setBounds(648, 27, 49, 14);
		contentPane.add(labelID);
		
		JButton sviIznajmljeniPrim = new JButton("Iznajmljeni primerci");
		sviIznajmljeniPrim.setBounds(615, 445, 131, 42);
		contentPane.add(sviIznajmljeniPrim);
		table_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				izdavanje=biblioteka.nadjiIzdavanje(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
				for (PrimerakKnjige p : biblioteka.sviNeobrisaniPrimerciKnjiga()) {
					for (JCheckBox j:listaBox) {
						if(p.getId().equals(j.getName())&& p.isIznajmljena()) {
							j.setEnabled(false);
							j.setSelected(false);
						}
					}
				}
				for (PrimerakKnjige p : izdavanje.getPrimerci()) {
					for (JCheckBox j:listaBox) {
						if(p.getId().equals(j.getName())) {
							j.setEnabled(true);
							j.setSelected(true);
						}
						else {
							
						}
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		
		sviIznajmljeniPrim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ListaSvihPrimerakaProzor lp  = new ListaSvihPrimerakaProzor(biblioteka);
				lp.setVisible(true);
				
			}
		});
		
		
	

	
}


	private void dodaj() {
		try {
			boolean greska =false;
			String id= textID.getText();
			LocalDate datum= LocalDate.parse(textDatumI.getText());
			LocalDate datum2= LocalDate.parse(textDatumV.getText());
			Zaposleni zaposleni = biblioteka.pronadjiZaposlenog(textZapos.getText());
			ClanBiblioteke clan = biblioteka.nadjiClana(textClan.getText());
			ArrayList<PrimerakKnjige> primerci = new ArrayList<PrimerakKnjige>();
			//proveravamo da li je primerak cekiran
			for (JCheckBox i : listaBox) {
				
				if(i.isSelected()==true ) {
					
					//pravljenje liste primeraka
					String idPrimerak =  i.getName();
					PrimerakKnjige p  = biblioteka.pronadjiPrimerak(idPrimerak);
					primerci.add(p);
					p.setIznajmljena(true);
					biblioteka.snimiPrimerkeKnjiga();
					
				}
			}
//			int indeks = comboBox.getSelectedIndex();
			boolean obrisan = false;


			if (isNum(textID.getText()) == true) {
				IzdavanjeKnjige novo = new IzdavanjeKnjige(id,datum,datum2,primerci,zaposleni,clan,obrisan);

				String[] zaglavlja = new String[] { "id","datum Iznajmljivanja","datum vracanja","zaposleni","clan","primerak"};
				Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < this.listaNeobrisanih.size(); x++) {
					IzdavanjeKnjige izdavanje = this.listaNeobrisanih.get(x);
					sadrzaj1[x][0] = izdavanje.getId();
					if (sadrzaj1[x][0].equals(textID.getText())) {
						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
								JOptionPane.WARNING_MESSAGE);
						greska = true;
						break;
					}

				}
				if (greska != true) {
					biblioteka.dodajIzdavanjeKnjige(novo);
					biblioteka.snimiIznajmljivanje();

					sadrzaj[0] = novo.getId();
					sadrzaj[1] = novo.getDatumIznajmljivanja();
					sadrzaj[2] = novo.getDatumVracanja();
					sadrzaj[3] = novo.getZaposleni();
					sadrzaj[4] = novo.getClan();
					sadrzaj[5] = novo.getPrimerci();
			
					biblioteka.snimiIznajmljivanje();
					modelTabele.addRow(sadrzaj);
					table_1.setModel(modelTabele);
					biblioteka.snimiPrimerkeKnjiga();
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
//		System.out.println(this.listaNeobrisanih);
		String[] zaglavlja = new String[] {"id","datum Iznajmljivanja","datum vracanja","zaposleni","clan","primerak" };
		Object[][] sadrzaj = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
		for (int i = 0; i < this.listaNeobrisanih.size(); i++) {
			IzdavanjeKnjige izdavanje = biblioteka.svaNeobrisanaIzdavanja().get(i);
			sadrzaj[i][0] = izdavanje.getId();
			sadrzaj[i][1] = izdavanje.getDatumIznajmljivanja();
			sadrzaj[i][2] = izdavanje.getDatumVracanja();
			sadrzaj[i][3] = izdavanje.getZaposleni();
			sadrzaj[i][4] = izdavanje.getClan();
			sadrzaj[i][5] = izdavanje.getPrimerci();
//			System.out.println(i);
		
		}
		//System.out.println(sadrzaj);
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);
		//System.out.println(modelTabele.getValueAt(0, 1)); sto neceeeeeeeeeeeeeeeeeeeeeee
		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"id","datum Iznajmljivanja","datum vracanja","zaposleni","clan","primerak"};
			Object[][] sadrzaj1 = new Object[biblioteka.svaNeobrisanaIzdavanja().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textID.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				IzdavanjeKnjige izdavanje= biblioteka.svaNeobrisanaIzdavanja().get(rowIndex);
				boolean greska = false;
				String id= textID.getText();
				izdavanje.setId(id);
				LocalDate datum= LocalDate.parse(textDatumI.getText());
				izdavanje.setDatumIznajmljivanja(datum);
				LocalDate datum2= LocalDate.parse(textDatumV.getText());
				izdavanje.setDatumVracanja(datum2);
				Zaposleni zaposleni = biblioteka.pronadjiZaposlenog(textZapos.getText());
				izdavanje.setZaposleni(zaposleni);
				ClanBiblioteke clan = biblioteka.nadjiClana(textClan.getText());
				izdavanje.setClan(clan);
				for (PrimerakKnjige p:izdavanje.getPrimerci()) {
					p.setIznajmljena(false);
				}
				izdavanje.setPrimerci(new ArrayList<PrimerakKnjige>());
				for(JCheckBox c: listaBox) {
					if (c.isSelected()) {
						String idPrimerak =  c.getName();
						PrimerakKnjige p  = biblioteka.pronadjiPrimerak(idPrimerak);
						izdavanje.getPrimerci().add(p);
						p.setIznajmljena(true);
					}
					 
		         
				biblioteka.snimiPrimerkeKnjiga();
		             
				biblioteka.snimiIznajmljivanje();
				
				
//				String Id = textDatumI.getText();
//				double textPlataDouble = Double.parseDouble(textPlata.getText());
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				
				String izabraniID = model.getValueAt(rowIndex, 0).toString();
				int izabraniIDint = Integer.parseInt(izabraniID);
				//comboBox.getSelectedIndex();
				//int indeks = comboBox.getSelectedIndex();
//				Pol pol = Pol.valueOf(textPrimerak.getText());
				boolean obrisan = false;

//				String polValue = "";
//				if (indeks == 0) {
//					polValue = "MUSKI";
//
//				} else {
//					polValue = "ZENSKI";
//				}

//
//				IzdavanjeKnjige knjiga1 = biblioteka.svaNeobrisanaIzdavanja().get(rowIndex);
//				IzdavanjeKnjige nova = new IzdavanjeKnjige(id,datum,datum2,izdavanje.getPrimerci(),zaposleni,clan,obrisan);

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
//					knjiga1.setId(nova.getId());
//					knjiga1.setDatumIznajmljivanja(nova.getDatumIznajmljivanja());
//					knjiga1.setDatumVracanja(nova.getDatumVracanja());
//					knjiga1.setZaposleni(nova.getZaposleni());
//					knjiga1.setClan(nova.getClan());
//					knjiga1.setPrimerci(nova.getPrimerci());
				
					model.setValueAt(izdavanje.getId(), rowIndex, 0);
					model.setValueAt(izdavanje.getDatumIznajmljivanja(), rowIndex, 1);
					model.setValueAt(izdavanje.getDatumVracanja(), rowIndex, 2);
					model.setValueAt(izdavanje.getZaposleni(), rowIndex, 3);
					model.setValueAt(izdavanje.getClan(), rowIndex, 4);
					model.setValueAt(izdavanje.getPrimerci(), rowIndex, 5);
			

					biblioteka.snimiIznajmljivanje();
					model.fireTableRowsInserted(rowIndex, izabraniIDint);
					table_1.setModel(model);
					model.fireTableDataChanged();
				}
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
			IzdavanjeKnjige izdavanje= biblioteka.svaNeobrisanaIzdavanja().get(indexReda);
			izdavanje.setObrisan(true);
			biblioteka.snimiIznajmljivanje();
			
			textDatumI.setText("");
			textDatumV.setText("");
			textZapos.setText("");
			textClan.setText("");
			//textPrimerci.setText("");
			
			model.removeRow(indexReda);
			table_1.setModel(model);
			model.fireTableDataChanged();
			
			for(PrimerakKnjige p : izdavanje.getPrimerci()) {
				p.setIznajmljena(false);
				biblioteka.snimiPrimerkeKnjiga();
			}
			
			
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
	
	
	private JCheckBox pronadjiCheckBox(String id) {
		for(JCheckBox i : listaBox) {
			
			if(i.getName().equals(id)) {
				return i;
			}
		}
		return checkBox;
	}
}
