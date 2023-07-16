package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BattleView extends JLabel implements ActionListener {
	private MainView parent;
	private JButton returns;
	private JComboBox chosearmy;
	private JComboBox citytoattack;
	private JButton attack;
	private GeneralInfo GeneralInfo;
	
	
	public BattleView(MainView parent) {
		this.parent=parent;
		this.setIcon(new ImageIcon("battleview.jpg"));
		
		returns =new JButton("Return to World Map ");
		returns.setBounds(800,10, 150, 60);
		this.add(returns);
		returns.setOpaque(true);
		returns.setBackground(Color.black);
		returns.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		returns.setForeground(new Color(255,204,150));
		returns.addActionListener(this);
		
		
		
		
		String [] combo1 ={"Choose Attacking Army", parent.getGame().getPlayer().getControlledCities().get(0).getName()+" Army" };
		/*for ( int i = 0; i<parent.getGame().getPlayer().getControlledArmies().size(); i++ ) {
			combo1 = combo1  + (String) parent.getGame().getPlayer().getControlledArmies().toString().get(i);
		}
		*/
		chosearmy =new JComboBox<String>(combo1);
		chosearmy.setBounds(10, 10, 220, 30);
		this.add(chosearmy);
		
		
		
		
		
		String [] combo2 ={"Choose City to attack"};
		citytoattack =new JComboBox<String>(combo2);
		citytoattack.setBounds(10, 50, 220, 30);
		this.add(citytoattack);
		
		attack=new JButton("Attack");
		attack.setBounds(250, 27, 150, 50);
		attack.setOpaque(true);
		attack.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		attack.setBackground(Color.black);
		attack.setForeground(new Color(255,204,150));
		this.add(attack);
		attack.addActionListener(this);
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==returns) {
			this.setVisible(false);
			parent.ends(parent.getWelcomeview().getText(),parent.getWelcomeview().getBox());
		}
		
	}
	

}
