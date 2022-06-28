
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
import java.awt.event.ActionEvent;

public class BibliotekaProzor extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private DefaultTableModel modelTabele;
	private DefaultTableModel tableModelNovi;
	private Biblioteka biblioteka;
	private JTable table_1;
	private JTextField textRadnoVreme;
	private JTextField textNaziv;
	private JTextField textAdresa;
	private JTextField textTelefon;
	

	/**
	 * Launch the application.
	 */


	public BibliotekaProzor(Biblioteka biblioteka, boolean admin) {
		this.biblioteka = biblioteka;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Biblioteka");
		getContentPane().setBackground(new Color(204, 61, 158));
		
		

		JLabel lblNewLabel = new JLabel("Naziv:");
		lblNewLabel.setBounds(176, 101, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Adresa:");
		lblNewLabel_1.setBounds(176, 157, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefon:");
		lblNewLabel_2.setBounds(176, 220, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Radno vreme:");
		lblNewLabel_3.setBounds(176, 279, 96, 14);
		contentPane.add(lblNewLabel_3);


	

	

		JButton btnNewButton_2 = new JButton("Dodaj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Biblioteka b = biblioteka.ucitajBiblioteku("biblioteka.txt");
				if(!textNaziv.getText().trim().equals("")) {
                    String naziv = textNaziv.getText().trim();
                    b.setNaziv(naziv);
                }
                if(!textAdresa.getText().trim().equals("")) {
                    String adresa = textAdresa.getText().trim();
                    b.setAdresa(adresa);
                }
                if(!textTelefon.getText().trim().equals("")) {
                    String broj = textTelefon.getText().trim();
                    b.setTelefon(broj);
                }
                if(!textRadnoVreme.getText().trim().equals("")) {
                    String radnovr = textRadnoVreme.getText().trim();
                    b.setRadnoVreme(radnovr);
                }



                b.snimiBiblioteku(BibliotekaMain.BIBLIOTEKA_FAJL);
                BibliotekaProzor.this.dispose();
                BibliotekaProzor.this.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(154, 445, 134, 42);
		contentPane.add(btnNewButton_2);
		
		
		textRadnoVreme = new JTextField();
		textRadnoVreme.setBounds(176, 304, 96, 19);
		contentPane.add(textRadnoVreme);
		textRadnoVreme.setColumns(10);
		
		textNaziv = new JTextField();
		textNaziv.setBounds(176, 126, 96, 20);
		contentPane.add(textNaziv);
		textNaziv.setColumns(10);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(176, 182, 96, 20);
		contentPane.add(textAdresa);
		textAdresa.setColumns(10);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(176, 245, 96, 20);
		contentPane.add(textTelefon);
		textTelefon.setColumns(10);

	
}
}
