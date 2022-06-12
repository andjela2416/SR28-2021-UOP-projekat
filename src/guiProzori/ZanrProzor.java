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
import projekat.Zanr;


import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class ZanrProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;
	private Biblioteka biblioteka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZanrProzor frame = new ZanrProzor(null);
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
	public ZanrProzor(Biblioteka biblioteka) {
		setTitle("Zanrovi Knjiga");
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
    	String[] zaglavlja = new String[] {"oznaka","opis","obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniZanrovi().size()][zaglavlja.length];
		
		 
		for(int i=0; i<biblioteka.sviNeobrisaniZanrovi().size(); i++) {
			Zanr zanr = biblioteka.sviNeobrisaniZanrovi().get(i);
            sadrzaj[i][0] = zanr.getOznaka();
            sadrzaj[i][1] = zanr.getOpis();
            sadrzaj[i][2] = zanr.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zanroviTabela = new JTable(tableModel);
		
		zanroviTabela.setRowSelectionAllowed(true);
		zanroviTabela.setColumnSelectionAllowed(false);
		zanroviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanroviTabela.setDefaultEditor(Object.class, null);
		zanroviTabela.getTableHeader().setReorderingAllowed(false);
		
		//JScrollPane scrollPane = new JScrollPane(zanroviTabela);
		//add(scrollPane, BorderLayout.CENTER);
		
		
	
        zanroviTabela.setBounds(39, 70, 565, 371);
        panel.add(zanroviTabela);

//        JTable table = new JTable();
//        table.setBackground(Color.WHITE);
//        table.setBounds(91, 26, 406, 405);
//        panel.add(table);
        
        textField = new JTextField();
        textField.setBounds(637, 157, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(637, 233, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(637, 296, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(42, 461, 105, 41);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Azuriraj");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(172, 461, 96, 41);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Obrisi");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(445, 461, 105, 41);
        panel.add(btnNewButton_2);
        
        JLabel lblNewLabel = new JLabel("Oznaka:");
        lblNewLabel.setBounds(637, 142, 49, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Opis:");
        lblNewLabel_1.setBounds(637, 220, 49, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Obrisan:");
        lblNewLabel_2.setBounds(637, 282, 118, 14);
        panel.add(lblNewLabel_2);
	}

}
