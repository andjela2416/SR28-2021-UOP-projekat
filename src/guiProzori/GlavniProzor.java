package guiProzori;
import biblioteka.Biblioteka;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GlavniProzor extends JFrame {
	
	private Biblioteka biblioteka;
	
	public GlavniProzor(Biblioteka biblioteka) {
		getContentPane().setBackground(Color.WHITE);
		
		JButton lblNewLabel = new JButton("New label");
		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/biblioteks.jpeg")));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(Color.GREEN);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 748, Short.MAX_VALUE)
					.addGap(124)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(185)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
        this.biblioteka = biblioteka;
        setTitle("Biblioteka");
        setSize(762, 433);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
        menuBar.add(mntmNewMenuItem);
        //initGUI();
        //initActions();
    }
}
