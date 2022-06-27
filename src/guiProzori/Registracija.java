package guiProzori;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteka.Biblioteka;
import projekat.Administrator;
import projekat.Pol;
import javax.swing.JList;


public class Registracija extends JFrame {

private JPanel contentPane;
private JTextField textId;
private JTextField textIme;
private JTextField textPrezime;
private JTextField textJmbg;
private JTextField textAdresa;
private JTextField textKorisnickoIme;
private JTextField textKorisnickaSifra;
private JTextField textPlata;
private Biblioteka biblioteka;
private JTextField textPol;


/* Validacija broja */

public static boolean isNum(String str) {
try {
Integer.parseInt(str);
return true;
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null, "ID mora biti broj", "Greska", JOptionPane.WARNING_MESSAGE);
return false;
}
}

private void dodaj() {
	try {
		
		boolean greska = false;
		String Id = textId.getText();
		double textPlataDouble = Double.parseDouble(textPlata.getText());
		boolean obrisan = false;
		Pol pol = Pol.valueOf(textPol.getText());
		if (isNum(textId.getText()) == true) {
			Administrator novi = new Administrator(Id, textIme.getText(), textPrezime.getText(),
					textJmbg.getText(), textAdresa.getText(), pol, obrisan,textPlataDouble,textKorisnickoIme.getText(),
					textKorisnickaSifra.getText());

			
			

			
			biblioteka.dodajAdministratora(novi);
			biblioteka.snimiAdministratore();
			this.dispose();
			this.setVisible(false);
			Login lp = new Login(biblioteka);
			lp.setVisible(true);

		}
	} catch (NumberFormatException x) {
		JOptionPane.showMessageDialog(null, "Unesite ispravno podatke", "Greska",
				JOptionPane.WARNING_MESSAGE);
	}
}



/**
* Create the frame.
*
* @param biblioteka2
*/
public Registracija(Biblioteka biblioteka) {
this.biblioteka = biblioteka;

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setBounds(100, 100, 770, 550);
contentPane = new JPanel();
contentPane.setBackground(Color.LIGHT_GRAY);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
setTitle("Registracija");
ImageIcon image = new ImageIcon("src/fajlovi/archive.png");
setIconImage(image.getImage());
getContentPane().setBackground(new Color(89, 81, 87));



JLabel lblNewLabel = new JLabel("ID");
lblNewLabel.setBounds(299, 11, 21, 14);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Ime");
lblNewLabel_1.setBounds(300, 53, 49, 14);
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("Prezime");
lblNewLabel_2.setBounds(299, 98, 49, 14);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("JMBG");
lblNewLabel_3.setBounds(299, 144, 49, 14);
contentPane.add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("Adresa");
lblNewLabel_4.setBounds(300, 189, 49, 14);
contentPane.add(lblNewLabel_4);

JLabel lblNewLabel_5 = new JLabel("Pol");
lblNewLabel_5.setBounds(300, 376, 49, 14);
contentPane.add(lblNewLabel_5);

JLabel lblNewLabel_6 = new JLabel("Korisnicko Ime");
lblNewLabel_6.setBounds(299, 280, 96, 14);
contentPane.add(lblNewLabel_6);

JLabel lblNewLabel_7 = new JLabel("Korisnicka Lozinka");
lblNewLabel_7.setBounds(299, 333, 121, 14);
contentPane.add(lblNewLabel_7);

JLabel lblNewLabel_8 = new JLabel("Plata");
lblNewLabel_8.setBounds(300, 233, 49, 14);
contentPane.add(lblNewLabel_8);

textId = new JTextField();
textId.setBounds(300, 27, 96, 20);
contentPane.add(textId);
textId.setColumns(10);

textIme = new JTextField();
textIme.setBounds(300, 67, 96, 20);
contentPane.add(textIme);
textIme.setColumns(10);

textPrezime = new JTextField();
textPrezime.setBounds(299, 113, 96, 20);
contentPane.add(textPrezime);
textPrezime.setColumns(10);

textJmbg = new JTextField();
textJmbg.setBounds(299, 156, 96, 20);
contentPane.add(textJmbg);
textJmbg.setColumns(10);

textAdresa = new JTextField();
textAdresa.setBounds(299, 202, 96, 20);
contentPane.add(textAdresa);
textAdresa.setColumns(10);

textKorisnickoIme = new JTextField();
textKorisnickoIme.setBounds(299, 295, 96, 20);
contentPane.add(textKorisnickoIme);
textKorisnickoIme.setColumns(10);

textKorisnickaSifra = new JTextField();
textKorisnickaSifra.setBounds(299, 345, 96, 20);
contentPane.add(textKorisnickaSifra);
textKorisnickaSifra.setColumns(10);

textPlata = new JTextField();
textPlata.setBounds(299, 249, 96, 20);
contentPane.add(textPlata);
textPlata.setColumns(10);

textPol = new JTextField();
textPol.setBounds(299, 390, 96, 19);
contentPane.add(textPol);
textPol.setColumns(10);
JButton btnNewButton_1 = new JButton("Registruj se");
btnNewButton_1.setBounds(251, 438, 211, 44);
contentPane.add(btnNewButton_1);

btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		dodaj();
	}
});


}
}