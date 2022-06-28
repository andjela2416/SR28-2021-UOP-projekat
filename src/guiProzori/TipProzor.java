
package guiProzori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projekat.Administrator;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TipProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNaziv;
	private JTextField textCena;
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
	private ArrayList<Tip>listaNeobrisanih;
	

	/**
	 * Launch the application.
	 */

	/* CREATE */

	private void dodaj() {
		try {
			boolean greska = false;
			String Id = textId.getText();
			String naziv = textNaziv.getText();
			double cena = Double.parseDouble(textCena.getText());
			boolean obrisan = false;

			
			if (isNum(textId.getText()) == true) {
				Tip novi = new Tip(Id,naziv,cena,obrisan);

				String[] zaglavlja = new String[] { "id","naziv","cena" };
				Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < this.listaNeobrisanih.size(); x++) {
					Tip tip =this.listaNeobrisanih.get(x);
					sadrzaj1[x][0] = tip.getId();
					if (sadrzaj1[x][0].equals(textId.getText())) {
						JOptionPane.showMessageDialog(null, "Vec postoji entitet sa istim ID-em", "Greska",
								JOptionPane.WARNING_MESSAGE);
						greska = true;
						break;
					}

				}
				if (greska != true) {
					biblioteka.dodajTip(novi);
					biblioteka.snimiTipClanarine();

					sadrzaj[0] = novi.getId();
					sadrzaj[1] = novi.getNaziv();
					sadrzaj[2] = novi.getCena();
		
					biblioteka.snimiTipClanarine();
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
		String[] zaglavlja = new String[] {"id","naziv","cena" };
		Object[][] sadrzaj = new Object[this.listaNeobrisanih.size()][zaglavlja.length];

		for (int i = 0; i < this.listaNeobrisanih.size(); i++) {
			Tip tip = this.listaNeobrisanih.get(i);
			sadrzaj[i][0] = tip.getId();
			sadrzaj[i][1] = tip.getNaziv();
			sadrzaj[i][2] = tip.getCena();
	

		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);

		

	}

	/* UPDATE */

	private void azuriraj() {
		try {

			String[] zaglavlja = new String[] {"id","naziv","cena"   };
			Object[][] sadrzaj1 = new Object[this.listaNeobrisanih.size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textId.getText();

			if (isNum(ID) == true) {
				int rowIndex = table_1.getSelectedRow();
				boolean greska = false;
				String Id = textId.getText();
				Tip tip1 = biblioteka.sviNeobrisaniTipovi().get(rowIndex);
				tip1.setId(Id);
				String Naziv = textNaziv.getText();
				tip1.setNaziv(Naziv);
				Double Cena= Double.parseDouble(textCena.getText());
				tip1.setCena(Cena);
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				
				String izabraniID = model.getValueAt(rowIndex, 0).toString();
				int izabraniIDint = Integer.parseInt(izabraniID);

				
				boolean obrisan = false;



				Tip admin = biblioteka.sviNeobrisaniTipovi().get(rowIndex);
				Tip novi = new Tip(Id,Naziv,Cena,obrisan);



				if (greska != true) {

					admin.setId(novi.getId());
					admin.setNaziv(novi.getNaziv());
					admin.setCena(novi.getCena());
			

					model.setValueAt(admin.getId(), rowIndex, 0);
					model.setValueAt(admin.getNaziv(), rowIndex, 1);
					model.setValueAt(admin.getCena(), rowIndex, 2);
				

					biblioteka.snimiTipClanarine();
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
			Tip tip = biblioteka.getListaTipova().get(indexReda);
			tip.setObrisan(true);
			biblioteka.snimiTipClanarine();
			
			textId.setText("");
			textNaziv.setText("");
			textCena.setText("");
		
		
			
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

	public TipProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		this.listaNeobrisanih=biblioteka.sviNeobrisaniTipovi();
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Tipovi");
		ImageIcon image = new ImageIcon("src/fajlovi/archive.png");
		setIconImage(image.getImage());
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(650, 18, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Naziv:");
		lblNewLabel_1.setBounds(650, 71, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cena:");
		lblNewLabel_2.setBounds(650, 121, 49, 14);
		contentPane.add(lblNewLabel_2);

		

		textId = new JTextField();
		textId.setBounds(650, 43, 96, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		textNaziv = new JTextField();
		textNaziv.setBounds(650, 90, 96, 20);
		contentPane.add(textNaziv);
		textNaziv.setColumns(10);

		textCena = new JTextField();
		textCena.setBounds(650, 143, 96, 20);
		contentPane.add(textCena);
		textCena.setColumns(10);

		
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
