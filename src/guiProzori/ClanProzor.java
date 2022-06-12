package guiProzori;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import biblioteka.Biblioteka;
import projekat.ClanBiblioteke;


import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

public class ClanProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private DefaultTableModel tableModel;
	private JTable clanoviTabela;
	private Biblioteka biblioteka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClanProzor frame = new ClanProzor(null);
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
	 * @param table 
	 */
	public ClanProzor(Biblioteka biblioteka) {
		setTitle("Clan");   // tu mi je biblioteka kod admina
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
        
    	String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "Jmbg", "Adresa","Pol","Obrisan","Plata","Korisnicko ime","Lozinka","aktivan","tip"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];
		
		 
		for(int i=0; i<biblioteka.sviNeobrisaniClanovi().size(); i++) {
			ClanBiblioteke clan = biblioteka.sviNeobrisaniClanovi().get(i);
            sadrzaj[i][0] = clan.getId();
            sadrzaj[i][1] = clan.getIme();
            sadrzaj[i][2] = clan.getPrezime();
            sadrzaj[i][3] = clan.getJmbg();
            sadrzaj[i][4] = clan.getAdresa(); 
            sadrzaj[i][5] = clan.getPol();
            sadrzaj[i][6] = clan.isObrisan();
            sadrzaj[i][7] = clan.getBrojClanskeKarte();
            sadrzaj[i][8] = clan.getDatumPoslUplate();
            sadrzaj[i][9] = clan.getBrojMeseciClan();
            sadrzaj[i][10] = clan.isAktivan();
            sadrzaj[i][11] = clan.getTip();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanoviTabela = new JTable(tableModel);
		
		clanoviTabela.setRowSelectionAllowed(true);
		clanoviTabela.setColumnSelectionAllowed(false);
		clanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanoviTabela.setDefaultEditor(Object.class, null);
		clanoviTabela.getTableHeader().setReorderingAllowed(false);
		
		//JScrollPane scrollPane = new JScrollPane(clanoviTabela);
		//add(scrollPane, BorderLayout.CENTER);
		
		
	
        clanoviTabela.setBounds(39, 70, 565, 371);
        panel.add(clanoviTabela);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(32, 488, 111, 46);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Azuriraj");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(184, 488, 105, 46);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Obrisi");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(437, 488, 105, 46);
        panel.add(btnNewButton_2);
        
        textField = new JTextField();
        textField.setBounds(640, 59, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(640, 94, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(640, 125, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(640, 158, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(640, 189, 96, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(640, 220, 96, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(640, 251, 96, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(640, 284, 96, 20);
        panel.add(textField_7);
        textField_7.setColumns(10);
        
        textField_8 = new JTextField();
        textField_8.setBounds(640, 321, 96, 20);
        panel.add(textField_8);
        textField_8.setColumns(10);
        
        textField_9 = new JTextField();
        textField_9.setBounds(640, 359, 96, 20);
        panel.add(textField_9);
        textField_9.setColumns(10);
        
        textField_10 = new JTextField();
        textField_10.setBounds(640, 396, 96, 20);
        panel.add(textField_10);
        textField_10.setColumns(10);
        
        textField_11 = new JTextField();
        textField_11.setBounds(640, 433, 96, 20);
        panel.add(textField_11);
        textField_11.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(640, 46, 49, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Ime:");
        lblNewLabel_1.setBounds(640, 81, 49, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Prezime:");
        lblNewLabel_2.setBounds(640, 113, 96, 14);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Jmbg:");
        lblNewLabel_3.setBounds(640, 144, 49, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Adresa:");
        lblNewLabel_4.setBounds(640, 176, 49, 14);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Pol:");
        lblNewLabel_5.setBounds(640, 207, 49, 14);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Obrisan:");
        lblNewLabel_6.setBounds(641, 238, 136, 14);
        panel.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Broj clanske karte:");
        lblNewLabel_7.setBounds(640, 271, 148, 14);
        panel.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Datum posl. uplate:");
        lblNewLabel_8.setBounds(640, 309, 117, 14);
        panel.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Br.meseci clanarine:");
        lblNewLabel_9.setBounds(640, 346, 148, 14);
        panel.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Aktivan:");
        lblNewLabel_10.setBounds(640, 384, 49, 14);
        panel.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("Tip:");
        lblNewLabel_11.setBounds(640, 418, 49, 14);
        panel.add(lblNewLabel_11);
        
	}
}