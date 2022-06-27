package guiProzori;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import biblioteka.Biblioteka;
import projekat.PrimerakKnjige;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DodavanjeIznajmljenogPrimerkaProzor extends JFrame {
	 
	private Biblioteka biblioteka;
	private	PrimerakKnjige primerak;
	private JComboBox<String> box = new JComboBox<String>();
	
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	public DodavanjeIznajmljenogPrimerkaProzor(Biblioteka biblioteka, PrimerakKnjige primerak) {

        this.biblioteka = biblioteka;
        this.primerak = primerak;

        setTitle("Dodavanje iznajmljenog primerka :");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(474,375);
        setLocationRelativeTo(null);
        btnOk.setBounds(0, 0, 120, 120);
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCancel.setBounds(0, 0, 120, 120);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(112)
        					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        					.addGap(42)
        					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(box, 0, 440, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addGap(131)
        			.addComponent(box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(11))
        );
        getContentPane().setLayout(groupLayout);
        
        for(PrimerakKnjige p : biblioteka.sviNeobrisaniPrimerciKnjiga()) {
        	if(p.isIznajmljena() == false) {
        	
        		box.addItem( p.getId() + ". primerak");
        	
        }
        	
        btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DodavanjeIznajmljenogPrimerkaProzor.this.dispose();
                    DodavanjeIznajmljenogPrimerkaProzor.this.setVisible(false);
                }
            });

         btnOk.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String primerak = box.getSelectedItem().toString();

                    String primerakId = String.valueOf(primerak.charAt(0));

                    PrimerakKnjige p = biblioteka.pronadjiPrimerak(primerakId);
                    p.setIznajmljena(true);

                    biblioteka.snimiPrimerkeKnjiga();

                    DodavanjeIznajmljenogPrimerkaProzor.this.dispose();
                    DodavanjeIznajmljenogPrimerkaProzor.this.setVisible(false);

                }
            });

        }

    }
}
