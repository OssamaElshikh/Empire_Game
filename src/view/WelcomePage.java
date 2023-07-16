package view;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.IOException;
import java.awt.event.ActionEvent;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WelcomePage extends JLabel implements ActionListener  {



	public String getBox() {
		return (String) box.getSelectedItem();
	}

	
    private static final Color gold=new Color(255,204,51);
	private JButton start;
	private JLabel L1,L2;
	public JTextField text;
	private JComboBox<String> box;
	private MainView parent;
	private JRadioButton radio;
	
	
	public WelcomePage(MainView parent){
		this.parent=parent;
		
		L1 = new JLabel("Player Name ");
		L1.setBounds(75, 150, 120 ,40);
		this.add(L1);
		L1.setForeground(new Color(255,204,70));		
		L1.setVisible(true);    //malhash lazma
	
		
		
		String [] combo = {"Select a city","Cairo","Rome","Sparta"};		
		box=new JComboBox<String> (combo);
		box.setBounds(140, 250, 200, 60);
		
		this.add(box);
		
		//box.setVisible(true);    //malhash lazma
		
		
		/*
		JRadioButton city1 = new JRadioButton("Cairo");
		city1.setOpaque(true);
		city1.setBackground(Color.lightGray);
        JRadioButton city2 = new JRadioButton("Rome");
        city2.setOpaque(true);
        city2.setBackground(Color.lightGray);
        JRadioButton city3 = new JRadioButton("Sparta");
        city3.setOpaque(true);
        city3.setBackground(Color.lightGray);
 
        ButtonGroup group = new ButtonGroup();
        group.add(city1);
        group.add(city2);
        group.add(city3);
        
        city1.setBounds(140, 250, 200, 30);
        this.add(city1);
        city2.setBounds(140, 270, 200, 30);
        this.add(city2);
        city3.setBounds(140, 290, 200, 30);
        this.add(city3);
        
		*/
		
			
		
		
		start = new JButton ("Start Game");
		start.setBounds(140, 390, 230, 58);
		this.add(start);
		start.setForeground(new Color(255,204,150));
		start.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		start.addActionListener(this);
		start.setOpaque(true);
		start.setBackground(Color.black);
		start.setVisible(true);
		
		
		
		text=new JTextField();
		text.setBounds(158,155,180, 30);
		this.add(text);
		text.setOpaque(true);
		text.setBackground(Color.lightGray);
		text.setVisible(true);
		
		
		
		
		L2 =new JLabel("");
	    L2.setBounds(0, 0, 1600,720);
	    L2.setIcon(new ImageIcon ("empire.png"));
	    this.add(L2);
	    L2.setVisible(true);
	    
	    
	    this.setVisible(true);
	    this.setSize(1035,745);
	    
	    
	    
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource()==start){
			if (text.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "YOU MUST ENTER YOUR NAME","Error",JOptionPane.ERROR_MESSAGE);
			}
			if (box.getSelectedIndex()== 0) {
				JOptionPane.showMessageDialog(this, "YOU MUST SELECT A CITY","Error",JOptionPane.ERROR_MESSAGE);	
				
			}
			
			else {
				parent.ends(text.getText(),box.getSelectedItem().toString());
			}
			
		}
				
	}

	
	

}
