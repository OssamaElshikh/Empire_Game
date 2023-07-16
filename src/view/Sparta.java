package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Sparta extends JLabel implements ActionListener {
	
	private MainView parent;
	private JLabel label;

	private JLabel hagat;   //ba7ot 3aleh el zarayer
	private JButton buildfarm;
	private JButton buildmarket;
	private JButton buildarcheryrange;
	private JButton buildbarracks;
	private JButton buildstable;
	private JButton upgradefarm;
	private JButton upgrademarket;
	private JButton upgradearcheryrange;
	private JButton upgradebarracks;
	private JButton upgradestable;
	private JButton showWorldmap;
	public Sparta(MainView parent) {
		this.parent=parent;
		
		//this.setIcon(new ImageIcon ("ossa5.jpg"));
		

		showWorldmap=new JButton("Show World Map");
		showWorldmap.setBounds(400, 200, 180,45);
		this.add(showWorldmap);
		showWorldmap.addActionListener(this);
		
		
		hagat=new JLabel("");
		hagat.setBounds(20,20, 330, 600);
		hagat.setLayout(new GridLayout(5,2));
		this.add(hagat);
		hagat.setVisible(true);
		
		
		
		buildfarm=new JButton("buildfarm");
		hagat.add(buildfarm);
		
		upgradefarm=new JButton("upgradefarm");
		hagat.add(upgradefarm);
		
		
		buildmarket=new JButton("buildmarket");
		hagat.add(buildmarket);
		

		upgrademarket=new JButton("upgrademarket");
		hagat.add(upgrademarket);
		
		buildarcheryrange=new JButton("buildarcheryrange");
		hagat.add(buildarcheryrange);
		
		upgradearcheryrange=new JButton("upgradearcheryrange");
		hagat.add(upgradearcheryrange);
		
		
		buildbarracks=new JButton("buildbarracks");
		hagat.add(buildbarracks);
		
	    upgradebarracks=new JButton("upgradebarracks");
	    hagat.add(upgradebarracks);
		
		buildstable=new JButton("buildstable");
		hagat.add(buildstable);
	
			
		upgradestable=new JButton("upgradestable");
		hagat.add(upgradestable);
		
		
		
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==showWorldmap) {
			this.setVisible(false);
			parent.endsparta();
			}
			
		}
		

	
	

}
