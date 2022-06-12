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
import projekat.Bibliotekar;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JLabel;

public class BibliotekarProzor extends JFrame {

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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private DefaultTableModel tableModel;
	private JTable bibliotekariTabela;
	private Biblioteka biblioteka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibliotekarProzor frame = new BibliotekarProzor(null);
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
	public BibliotekarProzor(Biblioteka biblioteka) {
		setTitle("Bibliotekar");
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
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniBibliotekari().size()][zaglavlja.length];
		
		 
		for(int i=0; i<biblioteka.sviNeobrisaniBibliotekari().size(); i++) {
			Bibliotekar bibliotekar = biblioteka.sviNeobrisaniBibliotekari().get(i);
            sadrzaj[i][0] = bibliotekar.getId();
            sadrzaj[i][1] = bibliotekar.getIme();
            sadrzaj[i][2] = bibliotekar.getPrezime();
            sadrzaj[i][3] = bibliotekar.getJmbg();
            sadrzaj[i][4] = bibliotekar.getAdresa(); 
            sadrzaj[i][5] = bibliotekar.getPol();
            sadrzaj[i][6] = bibliotekar.getPlata();
            sadrzaj[i][7] = bibliotekar.getKorisnickoIme();
            sadrzaj[i][8] = bibliotekar.getLozinka();
            sadrzaj[i][9] = bibliotekar.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		bibliotekariTabela = new JTable(tableModel);
		
		bibliotekariTabela.setRowSelectionAllowed(true);
		bibliotekariTabela.setColumnSelectionAllowed(false);
		bibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bibliotekariTabela.setDefaultEditor(Object.class, null);
		bibliotekariTabela.getTableHeader().setReorderingAllowed(false);
		
		//JScrollPane scrollPane = new JScrollPane(bibliotekariTabela);
		//add(scrollPane, BorderLayout.CENTER);
		
		
	
        bibliotekariTabela.setBounds(39, 70, 565, 371);
        panel.add(bibliotekariTabela);

//        JTable table = new JTable();
//        table.setBounds(70, 26, 427, 425);
//        panel.add(table);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(23, 481, 96, 37);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Azuriraj");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(151, 481, 96, 37);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Obrisi");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(449, 481, 86, 37);
        panel.add(btnNewButton_2);
        
        textField = new JTextField();
        textField.setBounds(649, 42, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(649, 87, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(649, 137, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(649, 186, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(649, 233, 96, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(649, 285, 96, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(649, 340, 96, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(649, 390, 96, 20);
        panel.add(textField_7);
        textField_7.setColumns(10);
        
        textField_8 = new JTextField();
        textField_8.setBounds(649, 431, 96, 20);
        panel.add(textField_8);
        textField_8.setColumns(10);
        
        textField_9 = new JTextField();
        textField_9.setBounds(649, 473, 96, 20);
        panel.add(textField_9);
        textField_9.setColumns(10);
        
        lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(650, 26, 49, 14);
        panel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Ime:");
        lblNewLabel_1.setBounds(649, 73, 49, 14);
        panel.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Prezime:");
        lblNewLabel_2.setBounds(649, 124, 96, 14);
        panel.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Jmbg:");
        lblNewLabel_3.setBounds(650, 168, 49, 14);
        panel.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Adresa:");
        lblNewLabel_4.setBounds(649, 217, 49, 14);
        panel.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Pol:");
        lblNewLabel_5.setBounds(649, 272, 49, 14);
        panel.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("Obrisan:");
        lblNewLabel_6.setBounds(649, 326, 96, 14);
        panel.add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("Plata:");
        lblNewLabel_7.setBounds(650, 378, 49, 14);
        panel.add(lblNewLabel_7);
        
        lblNewLabel_8 = new JLabel("Korisnicko ime:");
        lblNewLabel_8.setBounds(649, 418, 96, 14);
        panel.add(lblNewLabel_8);
        
        lblNewLabel_9 = new JLabel("Lozinka:");
        lblNewLabel_9.setBounds(652, 460, 49, 14);
        panel.add(lblNewLabel_9);
	}

}
