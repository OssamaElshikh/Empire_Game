package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import buildings.*;
import engine.*;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;

public class Cairo extends JLabel implements ActionListener {
	
	private MainView parent;
	private JLabel label;
	private JButton showWorldmap;
	private JLabel building;
	private JLabel buildingsDisplay;
	private JLabel upgradeMilitaryB;
	private JButton upgrade;
	private JLabel a;
	
	private JLabel hagat;
	private JLabel hagat2;//ba7ot 3aleh el zarayer
	private JButton buildFarm;
	private JButton buildMarket;
	private JButton buildArcheryRange;
	private JButton buildBarracks;
	private JButton buildStable;
	private JButton upgradeFarm;
	private JButton upgradeMarket;
	private JButton upgradeArcheryRange;
	private JButton upgradeBarracks;
	private JButton upgradeStable;
	
	private JButton recruitArcher;
	private JButton recruitInfantry;
	private JButton recruitCavalry;
	
	private GeneralInfo GeneralInfo;
	 
	
	ArrayList<JLabel>buildings;
	
	
	public Cairo(MainView parent) {
		this.parent=parent;
		
		/*if ( getBuildings().equals(null) ) {
			JOptionPane.showMessageDialog(this, "You don't control this city","Error",JOptionPane.ERROR_MESSAGE);
		}
		*/
		//this.setLayout(null);
		
		GeneralInfo =new GeneralInfo(parent.getGameView());
		GeneralInfo.setBounds(850,20,170,150);
		this.add(GeneralInfo);
		
		
		buildings= new ArrayList<JLabel>(); 
		
		
		buildingsDisplay=new JLabel();
		buildingsDisplay.setBounds(600,300,400,400);
		buildingsDisplay.setLayout(new GridLayout(buildings.size(), 1));
		this.add(buildingsDisplay);
		
		
		
		
		
		//es2ali ossama 3ala howar el else wel message
		
		
		
		//eso
		
		hagat=new JLabel("");
		hagat.setBounds(20,20, 800, 150);
		hagat.setLayout(new GridLayout(2,5));
		this.add(hagat);
		hagat.setVisible(true);
		
		showBuildings();
		
		
		
			
		
		buildFarm=new JButton("Build Farm");       //doul lazem yethatto f hetat tanyaa
		hagat.add(buildFarm);
		buildFarm.addActionListener(this);
		
		upgradeFarm=new JButton("Upgrade Farm");
		hagat.add(upgradeFarm);
		
		
		buildMarket=new JButton("Build Market");
		hagat.add(buildMarket);
		buildMarket.addActionListener(this);
		
		upgradeMarket=new JButton("Upgrade Market");
		hagat.add(upgradeMarket);
		
		
		buildArcheryRange=new JButton("Build Archery Range");
		hagat.add(buildArcheryRange);
		buildArcheryRange.addActionListener(this);
		
		upgradeArcheryRange=new JButton("Upgrade Archery Range");
		hagat.add(upgradeArcheryRange);
		
		

		
		buildBarracks=new JButton("Build Barracks");
		hagat.add(buildBarracks);
		buildBarracks.addActionListener(this);
		
		upgradeBarracks=new JButton("Upgrade Barracks");
		hagat.add(upgradeBarracks);
		
	   
		buildStable=new JButton("Build Stable");
		hagat.add(buildStable);
		buildStable.addActionListener(this);
	
		
		upgradeStable=new JButton("Upgrade Stable");
		hagat.add(upgradeStable);
			
		
		
		
		//eso
		
		/*
		buildingsDisplay=new JLabel(parent.getGame().getPlayer().getControlledCities().get(0).getName());
		buildingsDisplay.setBounds(10,40,170,150);
		this.add(buildingsDisplay);
		*/
		
		
		this.setIcon(new ImageIcon ("cairos2.jpg"));
		
		
		showWorldmap=new JButton("Show World Map");
		showWorldmap.setBounds(400, 400, 180,45);
		this.add(showWorldmap);
		showWorldmap.addActionListener(this);
		
		
		
	}
	
	
	public City getCity () {
		for ( int i = 0; i<parent.getGame().getPlayer().getControlledCities().size(); i++) {
			if ( parent.getGame().getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Cairo") ) {
				City c = parent.getGame().getPlayer().getControlledCities().get(i);
				return c;
			}
		}
		return null;
	}
	
	
	/*public void getBuildings () {
		a=new JLabel("");
		a.setBounds(20,20, 330, 600);
		a.setLayout(new GridLayout());
		this.add(a);
		a.setVisible(true);
		
		
		City c = getCity();
		if ( c.equals(null) )
			return ;
		else {
			
			for ( int i=0; i<c.getEconomicalBuildings().size(); i++ ) {
				Building b = c.getEconomicalBuildings().get(i);
				if ( b instanceof Farm ) {
					String buildingLevel = ""+ b.getLevel();
					String buildingType = "Economical Building";
					int upgradeCost = b.getUpgradeCost();
					building = new JLabel("Farm"+"\n"+ "           "+"Type: "+buildingType+"Level: "+buildingLevel);
					upgradeFarm = new JButton ("Upgrade"+"\n"+ "           "+"Cost: "+upgradeCost);    
					building.add(upgrade);       //lazem ahaded ana hahottofeen 3ala el label
					a.add(building);
					
				}
				else if ( b instanceof Market ) {
					String buildingLevel = ""+ b.getLevel();
					String buildingType = "Market";
					int upgradeCost = b.getUpgradeCost();
					building = new JLabel("Economical Building"+"\n"+ "           "+"Type: "+buildingType+"Level: "+buildingLevel);
					upgradeMarket = new JButton ("Upgrade"+"\n"+ "           "+"Cost: "+upgradeCost);
					building.add(upgrade);
					a.add(building);
				}
			}
			
			for ( int i=0; i<c.getMilitaryBuildings().size(); i++ ) {
				Building b = c.getMilitaryBuildings().get(i);
				if ( b instanceof ArcheryRange ) {
					String buildingLevel = ""+ b.getLevel();
					String buildingType = "Military Building";
					int upgradeCost = b.getUpgradeCost();
					building = new JLabel("Archery Range"+"\n"+ "           "+"Type: "+buildingType+"Level: "+buildingLevel);
					upgradeArcheryRange = new JButton ("Upgrade"+"\n"+ "           "+"Cost: "+upgradeCost);
					building.add(upgrade);
					a.add(building);
					
				}
				else if ( b instanceof Barracks ) {
					String buildingLevel = ""+ b.getLevel();
					String buildingType = "Military Building";
					int upgradeCost = b.getUpgradeCost();
					building = new JLabel("Barracks"+"\n"+ "           "+"Type: "+buildingType+"Level: "+buildingLevel);
					upgradeBarracks = new JButton ("Upgrade"+"\n"+ "           "+"Cost: "+upgradeCost);
					building.add(upgrade);
					a.add(building);
				}
				else {
					String buildingLevel = ""+ b.getLevel();
					String buildingType = "Military Building";
					int upgradeCost = b.getUpgradeCost();
					building = new JLabel("Stable"+"\n"+ "           "+"Type: "+buildingType+"Level: "+buildingLevel);
					upgradeStable = new JButton ("Upgrade"+"\n"+ "           "+"Cost: "+upgradeCost);
					building.add(upgrade);
					a.add(building);
				}
			}
			
			
		}
		
		
		
	}
	*/
	
	
	public void showBuildings () {
		/*buildings= getBuildings();
		City c = getCity();
		if ( !c.equals(null) ) {
			if ( c.getEconomicalBuildings().size()==0 && c.getMilitaryBuildings().size()==0 ) {
				buildingsDisplay.setText("no buildings");
			}
			else {
				for ( int i = 0; i<buildings.size(); i++) {         
					//buildings.get(i).setBounds(10,40,170,150);
					buildingsDisplay.add(buildings.get(i));
				}
			}
		}
		*/

		
		hagat2=new JLabel("");
		hagat2.setBounds(400,20, 330, 600);
		hagat2.setLayout(new GridLayout(5,2));
		this.add(hagat2);
		hagat2.setVisible(true);
		
		
		
	
		 City c = getCity();
		 for (int i=0 ; i<c.getEconomicalBuildings().size();i++) {
			 if (c.getEconomicalBuildings().get(i) instanceof Farm  ) {
				 JTextField os =new JTextField();
				 os.setBounds(400,220,100,20);
				 os.setText("Farm");
				 os.setEditable(false);
				 this.add(os);
				//parent.getGeneralInfo().updatelabels();
				 
				 
				 JTextField osH =new JTextField();
				 osH.setBounds(550,220,250,20);
				 osH.setText( "Type: Economical Building     " + "Level: "+""+c.getEconomicalBuildings().get(i).getLevel() );
				 osH.setEditable(false);
				 this.add(osH);
			 }
		 
			 
			 else if (c.getEconomicalBuildings().get(i) instanceof Market  ) {
				 JTextField os1 =new JTextField();
				 os1.setBounds(400,250,100,20);
				 os1.setText("Market");
				 os1.setEditable(false);
				 this.add(os1);
				 
				 JTextField os1H =new JTextField();
				 os1H.setBounds(550,250,250,20);
				 os1H.setText( "Type: Economical Building     " + "Level: "+""+c.getEconomicalBuildings().get(i).getLevel() );
				 os1H.setEditable(false);
				 this.add(os1H);
				
			 }
		 }
		 for (int i=0 ; i<c.getMilitaryBuildings().size();i++) {
			  if (c.getMilitaryBuildings().get(i) instanceof Barracks  ) {
				 JTextField os2 =new JTextField();
				 os2.setBounds(400,280,100,20);
				 os2.setText("Barracks");
				 os2.setEditable(false);
				 this.add(os2);
				 
				 JTextField os2H =new JTextField();
				 os2H.setBounds(550,280,250,20);
				 os2H.setText( "Type: Military Building           " + "Level: "+""+c.getMilitaryBuildings().get(i).getLevel() );
				 os2H.setEditable(false);
				 this.add(os2H);
				
				
			 }
			 else if (c.getMilitaryBuildings().get(i) instanceof ArcheryRange  ) {
				 JTextField os3 =new JTextField();
				 os3.setBounds(400,310,100,20);
				 os3.setText("ArcheryRange");
				 os3.setEditable(false);
				 this.add(os3);
				 
				 JTextField os3H =new JTextField();
				 os3H.setBounds(550,310,250,20);
				 os3H.setText( "Type: Military Building           " + "Level: "+""+c.getMilitaryBuildings().get(i).getLevel() );
				 os3H.setEditable(false);
				 this.add(os3H);
				  
				
				
			 }
			 else if (c.getMilitaryBuildings().get(i) instanceof Stable  ) {
				 JTextField os4 =new JTextField();
				 os4.setBounds(400,330,100,20);
				 os4.setText("Stable");
				 os4.setEditable(false);
				 this.add(os4);
				 
				 JTextField os4H =new JTextField();
				 os4H.setBounds(550,330,250,20);
				 os4H.setText( "Type: Military Building           " + "Level: "+""+c.getMilitaryBuildings().get(i).getLevel() );
				 os4H.setEditable(false);
				 this.add(os4H);
				  
				 
				
			 }
		 }
		 
		
	}
	
	public void upgradeBuilding(String s) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		City c = getCity();
		for ( int i=0; i<c.getEconomicalBuildings().size(); i++ ) {
			if ( c.getEconomicalBuildings().get(i) instanceof Farm && s.equals("Farm") ) 
				parent.getGame().getPlayer().upgradeBuilding(c.getEconomicalBuildings().get(i));
			
			else if ( c.getEconomicalBuildings().get(i) instanceof Market && s.equals("Market") ) 
				parent.getGame().getPlayer().upgradeBuilding(c.getEconomicalBuildings().get(i));
			
			else  
				parent.getGame().getPlayer().upgradeBuilding(c.getEconomicalBuildings().get(i));
		}
		
		for ( int i=0; i<c.getMilitaryBuildings().size(); i++ ) {
			if ( c.getMilitaryBuildings().get(i) instanceof ArcheryRange && s.equals("ArcheryRange") ) 
				parent.getGame().getPlayer().upgradeBuilding(c.getMilitaryBuildings().get(i));
			
			else if ( c.getMilitaryBuildings().get(i) instanceof Barracks && s.equals("Barracks") ) 
				parent.getGame().getPlayer().upgradeBuilding(c.getMilitaryBuildings().get(i));
			else
				parent.getGame().getPlayer().upgradeBuilding(c.getMilitaryBuildings().get(i));
		}
		
		
	}
	
	
	
	
	
	
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==showWorldmap) {
			this.setVisible(false);
			parent.getGameView().setVisible(true);
			//parent.ends(parent.getWelcomeview().getText(),parent.getWelcomeview().getBox());
						
			}
		else if (e.getSource()==upgradeFarm)
			try {
				upgradeBuilding("Farm");
				showBuildings();
			} catch (BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(this, "Building In CoolDown","Error",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		else if (e.getSource()==upgradeMarket)
			try {
				upgradeBuilding("Market");
				showBuildings();
				parent.updatelabels();
			} catch (BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(this, "Building In CoolDown","Error",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		else if (e.getSource()==upgradeArcheryRange)
			try {
				upgradeBuilding("ArcheryRange");
			} catch (BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(this, "Building In CoolDown","Error",JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		else if (e.getSource()==upgradeBarracks)
			try {
				upgradeBuilding("Barracks");
			} catch (BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(this, "Building In CoolDown","Error",JOptionPane.ERROR_MESSAGE);
				
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		else if (e.getSource()==upgradeStable)
			try {
				upgradeBuilding("Stable");
			} catch (BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(this, "Building In CoolDown","Error",JOptionPane.ERROR_MESSAGE);	
				
			} catch (NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		else if (e.getSource()==buildFarm)
			try {
				parent.getGame().getPlayer().build("Farm", "Cairo");
				showBuildings();
				parent.updatelabels();
				
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD","Error",JOptionPane.ERROR_MESSAGE);	
							}
		
		else if (e.getSource()==buildMarket)
			try {
				parent.getGame().getPlayer().build("Market", "Cairo");
				showBuildings();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD","Error",JOptionPane.ERROR_MESSAGE);	
				
				
			}
		
		else if (e.getSource()==buildArcheryRange)
			try {
				parent.getGame().getPlayer().build("ArcheryRange", "Cairo");
				showBuildings();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD","Error",JOptionPane.ERROR_MESSAGE);	
				
			
			}
		
		else if (e.getSource()==buildBarracks)
			try {
				parent.getGame().getPlayer().build("Barracks", "Cairo");
				showBuildings();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD","Error",JOptionPane.ERROR_MESSAGE);	
				
			}
		
		else if (e.getSource()==buildStable)
			try {
				parent.getGame().getPlayer().build("Stable", "Cairo");
				showBuildings();
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(this, "NOT ENOUGH GOLD","Error",JOptionPane.ERROR_MESSAGE);	
							}
		else if ( e.getSource()==recruitArcher )
			try {
				parent.getGame().getPlayer().recruitUnit("Archer", "Cairo");
			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if ( e.getSource()==recruitInfantry )
			try {
				parent.getGame().getPlayer().recruitUnit("Infantry", "Cairo");
			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if ( e.getSource()==recruitCavalry )
			try {
				parent.getGame().getPlayer().recruitUnit("Cavalry", "Cairo");
			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
	
			
	}
		

	
	

}
