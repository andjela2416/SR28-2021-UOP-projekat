//package guiProzori;
//import biblioteka.Biblioteka;
//import guiProzori.GlavniProzor;
////import net.miginfocom.swing.MigLayout;
//import projekat.Zaposleni;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JButton;
//import java.awt.Color;
//import java.awt.FlowLayout;
//import javax.swing.JLabel;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.ImageIcon;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JMenu;
//import javax.swing.JToolBar;
//import javax.swing.SwingConstants;
//
//public class GlavniProzor extends JFrame {
//	
//	private Zaposleni prijavljeniKorisnik;
//	
//	private Biblioteka biblioteka;
//	
//	public GlavniProzor(Biblioteka biblioteka) {
//		getContentPane().setBackground(Color.WHITE);
//		
//		JButton lblNewLabel = new JButton("New label");
//		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/biblioteks.jpeg")));
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBackground(Color.WHITE);
//		
//		JButton btnNewButton_1 = new JButton("Clanovi");
//		
//		JButton btnNewButton_2 = new JButton("Zaposleni");
//		
//		JButton btnNewButton_3 = new JButton("Knjige");
//		
//		JButton btnNewButton_4 = new JButton("Izdavanje Knjiga");
//		
//		JButton btnNewButton_5 = new JButton("Primerci Knjiga");
//		GroupLayout groupLayout = new GroupLayout(getContentPane());
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addGroup(groupLayout.createSequentialGroup()
//							.addContainerGap()
//							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
//							.addGap(57)
//							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
//							.addGap(70)
//							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
//							.addGap(61)
//							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
//							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//							.addComponent(btnNewButton_5)
//							.addGap(135))
//						.addGroup(groupLayout.createSequentialGroup()
//							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)
//							.addPreferredGap(ComponentPlacement.RELATED)))
//					.addComponent(btnNewButton)
//					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addGroup(groupLayout.createSequentialGroup()
//							.addGap(185)
//							.addComponent(btnNewButton))
//						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
//					.addGap(18)
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
//						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
//							.addComponent(btnNewButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//							.addComponent(btnNewButton_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
//					.addContainerGap(41, Short.MAX_VALUE))
//		);
//		getContentPane().setLayout(groupLayout);
//        this.biblioteka = biblioteka;
//        setTitle("Biblioteka");
//        setSize(762, 433);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//        
//        JMenuBar menuBar = new JMenuBar();
//        setJMenuBar(menuBar);
//        
//        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Biblioteka");
//        menuBar.add(mntmNewMenuItem_2);
//        
//        JMenu mnNewMenu = new JMenu("Drugo");
//        menuBar.add(mnNewMenu);
//        
//        JMenuItem mntmNewMenuItem = new JMenuItem("Tipovi ");
//        mnNewMenu.add(mntmNewMenuItem);
//        
//        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Zanrovi");
//        mnNewMenu.add(mntmNewMenuItem_1);
//        //initGUI();
//        //initActions();
//    }
//	
////	private void gui () {
////		MigLayout mig = new MigLayout("wrap 1", "[250px:n,grow][360px:n,grow][250px:n]", "[200px:n,grow][50px:n][80px:n][80px:n][]");
////		getContentPane().setLayout(mig);
////		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
////		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/library.jpg")));
////	}
//}

package guiProzori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import biblioteka.Biblioteka;
import guiProzori.AdminProzor;
import guiProzori.KnjigeProzor;
import guiProzori.BibliotekaProzor;
import guiProzori.BibliotekarProzor;
import guiProzori.AdminProzor;
import guiProzori.ClanProzor;
import guiProzori.IzdavanjeProzor;
import guiProzori.PrimerakProzor;
import guiProzori.TipProzor;
import guiProzori.ZanrProzor;
import projekat.Zaposleni;
import projekat.Bibliotekar;
import projekat.IzdavanjeKnjige;
import projekat.Administrator;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class GlavniProzor extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu ljudiMenu = new JMenu("Ljudi");
	private JMenuItem adminiItem = new JMenuItem("Admini");
	private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
	private JMenuItem clanoviItem = new JMenuItem("Clanovi");
	private JMenu bibliotekaMenu = new JMenu("Drugo");
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniKorisnik;
	private IzdavanjeKnjige izdavanje;
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JButton btnNewButton = new JButton("Primerci Knjiga");
	private final JButton btnNewButton_1 = new JButton("Knjige");
	private final JButton btnNewButton_2 = new JButton("Izdavanje");
	private final JMenuItem mntmNewMenuItem = new JMenuItem("Zanrovi");
	private final JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tipovi");
	private final JMenu mnNewMenu = new JMenu("Biblioteka");
	private final JMenuItem mntmNewMenuItem_2 = new JMenuItem("Biblioteka");
	private final JButton btnNewButton_3 = new JButton("Placanje");
	
	//private final JMenuItem mntmNewMenuItem_2 = new JMenuItem("Liste");
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik) {
		getContentPane().setBackground(new Color(255, 228, 225));
		getContentPane().setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/biblioteks.jpeg")));
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Zaposleni: "+ prijavljeniKorisnik.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	 
	private void initMenu() {
		setJMenuBar(mainMenu);
		
		mainMenu.add(mnNewMenu);
		
		mnNewMenu.add(mntmNewMenuItem_2);
		
		//mnNewMenu.add(mntmNewMenuItem_2);
		mainMenu.add(ljudiMenu);
		ljudiMenu.add(adminiItem);
		ljudiMenu.add(bibliotekariItem);
		ljudiMenu.add(clanoviItem);
		mainMenu.add(bibliotekaMenu);
		
		bibliotekaMenu.add(mntmNewMenuItem);
		
		bibliotekaMenu.add(mntmNewMenuItem_1);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 487, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
	private void initActions() {
		
//		if (prijavljeniKorisnik.equals(id.zaposleni.instanceof(bibliotekar))) {
//			
//		}
//		
		adminiItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminProzor pp = new AdminProzor(biblioteka, rootPaneCheckingEnabled);
				pp.setVisible(true);
				//System.out.println(biblioteka.getListaAdministratora());
			}
		});
		
		bibliotekariItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekarProzor kp = new BibliotekarProzor(biblioteka, rootPaneCheckingEnabled);
				kp.setVisible(true);
			}
		});
		
		clanoviItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanProzor dp = new ClanProzor(biblioteka, rootPaneCheckingEnabled);
				dp.setVisible(true); 
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeProzor kp = new KnjigeProzor(biblioteka, rootPaneCheckingEnabled);
				kp.setVisible(true);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				IzdavanjeProzor kp = new IzdavanjeProzor(biblioteka, rootPaneCheckingEnabled); //???????
				kp.setVisible(true);
			}
			
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanrProzor kp = new ZanrProzor(biblioteka, rootPaneCheckingEnabled);
				kp.setVisible(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerakProzor kp = new PrimerakProzor(biblioteka, rootPaneCheckingEnabled);
				kp.setVisible(true);
			}
		});
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TipProzor kp = new TipProzor(biblioteka, rootPaneCheckingEnabled);
				kp.setVisible(true);
			}
		});
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekaProzor kp = new BibliotekaProzor(biblioteka, rootPaneCheckingEnabled);
				kp.setVisible(true);
			}
		}); 
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Placanje kp = new Placanje(biblioteka);
				kp.setVisible(true);
			}
		}); 
		
		
	}

	public JMenuItem getAdminiItem() {
		return adminiItem;
	}

	public void setAdminiItem(JMenuItem adminiItem) {
		this.adminiItem = adminiItem;
	}

	public JMenuItem getBibliotekariItem() {
		return bibliotekariItem;
	}

	public void setBibliotekariItem(JMenuItem bibliotekariItem) {
		this.bibliotekariItem = bibliotekariItem;
	}
}

