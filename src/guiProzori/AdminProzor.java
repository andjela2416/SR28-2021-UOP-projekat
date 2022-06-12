package guiProzori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


//import artikli.admin;
import biblioteka.Biblioteka;
import bibliotekaMain.BibliotekaMain;
import projekat.Administrator;


import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class AdminProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_9;
	private DefaultTableModel tableModel;
	private JTable adminiTabela;
	JButton dodaj = new JButton("Dodaj");
	private Biblioteka biblioteka;
	JButton obrisi = new JButton("Obrisi");
	JButton azuriraj = new JButton("Azuriraj");
	private Administrator admin;
	JTextField txtid = new JTextField();
	
//	public AdminProzor(Biblioteka biblioteka, admin admin) {
//		this.biblioteka = biblioteka;
//		this.admin = admin;
//		if(admin == null) {
//			setTitle("Dodavanje prodavca");
//		}else {
//			setTitle("Izmena podataka - " + admin.getKorisnickoIme());
//		}
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setLocationRelativeTo(null);
//		initGUI();
//		initActions();
//		setResizable(false);
//		pack();
//	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminProzor frame = new AdminProzor(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @param biblioteka 
	 */
	public AdminProzor(Biblioteka biblioteka) {
		setTitle("admin");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 584);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(219, 112, 147));
        panel.setBounds(0, 0, 884, 545);
        contentPane.add(panel);
        panel.setLayout(null);

		
		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "Jmbg", "Adresa","Pol","Obrisan","Plata","Korisnicko ime","Lozinka"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniAdministratori().size()][zaglavlja.length];
		
		 
		for(int i=0; i<biblioteka.sviNeobrisaniAdministratori().size(); i++) {
			Administrator admin = biblioteka.sviNeobrisaniAdministratori().get(i);
            sadrzaj[i][0] = admin.getId();
            sadrzaj[i][1] = admin.getIme();
            sadrzaj[i][2] = admin.getPrezime();
            sadrzaj[i][3] = admin.getJmbg();
            sadrzaj[i][4] = admin.getAdresa(); 
            sadrzaj[i][5] = admin.getPol();
            sadrzaj[i][6] = admin.getPlata();
            sadrzaj[i][7] = admin.getKorisnickoIme();
            sadrzaj[i][8] = admin.getLozinka();
            sadrzaj[i][9] = admin.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		adminiTabela = new JTable(tableModel);
		
		adminiTabela.setRowSelectionAllowed(true);
		adminiTabela.setColumnSelectionAllowed(false);
		adminiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adminiTabela.setDefaultEditor(Object.class, null);
		adminiTabela.getTableHeader().setReorderingAllowed(false);
		
		//JScrollPane scrollPane = new JScrollPane(adminiTabela);
		//add(scrollPane, BorderLayout.CENTER);
		
		
	
        adminiTabela.setBounds(39, 70, 565, 371);
        panel.add(adminiTabela);
        
        
        dodaj.setFont(new Font("Tahoma", Font.PLAIN, 17));
        dodaj.setBounds(39, 489, 109, 38);
        panel.add(dodaj);
        
        
        obrisi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        obrisi.setBounds(432, 489, 109, 38);
        panel.add(obrisi);
        
        
        azuriraj.setFont(new Font("Tahoma", Font.PLAIN, 17));
        azuriraj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        azuriraj.setBounds(193, 489, 96, 38);
        panel.add(azuriraj);
        
        textField = new JTextField();
        textField.setBounds(656, 85, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(656, 129, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(656, 174, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(656, 219, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(656, 262, 96, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(656, 309, 96, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(656, 355, 96, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(656, 402, 96, 20);
        panel.add(textField_7);
        textField_7.setColumns(10);
        
        
        txtid.setBounds(656, 39, 96, 20);
        panel.add(txtid);
        txtid.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(656, 26, 165, 14);
        panel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Ime:");
        lblNewLabel_1.setBounds(656, 70, 96, 14);
        panel.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Prezime:");
        lblNewLabel_2.setBounds(656, 115, 109, 14);
        panel.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Adresa:");
        lblNewLabel_3.setBounds(656, 205, 96, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Jmbg:");
        lblNewLabel_4.setBounds(656, 160, 96, 14);
        panel.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Pol:");
        lblNewLabel_5.setBounds(656, 250, 79, 14);
        panel.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("Obrisan:");
        lblNewLabel_6.setBounds(656, 293, 96, 14);
        panel.add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("Plata:");
        lblNewLabel_7.setBounds(656, 340, 49, 14);
        panel.add(lblNewLabel_7);
        
        textField_9 = new JTextField();
        textField_9.setBounds(656, 451, 96, 20);
        panel.add(textField_9);
        textField_9.setColumns(10);
        
        JLabel lblNewLabel_8 = new JLabel("Korisnicko ime:");
        lblNewLabel_8.setBounds(656, 390, 96, 14);
        panel.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Lozinka:");
        lblNewLabel_9.setBounds(656, 436, 49, 14);
        panel.add(lblNewLabel_9);
	}
	
	private void initGUI() {
		

		//add(mainToolbar, BorderLayout.NORTH);
//		
//		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "Jmbg", "Adresa","Pol","Obrisan","Plata","Korisnicko ime","Lozinka"};
//		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniAdministratori().size()][zaglavlja.length];
//		
//		
//		for(int i=0; i<biblioteka.sviNeobrisaniAdministratori().size(); i++) {
//			Administrator admin = biblioteka.sviNeobrisaniAdministratori().get(i);
//            sadrzaj[i][0] = admin.getId();
//            sadrzaj[i][1] = admin.getIme();
//            sadrzaj[i][2] = admin.getPrezime();
//            sadrzaj[i][3] = admin.getJmbg();
//            sadrzaj[i][4] = admin.getAdresa();
//            sadrzaj[i][5] = admin.getPol();
//            sadrzaj[i][6] = admin.getPlata();
//            sadrzaj[i][7] = admin.getKorisnickoIme();
//            sadrzaj[i][8] = admin.getLozinka();
//		}
//		
//		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
//		adminiTabela = new JTable(tableModel);
//		
//		adminiTabela.setRowSelectionAllowed(true);
//		adminiTabela.setColumnSelectionAllowed(false);
//		adminiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		adminiTabela.setDefaultEditor(Object.class, null);
//		adminiTabela.getTableHeader().setReorderingAllowed(false);
//		
//		JScrollPane scrollPane = new JScrollPane(adminiTabela);
//		add(scrollPane, BorderLayout.CENTER);
//		table.add(scrollPane);
	}

	private void initActions() {
//		obrisi.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int red = AdminProzor.getSelectedRow();
//				if(red == -1) {
//					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
//				}else {
//					String adminID = tableModel.getValueAt(red, 0).toString();
//					admin admin = biblioteka.nadjiZaposlenog();
//					int izbor = JOptionPane.showConfirmDialog(null, 
//							"Da li ste sigurni da zelite da obrisete admin?", 
//							adminID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
//					if(izbor == JOptionPane.YES_OPTION) {
//						admin.setObrisan(true);
//						tableModel.removeRow(red);
//						biblioteka.snimiadminove(bibliotekaMain.adminOVI_FAJL);
//					}
//				}
//			}
//		});
		
		dodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminProzor df = new AdminProzor(biblioteka);
				df.setVisible(true);
			}
		}); 
//		
//		azuriraj.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int red = adminoviTabela.getSelectedRow();
//				if(red == -1) {
//					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
//				}else {
//					String adminID = tableModel.getValueAt(red, 0).toString();
//					admin admin = biblioteka.pronadjiadmin(adminID);
//					adminoviForma df = new adminoviForma(biblioteka, admin);
//					df.setVisible(true);
//				}
//			}
//		});
	}
//	private void popuniPolja() {
//		txtIme.setText(prodavac.getIme());
//		txtPrezime.setText(prodavac.getPrezime());
//		txtKorisnickoIme.setText(prodavac.getKorisnickoIme());
//		pfSifra.setText(prodavac.getLozinka());
//		cbPol.setSelectedItem(prodavac.getPol());
//	}
}
