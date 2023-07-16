package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameView extends JLabel  implements ActionListener{
	private GeneralInfo GeneralInfo;
	private MainView parent;
	private JButton showcity;
	private JButton hidecity;
	private Cairo cairo;
	private JButton cairos;
	private JButton rome;
	private JButton sparta;
	private JLabel cairol;
	private JLabel spartal;
	private JLabel romel;
	private JButton endturn;
	private JButton attack;
	private JButton seige;
	private JComboBox<String> attacks;

	
	
	
	
	public MainView getParent() {
		return parent;
	}

	public GameView(MainView parent) {
		this.parent=parent;
		
		
	
		
		cairol = new JLabel("Cairo");
		cairol.setBounds(555, 330, 100 ,40);
		this.add(cairol);
		cairol.setForeground(Color.black);		
		cairol.setVisible(true);
		
		romel = new JLabel("Rome ");
		romel.setBounds(850, 450, 100 ,40);
		this.add(romel);
		romel.setForeground(Color.black);		
		romel.setVisible(true);
		
		spartal = new JLabel("Sparta");
		spartal.setBounds(350, 550, 100 ,40);
		this.add(spartal);
		spartal.setForeground(Color.black);		
		spartal.setVisible(true);
		 
		
		this.setIcon(new ImageIcon ("map.jpg"));
		//this.setIcon(new ImageIcon ("Game.jpg"));
		
		/*GeneralInfo =new GeneralInfo(this);
		GeneralInfo.setBounds(850,55,170,150);
		this.add(GeneralInfo);
		
		
		this.setVisible(true);
		this.setSize(1200,900);
		 
		/*WorldMap =new WorldMap(this);
		WorldMap.setBounds(350,350,700,150);
		this.add(WorldMap);*/
		
		
		cairos=new JButton("Cairo");
		this.add(cairos);
		cairos.setBounds(530, 360, 100, 120);
		cairos.setOpaque(true);
		cairos.setIcon(new ImageIcon("cairobut.jpg"));
		//cairos.setBackground(Color.gray);
		cairos.addActionListener(this);
		
		
		
		rome=new JButton("Rome");
		this.add(rome);
		rome.setBounds(820, 480, 100, 120);
		rome.setOpaque(true);
		rome.setIcon(new ImageIcon("romebut.jpg"));
		rome.setBackground(Color.gray);
		rome.addActionListener(this);
		
		
		
		sparta=new JButton("Sparta");
		this.add(sparta);
		sparta.setBounds(320, 580, 100, 120);
		sparta.setOpaque(true);
		sparta.setIcon(new ImageIcon("spartebut.jpg"));		
		sparta.setBackground(Color.gray);
		sparta.addActionListener(this);
		
		endturn=new JButton("End Turn");
		endturn.setBounds(30,210,120,50);
		endturn.addActionListener(this);
		endturn.setOpaque(true);
		endturn.setBackground(Color.GRAY);
		endturn.setOpaque(true);
		endturn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		endturn.setBackground(Color.black);
		endturn.setForeground(new Color(255,204,150));
		endturn.setEnabled(true);
		this.add(endturn);
		endturn.addActionListener(this);
		
		
		attack=new JButton("Attack");
		attack.setBounds(10, 80, 160, 60);
		attack.setOpaque(true);
		attack.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		attack.setBackground(Color.black);
		attack.setForeground(new Color(255,204,150));
		this.add(attack);
		attack.addActionListener(this);
		//attack.setContentAreaFilled(false);
		
	
		
		seige=new JButton("Seige");
		seige.setBounds(10, 145, 160, 60);
		seige.setOpaque(true);
		seige.setBackground(Color.black);
		seige.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		seige.setForeground(new Color(255,204,150));
		this.add(seige);
	
		
		
		
	}
	

	/*public void updatelabels() {
		//playername.setText("Player name:"+parent.getParent().getGame().getPlayer().getName());
		GeneralInfo.getGold().setText("Gold: "+""+parent.getGame().getPlayer().getTreasury());
		GeneralInfo.getFood().setText("Food: "+""+ parent.getGame().getPlayer().getFood());
		GeneralInfo.getTurns().setText("Turns: "+""+parent.getGame().getCurrentTurnCount());
		
	}*/
	
	

	public GeneralInfo getGeneralInfo() {
		return GeneralInfo;
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==endturn) {
			parent.getGame().endTurn();
			//parent.getGeneralInfo().updatelabels();
		}
		
		if (e.getSource()==cairos) {			
			parent.opencairo();
			
		}
		if (e.getSource()==rome) {			
			parent.openrome();
			
		}
		if (e.getSource()==sparta) {			
			parent.opensparta();
		}
		if (e.getSource()==endturn) {
			parent.getGame().endTurn();
			//this.getGeneralInfo().updatelabels();
		}
		if (e.getSource()==attack) {
			parent.openbattleview();
			 
		}

	}
	

}
