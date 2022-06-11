package guiProzori;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class IzdavanjeProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzdavanjeProzor frame = new IzdavanjeProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IzdavanjeProzor() {
		setTitle("Izdavanje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JTable table = new JTable();
        table.setBounds(80, 26, 417, 418);
        panel.add(table);
        
        textField = new JTextField();
        textField.setBounds(652, 70, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(652, 118, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(652, 169, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(652, 219, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(652, 268, 96, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(652, 320, 96, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(23, 471, 105, 40);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Azuriraj");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(176, 471, 105, 40);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Obrisi");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(457, 471, 96, 40);
        panel.add(btnNewButton_2);
        
        JLabel lblNewLabel = new JLabel("Datum iznajmljivanja:");
        lblNewLabel.setBounds(652, 56, 120, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Datum vracanja:");
        lblNewLabel_1.setBounds(652, 105, 96, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Primerak knjige:");
        lblNewLabel_2.setBounds(652, 156, 96, 14);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Zaposleni koji je izdao:");
        lblNewLabel_3.setBounds(652, 204, 130, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Clan:");
        lblNewLabel_4.setBounds(652, 253, 49, 14);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Obrisan:");
        lblNewLabel_5.setBounds(652, 308, 49, 14);
        panel.add(lblNewLabel_5);
	}

}
