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
import projekat.Knjiga;
import projekat.Zanr;


import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class KnjigeProzor extends JFrame {

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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private DefaultTableModel tableModel;
	private JTable knjigeTabela;
	private Biblioteka biblioteka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KnjigeProzor frame = new KnjigeProzor(null);
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
	public KnjigeProzor(Biblioteka biblioteka) {
		setTitle("Knjiga");
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

		String[] zaglavlja = new String[] {" id", "naslovKnjige","originalNaslovKnjige", " pisac","godinaObjavljivanja",
				"jezikOriginala","opis", "zanr"," obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sveNeobrisaneKnjige().size()][zaglavlja.length];
		
		 
		for(int i=0; i<biblioteka.sveNeobrisaneKnjige().size(); i++) {
			Knjiga knjiga = biblioteka.sveNeobrisaneKnjige().get(i);
            sadrzaj[i][0] = knjiga.getId();
            sadrzaj[i][1] = knjiga.getNaslovKnjige();
            sadrzaj[i][2] = knjiga.getOriginalNaslovKnjige();
            sadrzaj[i][3] = knjiga.getPisac();
            sadrzaj[i][4] = knjiga.getGodinaObjavljivanja(); 
            sadrzaj[i][5] = knjiga.getJezikOriginala();
            sadrzaj[i][6] = knjiga.getOpis();
            sadrzaj[i][7] = knjiga.getZanr();
            sadrzaj[i][8] = knjiga.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		knjigeTabela = new JTable(tableModel);
		
		knjigeTabela.setRowSelectionAllowed(true);
		knjigeTabela.setColumnSelectionAllowed(false);
		knjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjigeTabela.setDefaultEditor(Object.class, null);
		knjigeTabela.getTableHeader().setReorderingAllowed(false);
		
		//JScrollPane scrollPane = new JScrollPane(knjigeTabela);
		//add(scrollPane, BorderLayout.CENTER);
		
		
	
        knjigeTabela.setBounds(39, 70, 565, 371);
        panel.add(knjigeTabela);

//        JTable table = new JTable();
//        table.setBounds(85, 26, 412, 423);
//        panel.add(table);
        
        textField = new JTextField();
        textField.setBounds(651, 50, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(651, 103, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(651, 160, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(651, 212, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(651, 270, 96, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(651, 316, 96, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(651, 366, 96, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(651, 421, 96, 20);
        panel.add(textField_7);
        textField_7.setColumns(10);
        
        textField_8 = new JTextField();
        textField_8.setBounds(651, 469, 96, 20);
        panel.add(textField_8);
        textField_8.setColumns(10);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(21, 488, 102, 39);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Azuriraj");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(150, 488, 102, 39);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Obrisi");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(436, 487, 96, 39);
        panel.add(btnNewButton_2);
        
        lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(651, 35, 49, 14);
        panel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Naslov knjige:");
        lblNewLabel_1.setBounds(651, 88, 123, 14);
        panel.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Original naslov knjige:");
        lblNewLabel_2.setBounds(651, 146, 194, 14);
        panel.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Pisac:");
        lblNewLabel_3.setBounds(651, 197, 49, 14);
        panel.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Godina objavljivanja:");
        lblNewLabel_4.setBounds(651, 255, 123, 14);
        panel.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Jezik originala:");
        lblNewLabel_5.setBounds(651, 302, 109, 14);
        panel.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("Opis:");
        lblNewLabel_6.setBounds(651, 353, 49, 14);
        panel.add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("Zanr:");
        lblNewLabel_7.setBounds(651, 407, 49, 14);
        panel.add(lblNewLabel_7);
        
        lblNewLabel_8 = new JLabel("Obrisana:");
        lblNewLabel_8.setBounds(651, 455, 49, 14);
        panel.add(lblNewLabel_8);
	}

	

}
