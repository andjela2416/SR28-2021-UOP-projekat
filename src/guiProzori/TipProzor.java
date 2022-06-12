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
import projekat.Tip;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class TipProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultTableModel tableModel;
	private JTable tipoviTabela;
	private Biblioteka biblioteka;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipProzor frame = new TipProzor(null);
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
	public TipProzor(Biblioteka biblioteka) {
		setTitle("Tip Clanarine");
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
        
    	String[] zaglavlja = new String[] {"id","naziv", "cena", "obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniTipovi().size()][zaglavlja.length];
		
		 
		for(int i=0; i<biblioteka.sviNeobrisaniTipovi().size(); i++) {
			Tip tip = biblioteka.sviNeobrisaniTipovi().get(i);
            sadrzaj[i][0] = tip.getId();
            sadrzaj[i][1] = tip.getNaziv();
            sadrzaj[i][2] = tip.getCena();
            sadrzaj[i][3] = tip.isObrisan();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		tipoviTabela = new JTable(tableModel);
		
		tipoviTabela.setRowSelectionAllowed(true);
		tipoviTabela.setColumnSelectionAllowed(false);
		tipoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tipoviTabela.setDefaultEditor(Object.class, null);
		tipoviTabela.getTableHeader().setReorderingAllowed(false);
		
		//JScrollPane scrollPane = new JScrollPane(tipoviTabela);
		//add(scrollPane, BorderLayout.CENTER);
		
		
	
        tipoviTabela.setBounds(39, 70, 565, 371);
        panel.add(tipoviTabela);
        
        textField = new JTextField();
        textField.setBounds(649, 108, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(649, 182, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(649, 252, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(649, 323, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(39, 476, 96, 34);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Azuriraj");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(169, 476, 105, 34);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Obrisi");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(429, 476, 105, 34);
        panel.add(btnNewButton_2);
        
        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setBounds(649, 93, 49, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Naziv:");
        lblNewLabel_1.setBounds(649, 168, 49, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Cena:");
        lblNewLabel_2.setBounds(649, 235, 49, 14);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Obrisan:");
        lblNewLabel_3.setBounds(649, 308, 159, 14);
        panel.add(lblNewLabel_3);
	}

}
