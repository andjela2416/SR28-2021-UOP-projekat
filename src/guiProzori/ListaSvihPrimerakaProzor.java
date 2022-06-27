package guiProzori;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Biblioteka;
import bibliotekaMain.BibliotekaMain;
import projekat.IzdavanjeKnjige;
import projekat.PrimerakKnjige;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ListaSvihPrimerakaProzor extends JFrame {
	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
	private JButton btnAdd = new JButton("Dodaj");
	private JButton btnRemove = new JButton("Obrisi");
	
	protected ArrayList<PrimerakKnjige> sviIznajmljeni = new ArrayList<PrimerakKnjige>();
	
	
	public ListaSvihPrimerakaProzor(Biblioteka biblioteka) {
		
	
		this.biblioteka = biblioteka;
		setTitle("Svi iznajmljeni primerci");
		setSize(1300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
		/*************************************************************************************/
		
		//Lista iznajmljenih primeraka
		for(PrimerakKnjige j : biblioteka.sviNeobrisaniPrimerciKnjiga()) {
			if(j.isIznajmljena()==true && j.isObrisan()==false) {
				
				sviIznajmljeni.add(j);
				
			}
		}
		
		/*************************************************************************************/
		
		
		String[] zaglavlja = new String[] {"ID", "Broj strana", "Tvrd povez", "Godina štampanja", "Iznajmljena", "Knjiga kojoj pripada", "Jezik Štampanja", "Obrisan"};
		Object[][] sadrzaj = new Object[sviIznajmljeni.size()][zaglavlja.length];
		
		
		for(int i=0; i<sviIznajmljeni.size(); i++) {
			
				PrimerakKnjige primerak = sviIznajmljeni.get(i);
			
				sadrzaj[i][0] = primerak.getId();
				sadrzaj[i][1] = primerak.getBrojStrana();
				sadrzaj[i][2] = primerak.isMekPovez();
				sadrzaj[i][3] = primerak.getGodinaStampanja();
				sadrzaj[i][4] = primerak.isIznajmljena();
				sadrzaj[i][5] = primerak.getKnjiga();
				sadrzaj[i][6] = primerak.getJezikStampanja();
				sadrzaj[i][7] = primerak.isObrisan();
				
		}
			
			tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
			primerciTabela = new JTable(tableModel);
			
			primerciTabela.setRowSelectionAllowed(true);
			primerciTabela.setColumnSelectionAllowed(false);
			primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			primerciTabela.setDefaultEditor(Object.class, null);
			primerciTabela.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane scrollPane = new JScrollPane(primerciTabela);
			btnAdd.setBounds(0, 0, 120, 120);
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(432)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addGap(221)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(473, Short.MAX_VALUE))
					.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1303, Short.MAX_VALUE)
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			getContentPane().setLayout(groupLayout);
			
			initAction();
	
		}
	
		
		private void initAction() {
			
			/*************************************************************************************/
			
			btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DodavanjeIznajmljenogPrimerkaProzor dp = new DodavanjeIznajmljenogPrimerkaProzor(biblioteka, null);
					dp.setVisible(true);
					
				}
			});
			
			/*************************************************************************************/
			
			btnRemove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int red = primerciTabela.getSelectedRow();
					
					if(red == -1) {
						
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
						
					}else {
						
						String primerciId = tableModel.getValueAt(red, 0).toString();
						PrimerakKnjige p = biblioteka.pronadjiPrimerak(primerciId);
						
						int select = JOptionPane.showConfirmDialog(null, 
								"Da li ste sigurni da zelite da obrisete iznajmljeni primerak?", 
								primerciId + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						
						if(select == JOptionPane.YES_OPTION) {
							
							p.setIznajmljena(false);
							tableModel.removeRow(red);
							
							//Element koji se uklonio iz liste iznajmljenih primeraka treba i iz iznajmljivanja
							for(IzdavanjeKnjige i : biblioteka.svaNeobrisanaIzdavanja()) {
								
								String el = String.valueOf(p.getId()) ;
								int index = i.getPrimerci().indexOf(el);
								i.getPrimerci().remove(index);
								
								//Ako u nekom iznajmljivanju vise ne postoji primeraka
								if(i.getPrimerci().size() == 0) {
									
									i.setObrisan(true);
									
								}
							}
							
							biblioteka.snimiPrimerkeKnjiga();
							biblioteka.snimiIznajmljivanje();
							
							
						}
					}
				}
			});
			
			/*************************************************************************************/
			
	}
}


