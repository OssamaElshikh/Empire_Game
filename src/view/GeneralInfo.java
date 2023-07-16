package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GeneralInfo extends JLabel {
	private JTextField playername;
	private JTextField cityname;
	private JTextField gold;
	private JTextField food;
	private JTextField turns;
	private GameView parent;
	private JButton endturn;
	
	public GeneralInfo(GameView Game) {
		this.parent=Game;
		
		
		
		playername=new JTextField("Player Name: "+parent.getParent().getGame().getPlayer().getName());
		this.add(playername);
		playername.setEditable(false);
		
		cityname=new JTextField("City Name: "+parent.getParent().getGame().getPlayer().getControlledCities().get(0).getName());
		this.add(cityname);
		cityname.setEditable(false);
		
		
		gold=new JTextField();
		this.add(gold);
		gold.setEditable(false);
		
		food=new JTextField();
		this.add(food);
		food.setEditable(false);
		
		turns=new JTextField();
		this.add(turns);
		turns.setEditable(false);
		
		//parent.updatelabels();
	
		
		
		
		this.setLayout(new GridLayout(5,1));
		this.setSize(100,150);
		this.setVisible(true);
		
	  
	    
		
		
	}
	
	
	
	public JTextField getPlayername() {
		return playername;
	}



	public JTextField getCityname() {
		return cityname;
	}



	public JTextField getGold() {
		return gold;
	}



	public JTextField getFood() {
		return food;
	}



	public JTextField getTurns() {
		return turns;
	}



	public GameView getParent() {
		return parent;
	}



	public JButton getEndturn() {
		return endturn;
	}
  






	
	

}
