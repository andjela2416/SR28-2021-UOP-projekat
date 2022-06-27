package guiProzori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import projekat.Bibliotekar;
import projekat.Zaposleni;
import biblioteka.Biblioteka;

public class Login extends JFrame {

	private JLabel lblGreeting = new JLabel("Dobrodosli. Molimo da se prijavite.");
	private JLabel lblUsername = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Sifra");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	
	public Login(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[][]");
		getContentPane().setLayout(mig);
		
		getContentPane().add(lblGreeting, "cell 0 0 2 1");
		getContentPane().add(lblUsername, "cell 0 1");
		getContentPane().add(txtKorisnickoIme, "cell 1 1");
		getContentPane().add(lblPassword, "cell 0 2");
		getContentPane().add(pfPassword, "cell 1 2");
		getContentPane().add(new JLabel(), "flowx,cell 0 3");
		getContentPane().add(btnOk, "flowx,cell 1 3");
		getContentPane().add(btnCancel, "cell 1 3");
		
		
		txtKorisnickoIme.setText("andjela24");
		pfPassword.setText("lozinka");
		getRootPane().setDefaultButton(btnOk);
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
				Login.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnikoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfPassword.getPassword()).trim();
				
				if(korisnikoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					Zaposleni prijavljeni = biblioteka.login(korisnikoIme, sifra,biblioteka);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						Login.this.dispose();
						Login.this.setVisible(false);
						GlavniProzor gp = new GlavniProzor(biblioteka, prijavljeni);
						gp.setVisible(true);
						if (prijavljeni instanceof Bibliotekar) {
							gp.getAdminiItem().setEnabled(false);
							gp.getBibliotekariItem().setEnabled(false);
						}
					}
				} 
			}
		});
		
	}
}
