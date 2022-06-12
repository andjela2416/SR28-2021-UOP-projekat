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
import projekat.PrimerakKnjige;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JLabel;

public class PrimerakProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	private Biblioteka biblioteka;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimerakProzor frame = new PrimerakProzor(null);
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
	public PrimerakProzor(Biblioteka biblioteka) {
		setTitle("Primerak");
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

		String[] zaglavlja = new String[] {"id", "brojStrana", "mekPovez","godinaStampanja","jezikStampanja",
				"iznajmljena", " knjiga","obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniPrimerciKnjiga().size()][zaglavlja.length];
		
		 
		for(int i=0; i<biblioteka.sviNeobrisaniPrimerciKnjiga().size(); i++) {
			PrimerakKnjige primerak = biblioteka.sviNeobrisaniPrimerciKnjiga().get(i);
            sadrzaj[i][0] = primerak.getId();
            sadrzaj[i][1] = primerak.getBrojStrana();
            sadrzaj[i][2] = primerak.isMekPovez();
            sadrzaj[i][3] = primerak.getGodinaStampanja();
            sadrzaj[i][4] = primerak.getJezikStampanja(); 
            sadrzaj[i][5] = primerak.isIznajmljena();
            sadrzaj[i][6] = primerak.getKnjiga();
            sadrzaj[i][7] = primerak.isObrisan();
         
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerciTabela = new JTable(tableModel);
		
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		
		//JScrollPane scrollPane = new JScrollPane(primerciTabela);
		//add(scrollPane, BorderLayout.CENTER);
		
		
	
        primerciTabela.setBounds(39, 70, 565, 371);
        panel.add(primerciTabela);

//        JTable table = new JTable();
//        table.setBounds(108, 50, 367, 376);
//        panel.add(table);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(10, 473, 110, 40);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Azuriraj");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(149, 473, 110, 40);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Obrisi");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(421, 473, 96, 40);
        panel.add(btnNewButton_2);
        
        textField = new JTextField();
        textField.setBounds(646, 68, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(646, 127, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(646, 183, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(646, 245, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(646, 302, 96, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(646, 357, 96, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(646, 410, 96, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(646, 462, 96, 20);
        panel.add(textField_7);
        textField_7.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(646, 50, 49, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Broj strana:");
        lblNewLabel_1.setBounds(646, 112, 110, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Mek povez:");
        lblNewLabel_2.setBounds(646, 170, 82, 14);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Godina stampanja:");
        lblNewLabel_3.setBounds(646, 230, 121, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Jezik stampanja:");
        lblNewLabel_4.setBounds(646, 288, 121, 14);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Iznajmljena:");
        lblNewLabel_5.setBounds(646, 342, 121, 14);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Knjiga kojoj pripada:");
        lblNewLabel_6.setBounds(646, 392, 160, 20);
        panel.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Obrisana:");
        lblNewLabel_7.setBounds(646, 450, 110, 14);
        panel.add(lblNewLabel_7);
	}

}
