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
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class BibliotekaProzor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibliotekaProzor frame = new BibliotekaProzor();
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
	public BibliotekaProzor() {
		setTitle("Biblioteka");
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
        table.setBounds(72, 26, 425, 419);
        panel.add(table);
        
        textField = new JTextField();
        textField.setBounds(647, 60, 96, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(647, 125, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(647, 201, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(647, 274, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(23, 473, 108, 38);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Obrisi");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_1.setBounds(177, 473, 89, 38);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Azuriraj");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton_2.setBounds(432, 473, 96, 38);
        panel.add(btnNewButton_2);
        
        JLabel lblNewLabel = new JLabel("Naziv:");
        lblNewLabel.setBounds(653, 43, 49, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Adresa:");
        lblNewLabel_1.setBounds(653, 106, 49, 14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Telefon:");
        lblNewLabel_2.setBounds(647, 176, 49, 14);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Radno vreme:");
        lblNewLabel_3.setBounds(653, 257, 89, 14);
        panel.add(lblNewLabel_3);
        
        JList list = new JList();
        list.setBounds(692, 422, -54, -34);
        panel.add(list);
	}
}
